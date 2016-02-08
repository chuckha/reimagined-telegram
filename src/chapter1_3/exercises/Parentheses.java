package chapter1_3.exercises;

import chapter1_3.Stack;

import java.util.Scanner;

public class Parentheses {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<Character>();
        Scanner stdin = new Scanner(System.in);
        String item = stdin.nextLine().trim();

        boolean error = false;
        for (int i = 0; i < item.length(); i++) {
            char c = item.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                s.push(c);
            } else if ((c == '}' && s.pop() != '{') || (c == ']' && s.pop() != '[') || (c == ')' && s.pop() != '(')) {
                error = true;
            }
            if (error) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
