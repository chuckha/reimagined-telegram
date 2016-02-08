package chapter1_3;

public class Stack<T> {
    public Stack() {};
    public Stack(Stack<T> stack) {
        Stack<T> tmpStack = new Stack<T>();
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        while (!tmpStack.isEmpty()) {
            T item = tmpStack.pop();
            push(item);
            stack.push(item);
        }
    }
    private class Node {
        T item;
        Node next;
    }

    private Node first;
    private int size;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T pop() {
        T tmp = first.item;
        first = first.next;
        size--;
        return tmp;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public T peek() {
        return first.item;
    }

    @Override
    public String toString() {
        Node current = first;
        String r = "";
        while (current != null) {
            r += current.item + " ";
            current = current.next;
        }
        return r;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("hello");
        s.push("world");
        s.push("how");
        s.push("are");
        s.push("you?");
        Stack<String> copy = new Stack<String>(s);
        System.out.println(s);
        System.out.println(copy);
        s.push("i'm good");
        copy.push("not great");
        System.out.println(s);
        System.out.println(copy);
    }
}