package chapter1_Foundation;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResizingArraryStackTest {
    @Test
    public void test() {

        ResizingArraryStack<String> stack = new ResizingArraryStack<>();
        stack.Push("Hello World 1");
        assertFalse(stack.isEmpty());
        stack.Pop();
        assertTrue(stack.isEmpty());
        stack.Push("Hello World 2");
        stack.Push("Hello World 3");
        stack.Push("Hello World 4");
        stack.Push("Welcome to Algorithm 4th");

        String[] results = new String[4];
        int index = 0;
        for (String str : stack) {
            results[index] = str;
            index++;
        }
        assertArrayEquals(results, new String[]{"Welcome to Algorithm 4th", "Hello World 4", "Hello World 3", "Hello World 2"});
    }
}