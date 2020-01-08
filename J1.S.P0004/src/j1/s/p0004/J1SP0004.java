/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0004;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tangminhtin
 */
public class J1SP0004 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of array:");
        int length = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Enter search value:");
        int search = scanner.nextInt();
        
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        BinarySearch searcher = new BinarySearch();
        searcher.bubbleSort(array);
        
        System.out.print("Sorted array: ");
        searcher.displayArray(array);
        
        int foundIndex = searcher.binarySearch(array, search, 0, length - 1);
        System.out.println("\nFound " + search + " at index: " + foundIndex);
    }
}
