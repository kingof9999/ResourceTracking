package model.bo;

import java.util.ArrayList;

import model.bean.PublicHoliday;
import model.dao.PublicHolidayDAO;

public class PublicHolidayBO {
	PublicHolidayDAO publicHolidayDAO = new PublicHolidayDAO();
	
	public ArrayList<PublicHoliday> getListPublicHoliday() {
		return publicHolidayDAO.getListPublicHoliday();
	}

}
