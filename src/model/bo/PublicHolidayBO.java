package model.bo;

import java.util.ArrayList;

import model.bean.PublicHoliday;
import model.dao.PublicHolidayDAO;

public class PublicHolidayBO {
	PublicHolidayDAO publicHolidayDAO = new PublicHolidayDAO();
	
	public ArrayList<PublicHoliday> getListPublicHoliday(int offset, int noOfRecords) {
		return publicHolidayDAO.getListPublicHoliday(offset, noOfRecords);
	}

	public ArrayList<PublicHoliday> getListPublicHoliday(String idCountry, String year) {
		return publicHolidayDAO.getListPublicHoliday(idCountry, year);
	}

}
