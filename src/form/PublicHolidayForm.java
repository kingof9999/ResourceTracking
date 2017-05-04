package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.PublicHoliday;

public class PublicHolidayForm extends ActionForm{
	private String idCountry;
	private String[] listDate;
	private ArrayList<PublicHoliday> listPublicHoliday;
	private String rowspan;
	
	public String getRowspan() {
		return rowspan;
	}
	public void setRowspan(String rowspan) {
		this.rowspan = rowspan;
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
	public String[] getListDate() {
		return listDate;
	}
	public void setListDate(String[] listDate) {
		this.listDate = listDate;
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
