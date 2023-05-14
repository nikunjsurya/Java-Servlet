<!--  
Name:		 
Date: 		 
Purpose:	 
Description: This is the Dashboard page that will display the student information
 -->
 <% 
		Student aStudent = (Student)session.getAttribute("student"); 
		if(aStudent==null){
			response.sendRedirect("./login.jsp");
			return;
		}
 %>
<%! String title = "Dashboard" ; %>
<!-- dynamic title for the page register --> 
<title><%= title %></title>
<!--  including header and footer -->
<%@ include file = "./header.jsp" %>
	<hr/>
	<!--  Durham College logo  -->
	<p><img src = "images/dc-logo.png" alt="Durham College Logo" height = "150px" width ="320" class ="center"/></p>
	<hr/>
	<!-- importing the package  -->
	<%@ page import = "webd4201.mansoorm.*" %>
	<!-- retrieve a student object -->
	
	<h3><%=message %></h3>
	<h2>Student Information</h2>
	<!--  Student's information -->
		<h4>Name:<%= aStudent.getFirstName() %> <%= aStudent.getLastName()%>  </h4>
		<h4>Student ID: <%= aStudent.getId() %> </h4>
		<h4>Program: <%= aStudent.getProgramDescription() %> (<%= aStudent.getProgramCode() %>)</h4>
		<h4>Enroll Date: <%= aStudent.getEnrolDate() %></h4>
		<h4>You last logged in on: <%= aStudent.getLastAccess() %></h4> 
<%@ include file ="./footer.jsp" %>