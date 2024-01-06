package dictionary;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Dictionary {
    private AVLTree<String> avlTree;

    // Constructors
    public Dictionary() {
        avlTree = new AVLTree<>();
    }

    public Dictionary(String s) {
        this();
        try {
            addWord(s);
        } catch (WordAlreadyExistsException e) {
            // This exception should never be thrown in this context
        }    }

    public Dictionary(File f) throws FileNotFoundException {
        this();
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNextLine()) {
            String word = fileScanner.nextLine().trim();
            try {
                addWord(word);
            } catch (WordAlreadyExistsException ignored) {
                // Ignore duplicates when loading from file
            }
        }
        fileScanner.close();
    }


    public void addWord(String s) throws WordAlreadyExistsException {
        if (avlTree.search(s)) {
            throw new WordAlreadyExistsException("Word already exists in the dictionary: " + s);
        }
        avlTree.insertAVL(s);
    }
    public boolean findWord(String s) {
        return avlTree.search(s);
    }

    public void deleteWord(String s) throws WordNotFoundException{
        if (!avlTree.search(s)) {
            throw new WordNotFoundException("Word not found: " + s);
        }
         avlTree.deleteAVL(s);
    }

    public static class WordAlreadyExistsException extends Exception {
        public WordAlreadyExistsException(String message) {
            super(message);
        }
    }

    public static class WordNotFoundException extends Exception {
        public WordNotFoundException(String message){
            super(message);
        }
    }

    // Method to find similar words in the dictionary
    public String[] findSimilar(String s) {
        SLL<String> sslStringList = new SLL<>();
        findSimilarRecursive(avlTree.root, s, sslStringList);

        String[] myList = new String[sslStringList.size()];
        int index = 0;
        while (!sslStringList.isEmpty()) {
            myList[index] = sslStringList.deleteFromHead();
            index++;
        }
        return myList;
    }
    // Recursive helper method to find similar words
    private void findSimilarRecursive(BTNode<String> node, String s, SLL<String> list) {
        if (node != null) {
            if (isSimilar(node.data, s)) {
                list.addToTail(node.data);
            }
            findSimilarRecursive(node.left, s, list);
            findSimilarRecursive(node.right, s, list);
        }
    }
    // Method to check if two words are similar based on the given criteria

    private boolean isSimilar(String word, String target) {
        if (word == null || target == null) return false;
        if (Math.abs(word.length() - target.length()) > 1) return false;

        int diffCount = 0;
        for (int i = 0, j = 0; i < word.length() && j < target.length(); i++, j++) {
            if (word.charAt(i) != target.charAt(j)) {
                diffCount++;
                if (diffCount > 1) return false;

                if (word.length() > target.length()) j--;
                else if (word.length() < target.length()) i--;
            }
        }
        return diffCount == 1 || (diffCount == 0 && word.length() != target.length());
    }


    public void saveToFile(String filename) throws IOException {
        PrintWriter writer = new PrintWriter(filename);
        saveToFileRecursive(avlTree.root, writer);
        writer.close();
    }

    private void saveToFileRecursive(BTNode<String> node, PrintWriter writer) {
        if (node != null) {
            saveToFileRecursive(node.left, writer);
            writer.println(node.data);
            saveToFileRecursive(node.right, writer);
        }
    }


    public static void main(String[] args) throws WordAlreadyExistsException {
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();

        while (true) {
            System.out.print("Enter an operation { load - find - add - remove - similar - save - exit}: ");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "load":
                    System.out.print("Enter filename: ");
                    String filename = scanner.nextLine();
                    try {
                        File file = new File(filename);
                        dictionary = new Dictionary(file);
                        System.out.println("Dictionary loaded successfully.");
                    } catch (Exception e) {
                        System.out.println("Error loading dictionary from file: " + e.getMessage());
                    }
                    break;

                case "find":
                    System.out.print("Enter word to find: ");
                    String wordToFind = scanner.nextLine();
                    if (dictionary.findWord(wordToFind)) {
                        System.out.println("Word found.");
                    } else {
                        System.out.println("Word not found.");
                    }
                    break;

                case "add":
                    System.out.print("Enter new word to add: ");
                    String newWord = scanner.nextLine();
                    try {
                        dictionary.addWord(newWord);
                        System.out.println("Word added successfully.");
                    } catch (WordAlreadyExistsException e) {
                        System.out.println("Exception: Word already exists.");
                    }
                    break;

                case "remove":
                    System.out.print("Enter word to remove: ");
                    String removeWord = scanner.nextLine();
                    try {
                        dictionary.deleteWord(removeWord);
                        System.out.println("Word removed successfully.");
                    } catch (WordNotFoundException e) {
                        System.out.println("Exception: Word not found.");
                    }
                    break;

                case "similar":
                    System.out.print("Enter word to search for similar words: ");
                    String similarWord = scanner.nextLine();
                    String[] similarWords = dictionary.findSimilar(similarWord);
                    if (similarWords.length == 0) {
                        System.out.println("No similar words found.");
                    } else {
                        System.out.println("Similar words: ");
                        for (String simWord : similarWords) {
                            System.out.println(simWord);
                        }
                    }
                    break;
                // Method to save the dictionary to a file
                case "save":
                    System.out.print("Save Updated Dictionary (Y/N): ");
                    String saveChoice = scanner.nextLine();
                    if (saveChoice.equalsIgnoreCase("Y")) {
                        System.out.print("Enter filename: ");
                        String saveFilename = scanner.nextLine();
                        try {
                            dictionary.saveToFile(saveFilename);
                            System.out.println("Dictionary saved successfully.");
                        } catch (IOException e) {
                            System.out.println("Error saving dictionary: " + e.getMessage());
                        }
                    }
                    break;

                case "exit":
                    scanner.close();
                    return; // Exit the program

                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }

    }}
