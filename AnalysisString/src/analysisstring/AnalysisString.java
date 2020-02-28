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
    private String[] stringsToArray;  // Store string after convert to array

    private String allStrings = "";     // Store all string
    private String lowerCases = ""; // Store lower cases
    private String upperCases = ""; // Store upper cases
    private String specialCharacters = "";  // Store specical characters

    private final ArrayList<Integer> allNumbers;    // Store all numbers
    private final ArrayList<Integer> oddNumbers;    // Store odd numbers
    private final ArrayList<Integer> evenNumbers;   // Store even numbers
    private final ArrayList<Integer> squareNumbers; // Store square numbers

    /**
     * Constructor for AnalysisString class
     */
    public AnalysisString() {
        allNumbers = new ArrayList<>(); // Create array allNumbers 
        oddNumbers = new ArrayList<>(); // Create array oddNumbers
        evenNumbers = new ArrayList<>();    // Create array evenNumbers
        squareNumbers = new ArrayList<>(); // Create array squaresNumbers
    }

    /**
     * Check upper, lower, special characters and store its
     */
    private void upperLowerSpecialCharacters() {
        char[] characters = allStrings.toCharArray();   // Convert string to sequences of characters
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
     * Check square numbers, then store it into array list
     */
    private void squareNumbers() {
        for (int num : allNumbers) {
            int x = (int) Math.sqrt(num);   // sqrt of num
            if (Math.pow(x, 2) == num) {    // If num equal to pow of x
                squareNumbers.add(num);     // Add square numbers into array
            }
        }
    }

    /**
     * Check even and odd number, then store it to array list
     */
    private void evenAndOdd() {
        for (int num : allNumbers) {
            if (num % 2 == 0) {     // If num % 2 equal to 0
                evenNumbers.add(num);   // Add num to evenNumbers array
            } else {
                oddNumbers.add(num); // Otherwise add num to oddNumbers array
            }
        }
    }

    /**
     * Analysis string of input with all number, odd, even, square number,
     * string, upper, lower, special characters
     */
    public void analysis() {
        // Split string with pattern. Ex: abc123hefFE*(32  -> ["abc", 123, "hefFE*(", "32"]
        stringsToArray = inputStr.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        for (String str : stringsToArray) {
            if (str.matches("\\d+")) {    // If string is number
                allNumbers.add(Integer.parseInt(str)); // Cast to integer and add it to array allNumbers
            } else {
                allStrings += str; // Store string to allStr
            }
        }
        squareNumbers();    // Check and store square numbers
        evenAndOdd();   // Check and store even and odd numbers
        upperLowerSpecialCharacters();  // Check upper cases, lower cases, special characters
    }

    /**
     * Show result after perform analysis string
     */
    public void showResults() {
        System.out.println("-----Result Analysis------");
        System.out.println("Square Numbers: " + squareNumbers); // Show square numbers
        System.out.println("Odd Numbers: " + oddNumbers);   // Show odd numbers
        System.out.println("Even Numbers: " + evenNumbers); // Show even numbers
        System.out.println("All Numbers: " + allNumbers);       // Show all numbers
        System.out.println("Uppercase Characters: " + upperCases);  // Show upper case characters
        System.out.println("Lowercase Characters: " + lowerCases);  // Show lower case characters
        System.out.println("Special Characters: " + specialCharacters); // Show special characters
        System.out.println("All Characters: " + allStrings);    // Show all characters
    }

    /**
     * Get input string from user and show result after analysis string
     */
    public void inputString() {
        Scanner scanner = new Scanner(System.in);   // Create scanner for input string

        System.out.println("===== Analysis String program ====");
        System.out.print("Input String: ");
        inputStr = scanner.nextLine(); // Get input string
    }

    /**
     * Main program will run here
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnalysisString analysis = new AnalysisString(); // Create new object analysis
        analysis.inputString(); // Input string and analysis string
        analysis.analysis();    // Analysis string
        analysis.showResults();  // Show result after analysis string
    }

}
