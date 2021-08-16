package in.co.rays.ors.ctl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.UserBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.model.UserModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;

/**
 * user list funcitonality controller.to perform search and show operation
 * @author AYUSH
 *
 */

@WebServlet(name = "UserListCtl", urlPatterns = { "/ctl/UserListCtl" })
public class UserListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(UserListCtl.class);

	
	
	protected BaseBean populateBean(HttpServletRequest request) {
		System.out.println("inside populateBean");
		log.debug("");

		UserBean bean = new UserBean();

		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
        System.out.println("login id"+(request.getParameter("login")));
		
        populateDTO(bean, request);

		return bean;

	}
	
	
	
	
	/**
	 * Contains Display logics
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside do get");

		UserModel model = new UserModel();

		UserBean bean = (UserBean) populateBean(request);

		List list = new ArrayList();
        
		
		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));
		List next=null;
		
		try {

			list = model.search(bean, pageNo, pageSize);
			next= model.search(bean, pageNo+1, pageSize);
			
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("no record exist", request);
			}

			if(next==null || next.size()==0){
				request.setAttribute("nextList1","0");
			}
			else{
				request.setAttribute("nextList1",next.size());
			}

			
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (Exception e) {
			e.printStackTrace();
			ServletUtility.handleException(e, request, response);
		}

		log.debug("");
	}
	
	
	
	
	/**
	 * Contains Submit logics
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 System.out.println("inside do post");
		 
		 String op = DataUtility.getString(request.getParameter("operation"));
		 
		String ids1[]= request.getParameterValues("ids");
		 
		 int pageNo =DataUtility.getInt(request.getParameter("pageno"));
		 int pageSize= DataUtility.getInt(request.getParameter("pagesize"));
		 
		 
		 pageNo = (pageNo==0)?1:pageNo;
		 pageSize= (pageSize==0)?DataUtility.getInt(request.getParameter("page.size")):pageSize;
		 
		 if(OP_SEARCH.equalsIgnoreCase(op)){
			 pageNo=1;
		 }
		 else if(OP_PREVIOUS.equalsIgnoreCase(op)){
			    if(pageNo>1){
			    	pageNo--;
			    }
			    else{
			    	pageNo=1;
			    	ServletUtility.setErrorMessage("No previous page", request);
			    }
		 }
		 else if(OP_NEXT.equalsIgnoreCase(op)){
			 pageNo++;
		 }
		 
		 else if(OP_NEW.equalsIgnoreCase(op)){
			 ServletUtility.redirect(ORSView.USER_CTL, request, response);
			 return;
		 }
		 
		 else if(OP_RESET.equalsIgnoreCase(op)){
			 ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
			 return;
		 }
		 else if(OP_DELETE.equalsIgnoreCase(op)){
			 
			 if(ids1!=null &&  ids1.length>0){
				 
				 UserModel mod = new UserModel();
				 
				 UserBean dbean = new UserBean();
				 
				 for(String idnew:ids1){
				 
					 int idnew1= DataUtility.getInt(idnew);
					 dbean.setId(idnew1);
				 try {
					mod.delete(dbean);
					ServletUtility.setSuccessMessage("User Deleted Successfully", request);
				} catch (ApplicationException e) {
					e.printStackTrace();
				}
				 }
			 }
			 
			 else{
				 ServletUtility.setErrorMessage("Select Atleast One Record", request);
				   
			 }
			 
		 }
		 
		 List<UserBean> list = new ArrayList();
		
		 List next=null;
		 
		 UserModel model = new UserModel();
		 
		 UserBean bean = (UserBean)populateBean(request);
		 
		 try{
		 list = model.search(bean, pageNo, pageSize);
		 next= model.search(bean, pageNo+1, pageSize);
		 
		    if(list==null ||list.size()==0 && !OP_DELETE.equalsIgnoreCase(op)){
		    	ServletUtility.setErrorMessage("No User Found", request);
		    }
		    if(next==null || next.size()==0){
				request.setAttribute("nextList1","0");
			}
			else{
				request.setAttribute("nextList1",next.size());
			}
		    
		    ServletUtility.setList(list, request);
		    ServletUtility.setPageNo(pageNo, request);
		    ServletUtility.setPageSize(pageSize, request);
		    ServletUtility.forward(getView(), request, response);
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }

	}

	@Override
	protected String getView() {
		return ORSView.USER_LIST_VIEW;
	}

}
