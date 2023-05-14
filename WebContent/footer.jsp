<%--
Name:		 
Date: 		 
Purpose:	 
Description: This is the footer page that displays the copyright date and validator info
 --%>
<%-- importing the java util library for the calendar class --%>
<%@ page import = "java.util.*" %>

<p>
	<a href = "http://validator.org/check?uri=referer"><img 
	alt="Valid XHTML 1.0 Strict" src="http://www.w3.org/Icons/valid-xhtml10" height="31" width = "88"/></a>
</p>

<span id ="copyright">&copy;<%=(Calendar.getInstance()).get(Calendar.YEAR)%></span>
</body>
</html>