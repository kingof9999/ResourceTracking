package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.CheckDbConnection;
import form.PublicHolidayForm;
import model.bean.Country;
import model.bean.PublicHoliday;
import model.bean.Year;
import model.bo.CountryBO;
import model.bo.PublicHolidayBO;
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
	public static final String emptyValue = "";
	public static final String nullValue = null;
	public static final String[] nullArrayValue = null;
	
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
		//use form PublicHolidayForm to use
		PublicHolidayForm publicHolidayForm = (PublicHolidayForm) form;
		//call class AcyionErrors to use
		ActionErrors actionErrors = new ActionErrors();
		//check database connection
		if(CheckDbConnection.checkConnect() == false){
			//add message error
			actionErrors.add("dbError", new ActionMessage("error.db.connectDatabase"));
			saveErrors(request, actionErrors);
			//return to error page
			return mapping.findForward("loi");
		}else{
			//call class PublicHolidayBO
			PublicHolidayBO publicHolidayBO;
			publicHolidayBO = new PublicHolidayBO();
			
			//get list Country
			CountryBO countryBO;
			countryBO = new CountryBO();
			ArrayList<Country> listCountry;
			//try catch to get message from throw Exception
			try {
				listCountry = countryBO.getListCountry();
			} catch (Exception e) {
				//set message and return error page
				actionErrors.add("dbError", new ActionMessage("error.db.sqlQuery"));
				saveErrors(request, actionErrors);
				publicHolidayForm.setMessage(e.getMessage());
				return mapping.findForward("loi");
			}
			publicHolidayForm.setListCountry(listCountry);
			
			//get list Year
			ArrayList<Year> listYear;
			//try catch to get message from throw Exception
			try {
				listYear = countryBO.getListYear();
			} catch (Exception e) {
				//set message and return error page
				actionErrors.add("dbError", new ActionMessage("error.db.sqlQuery"));
				saveErrors(request, actionErrors);
				publicHolidayForm.setMessage(e.getMessage());
				return mapping.findForward("loi");
			}
			publicHolidayForm.setListYear(listYear);
			
			//get list Public Holiday
			int page = 1;
			int recordsPerPage = 5;
			int noOfRecords=0;
			int noOfPages=0;
			if(request.getParameter("page") != nullValue){
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			ArrayList<PublicHoliday> listPublicHoliday;
			ArrayList<Integer> listPage;
			listPage = new ArrayList<Integer>();
			String idCountry = publicHolidayForm.getIdCountry();
			String year = publicHolidayForm.getYear();
			//check id country,year to filter
			if((idCountry==nullValue || idCountry.length()==0) && (year==nullValue || year.length()==0)){
				//try catch to get message from throw Exception
				try {
					listPublicHoliday = publicHolidayBO.getListPublicHoliday((page-1)*recordsPerPage,
							 recordsPerPage*page);
				} catch (Exception e) {
					//set message and return error page
					actionErrors.add("dbError", new ActionMessage("error.db.sqlQuery"));
					saveErrors(request, actionErrors);
					publicHolidayForm.setMessage(e.getMessage());
					return mapping.findForward("loi");
				}
				
				noOfRecords = PublicHolidayDAO.getNoOfRecords();
				noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
				for(int i=1; i<=noOfPages; i++){
					listPage.add(i);
				}
			}else{
				//return list with data found
				try {
					listPublicHoliday = publicHolidayBO.getListPublicHoliday(idCountry,year);
				} catch (Exception e) {
					//set message and return error page
					actionErrors.add("dbError", new ActionMessage("error.db.sqlQuery"));
					saveErrors(request, actionErrors);
					publicHolidayForm.setMessage(e.getMessage());
					return mapping.findForward("loi");
				}
			}
			
			//check list public database is empty?
			if(listPublicHoliday.isEmpty()){
				//add message error
				actionErrors.add("nullListError", new ActionMessage("error.list.nullDataFound"));
				saveErrors(request, actionErrors);
			}
			//set data to form
			publicHolidayForm.setListPublicHoliday(listPublicHoliday);
			publicHolidayForm.setListPage(listPage);
			publicHolidayForm.setCurrentPage(page);
			publicHolidayForm.setNoOfPages(noOfPages);
			
			//return to list
			return mapping.findForward("thanhCong");
		}
		
	}
	
}
