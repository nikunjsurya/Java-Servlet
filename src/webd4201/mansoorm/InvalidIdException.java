package webd4201.mansoorm;

import java.io.Serial;
/**
 * InvalidIdException- This class is created as per the requirements for the web d4201 course for deliverable 1
 * this class extends the generic exception class to throw exception for id attribute
 * @author 
 * @version  1.0 (2022.01.12)
 * @since 1.0
 */
public class InvalidIdException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * a default constructor that calls the base class constructor
     */
    public InvalidIdException(){
        super();
    }
    /**
     * an overload constructor to display error message using the parameter
     * @param message to display the error message
     */
    public InvalidIdException(String message){
        super(message);
    }
}
