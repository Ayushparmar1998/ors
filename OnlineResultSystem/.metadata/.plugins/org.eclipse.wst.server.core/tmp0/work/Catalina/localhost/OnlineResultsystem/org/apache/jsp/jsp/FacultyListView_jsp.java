/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.43
 * Generated at: 2021-07-12 12:28:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import in.co.model.FacultyModel;
import in.co.bean.CollegeBean;
import in.co.bean.CourseBean;
import in.co.controller.FacultyListCtl;
import java.util.Iterator;
import in.co.bean.FacultyBean;
import in.co.util.DataUtility;
import in.co.util.DataValidator;
import in.co.util.HTMLUtility;
import in.co.util.ServletUtility;
import java.util.List;
import in.co.util.ServletUtility;
import java.util.Enumeration;
import in.co.controller.LoginCtl;
import in.co.controller.ORSView;
import in.co.bean.RoleBean;
import in.co.bean.UserBean;

public final class FacultyListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/jsp/Footer.jsp", Long.valueOf(1559805840000L));
    _jspx_dependants.put("/jsp/Header.jsp", Long.valueOf(1626089442654L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("in.co.util.HTMLUtility");
    _jspx_imports_classes.add("java.util.Enumeration");
    _jspx_imports_classes.add("in.co.bean.RoleBean");
    _jspx_imports_classes.add("in.co.controller.ORSView");
    _jspx_imports_classes.add("in.co.bean.CourseBean");
    _jspx_imports_classes.add("in.co.bean.UserBean");
    _jspx_imports_classes.add("in.co.controller.LoginCtl");
    _jspx_imports_classes.add("in.co.bean.CollegeBean");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("in.co.util.DataUtility");
    _jspx_imports_classes.add("in.co.util.DataValidator");
    _jspx_imports_classes.add("in.co.bean.FacultyBean");
    _jspx_imports_classes.add("in.co.util.ServletUtility");
    _jspx_imports_classes.add("in.co.controller.FacultyListCtl");
    _jspx_imports_classes.add("in.co.model.FacultyModel");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/img/logo.png\" />\r\n");
      out.write("<title>Faculty list Page</title>\r\n");
      out.write("<script  src=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/js/jquery.min.js\">\r\n");
      out.write("\t\r\n");
      out.write("</script>\t\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/js/checkbox11.js\"></script>\r\n");
      out.write(" \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

UserBean userBean = (UserBean)session.getAttribute("user");
  

boolean userLogged = userBean != null;

String welcomeMsg="Hi";

if(userLogged){
	String role = (String)session.getAttribute("role");
	
	welcomeMsg= welcomeMsg+"  "+userBean.getFirstName()+" "+"("+role+")";
	
	
}
else{
	welcomeMsg = welcomeMsg+" , "+"Guest";
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<table  width=\"100%\" >\r\n");
      out.write("<tr>\r\n");
      out.write("        <td ><a href=\"");
      out.print(ORSView.WELCOME_CTL);
      out.write("\">Welcome</b></a> |\r\n");
      out.write("            ");

            if (userLogged) {
        
      out.write("  <a href=\"");
      out.print(ORSView.LOGIN_CTL);
      out.write("?operation=");
      out.print(LoginCtl.OP_LOG_OUT);
      out.write("\">Logout</b></a>\r\n");
      out.write("              \r\n");
      out.write("            ");

                } else {
            
      out.write(" <a href=\"");
      out.print(ORSView.LOGIN_CTL);
      out.write("\">Login</a> ");

     }
 
      out.write("</td>\r\n");
      out.write("        <td rowspan=\"2\">\r\n");
      out.write("            \r\n");
      out.write("                <img align=\"right\" src=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/img/sun.jpg\"  width=\"180\"\r\n");
      out.write("                    height=\"40\">\r\n");
      out.write("            \r\n");
      out.write("        </td>\r\n");
      out.write("\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td >\r\n");
      out.write("            <h3>\r\n");
      out.write("                ");
      out.print(welcomeMsg);
      out.write("</h3>\r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("     \r\n");
      out.write("\t");

        if (userLogged) {
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td colspan=\"2\" >\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        ");

           if (userBean.getRoleId() == RoleBean.ADMIN) 
            {
         
      out.write(" \r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MY_PROFILE_CTL);
      out.write("\"><b>MyProfile</b></a> | \r\n");
      out.write("        <a href=\"");
      out.print(ORSView.CHANGE_PASSWORD_CTL);
      out.write("\">Change Password</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.GET_MARKSHEET_CTL);
      out.write("\">Get Marksheet</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\">Marksheet MeritList</b></a> |\r\n");
      out.write("        \r\n");
      out.write("            <a href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\">Add Marksheet</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\">Marksheet List</b></a>  | \r\n");
      out.write("            <a href=\"");
      out.print(ORSView.USER_CTL);
      out.write("\">Add User</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.USER_LIST_CTL);
      out.write("\">User List</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COLLEGE_CTL);
      out.write("\">Add College</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\">Add Student</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.ROLE_CTL);
      out.write("\">Add Role</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.ROLE_LIST_CTL);
      out.write("\">Role List</b></a>  |  <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COURSE_CTL);
      out.write("\">Add Course</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</b></a>  |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.SUBJECT_CTL);
      out.write("\">Add Subject</b></a>  |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_CTL);
      out.write("\">Add Faculty</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\">Faculty List</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_CTL);
      out.write("\">Add Timetable</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">Timetable List</b></a>  |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.JAVA_DOC_VIEW);
      out.write("\" target=\"blank\">Java Doc</b></a>  \r\n");
      out.write("    \r\n");
      out.write("      ");

         }
      
      out.write("\r\n");
      out.write("\r\n");
      out.write("      ");

      if(userBean.getRoleId() == RoleBean.STUDENT){
    	  System.out.println("role name  "+userBean.getRoleId());
       
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MY_PROFILE_CTL);
      out.write("\">MyProfile</b></a> | \r\n");
      out.write("        <a href=\"");
      out.print(ORSView.CHANGE_PASSWORD_CTL);
      out.write("\">Change Password</b></a> |\r\n");
      out.write("        \r\n");
      out.write("         <a href=\"");
      out.print(ORSView.GET_MARKSHEET_CTL);
      out.write("\">Get Marksheet</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\">Marksheet MeritList</b></a> |\r\n");
      out.write("        \r\n");
      out.write("      \r\n");
      out.write("       <a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</b></a>  |\r\n");
      out.write("      \r\n");
      out.write("       \r\n");
      out.write("    ");

      }
    
      out.write("\r\n");
      out.write("\r\n");
      out.write("     ");

      if(userBean.getRoleId() == RoleBean.FACULTY){
    	  System.out.println("role id "+userBean.getRoleId());
       
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <a href=\"");
      out.print(ORSView.GET_MARKSHEET_CTL);
      out.write("\">Get Marksheet</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\">Marksheet MeritList</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MY_PROFILE_CTL);
      out.write("\">MyProfile</b></a> | \r\n");
      out.write("        <a href=\"");
      out.print(ORSView.CHANGE_PASSWORD_CTL);
      out.write("\">Change Password</b></a> |\r\n");
      out.write("        \r\n");
      out.write("      <a href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\">Marksheet List</b></a> | \r\n");
      out.write("            <a href=\"");
      out.print(ORSView.USER_CTL);
      out.write("\">Add User</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.USER_LIST_CTL);
      out.write("\">User List</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COLLEGE_CTL);
      out.write("\">Add College</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\">College List</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\">Add Student</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.ROLE_CTL);
      out.write("\">Add Role</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.ROLE_LIST_CTL);
      out.write("\">Role List</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COURSE_CTL);
      out.write("\">Add Course</b></a> | |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\">Course List</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.SUBJECT_CTL);
      out.write("\">Add Subject</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_CTL);
      out.write("\">Add Faculty</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\">Faculty List</b></a>|<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_CTL);
      out.write("\">Add Timetable</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">Timetable List</b></a> |\r\n");
      out.write("        \r\n");
      out.write("       \r\n");
      out.write("    ");

      }
    
      out.write("\r\n");
      out.write("         \r\n");
      out.write("      ");

      if(userBean.getRoleId() == RoleBean.COLLEGE){
    	  System.out.println("role id  "+userBean.getRoleId());
       
      out.write("\r\n");
      out.write("\r\n");
      out.write("     <a href=\"");
      out.print(ORSView.GET_MARKSHEET_CTL);
      out.write("\">Get Marksheet</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\">Marksheet MeritList</b></a> |\r\n");
      out.write("        \r\n");
      out.write("      <a href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\">Add Marksheet</b></a>  |  \r\n");
      out.write("      <a href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\"><b>Marksheet List</b></a> | \r\n");
      out.write("            <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\">Add Student</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\">Student List</b></a> | \r\n");
      out.write("            <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\">Faculty List</b></a>|<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\">Timetable List</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\">Subject List</b></a>\r\n");
      out.write("       \r\n");
      out.write("    ");

      }
    
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("  </td>    \r\n");
      out.write("        \r\n");
      out.write("    </tr>\r\n");
      out.write("    ");

        }
    
      out.write("\r\n");
      out.write("            \r\n");
      out.write(" </table>\r\n");
      out.write("<hr>\r\n");
      out.write(" </body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<h1>Faculty list</h1>\r\n");
      in.co.bean.FacultyBean bean = null;
      bean = (in.co.bean.FacultyBean) _jspx_page_context.getAttribute("bean", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (bean == null){
        bean = new in.co.bean.FacultyBean();
        _jspx_page_context.setAttribute("bean", bean, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h2>\r\n");
      out.write("<font color=\"red\">");
      out.print(ServletUtility.getErrorMessage(request));
      out.write("</font>\r\n");
      out.write("</h2>\r\n");
      out.write("\r\n");
      out.write("<h2>\r\n");
      out.write("<font color=\"green\">");
      out.print(ServletUtility.getSuccessMessage(request));
      out.write("</font>\r\n");
      out.write("</h2>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\" method=\"post\">\r\n");

List li = ServletUtility.getList(request);

if(li==null || li.size()==0){

      out.write("\r\n");
      out.write("<input type=\"submit\" name =\"operation\" value=\"");
      out.print(FacultyListCtl.OP_BACK);
      out.write("\">\t\r\n");
} else { 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("<tr align=\"center\">\r\n");
      out.write("    <td><label>FirstName</label>\r\n");
      out.write("    <input type=\"text\" name = \"fname\" value=\"");
      out.print(ServletUtility.getParameter("fname", request));
      out.write("\">\r\n");
      out.write("   &nbsp;<label>LastName</label> \r\n");
      out.write("   <input type=\"text\" name = \"lname\" value=\"");
      out.print(ServletUtility.getParameter("lname", request));
      out.write("\">\r\n");
      out.write("  &nbsp;<label>LoginId</label>\r\n");
      out.write("  <input type=\"text\" name = \"login\" value=\"");
      out.print(ServletUtility.getParameter("login", request));
      out.write("\">\r\n");
      out.write("  &nbsp;\r\n");
      out.write("  <input type=\"submit\" name=\"operation\" value=\"");
      out.print(FacultyListCtl.OP_SEARCH);
      out.write("\">\r\n");
      out.write("   &nbsp;\r\n");
      out.write("  <input type=\"submit\" name=\"operation\" value=\"");
      out.print(FacultyListCtl.OP_RESET);
      out.write("\">\r\n");
      out.write("  \r\n");
      out.write("  </td>\r\n");
      out.write(" </tr>  \r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\" border=\"1\">\r\n");
      out.write("<tr>\r\n");
      out.write("    <th><input type=\"checkbox\" id =\"select_all\" name=\"ids\">Select All</th>\r\n");
      out.write("    <th>SNO</th>\r\n");
      out.write("    <th>FIRST_NAME</th>\r\n");
      out.write("    <th>LAST_NAME</th>\r\n");
      out.write("    <th>LOGIN_ID</th>\r\n");
      out.write("    <th>Address</th>\r\n");
      out.write("    <th>DATE_OF_JOINING</th>\r\n");
      out.write("    <th>QUALIFICATION</th>\r\n");
      out.write("    <th>MOBILE_NO</th>\r\n");
      out.write("    <th>COLLEGE NAME</th>\r\n");
      out.write("    <th>COURSE NAME</th>\r\n");
      out.write("    <th>SUBJECT NAME</th>\r\n");
      out.write("    <th>EDIT</th>\r\n");
      out.write(" </tr>\r\n");
      out.write(" <tr>\r\n");
      out.write(" ");

 int pageNo  = ServletUtility.getPageNo(request);
 int pageSize= ServletUtility.getPageSize(request);
 int index   = ((pageNo-1)*pageSize)+1;
 
 List list = ServletUtility.getList(request);
 
 Iterator it= list.iterator();
  
 while(it.hasNext()){
	  bean= (FacultyBean)it.next();
	 System.out.println("view in"+bean.getCollegeName());
 
 
      out.write(" \r\n");
      out.write("    <td><input type=\"checkbox\" class=\"checkbox\" name =\"ids\" value=\"");
      out.print(bean.getId());
      out.write("\"></td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(index++);
      out.write("</td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getFirstName());
      out.write("</td> \r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getLastName());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getLoginId());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getAddress());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getDateOfJoining());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getQualification());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getMobileNo());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getCollegeName());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getCourseName() );
      out.write("</td>\r\n");
      out.write("    <td align=\"center\">");
      out.print(bean.getSubjectName());
      out.write("</td>\r\n");
      out.write("    <td align=\"center\"><a href=\"FacultyCtl?id=");
      out.print(bean.getId());
      out.write("\">Edit</a></td>\r\n");
      out.write(" </tr>\r\n");
      out.write(" ");
} 
      out.write("\r\n");
      out.write(" \r\n");
      out.write("</table>\r\n");

FacultyModel model = new FacultyModel();

      out.write("\r\n");
      out.write("<table width=\"100%\">\r\n");
      out.write("<tr>\r\n");
      out.write("    <td align=\"left\"><input type=\"submit\" name=\"operation\" value=\"");
      out.print(FacultyListCtl.OP_PREVIOUS);
      out.write('"');
      out.print((pageNo==1)?"disabled":"" );
      out.write("></td>\r\n");
      out.write(" <td align=\"center\"><input type=\"submit\" name=\"operation\" value=\"");
      out.print(FacultyListCtl.OP_NEW);
      out.write("\"></td>\r\n");
      out.write(" <td align=\"center\"><input type=\"submit\" name=\"operation\" value=\"");
      out.print(FacultyListCtl.OP_DELETE);
      out.write("\"></td>\r\n");
      out.write(" <td align=\"right\"><input type=\"submit\" name=\"operation\" value=\"");
      out.print(FacultyListCtl.OP_NEXT);
      out.write('"');
      out.print(((list.size()<pageSize || model.nextPk()-1==bean.getId())?"disabled":""));
      out.write(">\r\n");
      out.write("  </td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("  <input type=\"hidden\" name = \"pageNo\" value=\"");
      out.print(pageNo);
      out.write("\">\r\n");
      out.write("  <input type=\"hidden\" name = \"pageSize\" value=\"");
      out.print(pageSize);
      out.write("\">\r\n");
      out.write("</form>\r\n");
      out.write("</center>\r\n");
} 
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write(".footer {\r\n");
      out.write("  position: fixed;\r\n");
      out.write("  left: 0;\r\n");
      out.write("  bottom: 0;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("\r\n");
      out.write("<HR>\r\n");
      out.write("<CENTER>\r\n");
      out.write("    <H3>&copy Copyrights Rays Technologies</H3>\r\n");
      out.write("</CENTER>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<br><br><br>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
