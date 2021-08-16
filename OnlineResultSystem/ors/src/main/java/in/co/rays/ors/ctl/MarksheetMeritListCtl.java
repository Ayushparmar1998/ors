package in.co.rays.ors.ctl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.MarksheetBean;
import in.co.rays.ors.model.MarksheetModel;
import in.co.rays.ors.ctl.ORSView;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;

/**
 *  marksheetmerit list functionlity controller to show merit list student
 * @author AYUSH
 *
 */

@WebServlet(name="MarksheetMeritListCtl",urlPatterns={"/ctl/MarksheetMeritListCtl"})
public class MarksheetMeritListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    private static Logger log = Logger.getLogger(MarksheetMeritListCtl.class);
    
   
    
    /**
     * Contains Display logics
     */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("inside do get");
		
		log.debug("");
	
		int pageNo=1;
		int pageSize= DataUtility.getInt(PropertyReader.getValue("page.size"));
		
		MarksheetModel model = new MarksheetModel();
		try{
			List list =null;
			list=model.getMeritList(1,10);
			
			if(list==null && list.size()>0){
				ServletUtility.setErrorMessage("No record Found", request);
			}
			
			request.setAttribute("list",list);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(),request,response);
	}
    


	/**
     * Contains Submit logics
     */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("inside do post");
			
			String op = DataUtility.getString(request.getParameter("operation"));
			
			
			
			log.debug("MarksheetMeritListCtl doGet Start");
			System.out.println("doPost");
			List list=null;
			
			int pageNo=DataUtility.getInt(request.getParameter("pageNo"));
			int pageSize=DataUtility.getInt(request.getParameter("pageSize"));
			
			pageNo=(pageNo==0)?1:pageNo;
			pageSize=(pageSize==0)?DataUtility.getInt(PropertyReader.getValue("page.size")):pageSize;
			
			MarksheetBean bean=(MarksheetBean)populateBean(request);
			
//			String op=DataUtility.getString(request.getParameter("operation"));
			long id = DataUtility.getLong(request.getParameter("id"));
			
			MarksheetModel model=new MarksheetModel();
			
			try{
				if(OP_BACK.equalsIgnoreCase(op)){
					ServletUtility.redirect(ORSView.WELCOME_CTL, request, response);
					return;
				}
				list=model.getMeritList(pageNo, pageSize);
				ServletUtility.setList(list, request);
				
				if(list==null||list.size()==0){
					ServletUtility.setErrorMessage("No Record Found", request);
				}
				ServletUtility.setList(list, request);
				ServletUtility.setPageNo(pageNo, request);
				ServletUtility.setPageSize(pageSize, request);
				ServletUtility.forward(ORSView.MARKSHEET_MERIT_LIST_VIEW, request, response);
			}catch(ApplicationException e){
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
			log.debug("MarksheetMeritListCtl doPOst End");
	}

		@Override
		protected String getView() {
			return ORSView.MARKSHEET_MERIT_LIST_VIEW;
		}

}
