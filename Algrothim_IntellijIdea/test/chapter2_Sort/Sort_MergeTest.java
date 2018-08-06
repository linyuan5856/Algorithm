package chapter2_Sort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sort_MergeTest {

    @Test
    public void sort() {
        Comparable[] a = Sort_Base.GetTestArrary();
        Sort_Merge.Sort(a);
        Assert.assertTrue(Sort_Base.IsSorted(a));
        Sort_Base.Show(a);
    }
}