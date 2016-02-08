package chapter1_3;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
    private class Node {
        Node next;
        T item;
    }

    private Node first;

    public void add(T item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<T> {
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
}
