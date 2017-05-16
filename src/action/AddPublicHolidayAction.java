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
import model.bo.CountryBO;
import model.bo.PublicHolidayBO;

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
	public static final String emptyValue = "";
	public static final String nullValue = null;
	public static final String[] nullArrayValue = null;
	
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
		//call class AcyionErrors to use
		ActionErrors actionErrors = new ActionErrors();
		//check database connection
		if(CheckDbConnection.checkConnect() == false){
			//add message error
			actionErrors.add("dbError", new ActionMessage("error.db.connectDatabase"));
			saveErrors(request, actionErrors);
			//return error page
			return mapping.findForward("loi");
		}else{
			//get list Country
			CountryBO countryBO;
			countryBO = new CountryBO();
			ArrayList<Country> listCountry = countryBO.getListCountry();
			publicHolidayForm.setListCountry(listCountry);
			
			//check submit button
			if("Add".equals(publicHolidayForm.getSubmit())){
				String[] publicHoliday = publicHolidayForm.getPublicHoliday();
				String idCountry = publicHolidayForm.getIdCountry();
				//check null publicHoliday
				if(publicHoliday == nullArrayValue){
					//add error message
					actionErrors.add("addNullError", new ActionMessage("error.add.nullHoliday"));
					saveErrors(request, actionErrors);
					//return to add screen
					return mapping.findForward("addPublicHoloday");
				}
				//check type publicHoliday is Empty
				for(String s:publicHoliday){
					if(s.isEmpty() || s == nullValue){
						//add error message
						actionErrors.add("addTypeError", new ActionMessage("error.add.wrongTypeHoliday"));
						saveErrors(request, actionErrors);
						//return to add screen
						return mapping.findForward("addPublicHoloday");
					}
				}
				//check idCountry is already exist?
				if(countryBO.checkIdCountry(idCountry) == true){
					PublicHolidayBO publicHolidayBO;
					publicHolidayBO = new PublicHolidayBO();
					Boolean checkDatePublicHoliday = false;
					//try catch to get message from throw Exception
					try {
						checkDatePublicHoliday = publicHolidayBO.addPublicHoliday(publicHoliday,idCountry);
					} catch (Exception e) {
						//add error message
						actionErrors.add("addTypeError", new ActionMessage("error.add.wrongTypeHoliday"));
						saveErrors(request, actionErrors);
						//return to add screen
						return mapping.findForward("addPublicHoloday");
					}
					//check if exist date
					if(checkDatePublicHoliday == true){
						//set idCountry == this idCountry
						publicHolidayForm.setIdCountry(idCountry);
						//set year = ""
						publicHolidayForm.setYear(emptyValue);
						//return to list
						return mapping.findForward("thanhCong");
					}else{
						//add error message
						actionErrors.add("addExistDateError", new ActionMessage("error.add.existDateHoliday"));
						saveErrors(request, actionErrors);
						//return to add screen
						return mapping.findForward("addPublicHoloday");
					}
				}else{
					//set error if country exist
					actionErrors.add("addCountryExistError", new ActionMessage("error.add.existCountry"));
					saveErrors(request, actionErrors);
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
