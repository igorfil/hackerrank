package Misc;

// https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueOfTwoStacks {
    @Test
    void test() {
        MyQueue<Integer> q = new MyQueue<>();

        q.enqueue(1);

        assertEquals(1, (int) q.dequeue());

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        assertEquals(1, (int) q.dequeue());
        assertEquals(2, (int) q.dequeue());
        assertEquals(3, (int) q.dequeue());

        q.enqueue(1);
        assertEquals(1, (int) q.peek());
    }

    class MyQueue<T> {
        Stack<T> pushStack = new Stack<>();
        Stack<T> popStack = new Stack<>();

        public void enqueue(final T item) {
            pushStack.push(item);
        }

        public T dequeue() {
            if (popStack.empty()) {
                flip(pushStack, popStack);
            }

            return popStack.pop();
        }

        public T peek() {
            if (popStack.empty()) {
                flip(pushStack, popStack);
            }

            return popStack.peek();
        }

        private void flip(final Stack<T> from, final Stack<T> to) {
            while (!from.empty()) {
                to.push(from.pop());
            }
        }
    }
}
