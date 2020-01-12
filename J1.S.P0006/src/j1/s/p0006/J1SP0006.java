package j1.s.p0006;

import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class J1SP0006 {
    
    private void display(String msg) {
        System.out.println(msg);
    }
    
    private void result(ArrayList f) {
        System.out.print(f.get(0));
        for (int i=1; i<f.size(); i++) {
            System.out.print(", " + f.get(i));
        }
    }
    
    public static void main(String[] args) {
        J1SP0006 obj = new  J1SP0006();
        obj.display("The 45 sequence fibonacci: ");
        
        Fibonacci f = new Fibonacci();
        obj.result(f.fib45(45, 0, 1));
    }
}
