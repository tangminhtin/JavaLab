/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestudents;

/**
 *
 * @author tangminhtin
 */
public class Report {

    private String studentName; // Store student name
    private String courseName;  // Store course name
    private int totalCourses;   // Store total courses

    /**
     * Constructor for Report class
     *
     * @param studentName
     * @param courseName
     * @param totalCourses
     */
    public Report(String studentName, String courseName, int totalCourses) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourses = totalCourses;
    }

    /**
     * Gets student name
     *
     * @return
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets student name
     *
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets course name
     *
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets course name
     *
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Gets total course
     *
     * @return
     */
    public int getTotalCourses() {
        return totalCourses;
    }

    /**
     * Sets total course
     *
     * @param totalCourses
     */
    public void setTotalCourses(int totalCourses) {
        this.totalCourses = totalCourses;
    }

}
