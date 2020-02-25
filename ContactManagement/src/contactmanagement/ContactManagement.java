/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagement;

import java.util.ArrayList;

/**
 *
 * @author tangminhtin CE130438
 */
public class ContactManagement {

    private final ArrayList<Contact> contacts;  // Create array list to store contact
    private final Validation validation;    // Create validation to check validate of input

    /**
     * Create constructor for ContactManagement
     */
    public ContactManagement() {
        contacts = new ArrayList<>();   // Create new array list for contacts
        validation = new Validation();  // Create new validation
    }

    /**
     * Add new contact
     */
    public void addContact() {
        System.out.println("####### Add a Contact #######");
        String fullname = validation.checkEmpty("Enter Name: ");    // Call method to check empty of name
        String group = validation.checkEmpty("Enter Group: ");      // Call method to check empty of group
        String address = validation.checkEmpty("Enter Address: ");  // Call method to check emtpy of address
        String phone = validation.checkPhone("Enter Phone: ");      // Call method to check validate of phone

        String[] arrName = fullname.split(" "); // Split full name to array
        String firstName = "";  // Store first name
        String lastName = "";   // Store last name

        for (int i = 0; i < arrName.length; i++) {
            if (i == 0) {   // If i equal 0
                firstName = arrName[i]; // Then store first name
            } else {
                lastName += arrName[i] + " ";   // Otherwise store last name
            }
        }
        // Add new contact into array list
        contacts.add(new Contact(fullname, firstName, lastName, group, address, phone));
        System.out.println("Successful");   // Print out message
    }

    /**
     * Display all contact
     */
    public void displayContact() {
        System.out.println("################################### Display all Contact ###################################");
        System.out.println("+-------+----------------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.println("| ID    | Full Name            | First Name      | Last Name       | Group           | Address         |Phone            |");
        System.out.println("+-------+----------------------+-----------------+-----------------+-----------------+-----------------+-----------------+");
        for (Contact contact : contacts) {
            // Print out all information of contact
            System.out.printf("| %-5s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | \n", contact.getId(),
                    contact.getFullname(), contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
        System.out.println("+-------+----------------------+-----------------+-----------------+-----------------+-----------------+-----------------+");

    }

    /**
     * Delete contact
     */
    public void deleteContact() {
        System.out.println("####### Delete a Contact #######");
        int id = validation.checkValidate("Enter ID");  // Call method to check validate of id
        boolean isRemoved = false;  // Store status of remove
        for (int i = 0; i < this.contacts.size(); i++) {
            if (contacts.get(i).getId() == id) {    // If id equal id in contact
                contacts.remove(i);     // Then remove it
                isRemoved = true;       // Set status of remove
            }
        }

        if (isRemoved) {    // If isRemoved is true
            System.out.println("Successful");   // Then print out message
        } else {    // Otherwise print out error
            System.out.println("Your ID doesn't exist!");
        }
    }

    /**
     * Method will be show menu for user choice
     *
     * @return
     */
    public int showMenu() {
        System.out.println("============ Contact program ============");
        System.out.println("1. Add a Contact");
        System.out.println("2. Dislay all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        return validation.checkValidate("Your choice"); // Check and return choice
    }

    /**
     * First program will run here
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create object contactManagement
        ContactManagement contactManagement = new ContactManagement();

        while (true) {
            int choice = contactManagement.showMenu();  // Call method to show menu and return choice
            switch (choice) {
                case 1:
                    contactManagement.addContact();     // Call method to add contact
                    break;
                case 2:
                    contactManagement.displayContact(); // Call method to display all contact
                    break;
                case 3:
                    contactManagement.deleteContact();  // Call method to delete contact
                    break;
                case 4:
                    System.out.println("Thank for using my program!");
                    System.exit(0); // Exit program
                default: // Print error
                    System.out.println("ERROR: You must choice from 1 to 4!");
            }
        }
    }

}
