package SEARCH;

import static org.junit.Assert.assertEquals;

import org.junit.Test;;

public class BSTTest {

    @Test
    public void Test_BST() {

        BST<String, String> bst = new BST<String, String>();
        bst.Put("a", "我是一");
        bst.Put("b", "我是二");
        bst.Put("c", "我是三");
        bst.Put("d", "我是四");

        String value = bst.Get("c");
        assertEquals(value,"我是三");
        String minValue=bst.Min();
        assertEquals(minValue,"我是四");
        bst.DeleteMin();
        String newMinValue=bst.Min();
        assertEquals(newMinValue,"我是三");

        
    }

}