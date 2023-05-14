package webd4201.mansoorm;

import java.io.Serial;
/**
 * InvalidUserDataException- This class is created as per the requirements for the web d4201 course for deliverable 1
 * this class extends the generic exception class to throw exception for user's data attributes
 * @author 
 * @version  1.0 (2022.01.12)
 * @since 1.0
 */
public class InvalidUserDataException  extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * a default constructor that calls the base class constructor
     */
    public InvalidUserDataException(){
        super();
    }
    /**
     * an overload constructor to display error message using the parameter
     * @param message to display the error message
     */
    public InvalidUserDataException(String message){
        super(message);
    }
}
