package j1.s.p0007;

import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class LinearSearch {

    private ArrayList<Integer> arr;

    public LinearSearch(ArrayList arr) {
        this.arr = arr;
    }
    
    public int linearSearch(int value) {
        for (int i=0; i <arr.size(); i++) {
            if (arr.get(i).equals(value)) {
                return i;
            }
        }
        return -1;
    }
}
