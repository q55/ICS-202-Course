package lab6;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        // Inserting nodes into the tree
        tree.insert(8);
        tree.insert(4);
        tree.insert(9);
        tree.insert(2);
        tree.insert(7);

        System.out.println("Number of nodes is " + tree.count());

        System.out.println("'4' is leaf? " + tree.isLeaf(4));
        System.out.println("'7' is leaf? " + tree.isLeaf(7));

        System.out.println("Number of leaves " + tree.countLeaves());

        System.out.println("Height is " + tree.height());

        System.out.println();

        System.out.println("The various traversal are>> ");

        System.out.print("Preorder traversal: ");
        tree.preorder();

        System.out.print("\nInorder traversal: ");
        tree.inorder();

        System.out.print("\nPostorder traversal: ");
        tree.postorder();

        System.out.print("\nBreadth First ");
        tree.breadthFirst();
    }
}
