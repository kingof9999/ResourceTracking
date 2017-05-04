package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.PublicHoliday;

public class PublicHolidayDAO {
	DBConnection connect = new DBConnection();
	Connection conn = connect.getConnect();
	Statement stmt;
	
	public ArrayList<PublicHoliday> getListPublicHoliday() {
		String sql= "SELECT c.NAME_COUNTRY, c.ID_COUNTRY, pc.ID_PUBLIC_CALENDAR, CONVERT(VARCHAR(24),pc.PUBLIC_HOLIDAY,103) AS PUBLIC_HOLIDAY FROM COUNTRY c, PUBLIC_CALENDAR pc "+
					"WHERE c.ID_COUNTRY = pc.ID_COUNTRY ORDER BY c.ID_COUNTRY" ;
		
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<PublicHoliday> list = new ArrayList<PublicHoliday>();
		PublicHoliday x;
		try {
			while(rs.next()){
				x =new PublicHoliday();
				x.setNameCountry(rs.getString("NAME_COUNTRY"));
				x.setDatePublicHoliday(rs.getString("PUBLIC_HOLIDAY"));
				list.add(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
