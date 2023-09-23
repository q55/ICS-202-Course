package lab2;

public class testClass {
    public static void main(String[] args) {
        SLL<Integer> myList = new SLL<>();

        myList.addToTail(7);
        myList.addToTail(5);
        myList.addToTail(3);
        myList.addToTail(50);
        myList.addToTail(7);
        myList.addToTail(9);


        System.out.println("Original Integer array: " + myList);

        myList.insertBefore(4, 20);
        System.out.println("After inserting 20 before index 4: " + myList);

        Integer deletedElement = myList.delete(4);
        System.out.println("Element deleted from index 4: " + deletedElement);
        System.out.println("After deleting element from index 4: " + myList);

        myList.insertAfterSecondOccurrence(30, 7);
        System.out.println("After inserting 30 after the second occurrence of 7: " + myList);

    }
}