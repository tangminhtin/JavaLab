/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tangminhtin CE130438
 */
public class DoctorManagement {

    private final Scanner scanner = new Scanner(System.in); // Create scanner for input
    private final ArrayList<Doctor> doctors;      // Store doctor into array list

    /**
     * Create constructor for DoctorManagement
     */
    public DoctorManagement() {
        this.doctors = new ArrayList<>(); // Create new array list
    }

    /**
     * Method will add new doctor into array list and return if success
     *
     * @param code
     * @param name
     * @param specialization
     * @param availability
     * @return
     */
    private boolean addDoctor(String code, String name, String specialization, int availability) {
        return doctors.add(new Doctor(code, name, specialization, availability)); // Add new doctor
    }

    /**
     * Set information of the doctor with index and doctor object
     *
     * @param index
     * @param doctor
     * @return
     */
    private Doctor updateDoctor(int index, Doctor doctor) {
        return doctors.set(index, doctor);
    }

    /**
     * Method will delete doctor with parameter index
     *
     * @param index
     * @return
     */
    private Doctor deleteDoctor(int index) {
        return this.doctors.remove(index);  // Remove doctor
    }

    /**
     * Search doctor with name, and store its into array list
     *
     * @param name
     * @return
     */
    private ArrayList<Doctor> searchDoctors(String name) {
        // Create array list to store the doctor is founded
        ArrayList<Doctor> foundDoctors = new ArrayList<>();

        for (Doctor doctor : doctors) {
            // If name of doctor is existed
            if (doctor.getName().toUpperCase().contains(name.toUpperCase())) {
                foundDoctors.add(doctor);   // Then add doctor into array list
            }
        }

        return foundDoctors;    // Return array list of doctor
    }

    /**
     * Check doctor is exist or not with parameter code
     *
     * @param code
     * @return
     */
    private int isExisted(String code) {
        for (int i = 0; i < this.doctors.size(); i++) {
            if (doctors.get(i).getCode().equals(code)) { // If code is existed
                return i;    // Then return true
            }
        }
        return -1; // If not exit return false
    }

    /**
     * Add new doctor
     */
    public void addDoctor() {
        System.out.println("--------- Add Doctor ---------");
        System.out.print("Enter Code: ");
        String code = this.checkCode();     // Call method to check code
        System.out.print("Enter Name: ");
        String name = this.checkEmpty("Name"); // Call method to check empty of name
        System.out.print("Enter Specialization: ");
        String spec = this.checkEmpty("Specialization"); // Call method to check empty of specialization 
        System.out.print("Enter Availability: ");
        int avai = this.checkAvailability(); // Call method to check availability of doctor

        this.addDoctor(code, name, spec, avai); // Call method to add doctor into array list
        System.out.println("Your doctor is created!");
    }

