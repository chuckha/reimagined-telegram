package chapter1_3.exercises;

import java.util.Scanner;

public class MoveToFront<T> {

    private class Node {
        Node next;
        T item;
    }

    private Node first;

    private boolean isEmpty() { return this.first == null; }

    // insert
    public void insert(T item) {
        // If it's an empty list, make it not empty
        if (isEmpty()) {
            first = new Node();
            first.item = item;
            return;
        }

        // if it's the first item return
        if (first.item.equals(item)) {
            return;
        }

        // if there is only one node and it's not the first, make another
        if (first.next == null) {
            first.next = new Node();
            first.next.item = item;
            return;
        }

        // if it's not the first item, look for it
        Node current = first.next;
        Node follow = first;
        while (current != null) {
            if (current.item.equals(item)) {
                follow.next = current.next.next;
                current.next = first;
                return;
            }
            current = current.next;
            follow = follow.next;
        }

        // we found the end so it's not in the list so add it
        follow.next = new Node();
        follow.next.item = item;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        String r = "";
        Node current = this.first;
        while (current != null) {
            r += current.item + " ";
            current = current.next;
        }
        return r;
    }

    public static void main(String[] args) {
        MoveToFront<String> moveToFront = new MoveToFront<String>();
        Scanner stdin = new Scanner(System.in);
        while (stdin.hasNext()) {
            String item = stdin.next();
            moveToFront.insert(item);
        }
        System.out.println(moveToFront.toString());
    }
}
