package chapter1_Foundation;

import org.junit.Test;

import static org.junit.Assert.*;

public class Foundation_UnionFindQuickFindTest {

    @Test
    public void Test() {
        Foundation_UnionFind_QuickFind uf = new Foundation_UnionFind_QuickFind(10);
        this.Add(uf, 4, 3);
        this.Add(uf, 3, 8);
        this.Add(uf, 6, 5);
        this.Add(uf, 9, 4);
        this.Add(uf, 2, 1);
        this.Add(uf, 8, 9);
        this.Add(uf, 5, 0);
        this.Add(uf, 7, 2);
        this.Add(uf, 6, 1);
        this.Add(uf, 1, 0);
        this.Add(uf, 6, 7);

        boolean result = uf.connected(3, 8);
        assertTrue(result);
        boolean result2 = uf.connected(3, 6);
        assertFalse(result2);
    }


    private void Add(Foundation_UnionFind_QuickFind uf, int p, int q) {
        if (!uf.connected(p, q))
            uf.Union(p, q);
    }
}