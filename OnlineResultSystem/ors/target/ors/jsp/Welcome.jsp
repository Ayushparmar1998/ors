<%-- <%@page import="in.co.rays.ors.ctl.ORSView"%>

<html>
<head>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" />
<title>Welcome Page</title>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16*16"/>
<title> Welcome Page</title>
</head>
<body>
<%@ include file="Header.jsp" %>

<form action="<%=ORSView.WELCOME_CTL%>" method="post">

<h1 align="Center">
 <font size="10px" color="red">Welcome to ORS</font>
      </h1>
      
      <%
      UserBean userbean1 =(UserBean)session.getAttribute("user");
        if(userbean1!=null){
        	if(userbean1.getRoleId()==RoleBean.STUDENT){
       %>
       
       <h2 align="center">
       <a href="<%=ORSView.GET_MARKSHEET_CTL %>">click here to see ur marksheet</a>
       </h2>
       
       <%
        	}
        }
      
        %>

</form>
</body>
<%@ include file="Footer.jsp"%> 

</html> --%>






<%@page import="in.co.rays.ors.ctl.ORSView"%>
<%@page import="in.co.rays.ors.bean.UserBean"%>
<%@page import="in.co.rays.ors.bean.RoleBean"%>
<html>

<body >
    <form action="<%=ORSView.WELCOME_CTL%>">
    <center>
        <%@ include file="Header.jsp"%> 
                    <h1 align="Center">
                    <br>
                    <br>
                    <!-- <br> -->
                    
                        <font size="50px;" color="red">Welcome to ORS </font>
                    </h1>
                    
                <br><br><!-- <br><br><br><br><br> -->
            </center>    
                    
        
                    <%
                    UserBean beanUserBean = (UserBean) session.getAttribute("user");
                        if (beanUserBean != null) {
                            if (beanUserBean.getRoleId() == RoleBean.STUDENT) {
                    %> 
        
                    <h2 align="Center">
                        <a href="<%=ORSView.GET_MARKSHEET_CTL%>">Click here to see your Marksheet </a>
                    </h2>
                     
                      <%
                            }
                        }
                     %> 
                
                </form>
        
         <%@ include file="Footer.jsp"%>
</body>
</html>