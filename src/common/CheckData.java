package common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.dao.DBConnection;

/**
 * CheckData
 * 
 * Version 1.0
 * 
 * Date: 09/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 10/05/2017		TinLQ			Create
 */
public class CheckData {
	//call class DBconnection to use
	DBConnection connect = new DBConnection();
	//set method getConnect() from DBconnection class to use Connection
	static Connection conn = DBConnection.getConnect();
	Statement stmt;
	
	/**
	 * check data from database PUBLIC_CALENDAR
	 * @param idPublicHoliday
	 * @return
	 * @throws Exception 
	 */
	public static Boolean checkPublicHoliday(String idPublicHoliday) throws Exception {
		//select data from table PUBLIC_CALENDAR
		String sql = String
				.format("SELECT ID_PUBLIC_CALENDAR FROM PUBLIC_CALENDAR WHERE ID_PUBLIC_CALENDAR = '%s'", idPublicHoliday);
		ResultSet rs;
		//catch error and throw
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			//throw exception if error
			throw new Exception("Error occur: "+e.getMessage());
		}
		try {
			//check delete have action
			if(rs.next()){
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		} finally {
			DBConnection.disConnect();
		}
		return false;
	}
	
	/**
	 * check date data from database PUBLIC_CALENDAR
	 * @param idPublicHoliday
	 * @return
	 * @throws Exception 
	 */
	public static Boolean checkDatePublicHoliday(String idCountry, String listPublicHoliday) throws Exception {
		//select data from table PUBLIC_CALENDAR
		String sql = String
				.format("SELECT ID_PUBLIC_CALENDAR FROM PUBLIC_CALENDAR WHERE PUBLIC_HOLIDAY = '%s' AND ID_COUNTRY = '%s'", listPublicHoliday,idCountry);
		ResultSet rs;
		//catch error and throw
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			//throw exception if error
			throw new Exception("Error occur: "+e.getMessage());
		}
		try {
			//check delete have action
			if(rs.next()){
				return true;
			}
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		} finally {
			DBConnection.disConnect();
		}
		return false;
	}
	
	/**
	 * check exist element in string array
	 * @param idPublicHoliday
	 * @return
	 * @throws Exception 
	 */
	public static boolean contains(String[] publicHoliday, String checkDatePublicHoliday) {	
	    for (String e : publicHoliday){
	        if (e.equals(checkDatePublicHoliday)){
	            return true;
	        }
	    }
	    return false;
	}
	
}
