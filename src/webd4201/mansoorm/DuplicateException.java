package webd4201.mansoorm;

/**
 * DuplicateException - this file contains extends the generic Exception class so that
 * 			            we have a custom Exception, this one will be used to flag an attempt
 * 			            at a duplicate record in our database
 * @author 
 * @version 1.0 (2022-01-28)
 * @since 1.0
 */

@SuppressWarnings("serial")
/**
 * a public class that extends the generic Exception class and throws exception for any duplicate data
 */
public class DuplicateException extends Exception
{
    /**
     * a default constructor that calls the base class constructor using the keyword super
     */
    public DuplicateException()
    { super();}

    /**
     * a parameterized constructor that takes arguments for a string message to display the error message
     * @param message returns error message to the user
     */
    public DuplicateException(String message)
    { super(message);}
}