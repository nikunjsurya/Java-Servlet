package webd4201.mansoorm;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
/**
 * Student- This class is created as per the requirements for the web development-4201 course for deliverable 1
 * this class inherits the user class
 * @author 
 * @version  1.0 (2022.01.12)
 * @since 1.0
 */
public class Student extends User{
    // constants
    /**
     * string constant to store the default program code
     */
    public static final String DEFAULT_PROGRAM_CODE = "UNDC";
    /**
     * string constant to store the default program description
     */
    public static final String DEFAULT_PROGRAM_DESCRIPTION= "undeclared";
    /**
     * an int constant to store that default year
     */
    public static final int DEFAULT_YEAR = 1;

    //attributes
    /**
     * represent the program code for the student
     */
    private String programCode;
    /**
     * represent the program description for the student
     */
    private String programDescription;
    /**
     * this holds the year of the program that student is currently enrolled in
     */
    private int year;
    /**
     * a vector of marks
     */
    private Vector<Mark> marks = new Vector<>();

    // DA static methods

    /**
     * a static method of student data access class that initialize the connection of student database
     * @param c the associated object of student
     */
    public static void initialize(Connection c)
    {StudentDA.initialize(c);}
    
    /**
     * @param studentNum
     * @param password
     * @return a student object (student number and password after checking in the database)
     * @throws NoSuchAlgorithmException for the password hashing
     * @throws NotFoundException if the password is not in the database
     * @throws SQLException
     */
    public static Student authenticate(long studentNum, String password) throws NoSuchAlgorithmException, NotFoundException, SQLException
    {
    	return StudentDA.authenticate(studentNum, password);
    }

    /**
     *
     * @param key primary key id
     * @return retrieves the student object with the associated id (primary key)
     * @throws NotFoundException when there is no student record exists
     * @throws InvalidUserDataException when user data is invalid
     * @throws InvalidNameException when user's name is not valid
     * @throws InvalidPasswordException when password is not within the range
     * @throws InvalidIdException when id is not in the valid range
     */
    public static Student retrieve(long key) throws NotFoundException, InvalidUserDataException, InvalidNameException, InvalidPasswordException, InvalidIdException {
        return StudentDA.retrieve(key);
    }
    /**
     * retrieves a student object with id and checks if it exists in the database or not 
     * @param id primary key
     * @return true or false
     * @throws SQLException 
     */
    public static boolean isExistingLogin(long id) throws SQLException
    { return StudentDA.isExistingLogin(id);}
    
    
    /**
     * static method that disconnects the database connection
      */
    public static void terminate()
    {
        StudentDA.terminate();
    }

    /**
     * a create method that creates new user and student with the id as a primary key  in the database
     * @throws NotFoundException when there is no student record exists
     * @throws InvalidUserDataException when user data is invalid
     * @throws InvalidNameException when user's name is not valid
     * @throws InvalidPasswordException when password is not within the range
     * @throws InvalidIdException when id is not in the valid range
     */
    public void create() throws InvalidUserDataException, DuplicateException, InvalidNameException, InvalidPasswordException, InvalidIdException {
        StudentDA.create(this);
    }

    /**
     * a update method that updates the record of user and student with the id as a primary key in the database
     * @throws NotFoundException when there is no student record exists
     * @throws InvalidUserDataException when user data is invalid
     * @throws InvalidNameException when user's name is not valid
     * @throws InvalidPasswordException when password is not within the range
     * @throws InvalidIdException when id is not in the valid range
     */
    public void update() throws InvalidUserDataException, NotFoundException, InvalidNameException, InvalidPasswordException, InvalidIdException {
        StudentDA.update(this);
    }

    /**
     * a delete method that deletes the user and student record in the database
     * @throws NotFoundException when there is no student record exists
     * @throws InvalidUserDataException when user data is invalid
     * @throws InvalidNameException when user's name is not valid
     * @throws InvalidPasswordException when password is not within the range
     * @throws InvalidIdException when id is not in the valid range
     */
    public void delete() throws InvalidUserDataException, NotFoundException, InvalidNameException, InvalidPasswordException, InvalidIdException {
        StudentDA.delete(this);
    }
    //accessors/mutators
    /**
     *
     * @return program code: returns the value of the program code for the student
     */
    public String getProgramCode() {
        return programCode;
    }

