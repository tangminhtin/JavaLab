/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkdataformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author tangminhtin CE130438
 */
public class CheckDataFormat {

    private String phone;   // Store phone number
    private String date;    // Store date
    private String email;   // Store email address
    private final Scanner scanner = new Scanner(System.in); // Create scanner for input

    /**
     * Check input of user choice in menu
     *
     * @return
     */
    private int checkChoice() {
        while (true) {
            if (scanner.hasNextInt()) {  // If scanner has an integer number
                int num = scanner.nextInt();  // Get number from user
                scanner.nextLine(); // Remove enter key
                return num; // Return number of user choice
            } else {
                // Print out error and input again
                System.out.print("Error: Your input not an integer number! \n"
                        + "Try again: ");
                scanner.next();
            }
        }
    }

    /**
     * Check empty string of input data
     *
     * @param msg
     * @return
     */
    private String checkEmpty(String msg) {
        while (true) {
            String input = scanner.nextLine();  // Get input string from user
            if (!input.isEmpty()) {  // If not empty, then return input
                return input;
            } else {    // Print out error and input again
                System.out.print("ERROR: " + msg + " can't be empty! \n"
                        + "Try again: ");
            }
        }
    }

    /**
     * Check validate of phone number
     *
     * @return
     */
    public String checkPhone() {
        while (true) {
            System.out.print("Phone number: ");
            this.phone = this.checkEmpty("Phone number"); // Check empty phone number

            if (this.phone.matches("\\d+")) {  // Check number phone is numbers
                if (this.phone.matches("\\d{10}")) { // Check phone number is 10 numbers
                    System.out.println("Your phone number is valid");
                    return this.phone; // Return number of phone
                } else { // Print out error if not 10 numbers
                    System.out.println("ERROR: Phone number must be 10 digits!");
                }
            } else {    // Prrint out error if not numbers
                System.out.println("ERROR: Phone number must is number!");
            }
        }
    }

    /**
     * Check validate of email address
     *
     * @return
     */
    private String checkEmail() {
        while (true) {
            System.out.print("Email: ");
            this.email = this.checkEmpty("Email"); // Check empty email
            // Pattern for check validate of email address
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
                    + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

            if (this.email.matches(emailRegex)) { // If email match with emailRegex
                System.out.println("Your email is valid");
                return this.email;    // Return email address
            } else {    // Print out error if email not valid
                System.out.println("ERROR: Email must is correct format!");
            }
        }
    }

    /**
     * Check validate of date
     *
     * @return
     */
    private Date checkDate() {
        while (true) {
            System.out.print("Date: ");
            this.date = this.checkEmpty("Date"); // Check empty date
            // Pattern for check validate date
            String dateRegex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";

            if (this.date.matches(dateRegex)) { // If dateString is match with dateRegex
                try {
                    // Create new format for check date
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false);   // Set for special day
                    Date parseDate = sdf.parse(this.date);  // Convert string date to date
                    
                    System.out.println("Your date is valid");
                    return parseDate;  // Return date if is valid
                } catch(ParseException e) { // Print out error if date is not valid
                    System.out.println("Your date is invalid");
                }
            } else {    // Print out error if not valid
                System.out.println("ERROR: Date to correct format(dd/mm/yyyy). Ex: 01/01/2020");
            }
        }
    }

    /**
     * Main program will start first, show menu of program
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create new object of dataFormat
        CheckDataFormat dataFormat = new CheckDataFormat();

        while (true) {
            // Print out menu for user choice
            System.out.println("======= Validate Program =======");
            System.out.println("1. Check phone number");
            System.out.println("2. Check email address");
            System.out.println("3. Check date");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = dataFormat.checkChoice();  // Call method to check choice

            switch (choice) {
                case 1:
                    dataFormat.checkPhone();    // Call method to check phone number
                    break;

                case 2:
                    dataFormat.checkEmail();    // Call method to check email address
                    break;

                case 3:
                    dataFormat.checkDate(); // Call method to check validate of date
                    break;
                case 4:
                    // Exit program
                    System.out.println("Thank for using my program!");
                    System.exit(0);
                default:    // Print out error if not from 1 to 4
                    System.out.println("Error: Your must choice from 1 to 4!");
            }
        }
    }

    /**
     * Gets phone number
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone number
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets date
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets email address
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email address
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
