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
import in.co.rays.ors.bean.RoleBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.model.RoleModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;

/**
 * role functionality controller.to perform add,delete ,update operation
 * @author AYUSH
 *
 */


@WebServlet(name = "RoleCtl", urlPatterns = { "/ctl/RoleCtl" })
public class RoleCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(RoleCtl.class);

	
	
	protected BaseBean populateBean(HttpServletRequest request) {

		RoleBean bean = new RoleBean();

		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setDescription(DataUtility.getString(request.getParameter("desc")));
		populateDTO(bean, request);

		return bean;
	}

	
	
	protected boolean validate(HttpServletRequest request) {

		log.debug("");
		System.out.println("validation");
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name1", PropertyReader.getValue("error.require", "Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name1", "Invalid Role Name");
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("desc"))) {
			request.setAttribute("desc1", PropertyReader.getValue("error.require", "Description"));
			pass = false;
		}
		
		else if (!DataValidator.isName1(request.getParameter("desc"))) {
			request.setAttribute("desc1", "Invalid Role Name");
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

		log.debug("");
		System.out.println("inside do get of role");

		long id = DataUtility.getLong(request.getParameter("id"));

		System.out.println("id in role " + id);
		String op = DataUtility.getString(request.getParameter("operation"));

		RoleModel model = new RoleModel();

		RoleBean bean = null;

		if (id > 0 || op != null) {

			try {

				bean = model.findByPk(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ServletUtility.setBean(bean, request);
		ServletUtility.forward(getView(), request, response);
	}

	
	
	
	/**
	 * Contains Submit logics
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.debug("");
		System.out.println("inside do post of role");

		long id = DataUtility.getLong(request.getParameter("id"));

		String op = DataUtility.getString(request.getParameter("operation"));

		// String name = DataUtility.getString(request.getParameter("name"));
		RoleModel model = new RoleModel();

		if (OP_SAVE.equalsIgnoreCase(op)) {

			RoleBean bean;
			bean = (RoleBean) populateBean(request);

			try {
				model.add(bean);
				ServletUtility.setSuccessMessage("Role Added Successfully", request);
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (DuplicateRecordException e) {
				e.printStackTrace();
				ServletUtility.setErrorMessage("Role Already Exist", request);
				ServletUtility.setBean(bean, request);
			}

			// ServletUtility.setBean(bean, request); //It is used to set the
			// data again in text filed which is not required while inserting
			ServletUtility.forward(getView(), request, response);
		}

		else if (op.equals("Update")) {
			RoleBean bean1 = (RoleBean) populateBean(request);
			if (id > 0) {

				try {
					model.update(bean1);
					ServletUtility.setSuccessMessage("Role Updated Successfully", request);
				} catch (DuplicateRecordException e) {
					e.printStackTrace();
					ServletUtility.setErrorMessage("Role Already Exist", request);
				} catch (ApplicationException e) {
					e.printStackTrace();
				}

			}
			ServletUtility.setBean(bean1, request);
			ServletUtility.forward(getView(), request, response);
		}

		else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.ROLE_LIST_CTL, request, response);
			return;
		}

		else if (op.equals("Reset")) {
			ServletUtility.redirect(ORSView.ROLE_CTL, request, response);
			return;
		}

	}

	@Override
	protected String getView() {
		return ORSView.ROLE_VIEW;
	}

}
