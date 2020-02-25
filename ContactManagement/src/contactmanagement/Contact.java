/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagement;

/**
 *
 * @author tangminhtin CE130438
 */
public class Contact {

    private int id;             // Store id of contact
    private String fullname;    // Store full name of contact 
    private String firstName;   // Store first name of contact
    private String lastName;    // Store last name of contact
    private String group;       // Store group
    private String address;     // Store address
    private String phone;       // Store phone
    private static int autoId = 0;  // Id of contact will be automatically increase

    /**
     * Create constructor for Contact class
     *
     * @param fullname
     * @param firstName
     * @param lastName
     * @param group
     * @param address
     * @param phone
     */
    public Contact(String fullname, String firstName, String lastName, String group, String address, String phone) {
        this.id = ++autoId; // Id will increase by 1 for each time is call
        this.fullname = fullname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
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
     * Gets full name
     *
     * @return
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets full name
     *
     * @param fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Gets first name
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets group
     *
     * @return
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets group
     *
     * @param group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Gets Address
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets Address
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets phone
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
