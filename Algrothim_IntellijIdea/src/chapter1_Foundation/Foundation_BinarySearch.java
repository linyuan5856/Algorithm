package chapter1_Foundation;

public class Foundation_BinarySearch {

    public static int BinarySearch(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int middle = lo + (hi - lo) / 2;
            if (key > a[middle])
                lo = middle + 1;
            else if (key < a[middle])
                hi = middle - 1;
            else
                return middle;
        }
        return -1;
    }
}
