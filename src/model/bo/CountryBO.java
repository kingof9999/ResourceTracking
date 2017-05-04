package model.bo;

import java.util.ArrayList;

import model.bean.Country;
import model.bean.Year;
import model.dao.CountryDAO;

public class CountryBO {
	CountryDAO countryDAO = new CountryDAO();
	
	public ArrayList<Country> getListCountry() {
		return countryDAO.getListCountry();
	}

	public ArrayList<Year> getListYear() {
		return countryDAO.getListYear();
	}

}
