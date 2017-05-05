package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.PublicHoliday;

/**
 * PublicHolidayDAO
 * 
 * Version 1.3
 * 
 * Date: 05/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 05/05/2017		TinLQ			Create
 */
public class PublicHolidayDAO {
	DBConnection connect = new DBConnection();
	Connection conn = connect.getConnect();
	Statement stmt;
	private static int noOfRecords;
	
	/**
	 * get data for list public holiday page
	 * @param offset
	 * @param noOfRecords
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<PublicHoliday> getListPublicHoliday(int offset, int noOfRecords) throws SQLException {
		//select data from table COUNTRY,PUBLIC_CALENDAR
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
		PublicHoliday puclicHoliday;
		try {
			while(rs.next()){
				puclicHoliday =new PublicHoliday();
				puclicHoliday.setNameCountry(rs.getString("NAME_COUNTRY"));
				puclicHoliday.setDatePublicHoliday(rs.getString("PUBLIC_HOLIDAY"));
				puclicHoliday.setIdPublicHoliday(rs.getString("ID_PUBLIC_CALENDAR"));
				list.add(puclicHoliday);
			}
			rs.close();
			rs = stmt.executeQuery("select count(*) as num from PUBLIC_CALENDAR");
			if (rs.next())
				this.noOfRecords = rs.getInt("num");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    rs.close();
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
	 * the noOfRecords to set
	 */
	public static void setNoOfRecords(int noOfRecords) {
		PublicHolidayDAO.noOfRecords = noOfRecords;
	}
	
	/**
	 * get data for list public holiday page
	 * @param idCountry
	 * @param year
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<PublicHoliday> getListPublicHoliday(String idCountry, String year) throws SQLException {
		//select data from table COUNTRY,PUBLIC_CALENDAR
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
		PublicHoliday publicHoliday;
		try {
			while(rs.next()){
				publicHoliday =new PublicHoliday();
				publicHoliday.setNameCountry(rs.getString("NAME_COUNTRY"));
				publicHoliday.setDatePublicHoliday(rs.getString("PUBLIC_HOLIDAY"));
				publicHoliday.setIdPublicHoliday(rs.getString("ID_PUBLIC_CALENDAR"));
				list.add(publicHoliday);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    rs.close();
		}
		return list;
	}
	
	/**
	 * delete data from list public holiday page
	 * @param idPublicHoliday
	 * @return
	 * @throws SQLException 
	 */
	public boolean deletePublicHoliday(String idPublicHoliday) throws SQLException{
		//select data from table PUBLIC_CALENDAR
		String sql = String
				.format("DELETE FROM PUBLIC_CALENDAR WHERE ID_PUBLIC_CALENDAR = '%s' AND YEAR(GETDATE()) - YEAR(PUBLIC_HOLIDAY) >= 2", idPublicHoliday);
		int rs = 0;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs == 1){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		    conn.close();
		}
		return false;
	}

	/**
	 * add data to database table PUBLIC_CALENDAR
	 * @param publicHoliday
	 * @param idCountry
	 * @return
	 */
	public void addPublicHoliday(String[] publicHoliday, String idCountry) {
		//loop to insert each publicHoliday
		for(String s:publicHoliday){
			String listPublicHoliday = s;
			//insert data to table
			String sql = String.format("INSERT INTO PUBLIC_CALENDAR(ID_COUNTRY,PUBLIC_HOLIDAY) VALUES('%s','%s')", idCountry,listPublicHoliday);
			
			try {
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
