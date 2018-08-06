package chapter1_Foundation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Foundation_BinarySearchTest {

    @Test
    public void binarySearch() {

        int[] arrary = {1, 3, 5, 7, 20, 89, 109};
        int result = Foundation_BinarySearch.BinarySearch(20, arrary);
        assertEquals(4, result);
        int result2 = Foundation_BinarySearch.BinarySearch(200, arrary);
        assertEquals(-1, result2);

    }
}