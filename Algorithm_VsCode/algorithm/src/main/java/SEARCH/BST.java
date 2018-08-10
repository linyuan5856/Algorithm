package SEARCH;

public class BST<KEY extends Comparable<KEY>, VALUE> {

    private BSTNode root;

    class BSTNode {
        private KEY key;
        private VALUE value;
        private BSTNode left, right;
        private int N;

        public BSTNode(KEY _key, VALUE _value, int _n) {
            key = _key;
            value = _value;
            N = _n;
        }
    }

    public void Put(KEY key, VALUE value) {
        root = put(root, key, value);
    }

    private BSTNode put(BSTNode node, KEY key, VALUE value) {
        if (node == null)
            return new BSTNode(key, value, 1);

        int cmp = key.compareTo(node.key);

        if (cmp > 0)
            node.right = put(node.right, key, value);
        else if (cmp < 0)
            node.left = put(node.left, key, value);
        else
            node.value = value;

        node.N = Size(node.left) + Size(node.right) + 1;
        return node;
    }

    public VALUE Get(KEY key) {
        return get(root, key);
    }

    private VALUE get(BSTNode node, KEY key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp > 0)
            return get(node.right, key);
        else if (cmp < 0)
            return get(node.left, key);
        else
            return node.value;
    }

    public VALUE Min() {
        if (root == null)
            return null;

        return min(root).value;
    }

    private BSTNode min(BSTNode node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    private int Size(BSTNode node) {
        if (node == null)
            return 0;
        return node.N;
    }

    public void DeleteMin() {
        root = deleteMin(root);
    }

    private BSTNode deleteMin(BSTNode node) {
        if (node == null)
            return node;

        if (node.left == null)
            return node.right;
        else if (root.right == null)
            return node.left;

        return deleteMin(node.left);
    }

    public VALUE Select(int index) {
        return select(root, index).value;
    }

    private BSTNode select(BSTNode node, int index) {
        if (node == null)
            return null;

        int t = Size(node);
        if (t > index)
            return select(node.left, index);
        else if (t < index)
            return select(node.right, index - t - 1);
        else
            return node;
    }

    public void Delete(KEY key) {
        root = delete(root, key);
    }

    private BSTNode delete(BSTNode node, KEY key) {
        if (node == null)
            return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return delete(node.left, key);
        else if (cmp > 0)
            return delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            BSTNode temp = node;
            node = min(node.right);
            node.right=deleteMin(temp.right);
            node.left=temp.left;
        }
         node.N=Size(node.left)+Size(node.right)+1;
        return node;
    }

}