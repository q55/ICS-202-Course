package lab4;

import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {
        LabStack<String> s = new LabStack<String>();
        String myOpeningParentheses = "([{";
        String myClosingParentheses = ")]}";
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your expression:  ");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if(myOpeningParentheses.contains(Character.toString(currentChar))) {
                s.push(Character.toString(currentChar));
            } else if (myClosingParentheses.contains(Character.toString(currentChar))) {
                if (s.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    String lastOpeningParenthesis = s.pop();
                    int index = myOpeningParentheses.indexOf(lastOpeningParenthesis);
                    if (currentChar != myClosingParentheses.charAt(index)) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        if (flag && s.isEmpty()) {
            System.out.print("balanced");
        } else {
            System.out.print("Not balanced");
        }
        scanner.close();
    }
}
