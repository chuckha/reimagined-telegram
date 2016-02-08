package chapter1_3.exercises;

import chapter1_3.Stack;

import java.util.Scanner;

public class FixParentheses {
    public static void main(String[] args) {
        Stack<String> characters = new Stack<String>();
        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNext()) {
            String item = stdin.next();
            if (item.equals(")")) {
                String right = characters.pop();
                String operand = characters.pop();
                String left = characters.pop();
                characters.push("( " + left + " " + operand + " " + right + " )");
            } else {
                characters.push(item);
            }
        }
        while (!characters.isEmpty()) {
            System.out.println(characters.pop());
        }
    }
}
