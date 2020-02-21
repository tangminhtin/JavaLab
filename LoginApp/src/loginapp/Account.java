/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

import java.util.Date;

/**
 *
 * @author tangminhtin CE130438 SE1403
 */
public final class Account {

    private String username;    // Create username
    private String password;    // Create password
    private String name;        // Create name
    private String phone;       // Create phone
    private String email;       // Create email
    private String address;     // Create address
    private Date dob;           // Create dob (day of birth)

    /**
     * Create constructor for class Account
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
    public Account(String username, String password, String name, String phone, String email, String address, Date dob) throws AccountException {
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
        this.setPhone(phone);
        this.setEmail(email);
        this.setAddress(address);
        this.setDob(dob);
    }

    /**
     * Gets username
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username
     *
     * @param username
     * @throws AccountException
     */
    public void setUsername(String username) throws AccountException {
        if (username.isEmpty()) {
            throw new AccountException("Username cannot null");
        } else {
            this.username = username;
        }
    }

    /**
     * Gets password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password
     *
     * @param password
     * @throws AccountException
     */
    public void setPassword(String password) throws AccountException {
        if (password.isEmpty()) {
            throw new AccountException("Password cannot null");
        } else {
            this.password = password;
        }
    }

    /**
     * Gets name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     *
     * @param name
     * @throws AccountException
     */
    public void setName(String name) throws AccountException {
        if (name.isEmpty()) {
            throw new AccountException("Name cannot null");
        } else {
            this.name = name;
        }
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
     * @throws AccountException
     */
    public void setPhone(String phone) throws AccountException {
        if (phone.length() > 11 || phone.length() < 10) {
            throw new AccountException("Phone number must be 10 or 11 number!");
        } else {
            this.phone = phone;
        }
    }

    /**
     * Gets email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email
     *
     * @param email
     * @throws AccountException
     */
    public void setEmail(String email) throws AccountException {
        if (!email.contains("@") || email.isEmpty()) {
            throw new AccountException("Email is invalid!");
        } else {
            this.email = email;
        }
    }

    /**
     * Gets address
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address
     *
     * @param address
     * @throws AccountException
     */
    public void setAddress(String address) throws AccountException {
        if (address.isEmpty()) {
            throw new AccountException("Address cannot empty!");
        } else {
            this.address = address;
        }
    }

    /**
     * Gets day of birth
     *
     * @return
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Sets day of birth
     *
     * @param dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * Override toString() method
     *
     * @return
     */
    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address + ", dob=" + dob + '}';
    }

}
