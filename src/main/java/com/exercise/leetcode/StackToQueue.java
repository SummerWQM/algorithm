package com.exercise.leetcode;

import java.util.Stack;


public class StackToQueue<E> {

    Stack<E> stackIn = new Stack<>();

    Stack<E> stackOut = new Stack<>();

    public void offer(E e) {
        stackIn.push(e);
    }

    public E poll() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        return stackOut.pop();
    }

    public int size() {
        return stackOut.size() + stackIn.size();
    }

    public static void main(String[] args) {
        StackToQueue<Integer> queue = new StackToQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.size());

        System.out.println(queue.poll());

        queue.offer(4);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
