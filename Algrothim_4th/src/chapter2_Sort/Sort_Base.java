package chapter2_Sort;

import java.util.concurrent.CopyOnWriteArrayList;

public class Sort_Base {

    private static Comparable[] a = {"cat", "as", "zk", "ts", "titan", "game", "loveCoding", "gg"};

    public static Comparable[] GetTestArrary() {
        Comparable[] temp = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        return temp;
    }


    protected static boolean Less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void Exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean IsSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (Less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void Show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
