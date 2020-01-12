package j1.s.p0004;

import java.util.ArrayList;

/**
 *
 * @author tangminhtin
 */
public class BinarySearch {

    private ArrayList<Integer> arr;

    public BinarySearch(ArrayList arr) {
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

    // Returns index of x if it is present in arr[low..r], else return -1 
    int binarySearch(int low, int high, int value) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If the element is present at the middle itself 
            if (arr.get(mid) == value) {
                return mid;
            }

            // If element is smaller than mid, then it can only be present in left subarray 
            if (arr.get(mid) > value) {
                return binarySearch(low, mid - 1, value);
            }

            // Else the element can only be present in right subarray 
            return binarySearch(mid + 1, high, value);
        }

        // We reach here when element is not present in array 
        return -1;
    }
}
