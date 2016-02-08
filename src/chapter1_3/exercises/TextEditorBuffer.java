package chapter1_3.exercises;

import chapter1_3.Stack;

public class TextEditorBuffer {

    private Stack<Character> leftOfCursor;
    private Stack<Character> rightOfCursor;

    public TextEditorBuffer() {
        leftOfCursor = new Stack<Character>();
        rightOfCursor = new Stack<Character>();
    }

    public void insert(char c) {
        leftOfCursor.push(c);
    }
    public char delete() {
        return leftOfCursor.pop();
    }
    public void left(int k) {
        if (k > leftOfCursor.size()) {
            k = leftOfCursor.size();
        }
        for (int i = 0; i < k; i++) {
            rightOfCursor.push(leftOfCursor.pop());
        }
    }
    public void right(int k) {
        if (k > rightOfCursor.size()) {
            k = rightOfCursor.size();
        }
        for (int i = 0; i < k; i++) {
            leftOfCursor.push(rightOfCursor.pop());
        }
    }
    public int size() {
        return leftOfCursor.size() + rightOfCursor.size();
    }

    @Override
    public String toString() {
        return leftOfCursor.toString() + "|" + rightOfCursor.toString();
    }

    public static void main(String[] args) {
        TextEditorBuffer textEditorBuffer = new TextEditorBuffer();
        textEditorBuffer.insert('a');
        textEditorBuffer.insert('b');
        textEditorBuffer.insert('c');
        System.out.println(textEditorBuffer);
        textEditorBuffer.left(2);
        textEditorBuffer.insert('z');
        textEditorBuffer.delete();
        textEditorBuffer.insert('q');
        System.out.println(textEditorBuffer);
    }
}
