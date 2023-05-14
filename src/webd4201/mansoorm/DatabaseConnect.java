package webd4201.mansoorm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  @author 
 *  * @version 1.0 (2022-01-28)
 *  * @since 1.0
 *
 *  Database Connect.java: this class provides connection with the database of owner webd4201_user and also terminates the databse connectioon
 *  after its used
 */
public class DatabaseConnect {
    /**
     * Database location
     */
    static String url = "jdbc:postgresql://127.0.0.1:5432/webd4201_db";
    /**
     * Connection object to open port to db
     */
    static Connection aConnection;
    /**
     * database user
     */
    static String user = "webd4201_admin";
    /**
     * database user password
     */
    static String password = "webd4201_password";

    /**
     * establishes the database connection
     * @return Connection to the webd4201_db database
     * @throws  SQLException if the user, password or admin is wrong
     */
    public static Connection initialize()
    {
        try
        {
            Class.forName("org.postgresql.Driver"); // loads the JDBC Driver for PostGreSQL
            aConnection = DriverManager.getConnection(url, user, password); // creates the database connection instance

        }
        catch (ClassNotFoundException e)  //will occur if you did not import the PostGreSQL *.jar file with drivers
        {
            System.out.println(e);
        }
        catch (SQLException e)	//any other database exception (misnamed db, misnamed user, worng password, etc)
        { System.out.println(e); }
        return aConnection;
    }

    /**
     * closes the database connection
     * @throws  SQLException if the connection is not closed for some reason
     */
    public static void terminate()
    {
        try
        {
            aConnection.close(); // closes the database connection with the user webd4201_db
        }
        catch (SQLException e)
        { System.out.println(e);	}
    }
}
