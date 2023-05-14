package webd4201.mansoorm;
//imports
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * User- this class is created as oer the requirements for the web d4201 course for deliverable 1
 * this class will be used to create objects of type user
 * this class inherits the college interface class
 * @author 
 * @version  1.0 (2022.01.12)
 * @since 1.0
 */
public class User implements CollegeInterface{

    //constants
    /**
     * representing the default id for user: 100123456
     */
    protected static final long DEFAULT_ID = 100123456 ;
    /**
     * representing the default password for user: password
     */
    protected static final String DEFAULT_PASSWORD = "password";
    /**
     * representing the minimum password length for user: 8
     */
    protected static final byte MINIMUM_PASSWORD_LENGTH = 8;
    /**
     * representing the maximum password length for user: 40
     */
    protected static final byte MAXIMUM_PASSWORD_LENGTH = 40;
    /**
     * representing the default first name for the user: John
     */
    protected static final String DEFAULT_FIRST_NAME = "John";
    /**
     * representing the default last name for the user: "Doe"
     */
    protected static final String DEFAULT_LAST_NAME = "Doe";
    /**
     * representing the default email address for the user: john.doe@dcmail.com
     */
    protected static final String DEFAULT_EMAIL_ADDRESS = "john.doe@dcmail.com";
    /**
     * representing the default enable status for the user: true
     */
    protected static final boolean DEFAULT_ENABLED_STATUS = true;
    /**
     * representing the default type for the user : 's'
     */
    protected static final char DEFAULT_TYPE = 's';
    /**
     * representing the default id length for the user: 9
     */
    protected static final byte ID_NUMBER_LENGTH = 9;
    /**
     * representing the default date format to be used for the data members lastAccess and enrolDate
     */
    protected static final DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);


    // instance attributes
    /**
     * data member to store the user's id
     */
    private long id ;
    /**
     * data member to store user's password
     */
    private String password;
    /**
     * data member to store user's firstname
     */
    private String firstName;
    /**
     * data member to store user's last name
     */
    private String lastName;
    /**
     * data member to store user's email address
     */
    private String emailAddress;
    /**
     * data member to store user's last access data and time
     */
    private Date lastAccess;
    /**
     * data member to store user's enrol date and time
     */
    private Date enrolDate;
    /**
     * data member to store user's authorization data
     */
    private boolean enabled;
    /**
     * data member to store user's authentication type
     */
    private char type;

    /**
     * @return user's id information
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id set the user's id after performing validation
     */
    public void setId(long id) throws InvalidIdException {
        // if id is true then this.id is equal to the parameter else invalid argument will be thrown
        try{
            //checks if the firstname is an empty string
            if(verifyId(id)){
                this.id = id;
            }
            else{
                throw new InvalidIdException("Invalid! id must be between "+ MINIMUM_ID_NUMBER + " and " + MAXIMUM_ID_NUMBER);
            }
        }
        catch (InvalidIdException nfx ){
            System.out.println(nfx.getMessage());
        }

    }

    /**
     * @return user's password information
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password sets the user's password after performing validation
     */
    public void setPassword(String password) throws InvalidPasswordException {
        if(password.length() >= CollegeInterface.MINIMUM_PASSWORD_LENGTH && password.length() <= MAXIMUM_PASSWORD_LENGTH)
        {
            this.password = password;
        }
        else{
            throw new InvalidPasswordException("Invalid password: password must be between " + CollegeInterface.MINIMUM_PASSWORD_LENGTH
                    + " " + CollegeInterface.MAXIMUM_PASSWORD_LENGTH);
        }
    }
    /**
     *
     * @return user's first name data
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName sets the user's first name
     */
    public void setFirstName(String firstName) {
        try{
            //checks if the firstname is an empty string
            if(!firstName.isEmpty()){
                this.firstName = firstName;
            }
            else{
                throw new InvalidNameException("Invalid first name can not be blank or a numeric value");
            }
        }
        catch (InvalidNameException nfx ){
            System.out.println(nfx.getMessage());
        }
    }

    /**
     * @return user's last name data
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName sets the user's last name
     */
    public void setLastName(String lastName)throws InvalidNameException {
        try{
            //checks if the last name is an empty string
            if(!lastName.isEmpty()){
                this.lastName = lastName;
            }
            else{
                throw new InvalidNameException("Invalid last name can not be blank or a numeric value");
            }
        }
        catch (InvalidNameException nfx){
            System.out.println(nfx.getMessage());
        }
    }

    /**
     * @return user's email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     *
     * @param emailAddress sets the user's email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     *
     * @return user's last access date
     */
    public Date getLastAccess() {
        return lastAccess;
    }

    /**
     *
     * @param lastAccess sets the user's last access time using the date time library from the system
     */
    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    /**
     *
     * @return user'e enroll date data
     */
    public Date getEnrolDate() {
        return enrolDate;
    }

    /**
     *
     * @param enrolDate sets the user's enrollment date and time using the date time library
     */
    public void setEnrolDate(Date enrolDate) {
        this.enrolDate = enrolDate;
    }

    /**
     *
     * @return user's enable condition
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled sets the user's authorization status
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     *
     * @return  user's type
     */
    public char getType() {
        return type;
    }

    /**
     *
     * @param type sets the user's authentication type
     */
    public void setType(char type) {
        this.type = type;
    }

    /**
     * override method implements from the interface class that returns the string
     * @return null
     */
    @Override
    public String getTypeForDisplay() {
        return null;
    }

    /**
     * a parameterized constructor that sets all the attributes to its parameters using the setter methods
     * @param id user's id
     * @param password user's password
     * @param firstName user's first name
     * @param lastName user's last name
     * @param emailAddress user's email
     * @param lastAccess user's last access date and time
     * @param enrolDate user's enrolment date and time
     * @param enabled user's status
     * @param type user's type/authentication
     */
    public User(long id, String password, String firstName, String lastName, String emailAddress,
                Date lastAccess, Date enrolDate, boolean enabled, char type) throws InvalidIdException, InvalidPasswordException, InvalidNameException ,InvalidUserDataException{
        this.setId(id);
        this.setEmailAddress(emailAddress);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastAccess(lastAccess);
        this.setLastName(lastName);
        this.setEnabled(enabled);
        this.setEnrolDate(enrolDate);
        this.setType(type);

    }
    /**
     * a default constructor that calls the parameterized constructor and sets all the class attributes using this keyword
     */
    public User() throws InvalidIdException, InvalidPasswordException, InvalidNameException, InvalidUserDataException {
        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS, new Date(), new Date(),
                DEFAULT_ENABLED_STATUS, DEFAULT_TYPE);
    }

    /**
     * an override method implements to return the associated user's information using the getter methods
     */
    @Override
    public String toString() {
        return String.format("User Info for: %s\n\tName: %s %s (%s)\n\tCreated on: %s\n\tLast access: %s\n\t",
                this.getId(), this.getFirstName(), this.getLastName(), this.getEmailAddress(), DF.format(this.getEnrolDate())
        , DF.format(this.getLastAccess()));
    }

    /**
     * a method that displays the returned string from the toString() method
     */
    public void dump(){
        System.out.println(this.toString());
    }

    /**
     *
     * @param validId checks using the constants for id attribute whether the id is in a valid range or not
     * @return a boolean value
     */
    public static boolean verifyId(long validId) {
        if(validId >= MINIMUM_ID_NUMBER && validId <= MAXIMUM_ID_NUMBER){
            return true;
        }
        else {
            return false;
        }
    }
}