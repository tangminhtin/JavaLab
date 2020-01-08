/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0003;

import java.util.Random;

/**
 *
 * @author tangminhtin
 */
public class Sort {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Sort(int num) {
        this.num = num;
    }
    public int[] unSort(){
        int[] list = new int[this.num];
        Random rd = new Random();
        for(int i=0;i<this.num;i++){
            int min=1;
            int max=this.num;
            int value=rd.nextInt(max+1-min)+min;
            list[i] = value;
        }
        return list;
    }
    
    // InSection sort
    public int[] sorted(int[] arr){
        for (int i = 1; i < arr.length; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are greater than key, 
            to one position ahead of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
        return arr;
    }
}

