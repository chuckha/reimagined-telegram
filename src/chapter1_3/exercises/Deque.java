package chapter1_3.exercises;

public class Deque<T> {
    private class DoubleNode {
        DoubleNode prev;
        DoubleNode next;
        T item;
    }
    DoubleNode first;
    DoubleNode last;
    int size;

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void pushLeft(T item) {
        if (first == null) {
            first = new DoubleNode();
            first.item = item;
            last = first;
            return;
        }
        DoubleNode oldFirst = first;
        first = new DoubleNode();
        first.item = item;
        oldFirst.prev = first;
        first.next = oldFirst;
    }
    public void pushRight(T item) {
        if (last == null) {
            last = new DoubleNode();
            last.item = item;
            first = last;
            return;
        }
        DoubleNode oldLast = last;
        last = new DoubleNode();
        last.item = item;
        oldLast.next = last;
        last.prev = oldLast;
    }
    public T popLeft() {
        if (first == null) {
            return null;
        }
        DoubleNode oldFirst = first;
        T item = first.item;
        first = first.next;
        oldFirst.next = null;
        if (first == null) {
            return item;
        }
        first.prev = null;
        return item;
    }
    public T popRight() {
        if (last == null) {
            return null;
        }
        DoubleNode oldLast = last;
        T item = last.item;
        last = last.prev;
        oldLast.prev = null;
        if (last == null) {
            return item;
        }
        last.next = null;
        return item;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.pushLeft(3);
        Integer out = deque.popRight();
        assert out == 3;
        deque.pushRight(5);
        out = deque.popLeft();
        assert out == 5;
        deque.pushLeft(3);
        deque.pushRight(4);
        deque.pushLeft(2);
        deque.pushRight(5);
        deque.pushLeft(1);
        out = deque.popLeft();
        assert out == 1;
        System.out.println(deque.popLeft() == 2);
        System.out.println(deque.popLeft() == 3);
    }
}
