package chapter3_Find;

public class AVL_234Tree {

    class DataItem {
        public long data;

        public DataItem(long _data) {
            this.data = _data;
        }
    }

    class Node {
        private static final int ORDER = 4;
        private int itemNums;
        private Node parent;
        private Node childArrary[] = new Node[ORDER];
        private DataItem itemArrary[] = new DataItem[ORDER - 3];


        public void connectChild(int childNum, Node child) {
            childArrary[childNum] = child;
            if (child != null)
                child.parent = this;
        }

        public Node disConnectChild(int childNum) {
            Node temp = childArrary[childNum];
            childArrary[childNum] = null;
            return temp;
        }

        public Node getChild(int childNum) {
            return childArrary[childNum];
        }

        public Node getParent() {
            return parent;
        }

        public boolean isLeaf() {
            return childArrary[0] == null;
        }

        public int getItemNums() {
            return itemNums;
        }

        public DataItem getData(int index) {
            return itemArrary[index];
        }

        public boolean isFull() {
            return itemNums == ORDER - 1;
        }

        public int findItem(long key) {
            for (int i = 0; i < itemArrary.length; i++) {
                if (itemArrary[i] == null)
                    continue;
                if (itemArrary[i].data == key)
                    return i;
            }

            return -1;
        }

        public int insertItem(DataItem newItem) {
            itemNums++;
            long newK = newItem.data;

            for (int i = ORDER - 2; i >= 0; i--) {
                if (itemArrary[i] == null)
                    continue;

                long oldK = itemArrary[i].data;
                if (newK < oldK)
                    itemArrary[i + 1] = itemArrary[i];
                else
                    itemArrary[i + 1] = newItem;
                return i + 1;
            }

            itemArrary[0] = newItem;
            return 0;
        }

        public DataItem removeItem() {
            DataItem temp = itemArrary[itemNums - 1];
            itemArrary[itemNums--] = null;
            return temp;
        }
    }

    private Node root;

    public int find(long key) {
        Node curNode = root;
        int childNumer;
        while (true) {
            childNumer = curNode.findItem(key);
            if (curNode.isLeaf())
                return -1;
            else if (childNumer != -1)
                return childNumer;
            else
                curNode = getNextChild(curNode, key);
        }
    }

    private Node getNextChild(Node node, long value) {
        int j;
        int nums = node.getItemNums();
        for (j = 0; j < nums; j++) {
            if (value < node.getData(j).data)
                return node.getChild(j);
        }
        return node.getChild(j);
    }

    public void Insert(long value) {
        Node curNode = root;
        DataItem tempItem = new DataItem(value);
        while (true) {
            if (curNode.isFull()) {
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, value);
            } else if (curNode.isLeaf()) {
                break;
            } else {
                curNode = getNextChild(curNode, value);
            }
        }
        curNode.insertItem(tempItem);

    }

    public void split(Node node) {
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;
        itemC = node.removeItem();
        itemB = node.removeItem();
        child2 = node.disConnectChild(2);
        child3 = node.disConnectChild(3);
        Node newRight = new Node();
        if (node == root) {//如果当前节点是根节点，执行根分裂
            root = new Node();
            parent = root;
            root.connectChild(0, node);
        } else {
            parent = node.getParent();
        }
        //处理父节点
        itemIndex = parent.insertItem(itemB);
        int n = parent.getItemNums();
        for (int j = n - 1; j > itemIndex; j--) {
            Node temp = parent.disConnectChild(j);
            parent.connectChild(j + 1, temp);
        }
        parent.connectChild(itemIndex + 1, newRight);

        //处理新建的右节点
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);


    }

}
