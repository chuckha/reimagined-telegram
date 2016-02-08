package chapter1_3;

import java.util.Scanner;

public class Queue<T> {
    private class Node {
        Node next;
        T item;
    }
    private Node first;
    private Node last;
    private int size;

    public boolean isEmpty() { return first == null; }
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        size--;
        return item;
    }
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }
    public int size() { return size; }

    public static void main(String[] args)
    {  // Create a queue and enqueue/dequeue strings.
        Queue<String> q = new Queue<String>();

        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNext()) {
            String item = stdin.next();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) System.out.print(q.dequeue() + " ");
        }
        System.out.println("(" + q.size() + " left on queue)");
    }
}
