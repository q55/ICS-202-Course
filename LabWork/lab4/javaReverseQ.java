package lab4;

import java.util.Scanner;

public class javaReverseQ {
    public static void main(String[] args) {
        LabStack<String> stack = new LabStack<>();
        LabQueue<String> queue = new LabQueue<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your expression:  ");
        String input = scanner.nextLine();

        // Push each character or word of input to the stack
        for (String word : input.split(" ")) {
            stack.push(word);
        }
        System.out.println("Now the stack is >>  "+stack);


        // Transfer all elements from stack to queue
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        // Transfer all elements back from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }

        // Print reversed stack
        System.out.println("After Reverse the stack is>> " + stack.toString());
    }
}
