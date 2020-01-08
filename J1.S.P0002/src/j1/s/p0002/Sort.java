/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0002;

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
    
    // Selection sort
    public int[] sorted(int[] arr){
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < arr.length-1; i++) { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < arr.length; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
        return arr;
    }
}

