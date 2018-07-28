package chapter2_Sort;

public class Sort_Heap {


    public static void Sort(Comparable[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            heap_sink(a, k, n);
        }

        while (n > 1) {
            heap_exch(a, 1, n--);
            heap_sink(a, 1, n);
        }
    }

    private static void heap_sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && heap_less(a, j, j + 1))
                j++;

            if (!heap_less(a, k, j))
                break;

            heap_exch(a, k, j);
            k = j;
        }
    }

    private static boolean heap_less(Comparable[] a, int i, int j) {
        return a[i - 1] .compareTo(a[j - 1])<0 ;
    }

    private static void heap_exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }

}
