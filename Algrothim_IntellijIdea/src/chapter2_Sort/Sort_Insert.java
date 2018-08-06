package chapter2_Sort;

public class Sort_Insert extends Sort_Base {

    public static void Sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && Less(a[j], a[j - 1]); j--) {
                Exchange(a, j, j - 1);
            }
        }
    }
}
