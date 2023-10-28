package lab7;

public class AVLTree<T extends Comparable<? super T>> extends BST<T> {

    protected int height;

    public AVLTree() {
        super();
        height = -1;
    }

    public AVLTree(BSTNode<T> root) {
        super(root);
        height = -1;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BSTNode<T> node) {
        if (node == null)
            return -1;
        else
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private AVLTree<T> getLeftAVL() {
        return new AVLTree<>(root.left);
    }

    private AVLTree<T> getRightAVL() {
        return new AVLTree<>(root.right);
    }

    protected int getBalanceFactor() {
        return getRightAVL().getHeight() - getLeftAVL().getHeight();
    }

    public void insertAVL(T el) {
        insert(el);
        balance();
    }

    public void deleteAVL(T el) {
        root = deleteRecursively(root, el);
    }

    private BSTNode<T> deleteRecursively(BSTNode<T> node, T el) {
        if (node == null) {
            return null;
        }
        int cmp = el.compareTo(node.el);
        if (cmp < 0) {
            node.left = deleteRecursively(node.left, el);
        } else if (cmp > 0) {
            node.right = deleteRecursively(node.right, el);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.el = minValue(node.right);
            node.right = deleteRecursively(node.right, node.el);
        }
        adjustHeight();
        balance();
        return node;
    }

    private T minValue(BSTNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.el;
    }

    protected void balance() {
        if (!isEmpty()) {
            getLeftAVL().balance();
            getRightAVL().balance();
            adjustHeight();
            int balanceFactor = getBalanceFactor();
            if (balanceFactor == -2) {
                if (getLeftAVL().getBalanceFactor() < 0)
                    rotateRight();
                else
                    rotateLeftRight();
            } else if (balanceFactor == 2) {
                if (getRightAVL().getBalanceFactor() > 0)
                    rotateLeft();
                else
                    rotateRightLeft();
            }
        }
    }

    protected void adjustHeight() {
        if (isEmpty())
            height = -1;
        else
            height = 1 + Math.max(getLeftAVL().getHeight(), getRightAVL().getHeight());
    }

    protected void rotateRight() {
        BSTNode<T> tempNode = root.right;
        root.right = root.left;
        root.left = root.right.left;
        root.right.left = root.right.right;
        root.right.right = tempNode;
        T val = root.el;
        root.el = root.right.el;
        root.right.el = val;
        getRightAVL().adjustHeight();
        adjustHeight();
    }

    protected void rotateLeft() {
        BSTNode<T> tempNode = root.left;
        root.left = root.right;
        root.right = root.left.right;
        root.left.right = root.left.left;
        root.left.left = tempNode;
        T val = root.el;
        root.el = root.left.el;
        root.left.el = val;
        getLeftAVL().adjustHeight();
        adjustHeight();
    }

    protected void rotateLeftRight() {
        getLeftAVL().rotateLeft();
        getLeftAVL().adjustHeight();
        rotateRight();
        adjustHeight();
    }

    protected void rotateRightLeft() {
        getRightAVL().rotateRight();
        getRightAVL().adjustHeight();
        rotateLeft();
        adjustHeight();
    }
}
