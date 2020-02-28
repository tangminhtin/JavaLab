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

    private final ArrayList<Contact> contacts;  // Store contact
    private final Validation validation;    // Object validate to check input

    /**
     * Constructor for ContactManagement
     */
    public ContactManagement() {
        contacts = new ArrayList<>();   // Create array list for contacts
        validation = new Validation();  // Create validation
    }

    /**
     * Show menu for user choice
     *
     * @return
     */
    public int showMenu() {
        System.out.println("============ Contact program ============");
        System.out.println("1. Add a Contact");
        System.out.println("2. Dislay all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        return validation.CheckInt("Your choice"); // Check and return choice
    }

    /**
     * Add contact
     */
    public void addContact() {
        System.out.println("####### Add a Contact #######");
        String fullname = validation.checkEmpty("Enter name: ");    // Check empty of name
        String group = validation.checkEmpty("Enter group: ");      // Check empty of group
        String address = validation.checkEmpty("Enter address: ");  // Check emtpy of address
        String phone = validation.checkPhone("Enter phone: ");      // Check validate of phone

        String[] arrName = fullname.split(" "); // Split fullname to array. Ex: "Tang Minh Tin" -> ["Tang", "Minh", "Tin"]
        String lastName = "";   // Store last name

        for (int i = 0; i < arrName.length; i++) {
            if (i != 0) { // If i not equal to 0 (not at the first element in array)
                lastName += arrName[i] + " ";   // Otherwise concate to last name
            }
        }

        // Add contact into array list
        contacts.add(new Contact(fullname, arrName[0], lastName, group, address, phone));
        System.out.println("Successful");   // Show message
    }

    /**
     * Remove contact
     */
    public void removeContact() {
        System.out.println("####### Delete a Contact #######");
        int id = validation.CheckInt("Enter ID");  // Check input of id

        boolean isDeleted = false;  // Status of delete

        for (int i = 0; i < this.contacts.size(); i++) {
            if (contacts.get(i).getId() == id) {    // If id contact equal id
                contacts.remove(i);     // Then remove it
                isDeleted = true;       // Change status of isDeleted
                System.out.println("Successful");   // Show message and exit
                return;
            }
        }

        if (!isDeleted) {    // If isDeleted is false, then show message
            System.out.println("ID doesn't exist in contact!");
        }
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
            // Show all information of contact
            System.out.printf("| %-5s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | \n", contact.getId(),
                    contact.getFullname(), contact.getFirstName(), contact.getLastName(),
                    contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
        System.out.println("+-------+----------------------+-----------------+-----------------+-----------------+-----------------+-----------------+");

    }

    /**
     * Main program will run here
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create object contactManagement
        ContactManagement contactManagement = new ContactManagement();

        while (true) {
            int choice = contactManagement.showMenu();  // Show menu and return choice
            switch (choice) {
                case 1:
                    // Add contact
                    contactManagement.addContact();
                    break;
                case 2:
                    // Display all contact
                    contactManagement.displayContact();
                    break;
                case 3:
                    // Remove contact
                    contactManagement.removeContact();
                    break;
                case 4:
                    System.out.println("Thank for using my program!");
                    System.exit(0); // Exit program
                default: // Print error
                    System.out.println("ERROR: Please choice from 1 to 4!");
            }
        }
    }

}
