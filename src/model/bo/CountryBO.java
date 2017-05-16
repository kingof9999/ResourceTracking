package model.bo;

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
	 * @throws Exception 
	 */
	public ArrayList<Country> getListCountry() throws Exception {
		return countryDAO.getListCountry();
	}

	/**
	 * Processing business get list year
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<Year> getListYear() throws Exception {
		return countryDAO.getListYear();
	}
	
	/**
	 * Processing business check idCountry
	 * @return
	 * @throws Exception 
	 */
	public boolean checkIdCountry(String idCountry) throws Exception {
		return countryDAO.checkIdCountry(idCountry);
	}

}
