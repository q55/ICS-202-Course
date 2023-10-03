package lab5.Task02;

public class TestQueueAsArray {
    public static void main(String[] args) {
        QueueAsArray<Integer> queue = new QueueAsArray<>(5);
        queue.enqueue(60);
        queue.enqueue(20);
        queue.enqueue(40);
        queue.enqueue(30);
        queue.enqueue(70);

        System.out.println("The queue is: " + queue.toString());
        System.out.println("First dequeued element is: " + queue.dequeue());
        System.out.println("Second dequeued element is: " + queue.dequeue());
        System.out.println("After two node deletion the queue is: " + queue.toString());
        System.out.println("Element at queue front is: " + queue.peek());
    }
}
