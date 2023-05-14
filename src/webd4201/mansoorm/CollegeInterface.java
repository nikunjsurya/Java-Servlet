package webd4201.mansoorm;
/**
 * CollegeInterface- this interface is designed as per the requirements for the webd4201 enterprise course
 * for deliverable 1
 * @author 
 * @version  1.0 (2022.01.12)
 * @since 1.0
 */
public interface CollegeInterface {
    /**
     * Durham college represents the college name
     */
    public static final String COLLEGE_NAME = "Durham College";
    /**
     * phone number "(905)721-2000" represent the phone number field
     */
    public static final String PHONE_NUMBER = "(905)721-2000";

    /**
    minimum id represent the minimum id number for the id field
     */
    public static final long MINIMUM_ID_NUMBER = 100000000;
    /**
     * the 99999999 represent the maximum value for the id field
     */
    public static final long MAXIMUM_ID_NUMBER = 999999999;
    /**
     * 8 represent the minimum value for the password field
     */
    public static final byte MINIMUM_PASSWORD_LENGTH = 8;
    /**
     * 20 represent the maximum value for the password field
     */
    public static final byte MAXIMUM_PASSWORD_LENGTH = 20;

    /**
     * @return  a String value to represent the type depending on which class override
     */
    public abstract String getTypeForDisplay();
}
