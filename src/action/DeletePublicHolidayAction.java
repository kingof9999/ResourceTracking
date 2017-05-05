package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PublicHolidayForm;
import model.bo.PublicHolidayBO;
import model.dao.DBConnection;

/**
 * DeletePublicHolidayAction
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
public class DeletePublicHolidayAction extends Action{
	/**
	 * Processed action for delete public holiday
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//call form PublicHolidayForm
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
			String idPublicHoliday = publicHolidayForm.getIdPublicHoliday();
			//Performing and check delete data
			if(publicHolidayBO.deletePublicHoliday(idPublicHoliday) == false){
				publicHolidayForm.setMessage("The calendars of selected country can be removed after two years created.");
			}
			return mapping.findForward("thanhCong");
		}
	}
	
}
