package com.myself.exercise.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 */
public class QueueToStack<E> {

    Queue<E> queue1 = new LinkedList<>();

    Queue<E> queue2 = new LinkedList<>();

    public void push(E e) {

        queue2.offer(e);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 交换，保证后进来的 放在心的对列之前。
        Queue<E> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public E pop() {

        return queue1.poll();
    }

    public E peek() {
        return queue1.peek();
    }

    public int size() {
        return queue1.size();
    }


    public static void main(String[] args) {
        QueueToStack<Integer> stack = new QueueToStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.size());
        System.out.println(stack.pop());

        System.out.println(stack.peek());

        System.out.println(stack.pop());


        System.out.println(stack.size());
    }

}
