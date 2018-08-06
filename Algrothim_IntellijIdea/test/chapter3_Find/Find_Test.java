package chapter3_Find;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Find_Test {

    private int[] testArrary = {1, 3, 5, 7, 9, 28, 76, 79, 100};

    @Test
    public void Find_SequnceTest() {

        int res = Find_Sequnce.Find(testArrary, 28);
        Assert.assertEquals(5, res);
        int notFind = Find_Sequnce.Find(testArrary, 108);
        Assert.assertEquals(-1, notFind);
    }


    @Test
    public void Find_BinaryTest() {
        int res = Find_Binary.Find(testArrary, 76);
        Assert.assertEquals(6, res);
        int notFind = Find_Binary.Find(testArrary, 108);
        Assert.assertEquals(-1, notFind);
    }
}