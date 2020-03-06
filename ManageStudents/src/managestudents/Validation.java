/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestudents;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tangminhtin
 */
public class Validation {

    private final Scanner scanner = new Scanner(System.in); // Create scanner for input

    /**
     * Check id of student is exist or not
     *
     * @param students
     * @param id
     * @return
     */
    public int checkStudentId(ArrayList<Student> students, int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {    // If id equal to id
                return i;   // Then return i
            }
        }
        return -1;  // Otherwise return -1
    }

    /**
     * Check name of course is valid or not
     *
     * @param msg
     * @return
     */
    public String checkCourseName(String msg) {
        while (true) {
            String[] courses = {"java", ".net", "c/c++"}; // List of courses
            String course = checkEmpty(msg); // Check empty string
            for (String str : courses) {
                if (str.equalsIgnoreCase(course)) { // If str equal to list of courses
                    return course;  // Then return course
                }
            }
            // Show error message
            System.out.println("ERROR: There are only three courses: Java, .Net, C/C++");
        }
    }

    /**
     * Check input id of student b is exist or not
     *
     * @param students
     * @param msg
     * @return
     */
    public int checkInputId(ArrayList<Student> students, String msg) {
        while (true) {
            int id = this.checkInt(msg);    // Check input is an integer or not
            if (checkStudentId(students, id) == -1) {   // If not exist then return id
                return id;
            }
            System.out.println("ERROR: ID is existed!");    // Show error
        }
    }

    /**
     * Check input is an integer or not
     *
     * @param msg
     * @return
     */
    public int checkInt(String msg) {
        while (true) {
            System.out.print(msg + ": ");   // Show input message
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();    // Get input
                scanner.nextLine();
                return num; // Return num if valid
            } else {    // Otherwise show error message
                System.out.println("ERROR: " + msg + " must be an integer number!");
                scanner.next();
            }
        }
    }

    /**
     * Check string is empty or not
     *
     * @param msg
     * @return
     */
    public String checkEmpty(String msg) {
        while (true) {
            System.out.print(msg + ": ");   // Show input message
            String str = scanner.nextLine().trim(); // Get input string
            if (!str.isEmpty()) {   // If not empty
                return str; // Then return str
            } else {    // Otherwise show error message
                System.out.println("ERROR: " + msg + " cannot empty!");
            }
        }
    }

}
