package SORT;

import java.util.Random;

public class sort {

    public final static int SELECTION = 0;
    public final static int INSERT = 1;
    public final static int SHELL = 2;
    public final static int MERGE = 3;
    public final static int QUICK = 4;
    public final static int HEAP = 5;

    static int[] a = { 3, 90, 876, 168, 67, 288, 1314, 0, 999, -5, 36, -300 };

    private static int[] GetTestArrary() {
        int[] testArrary = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            testArrary[i] = a[i];
        }

        testArrary=new int[10000];
        Random rd = new Random();
        for (int i = 0; i < 10000; i++) {
            testArrary[i]=rd.nextInt();
        }
        return testArrary;
    }

    private static void ShowArrary(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static boolean Less(int[] a, int i, int j) {
        return a[i] < a[j];
    }

    private static void Exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void Sort_Selection(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (Less(a, j, min)) {
                    min = j;
                }
            }
            Exchange(a, i, min);
        }
    }

    private static void Sort_Insert(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && Less(a, j, j - 1); j--) {
                Exchange(a, j - 1, j);
            }
        }
    }

    private static void Sort_Shell(int[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && Less(a, j, j - h); j = j - h) {
                    Exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static int[] aux;

    private static void Sort_Merge(int[] a) {
        aux = new int[a.length];
        merge_divide(a, 0, a.length - 1);
    }

    private static void merge_divide(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        merge_divide(a, lo, mid);
        merge_divide(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (Less(aux, i, j))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    private static void Sort_Quick(int[] a) {
        quick_divide(a, 0, a.length - 1);
    }

    private static void quick_divide(int[] a, int lo, int hi) {
        if (lo >= hi)
            return;

        int pivot = partition(a, lo, hi);

        quick_divide(a, lo, pivot - 1);
        quick_divide(a, pivot + 1, hi);

    }

    private static int partition(int[] a, int lo, int hi) {
        int pivot = lo;
        int i = lo, j = hi + 1;

        while (true) {
            while (Less(a, ++i, pivot))
                if (i >= hi)
                    break;
            while (Less(a, pivot, --j))
                if (j <= lo)
                    break;

            if (i >= j)
                break;

            Exchange(a, i, j);
        }

        Exchange(a, pivot, j);

        return j;
    }

    private static void Sort_Heap(int[] a) {
        int n = a.length;
        for (int k = n / 2; k >= 1; k--) {
            heap_sink(a, k, n);
        }

        while (n > 1) {
            heap_exch(a, 1, n--);
            heap_sink(a, 1, n);
        }
    }

    private static void heap_sink(int[] a, int k, int n) {
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

    private static boolean heap_less(int[] a, int i, int j) {
        return a[i - 1] < a[j - 1];
    }

    private static void heap_exch(int[] a, int i, int j) {
        int temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }

    public static int[] SORT(int type) {
        String str = "";
        int[] tmp = GetTestArrary();
        switch (type) {
        case SELECTION:
            str = "selection sort  ";
            Sort_Selection(tmp);
            break;
        case INSERT:
            str = "insert sort  ";
            Sort_Insert(tmp);
            break;
        case SHELL:
            str = "shell sort  ";
            Sort_Shell(tmp);
            break;
        case MERGE:
            str = "merge sort  ";
            Sort_Merge(tmp);
            break;
        case QUICK:
            str = "quick sort  ";
            Sort_Quick(tmp);
            break;
        case HEAP:
            str = "heap sort";
            Sort_Heap(tmp);
        }
        System.out.println(str + " -> [BEGIN]");
        ShowArrary(tmp);
        return tmp;
    }

    public static void main(String[] args) {
       
    }
}