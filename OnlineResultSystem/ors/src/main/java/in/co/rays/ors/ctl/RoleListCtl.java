package in.co.rays.ors.ctl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.RoleBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.model.RoleModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;


/**
 * role list functionality controller. to show list and search of role operation
 * 
 * @author AYUSH
 *
 */

@WebServlet(name="RoleListCtl",urlPatterns={"/ctl/RoleListCtl"})
public class RoleListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
    
	private static Logger log= Logger.getLogger(RoleListCtl.class);
   
	
	
	protected BaseBean populateBean(HttpServletRequest request){
		
		RoleBean bean = new RoleBean();
		bean.setName(DataUtility.getString(request.getParameter("name")));
		return bean;
	}
	
	
	/**
	 * Contains Display logics
	 */
	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		log.debug("");
		System.out.println("inside do get");
		
		int pageNo=1;
		int pageSize= DataUtility.getInt(PropertyReader.getValue("page.size"));
		
		RoleModel model = new RoleModel();
		RoleBean bean = (RoleBean)populateBean(request);
		
		List<RoleBean> list = new ArrayList<RoleBean>();
		
		try{
			list = model.search(bean, pageNo, pageSize);
			
			if(list.size()==0 || list==null){
				ServletUtility.setErrorMessage("No record exist", request);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ServletUtility.setList(list, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request, response);
	}

	
	
	
	/**
	 * Contains Submit logics
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		log.debug("");
		System.out.println("inside do post");
		
		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize= DataUtility.getInt(request.getParameter("pageSize"));
		
		
		pageNo = (pageNo==0)?1:pageNo;
		pageSize= (pageSize==0)?DataUtility.getInt
				    (PropertyReader.getValue("page.size")):pageSize;

	    String op = DataUtility.getString(request.getParameter("operation"));
		
	    String ids[]=request.getParameterValues("ids");
	    
	    if(OP_SEARCH.equalsIgnoreCase(op)){
			pageNo=1;
		}
		else if(OP_PREVIOUS.equalsIgnoreCase(op)){
			
			if(pageNo>1){
				pageNo--;
			}
			else{
				pageNo=1;
			}
		}
		else if(OP_NEXT.equalsIgnoreCase(op)){
			pageNo++;
		}
		
		else if(OP_NEW.equalsIgnoreCase(op)){
			ServletUtility.redirect(ORSView.ROLE_CTL, request, response);
			return;
		}
		
		else if(OP_RESET.equalsIgnoreCase(op)){
			ServletUtility.redirect(ORSView.ROLE_LIST_CTL, request, response);
			return;
		}
		else if(OP_DELETE.equalsIgnoreCase(op)){
			RoleModel mod = new RoleModel();
			RoleBean dbean = new RoleBean();
			
			if(ids!=null && ids.length>0){
				
				for(String id2:ids){
				int idnew = DataUtility.getInt(id2);
				dbean.setId(idnew);
				try {
					mod.delete(dbean);
					ServletUtility.setSuccessMessage("Role Deleted Successfully", request);
					//ServletUtility.forward(getView(), request, response);
				} catch(Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				}
			}
			else{
				ServletUtility.setErrorMessage("Select Atleast One Record", request);
			}
		}
		
		RoleModel model = new RoleModel();
		RoleBean bean = (RoleBean)populateBean(request);
		
		List<RoleBean> list= new ArrayList<RoleBean>();
		try{
			
			list = model.search(bean, pageNo, pageSize);
			if(list==null || list.size()==0 && !OP_DELETE.equalsIgnoreCase(op)){
				ServletUtility.setErrorMessage("No Role Found", request);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ServletUtility.setList(list, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request, response);
	}


	@Override
	protected String getView() {
		return ORSView.ROLE_LIST_VIEW;
	}

}
