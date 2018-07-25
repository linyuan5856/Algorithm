package chapter2_Sort;

public class Sort_Selection extends Sort_Base {

    public static void Sort(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (Less(a[j], a[min])) {
                    min = j;
                }
                Exchange(a, i, min);
            }
        }

    }
}
