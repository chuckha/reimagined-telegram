package chapter1_4.exercises;

import chapter1_3.Stack;

public class QueueTwoStacks<T> {

    Stack<T> first;
    Stack<T> second;


    public QueueTwoStacks() {
        first = new Stack<T>();
        second = new Stack<T>();
    }

    public void enqueue(T item) {
        first.push(item);
    }

    public T dequeue() {
        if (second.isEmpty() && first.isEmpty()) {
            return null;
        }
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
        return second.pop();
    }

    public static void main(String[] args) {
        QueueTwoStacks<Integer> queueTwoStacks = new QueueTwoStacks<Integer>();
        queueTwoStacks.enqueue(1);
        queueTwoStacks.enqueue(2);
        queueTwoStacks.enqueue(3);
        queueTwoStacks.enqueue(4);
        assert queueTwoStacks.dequeue() == 1;
        assert queueTwoStacks.dequeue() == 2;
        queueTwoStacks.enqueue(5);
        assert queueTwoStacks.dequeue() == 3;
    }
}
