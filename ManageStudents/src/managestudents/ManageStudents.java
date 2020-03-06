/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managestudents;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author tangminhtin
 */
public class ManageStudents {

    private final Validation validation;  // Create object validation
    private ArrayList<Student> students;    // Store list of student
    private final Scanner scanner = new Scanner(System.in); // Create scanner for input

    /**
     * Constructor for ManageStudents class
     */
    public ManageStudents() {
        validation = new Validation(); // Create new validation
        students = loadStudents();  // Store student from file

        if (students == null) { // If student is null then create new array
            students = new ArrayList<>();
        }
    }

    /**
     * Gets input information of student
     *
     * @return
     */
    private Student getInfoStudent() {
        int id = validation.checkInputId(students, "Enter id"); // Check id exist or not
        String studentName = validation.checkEmpty("Enter name");   // Check empty of student name
        String semester = validation.checkEmpty("Enter semester");  // Check empty of semester
        String courseName = validation.checkCourseName("Enter course name"); // Check empty course name
        System.out.println("Added successfully!");
        return new Student(id, studentName, semester, courseName);  // Return of bject student
    }

    /**
     * Add new student
     */
    private void addStudent() {
        while (true) {
            if (students.size() >= 10) { // If size if list if geater than 10
                System.out.print("Do you want to order now (Y/N)? ");   // Ask add more 
                String choice = scanner.nextLine(); // Get input string

                if (choice.toUpperCase().equals("Y")) { // If yes, get and add information of student
                    students.add(getInfoStudent()); // Add student in to array list
                } else if (choice.toUpperCase().equals("N")) { // If no, exit
                    break;  // Exit add student
                } else {
                    System.out.println("ERROR: Your choice must be 'Y' or 'N'!");
                }
            } else {    // Add student in to array list
                students.add(getInfoStudent());
            }
        }
    }

    /**
     * Show list of student
     *
     * @param students
     */
    private void listStudents(ArrayList<Student> students) {
        System.out.printf("%-20s%-10s%10s\n", "Name", "Semester", "Course name");
        System.out.println("+-------+---------------------------+------------+-----------------+");
        System.out.println("|  ID   | Student name              | Semester   | Course name     |");
        System.out.println("+-------+---------------------------+------------+-----------------+");
        for (Student s : students) {    // Print out each student in array list
            System.out.printf("| %5s | %-25s | %-10s | %-15s |\n", s.getId(), s.getStudentName(), s.getSemester(), s.getCourseName());
        }
        System.out.println("+-------+---------------------------+------------+-----------------+");

    }

    /**
     * Find and sort student
     */
    private void findAndSort() {
        ArrayList<Student> foundStudents = new ArrayList<>();   // Store list of student if found
        String keyword = validation.checkEmpty("Enter name to search"); // Get name of student
        for (Student s : students) {
            // If name of student equal to name of input
            if (s.getStudentName().toLowerCase().contains(keyword.toLowerCase())) {
                foundStudents.add(s);   // Then add it into array list
            }
        }
        Collections.sort(foundStudents);    // Sort student by name
        if (foundStudents.isEmpty()) {  // If foundStudents if empty then show error message
            System.out.println("The list of student is empty!");
            return;     // Exit
        }
        listStudents(foundStudents); // Show list of student after found
    }

    /**
     * Update or delete student if user choice U or D
     */
    private void updateOrDelete() {
        int id = validation.checkInt("Enter id");   // Check input is number or not
        int index = validation.checkStudentId(students, id);    // Check studen exist or not
        if (index == -1) {      // If not exist, then print out error
            System.out.println("ERROR: Your ID doesn't exist!");
            return; // Exit
        }

        while (true) {
            String choice = validation.checkEmpty("Do you want to update (U) or delete (D) student? "); // Check empty of input
            if (choice.toUpperCase().equals("U")) { // If choice U, the update information of student
                String name = validation.checkEmpty("Enter name");   // Check empty of student name
                String semester = validation.checkEmpty("Enter semester");  // Check empty of semester
                String courseName = validation.checkEmpty("Enter course name");  // Check empty course name
                students.set(index, new Student(id, name, semester, courseName)); // Update student
                System.out.println("Updated successfully!");
                break;  // Exit
            } else if (choice.toUpperCase().equals("D")) {  // If user choice D
                students.remove(index); // Then remove student
                System.out.println("Deleted successfully!");
                break; // Exit
            } else {    // Otherwise show error
                System.out.println("ERROR: Your choice must be 'U' or 'D'!");
            }
        }
    }

