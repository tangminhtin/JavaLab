/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestudents;

import java.io.Serializable;

/**
 *
 * @author tangminhtin
 */
public class Student implements Comparable<Student>, Serializable {

    private static final long serialVersionUID = 1L; // Default serialVersion id
    private int id;             // Store id
    private String studentName; // Store student name
    private String semester;    // Store semester
    private String courseName;  // Store course name

    /**
     * Constructor for Student class
     *
     * @param id
     * @param studentName
     * @param semester
     * @param courseName
     */
    public Student(int id, String studentName, String semester, String courseName) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    /**
     * Gets id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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
     * Gets semester
     *
     * @return
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets semester
     *
     * @param semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
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
     * Override method compareTo to sort name by ascending
     */
    @Override
    public int compareTo(Student o) {
        return this.getStudentName().compareTo(o.getStudentName());
    }

}
