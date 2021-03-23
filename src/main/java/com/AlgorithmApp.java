
package com;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.ThreadPoolExecutor;

public class AlgorithmApp {


    public static void main(String[] args) {

//        double sum = 13.11;
//        for (int i = 0; i < 5; i++) {
//            sum += sum * 0.1;
//            System.out.println(sum);
//        }


//
//        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
//        for (StackTraceElement stackTraceElement : stackTrace) {
//            System.out.println(stackTraceElement.getMethodName());
//        }

        // SpringApplication.run(AlgorithmApp.class);

        // ThreadPoolExecutor poolExecutor;

    }

    public static void print(Node head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static class Node {
        Node(int val) {
            this.val = val;
        }

        int val;
        Node next;
    }

    public static Node re(Node head) {
        Node pre = null;

        if (head == null) {
            return head;
        }
        Node cur = head;

        while (cur != null) {

            Node next = cur.next;

            cur.next = pre;

            pre = cur;

            cur = next;
        }

        return pre;

    }

    public static Node links(int num) {

        Node dummy = new Node(0);
        Node cur = dummy;

        for (int i = 0; i < num; i++) {
            cur.next = new Node(i);

            cur = cur.next;
        }
        Node p = dummy.next;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

        return dummy.next;
    }


}