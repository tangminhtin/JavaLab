package j1.s.p0006;

import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class Fibonacci {

    public ArrayList fib45(int max, int pre, int next) {
        ArrayList<Integer> fib = new ArrayList<>();
        for (int i = 1; i <= max; ++i) {
            fib.add(pre);
            /* On each iteration, we are assigning second number to the first number
            and assigning the sum of last two numbers to the second number */

            int sum = pre + next;
            pre = next;
            next = sum;
        }
        return fib;
    }
}
