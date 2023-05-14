package webd4201.mansoorm;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

public class test {

	public static void main(String[] args)
	{
		Connection c = null; 
		Student s;
		try
		{
			c = DatabaseConnect.initialize();
			Student.initialize(c);
			s = Student.authenticate(100743787, "dark");
			System.out.println(s);
		}catch(NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}catch(NotFoundException e) {
			e.printStackTrace();
		}catch(SQLException x) {
			x.printStackTrace();
		}
	}
}