package webd4201.mansoorm;
/**
 * NotFoundException - this file contains extends the generic Exception class so that
 *                 we have a custom Exception, this one will be used to flag when
 *                 no record was found in the database (and therefore nothing can be
 *                 done to it)
 * @author 
 *  @version 1.0 (2022-01-28)
 *   @since 1.0
 */
@SuppressWarnings("serial")
public class NotFoundException extends Exception
{
    /**
     * a default constructor that calls the base class constructor using the keyword super
     */
    public NotFoundException()
    { super();}

    /**
     *  a parameterized constructor that takes argument for a string message that displays error message to the user
     * @param message displays string of error message
     */
    public NotFoundException(String message)
    {
        super(message);}
}
