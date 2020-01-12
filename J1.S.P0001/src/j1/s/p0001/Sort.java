package j1.s.p0001;

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

    // Buble sort
    public void sorted() {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    swap(j, j + 1);
                }
            }
        }
    }
}
