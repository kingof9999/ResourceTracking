package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Country;
import model.bean.Year;

/**
 * CountryDAO
 * 
 * Version 1.0
 * 
 * Date: 03/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 03/05/2017		TinLQ			Create
 */
public class CountryDAO {
	//call class DBconnection to use
	DBConnection connect = new DBConnection();
	//set method getConnect() from DBconnection class to use Connection
	Connection conn = DBConnection.getConnect();
	Statement stmt;
	
	/**
	 * get data country for filter public holiday page
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<Country> getListCountry() throws Exception {
		//select data from table COUNTRY
		String sql=	"SELECT ID_COUNTRY, NAME_COUNTRY FROM COUNTRY ORDER BY NAME_COUNTRY ASC";
		ResultSet rs = null;
		//catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		}
		
		ArrayList<Country> list;
		list = new ArrayList<Country>();
		Country country;
		try {
			//set each row to list
			while(rs.next()){
				country = new Country();
				country.setIdCountry(rs.getString("ID_COUNTRY"));
				country.setNameCountry(rs.getString("NAME_COUNTRY"));
				list.add(country);
			}
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		} finally {
			//catch sql error and throw
			try {
				rs.close();
			} catch (SQLException sqle) {
				throw new SQLException("Error occur: "+sqle.getMessage());
			}
			try {
				stmt.close();
			} catch (SQLException sqle) {
				throw new SQLException("Error occur: "+sqle.getMessage());
			}
		}
		return list;
	}
	
	/**
	 * get data year for filter public holiday page
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<Year> getListYear() throws Exception {
		//select data from table PUBLIC_CALENDAR
		String sql=	"SELECT TOP 2 YEAR(PUBLIC_HOLIDAY) as myYear"
			+ " FROM PUBLIC_CALENDAR"
			+ " WHERE DATEDIFF(year,GETDATE(),PUBLIC_HOLIDAY)<0"
			+ " GROUP BY YEAR(PUBLIC_HOLIDAY)"
			+ " ORDER BY myYear DESC";
		ResultSet rs = null;
		//catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		}
		
		ArrayList<Year> list;
		list = new ArrayList<Year>();
		Year year;
		try {
			// set each row to list
			while(rs.next()){
				year = new Year();
				year.setYear(rs.getString("myYear"));
				list.add(year);
			}
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		}finally {
			//catch sql error and throw
			try {
				rs.close();
			} catch (SQLException sqle) {
				throw new SQLException("Error occur: "+sqle.getMessage());
			}
			try {
				stmt.close();
			} catch (SQLException sqle) {
				throw new SQLException("Error occur: "+sqle.getMessage());
			}
		}
		return list;
	}

	/**
	 * get ID_COUNTRY from data and check
	 * @return
	 * @throws Exception 
	 */
	public boolean checkIdCountry(String idCountry) throws Exception {
		//select data from table PUBLIC_CALENDAR
		String sql=	String.format("SELECT ID_COUNTRY FROM PUBLIC_CALENDAR WHERE ID_COUNTRY = '%s'", idCountry);
		ResultSet rs = null;
		//catch error and throw
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		}

		try {
			//check if have row show
			while(rs.next()){
				return false;
			}
		} catch (Exception e) {
			throw new Exception("Error occur: "+e.getMessage());
		}finally {
			//catch sql error and throw
			try {
				rs.close();
			} catch (SQLException sqle) {
				throw new SQLException("Error occur: "+sqle.getMessage());
			}
			try {
				stmt.close();
			} catch (SQLException sqle) {
				throw new SQLException("Error occur: "+sqle.getMessage());
			}
		}
		return true;
	}

}
