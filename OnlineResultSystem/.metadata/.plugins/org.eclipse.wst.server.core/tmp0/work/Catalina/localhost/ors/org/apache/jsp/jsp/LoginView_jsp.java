/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.43
 * Generated at: 2021-08-13 21:33:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import in.co.rays.ors.util.ServletUtility;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.ctl.ORSView;
import in.co.rays.ors.util.ServletUtility;
import java.util.Enumeration;
import in.co.rays.ors.ctl.LoginCtl;
import in.co.rays.ors.ctl.ORSView;
import in.co.rays.ors.bean.RoleBean;
import in.co.rays.ors.bean.UserBean;

public final class LoginView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/jsp/Footer.jsp", Long.valueOf(1628760829002L));
    _jspx_dependants.put("/jsp/Header.jsp", Long.valueOf(1628762711613L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("in.co.rays.ors.util.ServletUtility");
    _jspx_imports_classes.add("in.co.rays.ors.ctl.ORSView");
    _jspx_imports_classes.add("in.co.rays.ors.bean.RoleBean");
    _jspx_imports_classes.add("in.co.rays.ors.bean.UserBean");
    _jspx_imports_classes.add("java.util.Enumeration");
    _jspx_imports_classes.add("in.co.rays.ors.util.DataUtility");
    _jspx_imports_classes.add("in.co.rays.ors.ctl.LoginCtl");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"");
      out.print(ORSView.APP_CONTEXT);
      out.write("/img/logo.png\" sizes=\"16*16\"/>\r\n");
      out.write("<title> Login Page</title>\r\n");
      out.write("</head>\r\n");
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
      out.write("/img/logo.png\"  width=\"180\"\r\n");
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
      out.write("\"><b>Change Password</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.GET_MARKSHEET_CTL);
      out.write("\"><b>Get Marksheet</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\"><b>Marksheet MeritList</b></a> |\r\n");
      out.write("        \r\n");
      out.write("            <a href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\"><b>Add Marksheet</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\"><b>Marksheet List</b></a>  | \r\n");
      out.write("            <a href=\"");
      out.print(ORSView.USER_CTL);
      out.write("\"><b>Add User</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.USER_LIST_CTL);
      out.write("\"><b>User List</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COLLEGE_CTL);
      out.write("\"><b>Add College</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\"><b>College List</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\"><b>Add Student</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\"><b>Student List</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.ROLE_CTL);
      out.write("\"><b>Add Role</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.ROLE_LIST_CTL);
      out.write("\"><b>Role List</b></a>  |  <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COURSE_CTL);
      out.write("\"><b>Add Course</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\"><b>Course List</b></a>  |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.SUBJECT_CTL);
      out.write("\"><b>Add Subject</b></a>  |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\"><b>Subject List</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_CTL);
      out.write("\"><b>Add Faculty</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\"><b>Faculty List</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_CTL);
      out.write("\"><b>Add Timetable</b></a>  | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\"><b>Timetable List</b></a>  |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.JAVA_DOC_VIEW);
      out.write("\" target=\"blank\"><b>Java Doc</b></a>  \r\n");
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
      out.write("\"><b>MyProfile</b></a> | \r\n");
      out.write("        <a href=\"");
      out.print(ORSView.CHANGE_PASSWORD_CTL);
      out.write("\"><b>Change Password</b></a> |\r\n");
      out.write("        \r\n");
      out.write("         <a href=\"");
      out.print(ORSView.GET_MARKSHEET_CTL);
      out.write("\"><b>Get Marksheet</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\"><b>Marksheet MeritList</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\"><b>Subject List</b></a>  |\r\n");
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
      out.write("\"><b>Get Marksheet</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\"><b>Marksheet MeritList</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MY_PROFILE_CTL);
      out.write("\"><b>MyProfile</b></a> | \r\n");
      out.write("        <a href=\"");
      out.print(ORSView.CHANGE_PASSWORD_CTL);
      out.write("\"><b>Change Password</b></a> |\r\n");
      out.write("        \r\n");
      out.write("      <a href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\"><b>Marksheet List</b></a> | \r\n");
      out.write("            <a href=\"");
      out.print(ORSView.USER_CTL);
      out.write("\"><b>Add User</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.USER_LIST_CTL);
      out.write("\"><b>User List</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COLLEGE_CTL);
      out.write("\"><b>Add College</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COLLEGE_LIST_CTL);
      out.write("\"><b>College List</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\"><b>Add Student</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\"><b>Student List</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.ROLE_CTL);
      out.write("\"><b>Add Role</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.ROLE_LIST_CTL);
      out.write("\"><b>Role List</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COURSE_CTL);
      out.write("\"><b>Add Course</b></a> | |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.COURSE_LIST_CTL);
      out.write("\"><b>Course List</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.SUBJECT_CTL);
      out.write("\"><b>Add Subject</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\"><b>Subject List</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_CTL);
      out.write("\"><b>Add Faculty</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\"><b>Faculty List</b></a>|<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_CTL);
      out.write("\"><b>Add Timetable</b></a> |<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\"><b>Timetable List</b></a> |\r\n");
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
      out.write("\"><b>Get Marksheet</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.MARKSHEET_MERIT_LIST_CTL);
      out.write("\"><b>Marksheet MeritList</b></a> |\r\n");
      out.write("        \r\n");
      out.write("      <a href=\"");
      out.print(ORSView.MARKSHEET_CTL);
      out.write("\"><b>Add Marksheet</b></a>  |  \r\n");
      out.write("      <a href=\"");
      out.print(ORSView.MARKSHEET_LIST_CTL);
      out.write("\"><b>Marksheet List</b></a> | \r\n");
      out.write("            <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_CTL);
      out.write("\"><b>Add Student</b></a> | <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.STUDENT_LIST_CTL);
      out.write("\"><b>Student List</b></a> | \r\n");
      out.write("            <a\r\n");
      out.write("            href=\"");
      out.print(ORSView.FACULTY_LIST_CTL);
      out.write("\"><b>Faculty List</b></a>|<a\r\n");
      out.write("            href=\"");
      out.print(ORSView.TIMETABLE_LIST_CTL);
      out.write("\"><b>Timetable List</b></a> |\r\n");
      out.write("        <a href=\"");
      out.print(ORSView.SUBJECT_LIST_CTL);
      out.write("\"><b>Subject List</b></a>\r\n");
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
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"");
      out.print(ORSView.LOGIN_CTL);
      out.write("\" method=\"post\">\r\n");
      out.write("\t\t");
      in.co.rays.ors.bean.UserBean bean = null;
      bean = (in.co.rays.ors.bean.UserBean) _jspx_page_context.getAttribute("bean", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (bean == null){
        bean = new in.co.rays.ors.bean.UserBean();
        _jspx_page_context.setAttribute("bean", bean, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t\t<h1>Login</h1>\r\n");

  String uri= (String)request.getAttribute("uri");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("             ");
 String str= (String)request.getAttribute("error11");
             if(str!=null){ 
             
      out.write("\r\n");
      out.write("             <h2><font color=\"red\">");
      out.print(request.getAttribute("error11") );
      out.write("</font></h2>\r\n");
      out.write("              ");
} 
      out.write("\r\n");
      out.write("             <h2>\r\n");
      out.write("             <font color=\"red\">");
      out.print(ServletUtility.getErrorMessage(request) );
      out.write("</font>\r\n");
      out.write("             </h2>\r\n");
      out.write("              <h2>\r\n");
      out.write("             <font color=\"green\">");
      out.print(ServletUtility.getSuccessMessage(request) );
      out.write("</font>\r\n");
      out.write("             </h2> \r\n");
      out.write("             \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(bean.getId());
      out.write("\"> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"createdBy\" value=\"");
      out.print(bean.getCreatedBy());
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"modifiedBy\" value=\"");
      out.print(bean.getModifiedBy());
      out.write("\"> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"createdDateTime\" value=\"");
      out.print(DataUtility.getTimestamp(bean.getCreatedDateTime()));
      out.write("\">\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"modifiedDateTime\" value=\"");
      out.print(DataUtility.getTimestamp(bean.getModifiedDateTime()));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th align=\"left\">LoginId<span style=\"color: red\">*</span></th>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"login\"  value=\"");
      out.print(DataUtility.getStringData(bean.getLogin()));
      out.write("\" placeholder=\"Enter Emailid\"> \r\n");
      out.write("\t\t\t\t\t </td>\t\r\n");
      out.write("\t\t\t\t\t\t<td style=\"position: fixed;\"><font color=\"red\">");
      out.print(ServletUtility.getErrorMessage("login", request));
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th align=\"left\">password<span style=\"color: red\">*</span></th>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"password\" value=\"");
      out.print(DataUtility.getStringData(bean.getPassword()));
      out.write("\" placeholder=\"Enter Password\"> \r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t<td style=\"position: fixed;\"><font color=\"red\">");
      out.print(ServletUtility.getErrorMessage("password", request));
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"submit\" name=\"operation\"\r\n");
      out.write("\t\t\t\t\t\tvalue=\"");
      out.print(LoginCtl.OP_SIGN_IN);
      out.write("\"> &nbsp;\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" name=\"operation\" value=\"");
      out.print(LoginCtl.OP_SIGN_UP);
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th></th>\r\n");
      out.write("\t\t\t\t\t<td><a href=\"");
      out.print(ORSView.FORGET_PASSWORD_CTL);
      out.write("\"><b>Forget\r\n");
      out.write("\t\t\t\t\t\t\t\tmy password</b></a></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"hidden\" name=\"str\" value=\"");
      out.print(uri);
      out.write("\">\r\n");
      out.write("\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write(".footer {\r\n");
      out.write("  position: relative;\r\n");
      out.write("  left: 0;\r\n");
      out.write("  bottom: 0;\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  text-align: center;\r\n");
      out.write(" }\r\n");
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
