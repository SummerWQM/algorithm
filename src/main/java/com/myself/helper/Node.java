package com.myself.helper;

public class Node {
    public int key, val;
    public Node next, prev;

    public Node(int v) {
        val = v;
    }

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }

    public static Node buildNode(int n) {
        int i = 0;
        Node hair = new Node(-1);
        Node pre = hair;
        while (i < n) {
            Node cur = new Node(i++);
            pre.next = cur;
            pre = cur;
        }
        return hair.next;

    }

    public static String printLink(Node head) {
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append("<~");
            }
            cur = cur.next;
        }
        return sb.toString();
    }

    public static Node reverse(Node head, int k) {

        Node hair = new Node(-1);
        hair.next = head;
        Node pre = hair, start = head, end = hair;

        while (end != null && start != null) {
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (end.next != null) {
                    end = end.next;
                    count++;
                }
            }
            if (count < k) {
                return hair.next;
            }
            pre.next = reverse(start, end);
            pre = start;
            end = pre;
            start = pre.next;
        }

        return hair.next;
    }

    private static Node reverse(Node start, Node end) {
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

    public static Node mergeLink(Node l1, Node l2) {
        Node hair = new Node(-1);
        Node pre = hair;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return hair.next;
    }

    public static Node sortLink(Node head) {
        return doSortLink(head, null);
    }

    public static Node doSortLink(Node head, Node tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        Node slow = head, fast = head;

        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        Node mid = slow;
        Node left = doSortLink(head, mid);
        Node right = doSortLink(mid, tail);

        return mergeLink(left, right);
    }



    public static void main(String[] args) {

        Node l1 = buildNode(2);
        System.out.println(printLink(l1));
    }


}
