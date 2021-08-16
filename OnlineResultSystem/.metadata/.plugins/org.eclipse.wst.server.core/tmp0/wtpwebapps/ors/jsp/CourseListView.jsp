<%@page import="in.co.rays.ors.model.CourseModel"%>
<%@page import="in.co.rays.ors.ctl.CourseListCtl"%>
<%@page import="in.co.rays.ors.bean.CourseBean"%>
<%@page import="in.co.rays.ors.util.HTMLUtility" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.ors.util.ServletUtility"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16"/>
<title>Course List Page</title>
<script  src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js">
	
</script>	
<script type="text/javascript" src="<%=ORSView.APP_CONTEXT%>/js/checkbox11.js"></script>
 
</head>
<body>
<%@include file="Header.jsp" %>
 <jsp:useBean id="bean" class="in.co.rays.ors.bean.CourseBean" scope="request"></jsp:useBean> 

<form action="<%=ORSView.COURSE_LIST_CTL %>" method="post">


<center>
 
     <h1>Course List</h1>
      <h2>
      <font color="red"><%=ServletUtility.getErrorMessage(request) %></font>
      </h2>
      <h2>
      <font color="green"><%=ServletUtility.getSuccessMessage(request) %></font>
      </h2>

<% List l = ServletUtility.getList(request); 
if(l==null || l.size()==0){%>
<input type="submit" name="operation" value="<%=CourseListCtl.OP_BACK %>">	
<%}else{ %>

<table align="center">
<tr align="center">
    <td><label>CourseName</label>
    <input type="text" name ="cname" value="<%=ServletUtility.getParameter("cname", request)%>"  " placeholder="Enter Course Name">
    &nbsp;
    <td><label>Duration</label>
    <input type="text" name ="duration" value="<%=ServletUtility.getParameter("duration", request) %>"  " placeholder="Enter Duration">
    &nbsp;
    <input type="submit" name="operation" value="<%=CourseListCtl.OP_SEARCH %>">
   &nbsp;
    <input type="submit" name="operation" value="<%=CourseListCtl.OP_RESET %>">
   
   </td>
 </tr> 
 
 
 
 <%-- <tr  align="center">
					<td><label class="p1">Course Name</label>&emsp;<%=HTMLUtility.getList("courseId", String.valueOf(bean.getId()), l)%>&emsp;&emsp;
					<td><label>CourseName</label>
                   <input type="text" name ="cname" value="<%=ServletUtility.getParameter("cname", request) %>">
                    &nbsp;
					<label class="p1">Duration</label>&emsp;<%
						HashMap map = new HashMap();
							map.put("1year","1year");
							map.put("2year","2year");
							map.put("3year","3year");
							map.put("4year","4year");
							map.put("5year","5year");
							
							String HtmlList = HTMLUtility.getList("duration", bean.getDuration(), map);
					%><%=HtmlList%>&emsp;&emsp; 
					<input type="submit" name="operation"
						value="<%=CourseListCtl.OP_SEARCH%>" style="padding: 3px;">&emsp;
						<input type="submit" name="operation"
						value="<%=CourseListCtl.OP_RESET%>" style="padding: 3px;"></td>
				</tr> --%>
</table>
</center>
<table width="100%" border="1">
<tr><th><input type="checkbox" id ="select_all" name="ids">Select All</th>
    <th>SNO</th>
    <th>CourseName</th>
    <th>Duration</th>
    <th>Description</th>
    <th>Edit</th>
  </tr>  

<tr>

   <%
   int pageNo = ServletUtility.getPageNo(request);
   int pageSize= ServletUtility.getPageSize(request);
   int index= ((pageNo-1)*pageSize)+1;
   
   
   List list = ServletUtility.getList(request);
   
   Iterator it = list.iterator();
   //CourseBean bean1;
   while(it.hasNext()){
	   bean = (CourseBean)it.next();
   
   %>
   <td><input type="checkbox" class="checkbox" name="ids" value="<%=bean.getId()%>"></td>
   <td align="center"><%=index++%></td>
   <td align="center"><%=bean.getcName()%></td>
   <td align="center"><%=bean.getDuration()%></td>
   <td align="center"><%=bean.getDescription()%></td>
   <td align="center"><a href="CourseCtl?id=<%=bean.getId()%>">Edit</a></td>
    </tr>
   <%-- <%  System.out.println("id=========="+bean1.getId());%> --%>
   
   <%} %>
</table>

<%
CourseModel model = new CourseModel();
//CourseBean bean2 = new CourseBean();
System.out.println("pk=========="+(model.nextPk()-1));
System.out.println("id=========="+bean.getId());
%>

<table width="100%">
<tr>
    <td align="left"><input type="submit" name="operation" value="<%=CourseListCtl.OP_PREVIOUS%>"<%=(pageNo==1)?"disabled":"" %>></td>
    <td align="center"><input type="submit" name="operation" value="<%=CourseListCtl.OP_NEW%>"></td>
  <td align="center"><input type="submit" name="operation" value="<%=CourseListCtl.OP_DELETE%>"></td>
   <td align="right"><input type="submit" name="operation" value="<%=CourseListCtl.OP_NEXT%>"<%=((list.size()<pageSize) || model.nextPk()-1==bean.getId())?"disabled":""%>>
</td>
</tr>
</table>

<input type="hidden" name ="pageNo" value="<%=pageNo%>">
<input type="hidden" name ="pageSize" value="<%=pageSize%>">

</form>
<%} %>


</body>
<br><br><br>
<%@include file="Footer.jsp"%>

</html>