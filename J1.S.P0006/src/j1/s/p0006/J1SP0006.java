/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0006;



/**
 *
 * @author tangminhtin
 */
public class J1SP0006 {
     public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci");
        fibonnaciHelper(45, 1, 0);
    }

    public static int fibonnaciHelper(int term, int lower, int higher) {
        if (term < 2) {
            return higher;
        }
        System.out.print(higher + " ");
        return fibonnaciHelper(term - 1, higher, higher + lower);
    }
    
    public void TinIaRaCay() {
        System.out.println("Ia gi ma nhieu vay cha!!!");
        
        System.out.println("Vo code chi ae coi");
        
        System.out.println("Con muon gi them thi keu Hao qua bus cu!!!");
    }
}
