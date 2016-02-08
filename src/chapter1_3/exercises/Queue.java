package chapter1_3.exercises;

// queue implemented with a circularly linked list
public class Queue<T> {
    private class Node {
        Node next;
        T item;
    }
    private Node last;

    public boolean isEmpty() {
        return last == null;
    }

    public void enqueue(T item) {
        if (isEmpty()) {
            last = new Node();
            last.item = item;
            last.next = last;
        } else {
            Node node = new Node();
            node.item = item;
            node.next = last.next.next;
            last.next = node;
        }
    }
    public T dequeue() {
        T item = last.next.item;
        last.next = last.next.next;
        return item;
    }

    @Override
    public String toString() {
        Node head = last.next;
        String r = head.item + "";
        Node current = head.next;
        while (current != head) {
            r += current.item + " ";
            current = current.next;
        }
        return r;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(4);
        queue.enqueue(8);
        System.out.println(queue);
    }
}
