package in.co.rays.ors.ctl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.CollegeBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.CollegeModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;
/**
 * college functionality ctl. To perform add,delete ,update operation
 * @author AYUSH
 * 
 */

@WebServlet(name = "CollegeCtl", urlPatterns = { "/ctl/CollegeCtl" })
public class CollegeCtl extends BaseCtl {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(CollegeCtl.class);

	
	
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("");

		CollegeBean bean = new CollegeBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("cName")));
		bean.setAddress(DataUtility.getString(request.getParameter("cAddress")));
		bean.setState(DataUtility.getString(request.getParameter("cState")));
		bean.setCity(DataUtility.getString(request.getParameter("cCity")));
		bean.setPhoneNo(DataUtility.getString(request.getParameter("cPhone")));
		populateDTO(bean, request);
		return bean;
	}

	protected boolean validate(HttpServletRequest request) {
		log.info("Hmm hai toh kyaa gum hai");

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("cName"))) {
			request.setAttribute("c_Name", PropertyReader.getValue("error.require", "College Name"));
			pass = false;
		} else if (!DataValidator.isName1(request.getParameter("cName"))) {
			request.setAttribute("c_Name", "Invalid College Name");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("cAddress"))) {
			request.setAttribute("c_Address", PropertyReader.getValue("error.require", "College Address"));
			pass = false;
		}

		else if (!DataValidator.isAddress(request.getParameter("cAddress"))) {
			request.setAttribute("c_Address", "Invalid Address");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("cState"))) {
			request.setAttribute("c_State", PropertyReader.getValue("error.require", "State"));
			pass = false;
		}

		else if (!DataValidator.isName1(request.getParameter("cState"))) {
			request.setAttribute("c_State", "Invalid State Name");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("cCity"))) {
			request.setAttribute("c_City", PropertyReader.getValue("error.require", "City"));
			pass = false;
		} else if (!DataValidator.isName1(request.getParameter("cCity"))) {
			request.setAttribute("c_City", "Invalid City Name");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("cPhone"))) {
			request.setAttribute("c_Phone", PropertyReader.getValue("error.require", "Phone no"));
			pass = false;
		} else if (!DataValidator.isPhoneNo(request.getParameter("cPhone"))) {
			request.setAttribute("c_Phone", "Invalid Phone No");
			pass = false;
		}
         log.info("Aeee bhagvan uthaa le");
		return pass;
	}

	
	
	 /* *
	  * Display Logics inside this method
	  * 
	  */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside do get");

		long id = DataUtility.getLong(request.getParameter("id"));

		String op = DataUtility.getString(request.getParameter("operation"));

		CollegeModel model = new CollegeModel();

		CollegeBean bean = null;

		if (id > 0) {
			try {
				bean = model.findByPK(id);
				System.out.println("id =" + bean.getId());
				ServletUtility.setBean(bean, request);
				// ServletUtility.forward(getView(), request, response);

			}

			catch (Exception e) {
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

		System.out.println("insided do post");

		log.debug("");

		long id = DataUtility.getLong(request.getParameter("id"));

		String op = DataUtility.getString(request.getParameter("operation"));

		CollegeModel model = new CollegeModel();


		if (OP_SAVE.equalsIgnoreCase(op)) {

			CollegeBean bean = (CollegeBean) populateBean(request);

			try {
				id = model.add(bean);
				bean.setId(id);
				ServletUtility.setSuccessMessage("College Added Successfully ", request);

			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				ServletUtility.handleException(e, request, response);
				e.printStackTrace();

			} catch (DuplicateRecordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ServletUtility.setErrorMessage("College Already Exist", request);
				ServletUtility.setBean(bean, request);
			}

			ServletUtility.forward(getView(), request, response);
		}

		else if (op.equals("Update")) {

			if (id > 0) {
				CollegeBean bean1 = (CollegeBean) populateBean(request);

				try {
					model.update(bean1);
					ServletUtility.setSuccessMessage("College  Updated Successfully ", request);

				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ServletUtility.handleException(e, request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ServletUtility.setBean(bean1, request);
				ServletUtility.forward(getView(), request, response);
			}

		}

		else if (OP_CANCEL.equalsIgnoreCase(op)) {
			System.out.println("button cancel pe");
			ServletUtility.redirect(ORSView.COLLEGE_LIST_CTL, request, response);
			return;
		}

		else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.COLLEGE_CTL, request, response);
			return;
		}
		log.debug("CollegeCtl Method doGet Ended");
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.COLLEGE_VIEW;
	}

}
