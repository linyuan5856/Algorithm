package chapter2_Sort;

public class Sort_Merge extends Sort_Base {

    private static Comparable[] aux;

    public static void Sort(Comparable[] a) {

        aux = new Comparable[a.length];
        Sort(a, 0, a.length - 1);
    }


    private static void Sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        Sort(a, lo, mid);
        Sort(a, mid + 1, hi);
        Merge(a, lo, mid, hi);
    }

    private static void Merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (Less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
