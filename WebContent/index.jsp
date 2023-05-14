<%--
Name:		 
Date: 		 
Purpose:	 for the purpose of webd4201-lab 3 
Description: This is the index page that is the main page of the site
 --%>
<%
	String title = "Index";
%>
<!-- dynamic title for the page register -->
<title><%= title %></title>
 <!-- implementing header -->
<%@ include file = "./header.jsp" %>
<br/>
<body>
<!-- page heading -->
	<h1>Welcome to Durham College's Student Mark Tracking Site</h1>
	<hr/>
	<!-- durham college logo -->
		<p><img src = "images/dc-logo.png" alt="Durham College Logo" height = "150px"/></p>
		<hr/>
		<!-- web page description -->
		<p class ="centerItem"> This website allows student's to track their grades in each of their repsective
		courses in an easy to navigate format</p>
		<p class ="centerItem"> To log in you must be a student of Durham College and must have a valid <b>Id</b>
		and <b>Password</b> set up before hand</p>
		
		<p class ="centerItem"><br/> If you are a Durham College student please log in here</p>
		<table id ="tableCenter" >
		<tr>
		<!--  link to login.jsp page  -->
			<td>
				<a id ="a1" href = "login.jsp">
				<strong id = "LoginText">Log In</strong></a>
			</td>
		</tr>
		</table>
		<!--  img for validation -->
		<p><img src ="images/indexValid.PNG" alt ="XHTML validation picture - Index"
		class ="center"/><br/></p>
</body>
		<!--  implementing footer -->
<%@ include file ="./footer.jsp" %>
