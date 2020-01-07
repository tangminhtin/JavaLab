/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0005;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author tangminhtin
 */
public class J1SP0005 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Enter your content: ");
        String words = scanner.nextLine();
        
        Counter counter = new Counter(words);
        
        HashMap<String, Integer> wordCount = counter.wordCount(words);
        System.out.println(wordCount);

//        words.split(" ");


        HashMap<Character, Integer> characterCount = counter.characterCount(words);
        System.out.println(characterCount);
        
     
    }
    
}
