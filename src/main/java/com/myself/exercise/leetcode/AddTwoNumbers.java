package com.myself.exercise.leetcode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/submissions/
 * <p>
 * <p>
 * 两数，链表值相加  考虑仅为  sum /10    sum%10 当前位值。
 */
public class AddTwoNumbers {

    public static class LisNode {
        int val;
        LisNode next;

        LisNode() {
        }

        LisNode(int val) {
            this.val = val;
        }
    }

    public LisNode addTwoNumbers(LisNode l1, LisNode l2) {
        LisNode pre = new LisNode(0);
        LisNode cur = pre;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new LisNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (carry > 0) {
            cur.next = new LisNode(carry);
        }
        return pre.next;
    }

    protected static class Node {
        Node next;
        int val;

        Node(int k) {
            val = k;
        }
    }

    private static Node buildNode(int n) {

        int i = 0;
        Node hair = new Node(-1);
        Node pre = hair;
        while (i < n) {
            Node cur = new Node(++i);
            pre.next = cur;
            pre = cur;
        }
        return hair.next;
    }

    protected static String printLink(Node head) {
        if (head == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Node read = head;
        while (read != null) {
            sb.append(read.val);
            if (read.next != null) {
                sb.append("->");
            }
            read = read.next;
        }
        return sb.toString();

    }

    protected static Node revser(Node head, int k) {

        Node hair = new Node(-1);
        hair.next = head;
        Node pre = hair, start = head, end = pre;

        while (start != null) {
            for (int i = 0; i < k; i++) {
                if (end.next != null) {
                    end = end.next;
                }
            }
            pre.next = revser(start, end);
            pre = start;
            end = pre;
            start = pre.next;
        }

        return hair.next;

    }

    protected static Node revser(Node start, Node end) {
        Node pre = end.next, tail = end.next;
        Node cur = start;
        while (cur != tail) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {

        Node head = buildNode(11);
        String link = printLink(head);
        Node re=  revser(head,2);
        System.out.println(printLink(re));
    }

}

