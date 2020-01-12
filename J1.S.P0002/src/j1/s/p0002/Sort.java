package j1.s.p0002;

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

    // Selection sort
    public void sorted() {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    swap(i, j);
                }
            }
        }
    }
}
