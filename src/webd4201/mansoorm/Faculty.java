package webd4201.mansoorm;
import java.util.Date;
/**
 * Faculty- This class is created as per the requirements for the web d4201 course for deliverable 1
 * this class inherits the user class
 * @author 
 * @version  1.0 (2022.01.12)
 * @since 1.0
 */
public class Faculty extends User {

    /**
     * this constant represents the default school code
     */
    public static final String DEFAULT_SCHOOL_CODE = "SET";
    /**
     * this represents the default school description
     */
    public static final String DEFAULT_SCHOOL_DESCRIPTION = "School of Engineering & Technology";
    /**
     * this represents the default office code for faculty
     */
    public static final String DEFAULT_OFFICE = "H-140";
    /**
     * this represents the default phone extension for the faculty
     */
    public static final int DEFAULT_PHONE_EXTENSION = 1234;

    //instance variables
    /**
     * instance variable school code that will store a code for the school the faculty is associated
     */
    private String schoolCode;
    /**
     * instance variable that will store the school description/name for the school the faculty is associated
     */
    private String schoolDescription;
    /**
     * instance variable to store the office location for the faculty
     */
    private String office;
    /**
     * instance variable to store the faculty's phone extension
     */
    private int extension;

     // Constructors
    /**
     * a default constructor that call's the parent class default constructor and set the extra attributes
     * @param schoolCode school code of the faculty
     * @param schoolDescription school name or description of the associated faculty
     * @param office office location for the associated faculty
     * @param extension phone extension for the associated faculty member
     */
    public Faculty(String schoolCode, String schoolDescription, String office, int extension) throws InvalidIdException, InvalidNameException, InvalidPasswordException, InvalidUserDataException {
        super();
        this.setSchoolCode(schoolCode);
        this.setSchoolDescription(schoolDescription);
        this.setOffice(office);
        this.setExtension(extension);
    }

    /**
     * a parameterized constructor that sets each attribute with the parameters using the setter method for each
     * @param id user's id
     * @param password user's password
     * @param firstName user's first name
     * @param lastName user's last name
     * @param emailAddress user's email
     * @param lastAccess user's last access date and time
     * @param enrolDate user's enrolment date and time
     * @param enabled user's authorization status
     * @param type user's type
     * @param schoolCode user's school code
     * @param schoolDescription user's school name/description
     * @param office user's office location
     * @param extension user's phone extension
     */
    public Faculty(long id, String password, String firstName, String lastName, String emailAddress, Date lastAccess, Date enrolDate, boolean enabled, char type, String schoolCode,
                   String schoolDescription, String office, int extension) throws InvalidIdException, InvalidNameException, InvalidPasswordException, InvalidUserDataException {
        super(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type);
        this.setSchoolCode(schoolCode);
        this.setSchoolDescription(schoolDescription);
        this.setOffice(office);
        this.setExtension(extension);
    }

    /**
     *
     * @return school code for the associated faculty
     */
    public String getSchoolCode() {
        return schoolCode;
    }

    /**
     *
     * @param schoolCode sets the value of the school code for the faculty
     */
    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    /**
     * @return school description or school name for the faculty
     */
    public String getSchoolDescription() {
        return schoolDescription;
    }

    /**
     *
     * @param schoolDescription sets the value of the school description for the associated faculty
     */
    public void setSchoolDescription(String schoolDescription) {
        this.schoolDescription = schoolDescription;
    }

    /**
     *
     * @return office location for the associated faculty member
     */
    public String getOffice() {
        return office;
    }

    /**
     *
     * @param office sets the office location for the associated faculty member
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * @return extension of the faculty member
     */
    public int getExtension() {
        return extension;
    }

    /**
     *
     * @param extension sets the phone extension for the associated faculty member
     */
    public void setExtension(int extension) {
        this.extension = extension;
    }


    /**
     * overriding the base class User's type method to return the word "Faculty".
     */
    @Override
    public String getTypeForDisplay() {
        return "Faculty";
    }

    /**
     * @return the faculty info for the faculty member using the getter methods by overriding the user's method so the information is
     * return for the faculty not User
     */
    @Override
    public String toString() {
        String userText = super.toString();
        return userText.replaceAll("User", "Faculty") + this.getSchoolCode() + ", " + this.getSchoolDescription() +
                "\n\t"
                + "Office: " + this.getOffice() + "\n\t"+
                PHONE_NUMBER + " x" +this.getExtension();
    }
}