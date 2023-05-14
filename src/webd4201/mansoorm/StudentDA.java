package webd4201.mansoorm;

import java.security.NoSuchAlgorithmException;
import  java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import static webd4201.mansoorm.PasswordHashing.get_SHA_1_SecurePassword;
/**
 * StudentDA - This class is created as per the requirements for the web development-4201 course for deliverable 1
 * this class provides the database connection methods for the student class
 *
 * @author 
 * @version  1.0 (2022.01.29)
 * @since 1.0
 */
public class StudentDA {

	// variables for database connection
	/**
	 * a static attribute for connection object
	 */
	static Connection aConnection;
	/**
	 * a static attribute for statement object
	 */
	static Statement aStatement;
	/**
	 * a static attribute for student object
	 */
	static Student aStudent;
	/**
	 * constant formatter for the last access and enrol date
	 */
	private static final SimpleDateFormat SQL_DF = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * a static member to store user's id
	 */
	static long id;
	/**
	 * a static member to store  user's password
	 */
	static String password;
	/**
	 * a static member to store user's first name
	 */
	static String firstName;
	/**
	 * data member to store user's last name
	 */
	static String lastName;
	/**
	 * data member to store user's email address
	 */
	static String emailAddress;
	/**
	 * data member to store user's last access data and time
	 */
	static Date lastAccess;
	/**
	 * data member to store user's enrol date and time
	 */
	static Date enrolDate;
	/**
	 * data member to store user's authorization data
	 */
	static boolean enabled;
	/**
	 * data member to store user's authentication type
	 */
	static char type;
	/**
	 * a static member to store student's program code
	 */
	static String programCode;
	/**
	 * a static member to store student's program description
	 */
	static String programDescription;
	/**
	 * a static member to store student's current year of study
	 */
	static int year;

	// establish the database connection

