package SORT;

import static org.junit.Assert.assertTrue;

import org.junit.Test;;

public class sortTest {

    private boolean IsSortCorrect(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1])
                return false;
        }
        return true;
    }

    @Test
    public void Test_Selection() {

        int[] a = sort.SORT(SORT.sort.SELECTION);
        assertTrue(IsSortCorrect(a));
    }

    @Test
    public void Test_Insert() {

        int[] a = sort.SORT(SORT.sort.INSERT);
        assertTrue(IsSortCorrect(a));
    }

    @Test
    public void Test_Shell() {

        int[] a = sort.SORT(SORT.sort.SHELL);
        assertTrue(IsSortCorrect(a));
    }


    @Test
    public void Test_Merge() {

        int[] a = sort.SORT(SORT.sort.MERGE);
        assertTrue(IsSortCorrect(a));
    }

    @Test
    public void Test_Quick() {

        int[] a = sort.SORT(SORT.sort.QUICK);
        assertTrue(IsSortCorrect(a));
    }
    
    @Test
    public void Test_Heap() {

        int[] a = sort.SORT(SORT.sort.HEAP);
        assertTrue(IsSortCorrect(a));
    }

}