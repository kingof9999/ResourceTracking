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
import model.bo.CountryBO;
import model.bo.PublicHolidayBO;
import model.dao.DBConnection;

/**
 * AddPublicHolidayAction
 * 
 * Version 1.0
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
public class AddPublicHolidayAction extends Action{
	
	/**
	 * Processed action for add public holiday
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
			//get list Country
			CountryBO countryBO = new CountryBO();
			ArrayList<Country> listCountry = countryBO.getListCountry();
			publicHolidayForm.setListCountry(listCountry);
			
			//check submit button
			if("Add".equals(publicHolidayForm.getSubmit())){
				String[] publicHoliday = publicHolidayForm.getPublicHoliday();
				String idCountry = publicHolidayForm.getIdCountry();
				//check null publicHoliday
				if(publicHoliday == null){
					publicHolidayForm.setMessage("You must add some holiday.");
					return mapping.findForward("addPublicHoloday");
				}
				//check type publicHoliday is Empty
				for(String s:publicHoliday){
					if(s.isEmpty() || s == null){
						publicHolidayForm.setMessage("Holiday must be a Date type.");
						return mapping.findForward("addPublicHoloday");
					}
				}
				//check idCountry is already exist?
				if(countryBO.checkIdCountry(idCountry) == true){
					PublicHolidayBO publicHolidayBO = new PublicHolidayBO();
					publicHolidayBO.addPublicHoliday(publicHoliday,idCountry);
					//set idCountry == this idCountry
					publicHolidayForm.setIdCountry(idCountry);
					//set year = ""
					publicHolidayForm.setYear("");
					//return to list
					return mapping.findForward("thanhCong");
				}else{
					publicHolidayForm.setMessage("The country exists in the system. Please enter a new country or use update functionality to update the public holiday date.");
					//return to page addPHCM.jsp
					return mapping.findForward("addPublicHoloday");
				}
			}else{
				//return to page addPHCM.jsp
				return mapping.findForward("addPublicHoloday");
			}
		}
		
	}
	
}
