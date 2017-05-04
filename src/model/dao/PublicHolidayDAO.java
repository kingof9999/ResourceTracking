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
	private static int noOfRecords;
	
	public ArrayList<PublicHoliday> getListPublicHoliday(int offset, int noOfRecords) {
		String sql= "SELECT *"
				+ " FROM ( SELECT c.NAME_COUNTRY, c.ID_COUNTRY, pc.ID_PUBLIC_CALENDAR, CONVERT(VARCHAR(24),pc.PUBLIC_HOLIDAY,103) AS PUBLIC_HOLIDAY, ROW_NUMBER() over (ORDER BY pc.ID_COUNTRY) AS ct FROM COUNTRY c INNER JOIN PUBLIC_CALENDAR AS pc ON c.ID_COUNTRY = pc.ID_COUNTRY) " +
					"sub WHERE ( ct > "
					+ offset + " AND ct <= " + noOfRecords + " ) ";
		
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
			rs.close();
			rs = stmt.executeQuery("select count(*) as num from PUBLIC_CALENDAR");
			if (rs.next())
				this.noOfRecords = rs.getInt("num");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * @return the noOfRecords
	 */
	public static int getNoOfRecords() {
		return noOfRecords;
	}
	/**
	 * @param noOfRecords
	 *            the noOfRecords to set
	 */
	public static void setNoOfRecords(int noOfRecords) {
		PublicHolidayDAO.noOfRecords = noOfRecords;
	}

	public ArrayList<PublicHoliday> getListPublicHoliday(String idCountry, String year) {
		String sql= String.format("SELECT c.NAME_COUNTRY, c.ID_COUNTRY, pc.ID_PUBLIC_CALENDAR, CONVERT(VARCHAR(24),pc.PUBLIC_HOLIDAY,103) AS PUBLIC_HOLIDAY, ROW_NUMBER() over (ORDER BY pc.ID_COUNTRY) AS ct"
				+ " FROM COUNTRY c INNER JOIN PUBLIC_CALENDAR AS pc ON c.ID_COUNTRY = pc.ID_COUNTRY"
				+ " WHERE pc.ID_COUNTRY = '%s' OR YEAR(pc.PUBLIC_HOLIDAY) = '%s'", idCountry, year);
		
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
