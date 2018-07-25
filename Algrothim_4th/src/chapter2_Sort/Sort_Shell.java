package chapter2_Sort;

public class Sort_Shell extends Sort_Base {

    public static void Sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && Less(a[j], a[j - h]); j = j - h) {
                    Exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
