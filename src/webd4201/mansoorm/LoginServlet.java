package webd4201.mansoorm;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

@SuppressWarnings("serial")
/**
 * login Servlet class that extends the generic http servlet 
 * this class is created as per the instruction to fulfill the requirements of 
 * webd4201-course's lab 3 
 * 
 * @author 
 * @version  1.0 (2022.02.27)
 * @since 1.0
 */
public class LoginServlet extends HttpServlet {
	
	
	/**
	 * do post method to check if the page in submitting in the post method
	 * this method utilizes the http server request and repsonse functionality
	 *@throws ServeletException, 
	 *@throws IOException.
	 */
    public void doPost(HttpServletRequest request,
                            HttpServletResponse response) 
					throws ServletException, IOException
    {
        try
        { 
            // connect to database
            Connection c = DatabaseConnect.initialize();
            //initializing student object
            Student.initialize(c);
            HttpSession session = request.getSession(true);
            /**
             * user inputed login id 
             */
            String id = new String();
            
            /**
             * user inputed password variable
             */
            String password = new String();
            
            /**
             * parsed id variable
             */
            long parseID = 0;
            try 
            {   // retrieve data from DB
                id = request.getParameter( "Login" ).trim(); //this is the name of the text input box on the form
                password = request.getParameter("password"); //this is the name of the text input box on the form 
                if(id != null && id!="")
                {
                	//parse the value of the id 
                	parseID = Long.parseLong(id);
                	//authenticate the student's credential
                	Student aStudent = Student.authenticate(parseID, password);
                	
                	//put the found student onto the session 
                	session.setAttribute("student", aStudent);
                	//empty out any errors 
                	session.setAttribute("errors", "");
                	session.setAttribute("message", "Welcome "+aStudent.getLastName()+", You secessfully log in!!!");
                	//redirect the user to the dashboard page 
                	response.sendRedirect("./dashboard.jsp");
                }
                else {
                    session.setAttribute("errors", "<strong>Error: Login ID cant't be empty</strong>");
                    response.sendRedirect("./login.jsp");
                }
            }catch( NotFoundException nfe)
            {
                //new code == way better, if I do say so myself
                //sending errors to the page thru the session
                StringBuffer errorBuffer = new StringBuffer();
                errorBuffer.append("<strong>Your sign in information is incorrect.<br/>");
                errorBuffer.append("Please try again.</strong>");
                //check if the user provided data is matching the database
                if(Student.isExistingLogin(parseID))
                  session.setAttribute("id", id);
                else //if not then display a error message 
                {
                  errorBuffer.append("Invalid login id.</strong>");
                  session.setAttribute("id", "");
                }
                session.setAttribute("errors", errorBuffer.toString());
                response.sendRedirect("./login.jsp");
            }
        }    
   	 catch (Exception e) //not connected
        {
   		 //display a error message if something is wrong other than the database
            System.out.println(e);
            String line1="<h2>A network error has occurred!</h2>";
            String line2="<p>Please notify your system " +
                                                    "administrator and check log. "+e.toString()+"</p>";
            formatErrorPage(line1, line2,response);
        }
    }
    /**
     * a do get method that checks if the session is being submitted in the  get mode 
     * this method utilizes the https server request and response arguments 
     * @throws a ServletException and IOException.
     */
    public void doGet(HttpServletRequest request,
                            HttpServletResponse response)
                                    throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * this method is use to format the error message on the page for 
     * ease of readability
     * @param first a string 
     * @param second a string 
     * @param response Http server 
     * @throws IOException for any IOException
     */
    public void formatErrorPage( String first, String second,
            HttpServletResponse response) throws IOException
    {
        PrintWriter output = response.getWriter();
        response.setContentType( "text/html" );
        output.println(first);
        output.println(second);
        output.close();
    }
}