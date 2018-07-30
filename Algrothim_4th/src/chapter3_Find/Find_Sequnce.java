package chapter3_Find;

public class Find_Sequnce {

    public static int Find(int[] a, int value) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value)
                return i;
        }
        return -1;
    }
}
