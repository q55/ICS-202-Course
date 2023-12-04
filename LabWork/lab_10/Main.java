package lab10;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer> hashTable = new HashTable<>(13); // Initialize the hash table with size 13

        // Insert elements
        insertAndPrint(hashTable, 18);
        insertAndPrint(hashTable, 26);
        // Duplicate insertions for 18 and 26 are not shown in your output, but you can call insertAndPrint again with these values if needed.
        insertAndPrint(hashTable, 35);
        insertAndPrint(hashTable, 9);

        // Print hash table state
        System.out.println("After inserting 18, 26, 35, and 9 the hashtable is: ");
        System.out.println(hashTable);

        // Find elements
        findAndPrint(hashTable, 15);
        findAndPrint(hashTable, 48);

        // Delete element
        deleteAndPrint(hashTable, 35);

        int find9 = hashTable.find(9);
        System.out.println(find9 != -1 ? "9 found at index " + find9 : "9 not found");


        // Insert more keys
        insertAndPrint(hashTable, 64);
        insertAndPrint(hashTable, 47);

        // Print hash table state after more operations
        System.out.println("After deleting 35 and inserting 64 and 47, hash table is: ");
        System.out.println(hashTable);

        // Find a key to check if deletion was successful
        findAndPrint(hashTable, 35);
    }

    private static void insertAndPrint(HashTable<Integer> hashTable, Integer value) {
        if (!hashTable.insert(value)) {
            System.out.println(value + " is duplicate element. Not inserted.");
        }
    }

    private static void findAndPrint(HashTable<Integer> hashTable, Integer value) {
        int index = hashTable.find(value);
        if (index != -1) {
            System.out.println(value + " found at index " + index + ".");
        } else {
            System.out.println(value + " not found.");
        }
    }

    private static void deleteAndPrint(HashTable<Integer> hashTable, Integer value) {
        if (!hashTable.delete(value)) {
            System.out.println(value + " not deleted because it is not in the table.");
        } else {
            System.out.println(value + " successfully deleted.");
        }
    }
}