    /**
     * Report student
     */
    private void reportStudent() {
        ArrayList<Report> reports = new ArrayList<>();  // Create new array list report

        for (int i = 0; i < students.size(); i++) {
            boolean isExisted = false;  // Check report exist or not
            for (int j = 0; j < reports.size(); j++) {
                // Student name and course name is exist in report, then update total of course
                if (students.get(i).getStudentName().equals(reports.get(j).getStudentName())
                        && students.get(i).getCourseName().equalsIgnoreCase(reports.get(j).getCourseName())) {
                    reports.get(j).setTotalCourses(reports.get(j).getTotalCourses() + 1);
                    isExisted = true; // Status of exist or not
                }
            }
            if (!isExisted) {   // If not exist in report, then create new report
                reports.add(new Report(students.get(i).getStudentName(), students.get(i).getCourseName(), 1));
            }
        }

        System.out.println("+-------+---------------------------+------------+-----------------+");
        System.out.println("| No.   | Student name              | Course     | Total of course |");
        System.out.println("+-------+---------------------------+------------+-----------------+");
        // Show list of report
        for (int i = 0; i < reports.size(); i++) {
            System.out.printf("| %5s | %-25s | %-10s | %15s |\n", i + 1, reports.get(i).getStudentName(),
                    reports.get(i).getCourseName(), reports.get(i).getTotalCourses());
        }
        System.out.println("+-------+---------------------------+------------+-----------------+");

    }

    /**
     * Save student into text file
     */
    public void saveStudents() {
        try {
            // Create object output stream to save file
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/data/studentData.txt"));
            oos.writeObject(students);  // Write object write into text file
            oos.close();    // Close object output stream
            System.out.println("Saving file studentData.txt");  // Print message
        } catch (IOException e) {   // Show message if error
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /**
     * Load student of text file and store it into array list
     *
     * @return
     */
    public ArrayList<Student> loadStudents() {
        try {
            // Create object input stream to read file
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/data/studentData.txt"));
            ArrayList<Student> student = (ArrayList<Student>) ois.readObject(); // Read file and cast it to array list
            ois.close(); // Close object input stream
            System.out.println("Loading file studentData.txt"); // Print message
            return student;
        } catch (IOException | ClassNotFoundException e) { // Show message if error
            System.out.println("ERROR: " + e.getMessage());
        }
        return null;    // Return null if file is empty
    }

    /**
     * Show menu for user choice
     *
     * @return
     */
    private int showMenu() {
        // Show menu
        System.out.println("\tWELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create\n"
                + "2. Find and Sort\n"
                + "3. Update/Delete\n"
                + "4. Report\n"
                + "5. Exit");
        return validation.checkInt("Please choose"); // Check input is integer number or not
    }

    /**
     * Main program will run first
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create new object manageStudents
        ManageStudents manageStudents = new ManageStudents();

        while (true) {
            int choice = manageStudents.showMenu(); // Show menu
            switch (choice) {
                case 1:
                    manageStudents.addStudent();    // Add new student
                    break;
                case 2:
                    manageStudents.findAndSort();   // Find and sort student
                    break;
                case 3:
                    manageStudents.updateOrDelete();  // Update or delete student
                    break;
                case 4:
                    manageStudents.reportStudent(); // Report student
                    break;
                case 5:
                    manageStudents.saveStudents();   // Save student to text file
                    System.out.println("Thank for using my program!");
                    System.exit(0); // Exit
            }
        }
    }

}
