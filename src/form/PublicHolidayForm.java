package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Country;
import model.bean.PublicHoliday;
import model.bean.Year;

public class PublicHolidayForm extends ActionForm{
	private String idCountry;
	private String year;
	private String message;
	private ArrayList<PublicHoliday> listPublicHoliday;
	private ArrayList<Country> listCountry;
	private ArrayList<Year> listYear;
	private ArrayList<Integer> listPage;
	private int noOfPages;
	private int currentPage;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Year> getListYear() {
		return listYear;
	}
	public void setListYear(ArrayList<Year> listYear) {
		this.listYear = listYear;
	}
	public ArrayList<Country> getListCountry() {
		return listCountry;
	}
	public void setListCountry(ArrayList<Country> listCountry) {
		this.listCountry = listCountry;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public ArrayList<Integer> getListPage() {
		return listPage;
	}
	public void setListPage(ArrayList<Integer> listPage) {
		this.listPage = listPage;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public ArrayList<PublicHoliday> getListPublicHoliday() {
		return listPublicHoliday;
	}
	public void setListPublicHoliday(ArrayList<PublicHoliday> listPublicHoliday) {
		this.listPublicHoliday = listPublicHoliday;
	}
	public String getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
}
