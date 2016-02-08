package chapter1_3.exercises;

// A queue with a constructor that takes a queue
public class CopyableQueue<T> {

    public CopyableQueue() {}
    public CopyableQueue(CopyableQueue<T> queue) {
        while (!queue.isEmpty()) {
            enqueue(queue.dequeue());
        }
        Node current = first;
        while (current != null) {
            queue.enqueue(current.item);
            current = current.next;
        }
    }
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

    public static void main(String[] args) {  // Create a queue and enqueue/dequeue strings.
        CopyableQueue<String> q = new CopyableQueue<String>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");
        CopyableQueue<String> newQueue = new CopyableQueue<String>(q);
        System.out.println(q);
        System.out.println(newQueue);
        q.enqueue("e");
        newQueue.enqueue("f");
        System.out.println(q);
        System.out.println(newQueue);
    }

}