    /**
     *
     * @param programCode modify the value of the program code for the associated student
     */
    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    /**
     *
     * @return program description: this holds the program name for the associated  student
     */
    public String getProgramDescription() {
        return programDescription;
    }

    /**
     *
     * @param programDescription modify the value of the program description
     */
    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    /**
     *
     * @return year the student is currently enrolled in
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @param year modify the value of the year
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     *
     * @return marks of the student
     */
    public Vector<Mark> getMarks() {
        return marks;
    }
    /**
     *
     * @param marks modify the marks of the student
     */
    public void setMarks(Vector<Mark> marks) {
        this.marks = marks;
    }

    /**
     * a parameterized constructor that takes one argument for all the inherited attributes of the
     * student class and sets the value of the arguments using the setter methods
     * @param id user's id
     * @param password user's password
     * @param firstName user's first name
     * @param lastName user's last name
     * @param emailAddress user's email address
     * @param enrolDate user's enrollment date and time
     * @param lastAccess user's last access date and time
     * @param enabled user's status
     * @param type user's type
     * @param programCode user's program code
     * @param programDescription user's program name or description
     * @param year user's current year
     */
    public Student(long id, String password, String firstName, String lastName, String emailAddress, Date enrolDate,Date lastAccess, boolean enabled, char type, String programCode,
                   String programDescription, int year) throws InvalidUserDataException, InvalidNameException, InvalidPasswordException, InvalidIdException {
        super(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type);
        this.setProgramCode(programCode);
        this.setProgramDescription(programDescription);
        this.setYear(year);
        this.setMarks(marks);
    }

    /**
     *an overloaded constructor that takes arguments for all the student objects except for the vector
     * and call the above created constructor and sends all the arguments plus the empty vector of mark object
     * @param programCode: student's program code
     * @param programDescription: student's program name or description
     * @param year : student's current year of study
     * @throws InvalidIdException for the id field
     * @throws InvalidNameException for the first name and last name field
     * @throws InvalidPasswordException for the password
     * @throws InvalidUserDataException for anything that is invalid in the class attribute
     */
    public Student(String programCode, String programDescription, int year) throws InvalidIdException, InvalidNameException, InvalidPasswordException, InvalidUserDataException {
        super();
        this.programCode = programCode;
        this.programDescription = programDescription;
        this.year = year;
        this.marks = new Vector<>();
    }

    /**
     * a default constructor that calls the parameterized constructor passing all the default values
     * using this keyword
     */
    public Student() throws InvalidUserDataException, InvalidNameException, InvalidPasswordException, InvalidIdException {
        this(DEFAULT_ID, DEFAULT_PASSWORD, DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_EMAIL_ADDRESS, new Date(), new Date(),
                DEFAULT_ENABLED_STATUS,DEFAULT_TYPE, DEFAULT_PROGRAM_CODE, DEFAULT_PROGRAM_DESCRIPTION,
                DEFAULT_YEAR);
    }

    /**
     * this method override the base class toString method and display the information of Student using the getter method for
     * each attribute
     * @return Student information
     */
    @Override
    public String toString() {
        return "Student Info for:\n\t" +this.getLastName() + " "+  this.getEmailAddress() +" (" + this.getId() + ") " + "\n\t"+
                "Currently in " + this.suffix(getYear(), "") + " year of " + "'" + this.getProgramDescription()+ "' " + "(" + this.getProgramCode() +")"
                + "\n\tat Durham College \n\t" + "Enrolled: " + this.getEnrolDate();
    }

    /**
     * this is the helper method to change the suffix for the attribute year
     * @param num represents the number of year
     * @param year represents the string for year
     * @return the int number of year + the suffix of the year
     */
    private String suffix(int num, String year){
        if(this.getYear() == 1){
            return num + year + "st";
        }
        else if(this.getYear() == 2){
            return num + year + "nd";
        }
        else if(this.getYear() == 3){
            return num + year + "rd";
        }
        else{
            return num + year;
        }
    }
}
