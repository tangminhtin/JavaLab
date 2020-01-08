/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0003;

import java.util.Scanner;

/**
 *
 * @author tangminhtin
 */
public class J1SP0003 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i, j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array:");
        int number = sc.nextInt();
        Sort sort = new Sort(number);
        
        int[] unsort = sort.unSort();
        System.out.print("Unsort array: [");
        for(i=0;i<unsort.length-1;i++){
            System.out.print(unsort[i]+", ");
        }
        System.out.print(unsort[i]+"]");
        
        int[] sorted = sort.sorted(unsort);
        System.out.print("\nSorted array: [");
        for(j=0;j<unsort.length-1;j++){
            System.out.print(sorted[j]+", ");
        }
        System.out.print(sorted[j]+"]");
    }
    
}
