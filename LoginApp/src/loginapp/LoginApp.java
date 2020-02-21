/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author tangminhtin CE130438 SE1403
 */
public class LoginApp {

    // Create array list for accounts to store account and scanner for input
    private final ArrayList<Account> accounts;
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructor for class LoginApp
     */
    public LoginApp() {
        accounts = new ArrayList<>();
    }

    /**
     * Add new user with full attributes
     *
     * @param username
     * @param password
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param dob
     * @throws AccountException
     */
    public void addUser(String username, String password, String name, String phone, String email, String address, Date dob) throws AccountException {
        accounts.add(new Account(username, getMd5(password), name, phone, email, address, dob));
    }

    /**
     * Call method to input information of account and add new account
     *
     * @throws AccountException
     */
    public void addUser() throws AccountException {
        System.out.println("----------------- Add User -----------------");
        System.out.print("Account: ");
        String username = this.checkUsername(); // Call method to check input of username

        System.out.print("Password: ");
        String password = this.checkEmpty("Password"); // Call method to check input of password

        System.out.print("Name: ");
        String name = this.checkEmpty("Name");  // Call method to check input of name

        System.out.print("Phone: ");
        String phone = this.checkPhone();   // Call method to check nput of phone

        System.out.print("Email: ");
        String email = this.checkEmail(); // Call method to check input of email

        System.out.print("Address: ");
        String address = this.checkEmpty("Address");  // Call method to check input of address

        System.out.print("DOB: ");
        Date dob = this.checkDate();    // Call method to check input of dob

        // Add new user and print success if created
        this.addUser(username, password, name, phone, email, address, dob);
        System.out.println("Create account success.");
    }

    /**
     * Login user, return true if username is exist or not is false
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        for (Account acc : accounts) {
            // If username and password is valid and then return true
            if (username.equals(acc.getUsername()) && getMd5(password).equals(acc.getPassword())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get input account, password and call method to check login
     *
     * @throws AccountException
     */
    public void login() throws AccountException {
        System.out.println("----------------- Login -----------------");
        System.out.print("Account: ");
        String acc = this.checkEmpty("Account");    // Call method to check input of acc
        System.out.print("Password: ");
        String pass = this.checkEmpty("Password");  // Call method to check input of pass

        // Check status of login
        boolean isLogin = this.login(acc, pass);

        if (isLogin) {
            // Show change password if user login success
            System.out.println("------------ Wellcome -----------");
            System.out.print("Hi " + acc + ", do you want change password now? Y/N: ");
            boolean isContinune = true;

            while (isContinune) {
                // Get y or n from user
                String op = scanner.nextLine();
                switch (op.toUpperCase()) {
                    case "Y":   // If y to check password
                        this.changPass(acc);    // Call method to change password
                        isContinune = false;    // End loop
                        break;
                    case "N":   // Don't change password
                        System.out.println("Don't change!");
                        isContinune = false;    // End loop
                        break;
                    default:    // Print error if not choice y or n
                        System.out.println("You must choose 'Y' or 'N'!");
                        System.out.print("Try again: ");    // Retype
                        break;
                }
            }
        } else {
            // Print out error if account or password incorrect
            System.out.println("Your account or password incorrect!");
        }
    }

    /**
     * Change password
     *
     * @param username
     * @param newpass
     * @throws AccountException
     */
    public void changePass(String username, String newpass) throws AccountException {
        for (Account acc : accounts) {
            // If user is exist and then change password
            if (username.equals(acc.getUsername())) {
                // Set new password
                acc.setPassword(getMd5(newpass));
            }
        }
    }

    /**
     * Method will get old, new and renew password and then change password
     *
     * @param acc
     * @throws AccountException
     */
    public void changPass(String acc) throws AccountException {
        boolean checker = true;
        while (checker) {
            System.out.print("Old password: ");
            // Check old password is empty or not
            String old = this.checkEmpty("Old password");
            // Check old password is cerrect or not
            if (this.login(acc, old)) {
                // Get newpass, repass and check empty
                System.out.print("New password: ");
                String newPass = this.checkEmpty("New password");
                System.out.print("Renew password: ");
                String rePass = this.checkEmpty("Renew password");

                // If newPass = rePass, then change password and print out success
                if (newPass.equals(rePass)) {
                    this.changePass(acc, newPass);
                    System.out.println("Password change successful!");
                    checker = false;
                } else {
                    // Print error if password not match
                    System.out.println("Password not match!");
                }
            } else {
                // Print error if old password incorrect
                System.out.println("Old password incorrect!");
            }
        }
    }

