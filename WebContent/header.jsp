<%--
Name:		 
Date: 		 
Purpose:	 
Description: This is the header page that have a nav bar and this page will be 
implemented by all the js pages
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns = "http://www.w3.org/1999/xhtml" xml:lang= "en" lang = "en">
<%@ page import = "webd4201.mansoorm.*" %>
<%@ page import = "java.util.*" %>
<head>

<meta http-equiv= "Content-Type" content="text/html; charset=utf-8"/>
<title>Insert title here</title>
<link href = "./css/durham.css" rel = "stylesheet" type = "text/css"/>
<%

	String message = (String)session.getAttribute("message");
	if(message == null) // if the message attribute is null 
	{
		message = ""; //prevents nullpointer exception
	}
	else //if the message attribute is not null then 
	{
		//remove the message to prevent re-displaying
		session.removeAttribute("message");	
	}
	
	String href1 = "";
	String link1 = "";
	String href2 = "";
	String link2 = "";
	String href3 = "";
	String link3 = "";
	
	if(session.getAttribute("student") != null)
	{
		//when the student is logged in display the other pages to the student 
			href1 = "./Logout";
		 	link1 = "Logout";
		 	href2 = "update.jsp";
		 	link2 = "Update";
		 	href3 = "dashboard.jsp";
		 	link3 = "Dashboard";
	}
	else{
		 href1 = "login.jsp";
		 link1 = "Login";
		 href2 = "register.jsp";
		 link2 = "Register";
		 href3 = "";
		 link3 = "";
	}
%>
</head>
<body>
	<a href ="<%= href1 %>"><%= link1 %></a>
	<a href ="<%= href2 %>"><%= link2 %></a>
	<a href ="<%= href3 %>"><%= link3 %></a>