	/**
	 * a static method that initializes the connection with the database
	 * @param c Connection
	 * @throws  SQLException exception if the connection is not made
	 */
	public static void initialize(Connection c) {
		try {
			aConnection = c;
			aStatement = aConnection.createStatement();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	// close the database connection

	/**
	 * a static method that terminates the connection with the database
	 * @throws  SQLException exception if the connection is not closed
	 */
	public static void terminate() {
		try {    // close the statement
			aStatement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * a static Student method that retrieves the data for the associated student
	 * @param key primary key (id)
	 * @return a student
	 * @throws NotFoundException if the student is not found in the student table
	 */
	public static Student retrieve(long key) throws NotFoundException {
		// retrieve Customer and Boat data
		aStudent = null;
		// define the SQL query statement using the id number key
		String sqlQuery = "SELECT users.id, email, password, first_name, last_name, last_access, enrolDate, " +
				"enable, type, program_code, program_description, year FROM users, students WHERE users.id = students.id AND users.id = ?";
		// execute the SQL query statement
		try
		{
			// next method sets cursor & returns true if there is data
			// prepared statement
			PreparedStatement studentRetrieve = aConnection.prepareStatement(sqlQuery);
			studentRetrieve.setLong(1, key);
			ResultSet rs = studentRetrieve.executeQuery();

			//when the record is found return true otherwise return false
			boolean gotIt = rs.next();
			if (gotIt)
			{	// extract the data
				id = rs.getLong("id");
				emailAddress = rs.getString("email");
				password = rs.getString("password");
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				lastAccess = rs.getDate("last_access");
				enrolDate = rs.getDate("enrolDate");
				enabled = rs.getBoolean( "enable");
				type = rs.getString("type").charAt(0);
				programCode = rs.getString("program_code");
				programDescription = rs.getString("program_description");
				year = rs.getInt("year");

				// create student
				try{
					aStudent = new Student(id,password,firstName,  lastName, emailAddress ,enrolDate,lastAccess,enabled,type, 
							programCode, programDescription, year);
				}
				// catch exceptions if any of the data in the user or student table is wrong
				catch (InvalidUserDataException | InvalidNameException | InvalidPasswordException | InvalidIdException e)
				{
					System.out.println(e);
				}

			}
			else// nothing was retrieved
			{
				throw (new NotFoundException("Student with id of " + key + " not found in the database."));
			}

			rs.close();

		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return aStudent; // record for the selected student
	}

	/**
	 * a static method that creates a new student in the database table for student
	 * @param newStudent a new student object
	 * @return boolean if the record is inserted or not
	 * @throws DuplicateException if the student with the same data already exists
	 * @throws InvalidUserDataException when user data is invalid
	 * @throws InvalidNameException when user's name is not valid
	 * @throws InvalidPasswordException when password is not within the range
	 * @throws InvalidIdException when id is not in the valid range
	 * @throws NoSuchAlgorithmException if the password passed cant be hashed
	 */
	public static boolean create(Student newStudent) throws DuplicateException, InvalidNameException, 
												InvalidUserDataException, InvalidPasswordException, InvalidIdException {
		boolean UserInserted = false; //insertion success flag for user
		boolean StudentInserted = false; // insertion success flag for students

		// retrieve the student attribute values
		id = newStudent.getId();
		password = newStudent.getPassword();
		emailAddress = newStudent.getEmailAddress();
		firstName = newStudent.getFirstName();
		lastName = newStudent.getLastName();
		enrolDate = newStudent.getEnrolDate();
		lastAccess = newStudent.getLastAccess();
		enabled = newStudent.isEnabled();
		type = newStudent.getType();
		programCode = newStudent.getProgramCode();
		programDescription = newStudent.getProgramDescription();
		year = newStudent.getYear();

		String hashedPassword = "";
		try{
			hashedPassword = get_SHA_1_SecurePassword(password);
		}
		catch (NoSuchAlgorithmException e1){
			e1.printStackTrace();
		}

		// create the SQL insert statement using attribute values
		String sqlUserInsert = "INSERT INTO users " +
				"(id, email, password, first_name, last_name, last_access, enrolDate, enable, type) " +
				"VALUES (?,?,?,?,?,?,?,?,?)";
		String sqlStudentsInsert = "INSERT INTO students" +
				"(id, program_code, program_description, year)" +
				" VALUES (?,?,?,?)";


		// see if this student already exists in the database
		try {
			retrieve(id);
			throw (new DuplicateException("Problem with creating student record, " +
					"id number " + id + " already exists in the system."));
		}
		// if NotFoundException, add student to database
		catch (NotFoundException e) {
			try {  // execute the SQL update statement
				PreparedStatement userInsert = aConnection.prepareStatement(sqlUserInsert);
				userInsert.setLong(1, id);
				userInsert.setString(2, emailAddress);
				userInsert.setString(3, hashedPassword);
				userInsert.setString(4, firstName);
				userInsert.setString(5, lastName);
				userInsert.setDate(6, java.sql.Date.valueOf(SQL_DF.format(lastAccess)));
				userInsert.setDate(7, java.sql.Date.valueOf(SQL_DF.format(enrolDate)));
				userInsert.setBoolean(8, enabled);
				userInsert.setString(9, String.valueOf(type));

				PreparedStatement studentInsert = aConnection.prepareStatement(sqlStudentsInsert);
				studentInsert.setLong(1, id);
				studentInsert.setString(2, programCode);
				studentInsert.setString(3, programDescription);
				studentInsert.setInt(4, year);

				UserInserted = userInsert.execute();
				StudentInserted = studentInsert.execute();

			} catch (SQLException ee) {
				System.out.println(ee);
			}
		}
		return UserInserted && StudentInserted;
	}


	/**
	 * a static method that updates the records for the passed id
	 * @param newStudent to update the existing student object
	 * @return number of records that are updated
	 * @throws NotFoundException if the id to update not exists
	 * @throws InvalidUserDataException when user data is invalid
	 * @throws InvalidNameException when user's name is not valid
	 * @throws InvalidPasswordException when password is not within the range
	 * @throws InvalidIdException when id is not in the valid range
	 * @throws NoSuchAlgorithmException if the password passed cant be hashed
	 */
	public static int update(Student newStudent) throws NotFoundException{
		int userRecords = 0;  //user records updated in method

		// retrieve the student argument attribute values
		id = newStudent.getId();
		password = newStudent.getPassword();
		emailAddress = newStudent.getEmailAddress();
		firstName = newStudent.getFirstName();
		lastName = newStudent.getLastName();
		enrolDate = newStudent.getEnrolDate();
		lastAccess = newStudent.getLastAccess();
		enabled = newStudent.isEnabled();
		type = newStudent.getType();
		programCode = newStudent.getProgramCode();
		programDescription = newStudent.getProgramDescription();
		year = newStudent.getYear();

		String hashedPassword = "";
		try{
			hashedPassword = get_SHA_1_SecurePassword(password);
		}
		catch (NoSuchAlgorithmException e1){
			e1.printStackTrace();
		}
		// sql query to update the records of users for a passed id
		String sqlUserUpdate =
				 "UPDATE users SET email = ?, password = ? ,first_name = ?, last_name = ?,"+
						 " last_access = ?, enrolDate = ? ,enable = ?, type = ?  WHERE id = ?";
		// sql query to update the students record for a passed id
		String sqlStudentsUpdate =
				"UPDATE students SET program_code = ?, program_description = ?, year = ?  WHERE id = ?";

		//check if the passed id exists in the database
		// NotFoundException is thrown by find method
		try
		{
			Student.retrieve(id);  //determine if there is a student record to be updated
			// if found, execute the SQL prepared  statement
			PreparedStatement userUpdate = aConnection.prepareStatement(sqlUserUpdate);
			userUpdate.setString(1, emailAddress);
			userUpdate.setString(2, hashedPassword);
			userUpdate.setString(3, firstName);
			userUpdate.setString(4, lastName);
			userUpdate.setDate(5, java.sql.Date.valueOf(SQL_DF.format(lastAccess)));
			userUpdate.setDate(6, java.sql.Date.valueOf(SQL_DF.format(enrolDate)));
			userUpdate.setBoolean(7, enabled);
			userUpdate.setString(8, String.valueOf(type));
			userUpdate.setLong(9, id);

			PreparedStatement studentUpdate = aConnection.prepareStatement(sqlStudentsUpdate);
			studentUpdate.setString(1, programCode);
			studentUpdate.setString(2, programDescription);
			studentUpdate.setInt(3, year);
			studentUpdate.setLong(4, id);

			// first updates in the user table then student table
			userRecords = userUpdate.executeUpdate();
			userRecords += studentUpdate.executeUpdate();


		}catch(NotFoundException | InvalidUserDataException | InvalidNameException | InvalidPasswordException | InvalidIdException e)
		{
			throw new NotFoundException("Student with id number " + id
					+ " cannot be updated, does not exist in the system.");
		}catch (SQLException e)
		{ System.out.println(e);}

		return userRecords;
	}


	/**
	 * a static method that deletes the record in the student table and user table for the passed id
	 * @param aStudent a student object to be deleted
	 * @return number of records deleted
	 * @throws NotFoundException if the id to update not exists
	 * @throws InvalidUserDataException when user data is invalid
	 * @throws InvalidNameException when user's name is not valid
	 * @throws InvalidPasswordException when password is not within the range
	 * @throws InvalidIdException when id is not in the valid range
	 */
	public static int delete(Student aStudent) throws NotFoundException, InvalidNameException, 
	InvalidPasswordException, InvalidIdException, InvalidUserDataException {
		int userRecords = 0;

		// retrieve the id no (key)
		id = aStudent.getId();
		// create the SQL delete statement
		String sqlUserDelete = "DELETE FROM users WHERE id = ?";
		String sqlStudentDelete = "DELETE FROM students WHERE id = ?";

		// see if this student already exists in the database
		try
		{
			Student.retrieve(id);  //used to determine if
			// record exists for the passed student
			// if found, execute the SQL update statement
			PreparedStatement userDelete = aConnection.prepareStatement(sqlUserDelete);
			userDelete.setLong(1, id);

			// prepared statement for the student table
			PreparedStatement studentDelete = aConnection.prepareStatement(sqlStudentDelete);
			studentDelete.setLong(1, id);

			//first delete in students then users table
			userRecords = studentDelete.executeUpdate();
			userRecords += userDelete.executeUpdate();

		}catch(NotFoundException e)
		{
			throw new NotFoundException("Student with id number " + id
					+ " cannot be deleted, does not exist.");
		}catch (SQLException e)
		{
			System.out.println(e);
		}
		return userRecords ;
	}
	
	/**
	 * a static method that returns a student object and checks if the student with id and password exists 
	 * in the database if not then it throws NotFoundException
	 * @throws NotFoundException if the data is not found in the database
	 * 
	 */
	 public static Student authenticate(long studentNum, String password) throws NotFoundException, SQLException,  NoSuchAlgorithmException 
	 {
		try 
		{
			aStudent= retrieve(studentNum);
			//hashes password
			String hashedPassword = get_SHA_1_SecurePassword(password);
			
			//if the password is in the database 
			if(aStudent.getPassword().equals(hashedPassword))
			{
				//return a student object
				return  aStudent;
			}
			else
			{
				//if the student object is not found in the database then throw a 
				//NotFoundException 
				throw new NotFoundException("Student with id : "
						+ studentNum + " and Password: "+ password + " doesnot exists");
			}
		}
		catch(NotFoundException ex)
		{
			throw new NotFoundException("Student with id : "
					+ studentNum + " and Password: "+ password + " doesnot exists");
			
		}
	}

	/**
	 * retrieves the student data using the primary key and checks if the students exists or not
	 * @param id primary key
	 * @return true or false
	 */
	public static boolean isExistingLogin(long id) throws SQLException
    {
    	// retrieve Student data
		// define the SQL query statement using the id key
		String sqlQuery = "SELECT  * " +
							" FROM users " +
							" WHERE id= '" + id +"'";
			//System.out.println(sqlQuery);
		 boolean exists = true;                  
		// execute the SQL query statement
		try
		{
			ResultSet rs = aStatement.executeQuery(sqlQuery);
			exists = rs.next();
		}catch (SQLException e)
		{ 
			System.out.println(e);
		}
		return exists;
    	
    }
}