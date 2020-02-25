/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagement;

import java.util.Scanner;

/**
 *
 * @author tangminhtin CE130438
 */
public class Validation {

    private final Scanner scanner = new Scanner(System.in); // Create scanner for input

    /**
     * Check empty string of input data from user
     *
     * @param msg
     * @return
     */
    public String checkEmpty(String msg) {
        while (true) {
            System.out.print(msg);  // Print out message
            String input = scanner.nextLine();// Get input string from user
            if (!input.isEmpty()) {
                return input;   // If not empty, then return input
            } else {    // Print out error and input again
                System.out.println("ERROR: Your input is empty!");
            }
        }
    }

    /**
     * Check validate of phone number
     *
     * @param msg
     * @return
     */
    public String checkPhone(String msg) {
        while (true) {
            String phone = this.checkEmpty(msg); // Check empty phone number
            // Pattern validate for phone number
            String phoneRegex = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
                    + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";

            if (phone.matches(phoneRegex)) {    // If phone is match with phoneRegex
                return phone;   // Then return phone
            } else {    // Otherwise print instruction of input phone number
                System.out.println("Please input Phone flow");
                System.out.println("# 1234567890\n"
                        + "# 123-456-7890\n"
                        + "# 123-456-7890 x1234\n"
                        + "# 123-456-7890 ext1234\n"
                        + "# (123)-456-7890\n"
                        + "# 123.456.7890\n"
                        + "# 123 456 7890");
            }
        }
    }

    /**
     * Check validate input of an integer
     *
     * @param msg
     * @return
     */
    public int checkValidate(String msg) {
        while (true) {
            System.out.print(msg + ": ");   // Print out message
            if (scanner.hasNextInt()) { // scanner has an integer number
                int num = scanner.nextInt();    // Get input from user
                scanner.nextLine();     // Remove enter key
                return num; // Return number of input
            } else {    // Print out error if invalid
                System.out.println("ERROR: " + msg + " must be digit!");
                scanner.next(); // Move the next of input
            }
        }
    }

}