    /**
     * Return MD5 hash
     *
     * @param input
     * @return
     */
    public String getMd5(String input) {
        try {
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Check validate of integer number
     *
     * @return
     */
    public int checkValidate() {
        while (true) {
            if (scanner.hasNextInt()) {
                // Get input from user
                int choice = scanner.nextInt();
                scanner.nextLine(); // Remove enter key
                return choice;  // Return choice
            } else {
                // Show out error if not an interger number
                System.out.println("Your inputted not an integer number!");
                System.out.print("Choice again: "); // Retype
                scanner.next();
            }
        }
    }

    /**
     * Check username is valid or not
     *
     * @return
     */
    public String checkUsername() {
        String username = "";   // Create username
        boolean isOK = true;    // Condition loop

        while (isOK) {
            username = checkEmpty("Account");   // Call method to check input of username
            boolean isExist = false;  // Check exist username
            for (Account acc : accounts) {
                // If username is exist, print out error
                if (username.equals(acc.getUsername())) {
                    System.out.println("This account has already existed");
                    System.out.print("Try another account: ");
                    isExist = true;
                }
            }
            // If username not exist then return username
            if (!isExist) {
                return username;
            }
        }
        return username;  // Return username
    }

    /**
     * Check empty or not
     *
     * @param msg
     * @return
     */
    public String checkEmpty(String msg) {
        while (true) {
            String input = scanner.nextLine();
            // If input is empty and then print out error
            if (input.isEmpty()) {
                System.out.println("ERROR: " + msg + " can't be empty!");
                System.out.print("Enter " + msg + " again: ");
            } else {
                // therwise return input
                return input;
            }
        }
    }

    /**
     * Check phone is valid or not
     *
     * @return
     */
    public String checkPhone() {
        String phone = "";      // Create phone
        boolean isOK = true;    // Condition loop

        while (isOK) {
            phone = checkEmpty("Phone"); // Call method to check input of phone
            String phoneRegex = "\\d{10,11}"; // Pattern for phone number
            boolean isContinue = true;  // Condition loop

            while (isContinue) {
                // If pattern not match, the print out error
                if (!Pattern.matches(phoneRegex, phone)) {
                    System.out.println("Phone number must be 10 or 11 number!");
                    System.out.print("Try anthor phone: ");
                    phone = checkEmpty("Phone");
                } else {
                    isContinue = false;
                }
            }

            boolean isExist = false;  // Check exist phone
            for (Account acc : accounts) {
                if (phone.equals(acc.getPhone())) {
                    // Check phone if exist print out error
                    System.out.println("This phone has already existed!");
                    System.out.print("Try another phone: ");
                    isExist = true;
                }
            }

            // If phone not exist then return phone
            if (!isExist) {
                return phone;
            }
        }
        return phone;   // Return phone
    }

    /**
     * Check email is valid or not
     *
     * @return
     */
    public String checkEmail() {
        String email = "";  // Create email
        boolean isOK = true;    // Condition loop

        while (isOK) {
            email = checkEmpty("Email"); // Call method to check input of email
            // Pattern for email
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
                    + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
            boolean isContinue = true;  // Condition loop

            while (isContinue) {
                // If pattern not match, the print out error
                if (!Pattern.matches(emailRegex, email)) {
                    System.out.println("Your email invalid!");
                    System.out.print("Try another email: ");
                    email = checkEmpty("Email");
                } else {
                    isContinue = false;
                }
            }

            boolean isExist = false;  // Check exist email
            for (Account acc : accounts) {
                if (email.equals(acc.getEmail())) {
                    // Check email if exist print out error
                    System.out.println("This email has already existed!");
                    System.out.print("Try another email: ");
                    isExist = true;
                }
            }

            // If email not exist then return email
            if (!isExist) {
                return email;
            }
        }
        return email;   // Return email
    }

    /**
     * Check valid for date
     *
     * @return
     */
    public Date checkDate() {
        // Create new sdf with format is dd/MM/yyyy
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  // Check special day
        Date date = null;  // Create date
        boolean isOK = true;    // Condition loop

        while (isOK) {
            try {
                String dateStr = checkEmpty("DOB"); // Call method to check input of dob
                date = sdf.parse(dateStr); // Convert string to date
                return date;

            } catch (ParseException e) {
                // Print error if date is invalid
                System.out.println("Date is invalid !");
                System.out.print("Enter again (dd/MM/yyyy): ");
            }
        }
        return date;    // Return date
    }

    /**
     * Method to show menu for user choice
     *
     * @return
     */
    public int showMenu() {
        // Print out menu for user choice
        System.out.println("==================== Login Program ====================");
        System.out.println("1. Add User");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");

        // Return number if method to check validate of input is done
        return this.checkValidate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LoginApp myLoginApp = new LoginApp(); // Create new object

        try {
            while (true) {
                int func = myLoginApp.showMenu();   // Call method to show menu
                switch (func) {
                    case 1:
                        myLoginApp.addUser();   // Call method to add new user
                        break;
                    case 2:
                        myLoginApp.login(); // Call method to login
                        break;
                    case 3:
                        // Print message and exit program
                        System.out.println("Thank for using my application.");
                        System.exit(0);
                    default:    // Print error if not in 1 to 3
                        System.out.println("Error: Please enter 1 to 3");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print out error
        }
    }

}
