package in.co.rays.ors.ctl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.CourseBean;
import in.co.rays.ors.model.CourseModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;
/**
 * course list functionality ctl.Toperform search and delete,show list operation
 * @author AYUSH
 *
 */
@WebServlet(name = "CourseListCtl", urlPatterns = { "/ctl/CourseListCtl" })
public class CourseListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	protected BaseBean populateBean(HttpServletRequest request) {

		System.out.println("populate");

		CourseBean bean = new CourseBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setcName(DataUtility.getString(request.getParameter("cname")));
		bean.setDuration(DataUtility.getString(request.getParameter("duration")));
		bean.setDescription(DataUtility.getString(request.getParameter("desc")));
		populateDTO(bean, request);
		return bean;

	}
	/**
	 * Display Logics inside this method
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside doGet");

		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));

		CourseModel model = new CourseModel();

		CourseBean bean = new CourseBean(); // No need to populate during list
											// display

		List list = new ArrayList();
		try {

			list = model.search(bean, pageNo, pageSize);

			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found", request);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		ServletUtility.setList(list, request);
		ServletUtility.setPageNo(pageNo, request);
		ServletUtility.setPageSize(pageSize, request);
		ServletUtility.forward(getView(), request, response);

	}
	/**
	 * Submit logic inside it
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = DataUtility.getLong(request.getParameter("id"));
		String op = DataUtility.getString(request.getParameter("operation"));

		String ids[] = request.getParameterValues("ids");

		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;

		if (OP_SEARCH.equalsIgnoreCase(op)) {
			pageNo = 1;

		} else if (OP_PREVIOUS.equalsIgnoreCase(op)) {
			pageNo--;
		
		} else if (OP_NEXT.equalsIgnoreCase(op)) {
			pageNo++;
		}

		else if (OP_NEW.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.COURSE_CTL, request, response);
			return;
		}

		else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.COURSE_LIST_CTL, request, response);
			return;
		}

		else if (OP_DELETE.equalsIgnoreCase(op)) {

			CourseModel mod = new CourseModel();
			CourseBean dbean = new CourseBean();

			if (ids != null && ids.length > 0) {

				for (String id2 : ids) {
					int idnew = DataUtility.getInt(id2);
					dbean.setId(idnew);
					try {
						mod.delete(dbean);
						ServletUtility.setSuccessMessage("Course Deleted Successfully", request);
						ServletUtility.forward(getView(), request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				ServletUtility.setErrorMessage("Select Atleast One Record", request);
			}
		}

		CourseModel model = new CourseModel();

		CourseBean bean = (CourseBean) populateBean(request);

		List list = new ArrayList();

		try {
			list = model.search(bean, pageNo, pageSize);

			if (list == null || list.size() == 0 && !OP_DELETE.equalsIgnoreCase(op)) {
				ServletUtility.setErrorMessage("No Course found", request);
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
		return ORSView.COURSE_LIST_VIEW;
	}

}
