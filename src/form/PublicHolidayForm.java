package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Country;
import model.bean.PublicHoliday;
import model.bean.Year;

/**
 * PublicHolidayForm
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
public class PublicHolidayForm extends ActionForm{
	private String idCountry;
	private String idPublicHoliday;
	private String year;
	private String message;
	private String submit;
	private String[] publicHoliday;
	private ArrayList<PublicHoliday> listPublicHoliday;
	private ArrayList<Country> listCountry;
	private ArrayList<Year> listYear;
	private ArrayList<Integer> listPage;
	private int noOfPages;
	private int currentPage;
	
	/**
	 * the submit to get
	 * @return
	 */
	public String getSubmit() {
		return submit;
	}
	
	/**
	 * @param submit
	 * the submit to set
	 */
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	/**
	 * the publicHoliday to get
	 * @return
	 */
	public String[] getPublicHoliday() {
		return publicHoliday;
	}
	
	/**
	 * @param publicHoliday
	 * the publicHoliday to set
	 */
	public void setPublicHoliday(String[] publicHoliday) {
		this.publicHoliday = publicHoliday;
	}

	/**
	 * the idPublicHoliday to get
	 * @return
	 */
	public String getIdPublicHoliday() {
		return idPublicHoliday;
	}
	
	/**
	 * @param idPublicHoliday
	 * the idPublicHoliday to set
	 */
	public void setIdPublicHoliday(String idPublicHoliday) {
		this.idPublicHoliday = idPublicHoliday;
	}
	
	/**
	 * the message to get
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @param message
	 * the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * the listYear to get
	 * @return
	 */
	public ArrayList<Year> getListYear() {
		return listYear;
	}
	
	/**
	 * @param listYear
	 * the listYear to set
	 */
	public void setListYear(ArrayList<Year> listYear) {
		this.listYear = listYear;
	}
	
	/**
	 * the listCountry to get
	 * @return
	 */
	public ArrayList<Country> getListCountry() {
		return listCountry;
	}
	
	/**
	 * @param listCountry
	 * the listCountry to set
	 */
	public void setListCountry(ArrayList<Country> listCountry) {
		this.listCountry = listCountry;
	}
	
	/**
	 * the year to get
	 * @return
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * @param year
	 * the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * the listPage to get
	 * @return
	 */
	public ArrayList<Integer> getListPage() {
		return listPage;
	}
	
	/**
	 * @param listPage
	 * the listPage to set
	 */
	public void setListPage(ArrayList<Integer> listPage) {
		this.listPage = listPage;
	}
	
	/**
	 * the noOfPages to get
	 * @return
	 */
	public int getNoOfPages() {
		return noOfPages;
	}
	
	/**
	 * @param noOfPages
	 * the noOfPages to set
	 */
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	
	/**
	 * the currentPage to get
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	
	/**
	 * @param currentPage
	 * the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * the listPublicHoliday to get
	 * @return
	 */
	public ArrayList<PublicHoliday> getListPublicHoliday() {
		return listPublicHoliday;
	}
	
	/**
	 * @param listPublicHoliday
	 * the listPublicHoliday to set
	 */
	public void setListPublicHoliday(ArrayList<PublicHoliday> listPublicHoliday) {
		this.listPublicHoliday = listPublicHoliday;
	}
	
	/**
	 * the idCountry to get
	 * @return
	 */
	public String getIdCountry() {
		return idCountry;
	}
	
	/**
	 * @param idCountry
	 * the idCountry to set
	 */
	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}
	
	/**
	 * convert to UTF-8
	 * @param mapping
	 * @param request
	 */
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
}
