<!--
Name:		 
Date: 		 
Purpose:	 for the purpose of webd4201-lab 3 
Description: This is the update page that have a dc-logo 
  -->

 <%!
	String title = "Update";
%>
<!-- dynamic title for the page register -->
<title> <%= title %> </title>
<%@ include file = "./header.jsp" %>

	<hr/>
	<img src = "images/dc-logo.png" alt="Durham College Logo" height = "150px" width ="320" class ="center"/>
	<hr/>
	
	<h2>Update</h2>

<%@ include file ="./footer.jsp" %>