package webd4201.mansoorm;

import java.util.*;
/**
 * Main method to test the first part of Deliverable 1
 * this main method was provided by the professor and were asked not to modify it
 * the purpose of this main class is to test the classes created according to the lab requirement
 * @author Darren Puffer
 * @version 1.0 (January 8th, 2019)
 * @since 1.0
 */
public class lab1Tester {
    public static void main(String[] args) throws InvalidIdException, InvalidPasswordException, InvalidNameException {

        System.out.println("******************** Deliverable 1 Output ********************\n");

        GregorianCalendar cal = new GregorianCalendar();
        Date lastAccess = cal.getTime();
        cal.set(2016, Calendar.SEPTEMBER, 3);
        Date enrol = cal.getTime();
        Student student1;
        System.out.println("\n*************************************************************************************************************");
        System.out.println("NOTE: any exceptions displayed while instantiating Student objects in the program only display the contents " +
                "of the Exception, by using the getMessage() method.");
        System.out.println("*************************************************************************************************************");
        System.out.println("\n The following will cause an Exception based on student id being too small (123L).\n"+
                "Trying to instantiating a random student before displaying it, passing:\n" +
                "\n\tStudent student1 = new Student(123L, \"password\", \"Robert\", \"McReady\"," +
                " \"bob.mcready@dcmail.ca\", enrol, lastAccess, 's', true, \"CPA\", \"Computer Programmer Analyst\", 3);\n");
        try{
            student1 = new Student(123L,"password", "Robert", "McReady", "bob.mcready@dcmail.ca",
                    enrol, lastAccess, true, 's', "CPA", "Computer Programmer Analyst", 2);
            student1.dump();
        }catch(InvalidUserDataException iude){
            System.out.println(iude.getMessage());
        }catch(NumberFormatException test)
        {
            System.out.println(test.getMessage());
        }
        System.out.println("\nThe following will cause an Exception based on student id being too big(10012345678L).\n"+
                "Trying to instantiating a random student before displaying it, passing:\n\t" +
                "Student student1 = new Student(10012345678L, \"password\", \"Robert\", \"McReady\"," +
                " \"bob.mcready@dcmail.ca\", enrol, lastAccess, 's', true, \"CPA\", \"Computer Programmer Analyst\", 3);\n");
        try{
            student1 = new Student(10012345678L,"password", "Robert", "McReady", "bob.mcready@dcmail.ca",
                    enrol, lastAccess, true, 's', "CPA", "Computer Programmer Analyst", 3);
            student1.dump();
        }catch(InvalidUserDataException iude){
            System.out.println(iude.getMessage());
        }
        System.out.println("\nThe following will not cause an Exception (data is valid).\n"+
                "Trying to instantiating a student before displaying it, passing:\n\t" +
                "Student student1 = new Student(100123456L, \"password\", \"Robert\", \"McReady\"," +
                " \"bob.mcready@dcmail.ca\", enrol, lastAccess, 's', true, \"CPA\", \"Computer Programmer Analyst\", 3);\n");
        try{
            student1 = new Student(100123456L,"password", "Robert", "McReady", "bob.mcready@dcmail.ca",
                    enrol, lastAccess, true, 's', "CPA", "Computer Programmer Analyst", 3);
            student1.dump();
            try{
                System.out.println("\nTry to set the last name for student1 to an empty string.");
                student1.setLastName("");
            }catch(InvalidNameException ine)
            {
                System.out.println(ine.getMessage());
            }
            try{
                long newId = -100123456L;
                System.out.println("\nTry to set the id for student1 to an invalid number: " + newId + ".");
                student1.setId(newId);
            }catch(InvalidIdException iie)
            {
                System.out.println(iie.getMessage());
            }
            try{
                String newPassword = "tiny";
                System.out.println("\nTry to set the password for student1 to a String that is not valid (too short): " + newPassword + ".");
                student1.setPassword(newPassword);
            }catch(InvalidPasswordException ipe)
            {
                System.out.println(ipe.getMessage());
            }
            try{
                String newPassword = "supercrazylongpassword";
                System.out.println("\nTry to set the password to a String that is not valid (too long): " + newPassword + ".");
                student1.setPassword(newPassword);
            }catch(InvalidPasswordException ipe)
            {
                System.out.println(ipe.getMessage());
            }
        }catch(InvalidUserDataException iude){
            System.out.println(iude.getMessage());
        }

        System.out.println("\n*************************************************************************************************************");
        System.out.println("NOTE: any exceptions displayed while instantiating Faculty objects will call the toString() method, " +
                "this includes the Exception type as part of the message.");
        System.out.println("*************************************************************************************************************");

        System.out.println("\nThe following object instantiations will use a Faculty object passing a String for the id (where there could be parsing issues).\n");

        Faculty professor;
        long possibleId = 100123456L; //invalid/un-parseable string
        System.out.println("\n\nTrying to instantiate my professor before displaying it, passing:\n\t" +
                "professor = new Faculty(\""+ possibleId +"\", \"another password\", \"Darren\", \"Puffer\", " +
                "\"darren.puffer@durhamcollege.ca\", enrol, lastAccess, 'f', true, " +
                "\"BITM\", \"School of Business, IT & Management\", \"C-315\", 2044);\n");
        try{
            professor = new Faculty(possibleId, "another password", "Darren", "Puffer", "darren.puffer@durhamcollege.ca", enrol, lastAccess, true, 'f',
                    "BITM", "School of Business, IT & Management", "C-315", 2044);
            professor.dump();
        }catch(InvalidUserDataException ide)
        {
            System.out.println("Problem creating a professor with an id of: \"" + possibleId + "\"\n\t " + ide.toString());

        }
        System.out.println("\nThe following will cause an InvalidUserDataException based on a missing first name,\n"+
                "the program demonstrates that InvalidUserDataException (in fact any/all Exceptions) can be caught by\n"
                + "the generic Exception catch.\n"+
                "\nTrying to instantiate my professor before displaying it, passing:\n\t" +
                "professor = new Faculty(\""+ possibleId +"\", \"somepassword\", \"\", \"Puffer\", " +
                "\"darren.puffer@durhamcollege.ca\", enrol, lastAccess, 'f', true, " +
                "\"BITM\", \"School of Business, IT & Management\", \"C-315\", 2044);\n");
        try{
            professor = new Faculty(possibleId, "somepassword", "", "Puffer", "darren.puffer@durhamcollege.ca", enrol, lastAccess, true, 'f',
                    "BITM", "School of Business, IT & Management", "C-315", 2044);
            professor.dump();
        }catch(Exception e)
        {
            System.out.println("Problem creating a professor with an id of: \"" + possibleId + "\"\n\t " + e.toString());
        }

    }
}