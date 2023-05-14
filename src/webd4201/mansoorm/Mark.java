package webd4201.mansoorm;

import java.text.DecimalFormat;
/**
 * Mark- This class is created as per the requirements for the webd4201 course for deliverable 1
 * @author 
 * @version  1.0 (2022.01.12)
 * @since 1.0
 */
public class Mark {

    //constants
    /**
     * constant to store the minimum gpa
     */
    public static final float MINIMUM_GPA = 0.0F;
    /**
     * a constant to store the maximum gpa
     */
    public static final float MAXIMUM_GPA = 5.0F;
    /**
     * a constant that formats decimal numbers to two decimal place with a leading zero
     */
    public static final DecimalFormat GPA = new DecimalFormat("0.00");

    //class attributes
    /**
     * a String courseCode to store the course code for the associated class
     */
    private String courseCode;
    /**
     * a String courseName to store the course name for the associated class
     */
    private String courseName;
    /**
     * a int result to store the result of the associated Student
     */
    private int result;
    /**
     * a float gpaWeighing to store the gpa of the associated Student
     */
    private float gpaWeighting;

    //accessors/mutators

    /**
     *
     * @return courseCode that contains course code for the mark
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     *
     * @param courseCode modify the value of the course code
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     *
     * @return courseName that contains the course Name for the mark
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     *
     * @param courseName modify the value of  course Name for the mark
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     *
     * @return result: contains student's final result in the course
     */
    public int getResult() {
        return result;
    }

    /**
     *
     * @param result modify the value of result for the student
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     *
     * @return gpaWeighing that contains the gpa of the course
     */
    public float getGpaWeighting() {
        return gpaWeighting;
    }

    /**
     *
     * @param gpaWeighting modify the value of gpaWeighing for the course
     */
    public void setGpaWeighting(float gpaWeighting) {
        this.gpaWeighting = gpaWeighting;
    }

    /**
     * a parameterized constructor that sets the value of the attributes with the arguments using the setter
     * methods
     * @param courseCode course code for the associated user: student
     * @param courseName course name for the associated user: student
     * @param result course result for the associated user: student
     * @param gpaWeighting gpa weighing for the associated course
     */
    public Mark(String courseCode, String courseName, int result, float gpaWeighting) {
        this.setCourseCode(courseCode);
        this.setCourseName(courseName);
        this.setResult(result);
        this.setGpaWeighting(gpaWeighting);
    }

    /**
     * this method returns the mark's info using the getter method to retrieve the object's attributes
     * @return the String of the mark's information
     */
    @Override
    public String toString() {
        return  this.getCourseCode()+ "\t" + String.format("%-35s", getCourseName())
                 + getResult() + "\t" +
                GPA.format(this.getGpaWeighting());
    }
}
