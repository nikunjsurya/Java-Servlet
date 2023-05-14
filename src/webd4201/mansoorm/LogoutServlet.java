package webd4201.mansoorm;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
/**
 * Logout Servlet class that extends the generic http servlet 
 * this class is created as per the instruction to fullfil the requirements of 
 * webd4201-course's lab 3 
 * 
 * this class  will simply remove the student object from the session 
 * and redirect the user to the login page with a display message 
 * 
 * @author 
 * @version  1.0 (2022.02.27)
 * @since 1.0
 */
public class LogoutServlet extends HttpServlet {
	
	/**
	 * this method will retrieves a session data from tht http servlet 
	 * and simply removes the logged in student object from the server 
	 * @param request httpservlerRequest
	 * @param response httpserverResponse
	 * @throws ServletException
	 * @throws IOException 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//retrieves the session 
		HttpSession session = request.getSession(true);
		//remove the student from the session
		session.removeAttribute("student");
		//display successful logged out message 
		session.setAttribute("errors", "<strong>You have successfully logged out</strong>");
		//redirect user to the login page 
		response.sendRedirect("./login.jsp");
		
	}
	
	/**
	 * this method will call the doPost method above and simply remove the student 
	 * if the page is submitted in the get mode
	 * @throws ServletException 
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		doPost(request, response);
	}
}