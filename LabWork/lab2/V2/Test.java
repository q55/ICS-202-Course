package lab2.V2;

public class Test {

    public static void main(String[] args){
        SLL<Integer> myLinkedList = new SLL<>();
        myLinkedList.addToTail(7);
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(50);
        myLinkedList.addToTail(7);
        myLinkedList.addToTail(9);
        System.out.println("Original "+myLinkedList);
        myLinkedList.insertBefore(4,20);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.delete(4));
        System.out.println(myLinkedList);
        myLinkedList.insertAfterSecondOccurrence(30,7);
        System.out.println(myLinkedList);

    }
}
