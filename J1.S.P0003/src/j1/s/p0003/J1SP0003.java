package j1.s.p0003;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tangminhtin
 */
public class J1SP0003 {

    private ArrayList<Integer> arr;

    public J1SP0003() {
        this.arr = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getA() {
        return arr;
    }

    public void generateArray() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (true) {
            try {
                System.out.println("Enter number of array: ");
                n = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("You must enter digit only!");
                scanner.nextLine();
            }
        }

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            this.arr.add(random.nextInt() % 100);
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

    public static void main(String[] args) {
        J1SP0003 obj = new J1SP0003();

        obj.generateArray();
        obj.display("Array before sorted: ");

        Sort sort = new Sort(obj.getA());
        sort.sorted();

        obj.display("Array after sorted: ");
    }
}
