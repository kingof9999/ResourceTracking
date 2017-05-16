package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.PublicHoliday;
import model.dao.PublicHolidayDAO;

/**
 * PublicHolidayBO
 * 
 * Version 1.3
 * 
 * Date: 03/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 05/05/2017		TinLQ			Create
 */
public class PublicHolidayBO {
	//call class PublicHolidayDAO
	PublicHolidayDAO publicHolidayDAO = new PublicHolidayDAO();
	
	/**
	 * Processing business get list public holiday
	 * @param offset
	 * @param noOfRecords
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<PublicHoliday> getListPublicHoliday(int offset, int noOfRecords) throws Exception {
		return publicHolidayDAO.getListPublicHoliday(offset, noOfRecords);
	}
	
	/**
	 * Processing business get list public holiday
	 * @param idCountry
	 * @param year
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<PublicHoliday> getListPublicHoliday(String idCountry, String year) throws Exception {
		return publicHolidayDAO.getListPublicHoliday(idCountry, year);
	}
	
	/**
	 * Processing business delete public holiday
	 * @param idPublicHoliday
	 * @return
	 * @throws Exception 
	 */
	public boolean deletePublicHoliday(String idPublicHoliday) throws Exception{
		return publicHolidayDAO.deletePublicHoliday(idPublicHoliday);
	}
	
	/**
	 * Processing business add public holiday
	 * @param publicHoliday
	 * @param idCountry
	 * @return
	 * @throws SQLException 
	 */
	public boolean addPublicHoliday(String[] publicHoliday, String idCountry) throws Exception {
		return publicHolidayDAO.addPublicHoliday(publicHoliday,idCountry);
	}

}
