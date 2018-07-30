package chapter3_Find;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Find_Test {

    private int[] testArrary = {1, 3, 5, 7, 9, 28, 79, 100, 76};

    @Test
    public void Find_SequnceTest() {

        int res = Find_Sequnce.Find(testArrary, 28);
        Assert.assertTrue(res == 5);
        int notFind = Find_Sequnce.Find(testArrary, 108);
        Assert.assertTrue(notFind == -1);
    }

}