<%--
Name:		
Date: 		 
Purpose:	 for the purpose of webd4201-lab 3 
Description: This is the register page that have a dc-logo 
 --%>
<%
	String title = "Register";
%>
<!-- dynamic title for the page register -->
<title><%= title %></title>

<!--  including header and footer -->
<%@ include file = "./header.jsp" %>
	<hr/>
	<p><img src = "images/dc-logo.png" alt="Durham College Logo" height = "150px" width ="320" class ="center"/></p>
	<hr/>
	
	<h2>Register</h2>

<%@ include file ="./footer.jsp" %>