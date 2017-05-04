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
import model.dao.PublicHolidayDAO;

public class ListPublicHolidayAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PublicHolidayForm publicHolidayForm = (PublicHolidayForm) form;
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
			System.out.println("page get = "+page);
		}
		
		ArrayList<PublicHoliday> listPublicHoliday;
		ArrayList<Integer> listPage = new ArrayList<Integer>();
		String idCountry = publicHolidayForm.getIdCountry();
		String year = publicHolidayForm.getYear();
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
		
		if(listPublicHoliday.isEmpty()){
			publicHolidayForm.setMessage("No data found.");
		}
		
		publicHolidayForm.setListPublicHoliday(listPublicHoliday);
		publicHolidayForm.setListPage(listPage);
		publicHolidayForm.setCurrentPage(page);
		publicHolidayForm.setNoOfPages(noOfPages);
		return mapping.findForward("thanhCong");
	}
	
}
