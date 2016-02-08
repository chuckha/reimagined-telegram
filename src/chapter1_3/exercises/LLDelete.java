package chapter1_3.exercises;

import java.util.Iterator;

public class LLDelete<T> implements Iterable<T> {
    private class Node {
        Node next;
        T item;
    }

    private Node first;
    private Node last;

    public boolean isEmpty() {
        return first == null;
    }

    public boolean find(T key) {
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return true;
            }
        }
        return false;
    }
    
    public void append(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public void removeAfter(Node node) {
        Node current = first;
        while (current != node) {
            if (current == null) {
                return;
            }
            current = current.next;
        }
        current.next = current.next.next;
    }

    public void insertAfter(Node node, Node toInsert) {
        Node current = first;
        while (current != node) {
            if (current == null) {
                return;
            }
            current = current.next;
        }
        toInsert.next = current.next;
        current.next = toInsert;
    }

    public void delete(int k) {
        Node current = first;
        int count = 1;
        while (count < k) {
            if (first == null) {
                return; // just don't do anything
            }
            current = current.next;
            count++;
        }
        current.next = current.next.next;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {}
    }

    public static void main(String[] args) {
        LLDelete<String> list = new LLDelete<String>();
        list.append("hello");
        list.append("world");
        list.append("1234");
        list.append("!");
        list.removeAfter(list.first.next);
        Iterator i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
