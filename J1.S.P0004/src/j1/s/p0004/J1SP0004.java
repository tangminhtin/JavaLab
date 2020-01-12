package j1.s.p0004;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tangminhtin
 */
public class J1SP0004 {

    private ArrayList<Integer> arr;

    public J1SP0004() {
        this.arr = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getA() {
        return arr;
    }

    public int getValue(String msg) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (true) {
            try {
                System.out.println(msg);
                n = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("You must enter digit only!");
                scanner.nextLine();
            }
        }
        return n;
    }
    
    public void generateArray(String msg) {
        Random random = new Random();
        int n = getValue(msg);
        
        for (int i = 0; i < n; i++) {
            this.arr.add(random.nextInt(11));
        }
    }

    public void display(String msg) {
        System.out.print(msg);
        System.out.print("[" + arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            System.out.print(", " + arr.get(i));
        }
        System.out.println("]");
    }
    
    public void result(int value, int index) {
        if (index == -1) {
            System.out.println("Value " + value + " doesn't exist in array");
        } else {
            System.out.println("Found " + value + " at index: " + index);
        }
    }

    public static void main(String[] args) {
        J1SP0004 obj = new J1SP0004();

        obj.generateArray("Enter number of array: ");
        int value = obj.getValue("Enter search value: ");
                
        BinarySearch binarySearch = new BinarySearch(obj.getA());
        binarySearch.sorted();
        obj.display("Sorted array: ");
        
        int index = binarySearch.binarySearch(0, obj.arr.size(), value);
        obj.result(value, index);
    }
}
