package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.CheckData;
import common.CheckDbConnection;
import form.PublicHolidayForm;
import model.bo.PublicHolidayBO;

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
		//call form PublicHolidayForm to use
		PublicHolidayForm publicHolidayForm = (PublicHolidayForm) form;
		//call class AcyionErrors to use
		ActionErrors actionErrors = new ActionErrors();
		//check database connection
		if(CheckDbConnection.checkConnect() == false){
			//add message error
			actionErrors.add("dbError", new ActionMessage("error.db.connectDatabase"));
			saveErrors(request, actionErrors);
			//go to error page
			return mapping.findForward("loi");
		}else{
			//call class PublicHolidayBO to use
			PublicHolidayBO publicHolidayBO;
			publicHolidayBO = new PublicHolidayBO();
			String idPublicHoliday = publicHolidayForm.getIdPublicHoliday();
			Boolean deleteIdPublicHoliday = false;
			Boolean checkIdPublicHoliday = false;
			//try catch to get message from throw Exception
			try {
				//check idPublicHoliday have in database
				checkIdPublicHoliday = CheckData.checkPublicHoliday(idPublicHoliday);
			} catch (Exception e) {
				//set message and return error page
				actionErrors.add("dbError", new ActionMessage("error.db.sqlQuery"));
				saveErrors(request, actionErrors);
				publicHolidayForm.setMessage(e.getMessage());
				return mapping.findForward("loi");
			}
			//check return checkPublicHoliday
			if(checkIdPublicHoliday == true){
				//try catch to get message from throw Exception
				try {
					deleteIdPublicHoliday = publicHolidayBO.deletePublicHoliday(idPublicHoliday);
				} catch (Exception e) {
					//set message and return error page
					actionErrors.add("dbError", new ActionMessage("error.db.sqlQuery"));
					saveErrors(request, actionErrors);
					publicHolidayForm.setMessage(e.getMessage());
					return mapping.findForward("loi");
				}
				
				//Performing and check delete data
				if(deleteIdPublicHoliday == false){
					//add message error
					actionErrors.add("deleteError", new ActionMessage("error.delete.deletePublicHoliday"));
					saveErrors(request, actionErrors);
				}
				//return to list page
				return mapping.findForward("thanhCong");
			}else{
				//add message error
				actionErrors.add("deleteError", new ActionMessage("error.deelte.deleteAlreadyPublicHoliday"));
				saveErrors(request, actionErrors);
				//return to list page
				return mapping.findForward("thanhCong");
			}
		}
	}
	
}
