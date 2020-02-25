/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculateamountofspent;

import java.util.Scanner;

/**
 *
 * @author tangminhtin CE130438
 */
public class CalculateAmountOfSpent {

    private int numOfBill = 0;  // Store number of bill
    private int wallet = 0;     // Store wallet
    private final Scanner scanner = new Scanner(System.in); // Create scanner for input

    /**
     * Calculate and return total money of bill
     *
     * @param msg
     * @return
     */
    private int totalBill(String msg) {
        int totalMoney = 0; // Store total of money
        for (int i = 0; i < this.numOfBill; i++) {
            System.out.print(msg + (i + 1) + ": "); // Print out message for input
            totalMoney += checkValidate();  // Check money of bill
        }
        return totalMoney;  // Return total money of bill
    }

    /**
     * Check status of pay, return true if pay, otherwise return false
     *
     * @param totalMoney
     * @return
     */
    private boolean isPay(int totalMoney) {
        if (totalMoney <= this.wallet) { // If total money is less than or equal to wallet
            return true;    // Then return true
        } else {
            return false;   // Otherwise return false
        }
    }

    /**
     * Check validate input of an integer
     *
     * @return
     */
    private int checkValidate() {
        while (true) {
            if (scanner.hasNextInt()) { // scanner has an integer number
                int num = scanner.nextInt();    // Get input from user
                return num; // Return number of input
            } else {    // Print out error if invalid
                System.out.print("ERROR: Your input must be an integer! \nTry again: ");
                scanner.next();
            }
        }
    }

    /**
     * Calculate of bill and show result
     */
    public void calculateBill() {
        System.out.println("================= Shopping program =================");
        System.out.print("Input number of bill: ");
        this.numOfBill = checkValidate();   // Get number of bill from user, and check validate

        // Call method to input value of bill, and calculate total money of bill
        int totalBill = totalBill("Input value of bill ");

        System.out.print("Input value of wallet: ");
        this.wallet = checkValidate(); // Call method to check validate of wallet

        // Print total money of bill
        System.out.println("This total of bill: " + totalBill);

        if (isPay(totalBill)) { // If isPay is true, then print out you can buy it
            System.out.println("You can buy it.");
        } else { // Otherwise you can't buy it
            System.out.println("You can’t buy it.");
        }
    }

    /**
     * First program will run here
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create new object calc
        CalculateAmountOfSpent calc = new CalculateAmountOfSpent();
        calc.calculateBill();   // Call method to calculate bill
    }

    /**
     * Gets number of bill
     *
     * @return
     */
    public int getNumOfBill() {
        return numOfBill;
    }

    /**
     * Sets number of bill
     *
     * @param numOfBill
     */
    public void setNumOfBill(int numOfBill) {
        this.numOfBill = numOfBill;
    }

    /**
     * Gets wallet
     *
     * @return
     */
    public int getWallet() {
        return wallet;
    }

    /**
     * Sets wallet
     *
     * @param wallet
     */
    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

}
