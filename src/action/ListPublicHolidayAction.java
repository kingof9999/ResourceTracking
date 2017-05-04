package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PublicHolidayForm;
import model.bean.PublicHoliday;
import model.bo.PublicHolidayBO;

public class ListPublicHolidayAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PublicHolidayForm publicHolidayForm = (PublicHolidayForm) form;
		
		ArrayList<PublicHoliday> listPublicHoliday;
		
		PublicHolidayBO publicHolidayBO = new PublicHolidayBO();
		listPublicHoliday = publicHolidayBO.getListPublicHoliday();
		
		publicHolidayForm.setListPublicHoliday(listPublicHoliday);
		return mapping.findForward("thanhCong");
	}
	
}
