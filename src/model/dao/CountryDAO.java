package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Country;
import model.bean.Year;

public class CountryDAO {
	DBConnection connect = new DBConnection();
	Connection conn = connect.getConnect();
	Statement stmt;
	
	public ArrayList<Country> getListCountry() {
		String sql=	"SELECT ID_COUNTRY, NAME_COUNTRY FROM COUNTRY";
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Country> list = new ArrayList<Country>();
		Country country;
		try {
			while(rs.next()){
				country = new Country();
				country.setIdCountry(rs.getString("ID_COUNTRY"));
				country.setNameCountry(rs.getString("NAME_COUNTRY"));
				list.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Year> getListYear() {
		String sql=	"SELECT TOP 2 YEAR(PUBLIC_HOLIDAY) as myYear"
			+ " FROM PUBLIC_CALENDAR"
			+ " WHERE DATEDIFF(year,GETDATE(),PUBLIC_HOLIDAY)<0"
			+ " GROUP BY YEAR(PUBLIC_HOLIDAY)"
			+ " ORDER BY myYear DESC";
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Year> list = new ArrayList<Year>();
		Year year;
		try {
			while(rs.next()){
				year = new Year();
				year.setYear(rs.getString("myYear"));
				list.add(year);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
