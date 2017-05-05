package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Country;
import model.bean.Year;
import model.dao.CountryDAO;

/**
 * CountryBO
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
public class CountryBO {
	//call class CountryDAO
	CountryDAO countryDAO = new CountryDAO();
	
	/**
	 * Processing business get list country
	 * @return
	 */
	public ArrayList<Country> getListCountry() throws SQLException {
		return countryDAO.getListCountry();
	}

	/**
	 * Processing business get list year
	 * @return
	 */
	public ArrayList<Year> getListYear() throws SQLException {
		return countryDAO.getListYear();
	}
	
	/**
	 * Processing business check idCountry
	 * @return
	 */
	public boolean checkIdCountry(String idCountry) {
		return countryDAO.checkIdCountry(idCountry);
	}

}
