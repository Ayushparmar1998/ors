package in.co.rays.ors.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.ServletUtility;

/**
 * welcome functionality controller.to  show welcome page
 * @author AYUSH
 *
 */

@WebServlet(name="WelcomeCtl",urlPatterns={"/WelcomeCtl"})
public class WelcomeCtl extends BaseCtl {
	
	private static final long serialVersionUID = 1L;
      
	private static Logger log = Logger.getLogger(WelcomeCtl.class);
    
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.debug("WelcomeCtl Method doGet Started");
		
		ServletUtility.forward(ORSView.WELCOME_VIEW, request, response);
		
		log.debug("WelcomeCtl Method doGet end");
       }
	
	
	@Override
	protected String getView(){
			return ORSView.WELCOME_VIEW;
		}

}
