package j1.s.p0003;

import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class Sort {

    private ArrayList<Integer> arr;

    public Sort(ArrayList arr) {
        this.arr = arr;
    }

    private void swap(int i, int j) {
        Integer tmp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, tmp);
    }

    // Insertion sort
    public void sorted() {
        for (int i = 1; i < arr.size(); i++) {
            int current = arr.get(i);
            int j = i;
            while (j>0 && arr.get(j-1)>current) {                
                swap(j-1, j);
                j = j-1;
            }
        }
    }
}