    /**
     * Update information of the doctor
     */
    public void updateDoctor() {
        System.out.println("--------- Update Doctor ---------");
        System.out.print("Enter Code: ");
        int index;  // Store index if code of doctor is existed

        String code;    // Store code of input
        while (true) {
            code = scanner.nextLine();  // Get code of input from user
            index = this.isExisted(code);   // Call method to check code exist or not
            if (index == -1) {   // If code not exit, then print out error
                System.out.print("ERROR: Doctor code does not exist! \nTry again: ");
            } else {    // Otherwise stop input code of doctor
                break;
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();   // Get input name of doctor
        if (name.isEmpty()) {    // If empty, then set oll name for doctor
            name = this.doctors.get(index).getName();
        }

        System.out.print("Enter Specialization: ");
        String spec = scanner.nextLine();   // Get input specialization of doctor
        if (spec.isEmpty()) {    // If empty, then set old specialization for doctor
            spec = this.doctors.get(index).getSpecialization();
        }

        System.out.print("Enter Availability: ");
        int avai = this.checkAvailability(); // Call method to check input availability of doctor

        this.updateDoctor(index, new Doctor(code, name, spec, avai)); // Call method to update doctor
        System.out.println("Your doctor is updated!");
    }

    /**
     * Delete doctor
     */
    public void deleteDoctor() {
        System.out.println("--------- Delete Doctor ---------");
        System.out.print("Enter Code: ");
        int index;  // Store index if code of doctor is existed

        String code;    // Store code of input
        while (true) {
            code = scanner.nextLine();  // Get code of input from user
            index = this.isExisted(code);   // Call method to check code exist or not
            if (index == -1) {   // If code not exit, then print out error
                System.out.print("ERROR: Doctor code does not exist! \nTry again: ");
            } else {    // Otherwise stop input code of doctor
                break;
            }
        }

        this.deleteDoctor(index);    // Call method to delete doctor
        System.out.println("Your doctor is deleted!");
    }

    /**
     * Method will search doctor with input from user
     */
    public void searchDoctor() {
        System.out.println("--------- Search Doctor ---------");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();   // Get input search of doctor
        ArrayList<Doctor> doc = searchDoctors(text);    // Store doctor after search

        if (doc.isEmpty()) {    // If doctor is empty then print out error
            System.out.println("Doctor does not exist");
        } else {
            // Otherwisde show list search of doctor
            System.out.println("######### Result #########");
            System.out.println("+------------+----------------------+----------------------+----------------------+");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | \n", "Code", "Name", "Specialization", "Availability");
            System.out.println("+------------+----------------------+----------------------+----------------------+");
            // Print out information of doctor after search
            for (int i = 0; i < doc.size(); i++) {
                System.out.printf("| %-10s | %-20s | %-20s | %-20s | \n", doc.get(i).getCode(), doc.get(i).getName(),
                        doc.get(i).getSpecialization(), doc.get(i).getAvailability());
            }
            System.out.println("+------------+----------------------+----------------------+----------------------+");
        }
    }

    /**
     * Check code is empty or not, and check code is exist or not
     *
     * @return
     */
    private String checkCode() {
        while (true) {
            String code = checkEmpty("Code"); // Call method to check empty of code
            if (isExisted(code) == -1) {  // If not exist, then return the code
                return code;
            } else {    // Print out error if code is exist
                System.out.print("ERROR: Doctor code is duplicate! \nTry again: ");
            }
        }
    }

    /**
     * Check availability of the doctor
     *
     * @return
     */
    private int checkAvailability() {
        while (true) {
            int avai = checkNum();  // Call method to check avai is number or not
            if (avai >= 0) { // if avai >= 0, then return avai
                return avai;
            } else {    // Otherwise print out error and input again
                System.out.print("ERROR: Availability must be greater than or equal to 0! \n"
                        + "Try again: ");
            }
        }
    }

    /**
     * Check empty value for input
     *
     * @param msg
     * @return
     */
    private String checkEmpty(String msg) {
        while (true) {
            String str = scanner.nextLine();  // Get input from user
            if (!str.isEmpty()) {    // If not empty, then return str
                return str;
            } else {    // Print out error if input is empty
                System.out.print("ERROR: " + msg + " can't be empty! \nTry again: ");
            }
        }
    }

    /**
     * Check input is an integer or not
     *
     * @return
     */
    private int checkNum() {
        while (true) {
            if (scanner.hasNextInt()) {  // If scanner has an integer number
                int num = scanner.nextInt();  // Get number from user
                scanner.nextLine(); // Remove enter key
                return num; // Return number of user choice
            } else {
                // Print out error and input again
                System.out.print("ERROR: Your input not an integer number! \n"
                        + "Try again: ");
                scanner.next();
            }
        }
    }

    /**
     * Main program will start first, show menu of program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create new object of management
        DoctorManagement management = new DoctorManagement();

        while (true) {
            // Show meu for user choice
            System.out.println("=========== DOCTOR MANAGEMENT ===========");
            System.out.println("1. Add Doctor.");
            System.out.println("2. Update Doctor.");
            System.out.println("3. Delete Doctor.");
            System.out.println("4. Search Doctor.");
            System.out.println("5. Exit.");
            System.out.print("Please choose: ");
            int choice = management.checkNum(); // Call method to check and get choice

            switch (choice) {
                case 1:
                    management.addDoctor(); // Call method to add doctor
                    break;
                case 2:
                    management.updateDoctor();  // Call method to update doctor
                    break;
                case 3:
                    management.deleteDoctor(); // Call method to delete doctor
                    break;
                case 4:
                    management.searchDoctor();  // Call method to search doctor
                    break;
                case 5: // Exit program
                    System.out.println("Thanks for using my program!");
                    System.exit(0);
                default: // Print out error if not from 1 to 5
                    System.out.println("Error: Your must choice from 1 to 5!");
            }
        }
    }

}
