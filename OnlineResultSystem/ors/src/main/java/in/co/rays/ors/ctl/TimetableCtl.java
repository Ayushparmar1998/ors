package in.co.rays.ors.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.TimetableBean;
import in.co.rays.ors.model.CourseModel;
import in.co.rays.ors.model.SubjectModel;
import in.co.rays.ors.model.TimetableModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;


/**
 * Timetable functionality controller. to perform add,delete and update
 * operation
 * @author AYUSH
 *
 */

@WebServlet(name = "TimetableCtl", urlPatterns = { "/ctl/TimetableCtl" })
public class TimetableCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	
	
	protected void preload(HttpServletRequest request) {

		System.out.println("in preload");

		CourseModel cmodel = new CourseModel();
		try {
			List list1 = cmodel.list();
			request.setAttribute("courseList", list1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SubjectModel smodel = new SubjectModel();
		try {
			List list2 = smodel.list();
			request.setAttribute("subjectList", list2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	protected boolean validate(HttpServletRequest request) {
		
		boolean pass=true;
		
		if(DataValidator.isNull(request.getParameter("courseid"))){
			request.setAttribute("courseName1",PropertyReader.getValue("error.require","Course Name"));
		   pass= false;
		}
		if(DataValidator.isNull(request.getParameter("subjectid"))){
			request.setAttribute("subjectName1",PropertyReader.getValue("error.require","Subject Name"));
		   pass= false;
		}
		if(DataValidator.isNull(request.getParameter("sem"))){
			request.setAttribute("sem1",PropertyReader.getValue("error.require","Semester"));
		   pass= false;
		}
		
		if(DataValidator.isNull(request.getParameter("examtime"))){
			request.setAttribute("examtime1",PropertyReader.getValue("error.require","Examtime"));
		   pass= false;
		}
		if(DataValidator.isNull(request.getParameter("examdate"))){
			request.setAttribute("examdate1",PropertyReader.getValue("error.require","Examdate"));
		   pass= false;
		}
		System.out.println("VALUE OF PASS IS"+pass);
		return pass;
	}


	
	
	protected BaseBean populateBean(HttpServletRequest request) {

		System.out.println("in populateBean");
		
		TimetableBean bean = new TimetableBean();
		
		bean.setId(DataUtility.getInt(request.getParameter("id")));
		bean.setCourseId(DataUtility.getInt(request.getParameter("courseid")));
		bean.setCourseName(DataUtility.getString(request.getParameter("courseName")));
		System.out.println("Course name is"+request.getParameter("courseName"));
		bean.setSubjectId(DataUtility.getInt(request.getParameter("subjectid")));
		bean.setSubjectName(DataUtility.getString(request.getParameter("subjectName")));
		System.out.println("subject name is"+request.getParameter("subjectName"));
		bean.setSemester(DataUtility.getString(request.getParameter("sem")));
		bean.setExamTime(DataUtility.getString(request.getParameter("examtime")));
		bean.setExamDate(DataUtility.getDate(request.getParameter("examdate")));
		populateDTO(bean, request);
		
		return bean;
	}
	

	
	
	/**
	 * Display Logics inside this method
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id =DataUtility.getLong(request.getParameter("id"));
		
		TimetableModel model = new TimetableModel();
		TimetableBean bean;
		if(id>0){
			try {
				bean=model.findByPk(id);
				ServletUtility.setBean(bean, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		ServletUtility.forward(getView(), request, response);
	}

	
	
	
	/**
	 * Submit logic inside it
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id =DataUtility.getLong(request.getParameter("id"));
		String op =DataUtility.getString(request.getParameter("operation"));
		
		TimetableModel model = new TimetableModel();
		if(OP_SAVE.equalsIgnoreCase(op)){
			TimetableBean bean1 = (TimetableBean)populateBean(request);
			try {
				id= model.add(bean1);
				ServletUtility.setSuccessMessage("Timetable Added Successfullly", request);
			} catch (Exception e) {
				e.printStackTrace();
				ServletUtility.setErrorMessage("Timetable Already Exist", request);
				ServletUtility.setBean(bean1, request);
			}
			
			ServletUtility.forward(getView(), request, response);
		}
		
		else if(op.equals("Update")){
			TimetableBean bean2 = (TimetableBean)populateBean(request);
			if(id>0){
				
				try {
					model.update(bean2);
					ServletUtility.setSuccessMessage("Timetable Updated Successfullly", request);
				} catch (Exception e) {
					e.printStackTrace();
					ServletUtility.setErrorMessage("Timetable Already Exist", request);
				}
			}
			ServletUtility.setBean(bean2, request);
			ServletUtility.forward(getView(), request, response);
		}
		
		else if(op.equals("Reset")){
			ServletUtility.redirect(ORSView.TIMETABLE_CTL, request, response);
			return;
		}
		else if(OP_CANCEL.equalsIgnoreCase(op)){
			ServletUtility.redirect(ORSView.TIMETABLE_LIST_CTL, request, response);
		    return;
		}
	}

	
	
	@Override
	protected String getView() {
		return ORSView.TIMETABLE_VIEW;
	}

}
