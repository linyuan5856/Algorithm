package chapter3_Find;

public class Find_Binary {

    public static int Find(int[] a, int value) {
        int lo = 0, hi = a.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < value)
                lo = mid + 1;
            else if (a[mid] > value)
                hi = mid - 1;
            else
                return mid;

        }
        return -1;
    }


}
