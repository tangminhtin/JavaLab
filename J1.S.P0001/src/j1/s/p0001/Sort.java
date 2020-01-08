/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0001;


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
    
    // Buble sort
    public int[] sorted(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
