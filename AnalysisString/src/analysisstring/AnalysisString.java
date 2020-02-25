/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analysisstring;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tangminhtin CE130438
 */
public class AnalysisString {

    private String inputStr;    // Store input string from user
    private String[] strToArr;  // Store string after convert to array
    private final ArrayList<Integer> allNumbers;    // Store all numbers
    private final ArrayList<Integer> oddNumbers;    // Store odd numbers
    private final ArrayList<Integer> evenNumbers;   // Store even numbers
    private final ArrayList<Integer> squareNumbers; // Store square numbers
    private String lowerCases = ""; // Store lower cases
    private String upperCases = ""; // Store upper cases
    private String specialCharacters = "";  // Store specical characters
    private String allStr = "";     // Store all string

    /**
     * Create constructor for AnalysisString class
     */
    public AnalysisString() {
        allNumbers = new ArrayList<>(); // Create new array allNumbers 
        oddNumbers = new ArrayList<>(); // Create new array oddNumbers
        evenNumbers = new ArrayList<>();    // Create new array evenNumbers
        squareNumbers = new ArrayList<>(); // Create new array squaresNumbers
    }

    /**
     * Check and store square numbers into array list
     */
    private void squareNumbers() {
        for (int num : allNumbers) {
            int x = (int) Math.sqrt(num);   // Store sqrt of num to x
            if (Math.pow(x, 2) == num) {    // If num equal pow of x
                squareNumbers.add(num);     // Store square numbers into array list
            }
        }
    }

    /**
     * Check upper, lower, special characters and store its
     */
    private void upperLowerSpecialCharacters() {
        char[] characters = allStr.toCharArray();   // Convert string to sequences of characters
        for (Character c : characters) {
            if (Character.isUpperCase(c)) { // If character in sequences of characters is upper case
                upperCases += c;        // Then store its to upperCases
            } else if (Character.isLowerCase(c)) {  // If character in sequences of characters is lower case
                lowerCases += c;        // Then store its to lowerCases
            } else {    // Otherwise store its to specialCharacters
                specialCharacters += c;
            }
        }
    }

    /**
     * Check even and odd number, then store it to array list
     */
    private void evenAndOdd() {
        for (int num : allNumbers) {
            if (num % 2 == 0) {     // If num % 2 equal to 0
                evenNumbers.add(num);   // Then store num to evenNumbers array list
            } else {    // Otherwise store num to oddNumbers array list
                oddNumbers.add(num);
            }
        }
    }

    /**
     * Get input string from user and show result after analysis string
     */
    public void inputString() {
        System.out.println("===== Analysis String program ====");
        System.out.print("Input String: ");
        Scanner scanner = new Scanner(System.in);   // Create scanner for input string
        inputStr = scanner.nextLine(); // Get input string from user
        analysis();     // Call method to analysis string
        showResult();   // Call method to show result after analysis string
    }

    /**
     * Show result of analysis string
     */
    public void showResult() {
        System.out.println("-----Result Analysis------");
        System.out.println("Square Numbers: " + squareNumbers); // Print square numbers
        System.out.println("Odd Numbers: " + oddNumbers);   // Print odd numbers
        System.out.println("Even Numbers: " + evenNumbers); // Print even numbers
        System.out.println("All Numbers: " + allNumbers);       // Print all numbers
        System.out.println("Uppercase Characters: " + upperCases);  // Print upper case characters
        System.out.println("Lowercase Characters: " + lowerCases);  // Print lower case characters
        System.out.println("Special Characters: " + specialCharacters); // Print special characters
        System.out.println("All Characters: " + allStr);    // Print all characters
    }

    /**
     * Method will be analysis string of input
     */
    public void analysis() {
        // Pattern for split string to number and string
        strToArr = inputStr.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        for (String s : strToArr) {
            if (s.matches("\\d+")) {    // If string is number
                allNumbers.add(Integer.parseInt(s)); // Then add it to array allNumbers
            } else {    // Otherwise add it to allStr
                allStr += s;
            }
        }
        squareNumbers();    // Call method to check and store square numbers
        evenAndOdd();   // Call method to check and store even and odd numbers
        upperLowerSpecialCharacters();  // Call method to check upper, lower, special characters
    }

    /**
     * First program will run here
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnalysisString analysis = new AnalysisString(); // Create new object analysis
        analysis.inputString(); // Call method to input string and analysis string
    }

}
