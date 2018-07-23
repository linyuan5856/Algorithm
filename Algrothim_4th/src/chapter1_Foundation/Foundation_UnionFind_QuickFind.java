package chapter1_Foundation;

public class Foundation_UnionFind_QuickFind {

    private int[] id;
    private int count;

    public Foundation_UnionFind_QuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    int count() {
        return count;
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void Union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }
}
