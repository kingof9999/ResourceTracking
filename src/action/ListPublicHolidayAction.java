package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PublicHolidayForm;
import model.bean.Country;
import model.bean.PublicHoliday;
import model.bean.Year;
import model.bo.CountryBO;
import model.bo.PublicHolidayBO;
import model.dao.DBConnection;
import model.dao.PublicHolidayDAO;

/**
 * ListPublicHolidayAction
 * 
 * Version 1.3
 * 
 * Date: 05/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 05/05/2017		TinLQ			Create
 */
public class ListPublicHolidayAction extends Action{
	/**
	 * Processed action for list public holiday
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//use form PublicHolidayForm
		PublicHolidayForm publicHolidayForm = (PublicHolidayForm) form;
		//call class DBConnection
		DBConnection dbConnection = new DBConnection();
		//check database connection
		if(dbConnection.getConnect() == null){
			publicHolidayForm.setMessage("Database connection error.");
			return mapping.findForward("loi");
		}else{
			//call class PublicHolidayBO
			PublicHolidayBO publicHolidayBO = new PublicHolidayBO();
			
			//get list Country
			CountryBO countryBO = new CountryBO();
			ArrayList<Country> listCountry = countryBO.getListCountry();
			publicHolidayForm.setListCountry(listCountry);
			
			//get list Year
			ArrayList<Year> listYear = countryBO.getListYear();
			publicHolidayForm.setListYear(listYear);
			
			//get list Public Holiday
			int page = 1;
			int recordsPerPage = 5;
			int noOfRecords=0;
			int noOfPages=0;
			if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			ArrayList<PublicHoliday> listPublicHoliday;
			ArrayList<Integer> listPage = new ArrayList<Integer>();
			String idCountry = publicHolidayForm.getIdCountry();
			String year = publicHolidayForm.getYear();
			//check id country,year to filter
			if((idCountry==null || idCountry.length()==0) && (year==null || year.length()==0)){
				listPublicHoliday = publicHolidayBO.getListPublicHoliday((page-1)*recordsPerPage,
						 recordsPerPage*page);
				
				noOfRecords = PublicHolidayDAO.getNoOfRecords();
				noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
				for(int i=1;i<=noOfPages;i++){
					listPage.add(i);
				}
			}else{
				listPublicHoliday = publicHolidayBO.getListPublicHoliday(idCountry,year);
			}
			
			//check list public database is empty?
			if(listPublicHoliday.isEmpty()){
				publicHolidayForm.setMessage("No data found.");
			}
			
			publicHolidayForm.setListPublicHoliday(listPublicHoliday);
			publicHolidayForm.setListPage(listPage);
			publicHolidayForm.setCurrentPage(page);
			publicHolidayForm.setNoOfPages(noOfPages);
			
			//return to list
			return mapping.findForward("thanhCong");
		}
		
	}
	
}
