package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TestAVL {

    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        int[] keys = {8, 14, 12, 18, 23, 20, 15, 13, 7, 16};
        for (int key : keys) {
            avlTree.insertAVL(key);
        }
        System.out.println("AVL Tree in BFS after insertions:");
        printBFS(avlTree);

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter an element to delete:");
            int elementToDelete = scanner.nextInt();
            avlTree.deleteAVL(elementToDelete);
            System.out.println("AVL Tree in BFS after deletion:");
            printBFS(avlTree);
        }

        AVLTree<String> stringTree = new AVLTree<>();
        try (Scanner fileScanner = new Scanner(new File("sampletextfile.txt"))) {
            while (fileScanner.hasNext()) {
                String word = fileScanner.next();
                stringTree.insertAVL(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("AVL Tree of strings in inorder:");
        printInOrder(stringTree);
    }

    public static void printBFS(AVLTree<Integer> tree) {
        if (tree.root == null) return;

        Queue<BSTNode<Integer>> queue = new LinkedList<>();
        queue.add(tree.root);

        while (!queue.isEmpty()) {
            BSTNode<Integer> currentNode = queue.poll();
            System.out.print(currentNode.el + " ");

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
        System.out.println();
    }

    public static void printInOrder(AVLTree<String> tree) {
        printInOrder(tree.root);
        System.out.println();
    }

    private static void printInOrder(BSTNode<String> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.el + " ");
            printInOrder(node.right);
        }
    }
}
