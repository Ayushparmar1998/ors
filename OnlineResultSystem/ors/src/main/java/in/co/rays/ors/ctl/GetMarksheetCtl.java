package in.co.rays.ors.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.BaseBean;
import in.co.rays.ors.bean.MarksheetBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.model.MarksheetModel;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.DataValidator;
import in.co.rays.ors.util.PropertyReader;
import in.co.rays.ors.util.ServletUtility;

/**
 * get marksheet functionality ctl.to perform  get marksheet opeation
 * @author AYUSH
 *
 */


@WebServlet(name = "GetMarksheetCtl", urlPatterns = { "/ctl/GetMarksheetCtl" })
public class GetMarksheetCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(GetMarksheetCtl.class);

	protected boolean validate(HttpServletRequest request) {
		log.debug("GetMarksheetCTL Method validate Ended");
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("rollNo"))) {
			request.setAttribute("rollno1", PropertyReader.getValue("error.require", "Roll No"));
			pass = false;
		}
		/*else if(!DataValidator.isRollNo(request.getParameter("rollNo"))){
			request.setAttribute("rollno1","enter Valid roll No");
			pass=false;
		}*/
		/*else if(!DataValidator.isInteger(request.getParameter("rollNo")))
		 {
			request.setAttribute("rollno1", "Enter Number Only");
			pass=false;	 
		 }
*/
		
		log.debug("GetMarksheetCTL Method validate Ended");
		return pass;
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		log.debug("GetMarksheetCtl Method populatebean Begin");
		MarksheetBean bean = new MarksheetBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setRollNo(DataUtility.getString(request.getParameter("rollNo")));

		bean.setName(DataUtility.getString(request.getParameter("name")));

		bean.setPhysics(DataUtility.getInt(request.getParameter("physics")));

		bean.setChemistry(DataUtility.getInt(request.getParameter("chemistry")));

		bean.setMaths(DataUtility.getInt(request.getParameter("maths")));

		log.debug("GetMarksheetCtl Method populatebean Ended");

		return bean;
	}

	
	/**
	 * Concept of Display method
	 */
	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletUtility.forward(getView(), request, response);
	}

	
	
	
	/**
     * Concept of submit method
     *
     */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("inside dopost method");

		log.debug("MarksheetCtl Method doGet Begin");

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = (MarksheetBean) populateBean(request);

		String op = DataUtility.getString(request.getParameter("operation"));

		System.out.println("operation in " + op);
		long id = DataUtility.getLong(request.getParameter("id"));

		if (OP_GO.equalsIgnoreCase(op)) {

			try {
				bean = model.findByRollNo(bean.getRollNo());
				System.out.println("bean value " + bean.getRollNo() + " " + bean.getName());

				if (bean.getRollNo() != null) {
					 System.out.println("if part of roll no");
					ServletUtility.setBean(bean, request);
					//ServletUtility.setSuccessMessage("found marksheet", request);
					ServletUtility.forward(getView(), request, response);
				}

				else {
					// System.out.println("else part");
					ServletUtility.setErrorMessage("RollNo Does Not exists", request);
					ServletUtility.forward(getView(), request, response);
				}
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}

			
		}

		else if(OP_RESET.equalsIgnoreCase(op)){
			System.out.println("reset per");
			ServletUtility.redirect(ORSView.GET_MARKSHEET_CTL, request, response);
			return;
		}
		
		log.debug("MarksheetCtl Method doGet Ended");
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.GET_MARKSHEET_VIEW;
	}

}
