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

    private final Scanner scanner = new Scanner(System.in); // Create scanner

    /**
     * Check integer or not and retype
     *
     * @param msg
     * @return
     */
    public int CheckInt(String msg) {
        while (true) {
            System.out.print(msg + ": ");   // Show message
            if (scanner.hasNextInt()) { // If scanner has an integer number
                int num = scanner.nextInt();    // Get input
                scanner.nextLine();     // Delete enter key
                return num; // Return num
            } else {    // Show error if invalid
                System.out.println("ERROR: " + msg + " must be digit!");
                scanner.next(); // Move the next of input
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
            System.out.print(msg);  // Show message
            String input = scanner.nextLine();// Get input
            if (!input.isEmpty()) {
                return input;   // If not empty, then return input
            } else {    // Show error and input again
                System.out.println("ERROR: Input is empty!");
            }
        }
    }

    /**
     * Check phone number
     *
     * @param msg
     * @return
     */
    public String checkPhone(String msg) {
        while (true) {
            String phone = this.checkEmpty(msg); // Check empty for phone number

            // If phone is match with each regex
            if (phone.matches("\\d{10}")
                    || phone.matches("\\d{3}\\-\\d{3}\\-\\d{4}") || phone.matches("\\d{3}\\-\\d{3}\\-\\d{4} (x)\\d{4}")
                    || phone.matches("\\d{3}\\-\\d{3}\\-\\d{4} (ext)\\d{4}") || phone.matches("\\(\\d{3}\\)\\-\\d{3}\\-\\d{4}")
                    || phone.matches("\\d{3}\\.\\d{3}\\.\\d{4}") || phone.matches("\\d{3} \\d{3} \\d{4}")) {
                return phone;   // Return phone
            } else {    // Otherwise show instruction of input phone number
                System.out.println("Please input Phone flow \n"
                        + "# 1234567890\n" + "# 123-456-7890\n"
                        + "# 123-456-7890 x1234\n" + "# 123-456-7890 ext1234\n"
                        + "# (123)-456-7890\n" + "# 123.456.7890\n" + "# 123 456 7890");
            }
        }
    }

}
