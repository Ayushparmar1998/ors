package in.co.rays.ors.ctl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.CollegeBean;
import in.co.rays.ors.bean.CourseBean;
import in.co.rays.ors.bean.FacultyBean;
import in.co.rays.ors.model.CollegeModel;
import in.co.rays.ors.model.CourseModel;
import in.co.rays.ors.model.FacultyModel;
import in.co.rays.ors.model.SubjectModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;
/**
 * faculty list functionality ctl.To perform show,search and delete operation
 * @author AYUSH
 *
 */
@WebServlet(name = "FacultyListCtl", urlPatterns = { "/ctl/FacultyListCtl" })
public class FacultyListCtl extends BaseCtl {

	private static final long serialVersionUID = 1L;

	protected BaseBean populateBean(HttpServletRequest request) {

		FacultyBean bean = new FacultyBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setFirstName(DataUtility.getString(request.getParameter("fname")));
		bean.setLastName(DataUtility.getString(request.getParameter("lname")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setLoginId(DataUtility.getString(request.getParameter("login")));
		bean.setAddress(DataUtility.getString(request.getParameter("address")));
		// bean.setDateOfJoining(DataUtility.getDate(request.getParameter("doj")));
		bean.setQualification(DataUtility.getString(request.getParameter("qual")));
		bean.setMobileNo(DataUtility.getString(request.getParameter("mobile")));
		bean.setCollegeId(DataUtility.getInt(request.getParameter("collegeName")));
		 bean.setCollegeName(DataUtility.getString(request.getParameter("collegeName")));
		System.out.println("name of college" + (request.getParameter("collegeName")));
		bean.setCourseId(DataUtility.getInt(request.getParameter("courseid")));
		bean.setCourseName(DataUtility.getString(request.getParameter("courseName")));
		bean.setSubjectId(DataUtility.getInt(request.getParameter("subjectid")));
		System.out.println(" subject id is" + request.getParameter("subjectid"));
		System.out.println(" subject name is" + request.getParameter("subjectName"));
		bean.setSubjectName(DataUtility.getString(request.getParameter("subjectName")));
		populateDTO(bean, request);

		return bean;
	}
	/**
	 * contain display logic
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside doGet");

		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		List list = new ArrayList();
		FacultyModel model = new FacultyModel();
		FacultyBean bean = new FacultyBean();
		try {

			list = model.search(bean, pageNo, pageSize);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("no record found", request);
			}

			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * Contains submit logic
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside do post");

		long id = DataUtility.getInt(request.getParameter("id"));
		String op = DataUtility.getString(request.getParameter("operation"));

		String ids[] = request.getParameterValues("ids");

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;

		if (OP_SEARCH.equalsIgnoreCase(op)) {
			System.out.println("search called");
			pageNo = 1;
		}

		else if (OP_PREVIOUS.equalsIgnoreCase(op)) {

			if (pageNo > 1) {
				pageNo--;
			} else {
				pageNo = 1;
			}
		}

		else if (OP_NEXT.equalsIgnoreCase(op)) {
			pageNo++;
		}

		else if (OP_NEW.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.FACULTY_CTL, request, response);
			return;
		}

		else if(OP_RESET.equalsIgnoreCase(op)){
			ServletUtility.redirect(ORSView.FACULTY_LIST_CTL, request, response);
			return;
		}
		else if(OP_BACK.equalsIgnoreCase(op)){
			ServletUtility.redirect(ORSView.FACULTY_LIST_CTL, request, response);
			return;
		}
		else if (OP_DELETE.equalsIgnoreCase(op)) {

			FacultyModel mod = new FacultyModel();
			FacultyBean dbean = new FacultyBean();

			if (ids != null && ids.length > 0) {

				for (String id2 : ids) {
					int idnew = DataUtility.getInt(id2);
					dbean.setId(idnew);
					try {
						mod.delete(dbean);
						ServletUtility.setSuccessMessage("Faculty Deleted Successfully", request);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				ServletUtility.setErrorMessage("Select Atleast One Record", request);
			}
		}

		List list = new ArrayList();
		FacultyModel model = new FacultyModel();
		FacultyBean bean = null;
		try {
			bean = (FacultyBean) populateBean(request);
			list = model.search(bean, pageNo, pageSize);
			if (list == null || list.size() == 0 && !OP_DELETE.equalsIgnoreCase(op)) {
				ServletUtility.setErrorMessage("No Faculty Found", request);
			}

			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.FACULTY_LIST_VIEW;
	}

}
