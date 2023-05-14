<%--
Name:		 
Date: 		 
Purpose:	 for the purpose of webd4201-lab 3 
Description: This is the login page that have a form for student information 
 --%>
<html>
<!-- package import -->
<%@ page import = "webd4201.mansoorm.*" %>
<!--  variable declarations -->
<%  String errorMessage = (String)session.getAttribute("errors"); 
	if(errorMessage == null) // if the message attribute is null 
	{
		errorMessage = ""; //prevents nullpointer exception
	}
	else //if the message attribute is not null then 
	{
			//remove the message to prevent re-displaying
			session.removeAttribute("errors");	
	}
		//get the student id from the session
	String login = (String)session.getAttribute("id");
		//get the student's password from the session
	String password = (String)session.getAttribute("password");
		//if there is no error empty the error message 
	if(errorMessage == null)
		//set the error message to empty
		errorMessage="";
		//if the login id textbox is null set the textbox to empty
	if(login == null)
		login = "";
		//if the password textbox is null set the textbox value to empty
	if(password == null)
		password ="";
%>
<%
//varaible for holding the title of the page
	String title = "Login";
%>
<!-- dynamic title for the page register -->
<title><%= title %></title>
<body>
<!-- implementing header -->
<%@ include file = "./header.jsp" %>

<br/>
<!-- page heading -->
	<hr/>
	<!-- Durham college logo -->
		<p><img src = "images/dc-logo.png" alt="Durham College Logo" height = "150px" width ="250px"/></p>
	<hr/>
<h2>Please log in</h2>
	<p>Enter your login information below.<br>
	   If you are not a student, please return to the
	   <a href="index.jsp">Mark Tracker</a> home page.</p>
	<p>
	   If you are a student and don't have an account, <a href="register.jsp">register here</a>.
	</p>

	<form name="Input" method="post" action="./Login" >
		<!-- action="http://localhost:81/Bradshaw/LoginServlet" > -->
		<table align ="center" border=0 bgcolor="lightgoldenrodyellow" >
		<tr>
		<td colspan="2" align="center"><%= errorMessage %>
		</td>
		</tr>
		<tr>
		<!-- login text box -->
			<td><strong>Login Id</strong></td>
			<td><input type="text" name="Login" value="<%= login %>" size=20></td>
		</tr>
		<tr>
		<!-- password text box -->
			<td id ="pass"><strong>Password</strong></td>
			<td><input type="password" name="password" value="<%= password %>" size=20></td>
		</tr>
		</table>
		<!-- table for the submit and clear button  -->
		<table border=0  align="center">
		<tr>
			<td><input type="submit" value = "Log In"></td>
			<td><input type="reset" value = "Clear"></td>
		</tr>
		</table>
	</form>
	Please wait after pressing <strong>Log in</strong>
	while we retrieve your records from our database.<br>
	<em>(This may take a few moments)</em>


<!--  implementing footer  -->
<%@ include file ="./footer.jsp" %>