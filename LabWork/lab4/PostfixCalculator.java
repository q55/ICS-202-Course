package lab4;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class PostfixCalculator {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your expression:  ");
        String input = scanner.nextLine();

        LabStack<String> stack1 = new LabStack<String>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' '){
                stack1.push(String.valueOf(c));
            }
        }
        System.out.println(stack1);

        ArrayList<String> expression = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else if (c == ' ' && number.length() > 0) {
                expression.add(number.toString());
                number = new StringBuilder();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (number.length() > 0) {
                    expression.add(number.toString());
                    number = new StringBuilder();
                }
                expression.add(String.valueOf(c));
            }
        }
        if (number.length() > 0) {
            expression.add(number.toString());
        }

        for (String token : expression) {
            if (token.matches("\\d+")) { // If token is a number
                stack.push(Integer.parseInt(token));
            } else {
                if (stack.size() < 2) {
                    System.out.println("Invalid expression");
                    return;
                }
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = 0;
                switch (token) {
                    case "+": result = num2 + num1; break;
                    case "-": result = num2 - num1; break;
                    case "*": result = num2 * num1; break;
                    case "/":
                        if (num1 == 0) {
                            System.out.println("Cannot divide by zero");
                            return;
                        }
                        result = num2 / num1;
                        break;
                }
                stack.push(result);
                System.out.println("Currently, the stack is>> " + stack);
            }
        }
        if (stack.size() != 1) {
            System.out.println("Invalid expression");
            return;
        }
        System.out.println(input +" = " + stack.pop());
    }
}
