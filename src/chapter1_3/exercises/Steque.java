package chapter1_3.exercises;

public class Steque<T> {
    private class Node {
        Node next;
        T item;
    }

    Node first;
    Node last;

    private boolean isEmpty() {
        return first == null;
    }
    public void push(T item) {
        if (isEmpty()) {
            first = new Node();
            first.item = item;
            last = first;
            return;
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T tmp = first.item;
        first = first.next;
        return tmp;
    }
    public void enqueue(T item) {
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            first = last;
            return;
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;;
        oldLast.next = last;
    }

    @Override
    public String toString() {
        String r = "";
        Node current = first;
        while (current != null) {
            r += current.item + " ";
            current = current.next;
        }
        return r;
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<Integer>();
        steque.push(1);
        steque.push(2);
        steque.enqueue(3);
        System.out.println(steque);
        steque.pop();
        System.out.println(steque);
    }
}
