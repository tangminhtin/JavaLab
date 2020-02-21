/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

/**
 *
 * @author tangminhtin CE130438 SE1403
 */
public class AccountException extends Exception {

    /**
     * Creates new AccountException
     *
     * @param message
     */
    public AccountException(String message) {
        super(message);
    }

    /**
     * Gets the exception message
     *
     * @return
     */
    @Override
    public String getMessage() {
        return "AccountException: " + super.getMessage();
    }

}
