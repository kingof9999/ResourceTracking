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
	DBConnection connect = new DBConnection();
	Connection conn = connect.getConnect();
	Statement stmt;
	
	/**
	 * get data country for filter public holiday page
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Country> getListCountry() throws SQLException {
		//select data from table COUNTRY
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
		} finally {
		    rs.close();
		}
		return list;
	}
	
	/**
	 * get data year for filter public holiday page
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Year> getListYear() throws SQLException {
		//select data from table PUBLIC_CALENDAR
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
		}finally {
		    rs.close();
		}
		return list;
	}

	/**
	 * get ID_COUNTRY from data and check
	 * @return
	 */
	public boolean checkIdCountry(String idCountry) {
		//select data from table PUBLIC_CALENDAR
		String sql=	String.format("SELECT ID_COUNTRY FROM PUBLIC_CALENDAR WHERE ID_COUNTRY = '%s'", idCountry);
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while(rs.next()){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		    
		}
		return true;
	}

}
