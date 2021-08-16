package in.co.rays.ors.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.StudentBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.CollegeModel;
import in.co.rays.ors.model.StudentModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;

/**
 * student functionality controller.to perform add,delete ,update operation
 * @author AYUSH
 *
 */


@WebServlet(name = "StudentCtl", urlPatterns = { "/ctl/StudentCtl" })
public class StudentCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(StudentCtl.class);

	
	
	protected void preload(HttpServletRequest request) {

		System.out.println("preload");

		CollegeModel model = new CollegeModel();

		try {
			List list = model.list();
			request.setAttribute("collegeList", list);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	
	
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("");

		StudentBean bean = new StudentBean();

		System.out.println("populate called");
		String db1 = request.getParameter("dob1");

		System.out.println("db1 value is" + db1);

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		bean.setDob(DataUtility.getDate(db1));
		bean.setMobileNo(DataUtility.getString(request.getParameter("mobile")));
		bean.setAddress(DataUtility.getString(request.getParameter("address")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setCollegeId(DataUtility.getLong(request.getParameter("college")));

		populateDTO(bean, request);
		return bean;
	}

	
	
	protected boolean validate(HttpServletRequest request) {

		System.out.println("validation perform");
		boolean pass = true;
		String db = request.getParameter("dob1");
		System.out.println("db value is" + db);

		if (DataValidator.isNull(request.getParameter("college"))) {
			request.setAttribute("college", PropertyReader.getValue("error.require", "College Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			request.setAttribute("first_Name", PropertyReader.getValue("error.require", "First Name"));
			pass = false;
		}

		else if (!DataValidator.isName(request.getParameter("firstName"))) {
			request.setAttribute("first_Name", "Invalid First Name");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("last_Name", PropertyReader.getValue("error.require", "Last name"));
			pass = false;
		}

		else if (!DataValidator.isName(request.getParameter("lastName"))) {
			request.setAttribute("last_Name", "Invalid Last Name");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("dob1"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "DOB"));
			pass = false;
		}
		
		else if(!DataValidator.isValidAge(request.getParameter("dob1"))){
			request.setAttribute("dob", PropertyReader.getValue("error.date","DOB"));
			pass=false;
		}

		if (DataValidator.isNull(request.getParameter("mobile"))) {
			request.setAttribute("mobile", PropertyReader.getValue("error.require", "Mobile No"));
			pass = false;
		}

		else if (!DataValidator.isMobileNo(request.getParameter("mobile"))) {
			request.setAttribute("mobile", "Invalid Mobile No(starting digit should be between 6 to 9");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("address"))) {
			request.setAttribute("address", PropertyReader.getValue("error.require", "Address"));
			pass = false;
		}

		else if (!DataValidator.isAddress(request.getParameter("address"))) {
			request.setAttribute("address", "Invalid Address");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getValue("error.require", "Emailid"));
			pass = false;
		} else if (!DataValidator.isEmail(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getValue("error.email", "Invalid"));
			pass = false;
		}

		System.out.println("pass=" + pass);
		return pass;
	}

	
	
	/**
	 * Contains Display logics
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("StudentCtl Method doGet Started ");

		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println("id------------");
		String op = DataUtility.getString(request.getParameter("operation"));

		StudentModel model = new StudentModel();
		if (id > 0) {
			StudentBean bean;
			try {
				bean = model.findByPk(id);
				System.out.println("id is" + bean.getFirstName());
				ServletUtility.setBean(bean, request);

			} catch (Exception e) {
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
			}
		}

		ServletUtility.forward(getView(), request, response);

		log.debug("");
	}

	
	
	
	/**
	 * Contains Submit logics
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside do post");

		long id = DataUtility.getLong(request.getParameter("id"));
		System.out.println("id------------");
		String op = DataUtility.getString(request.getParameter("operation"));

		StudentModel model = new StudentModel();

		if (OP_SAVE.equalsIgnoreCase(op)) {

			StudentBean bean1 = (StudentBean) populateBean(request);
			long pk = 0;

			try {
				pk = model.add(bean1);
				bean1.setId(pk);
				ServletUtility.setSuccessMessage("Student Added Successfully", request);
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				e.printStackTrace();
			} catch (DuplicateRecordException e) {
				// TODO Auto-generated catch block
				ServletUtility.setErrorMessage("Student Already Exist", request);
				ServletUtility.setBean(bean1, request);
				e.printStackTrace();
			}

			ServletUtility.forward(getView(), request, response);
		}

		else if (op.equals("Update")) {

			StudentBean bean2 = (StudentBean) populateBean(request);
			if (id > 0) {
				try {
					model.update(bean2);

					ServletUtility.setSuccessMessage("Student Updated Successfully", request);
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ServletUtility.handleException(e, request, response);
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ServletUtility.setErrorMessage("Student Already Exist", request);
				}

			}
			ServletUtility.setBean(bean2, request);
			ServletUtility.forward(getView(), request, response);
			return;
		}

		 else if (OP_CANCEL.equalsIgnoreCase(op)) {
			System.out.println("cancel worked");
			ServletUtility.redirect(ORSView.STUDENT_LIST_CTL, request, response);
			return;

		} else if (OP_RESET.equalsIgnoreCase(op)) {
			System.out.println("reset worked");
			ServletUtility.redirect(ORSView.STUDENT_CTL, request, response);
			return;

		}

	}

	@Override
	protected String getView() {
		return ORSView.STUDENT_VIEW;
	}

}
