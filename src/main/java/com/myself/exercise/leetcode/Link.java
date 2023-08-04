<<<<<<< HEAD:src/main/java/com/myself/exercise/leetcode/Link.java
package com.myself.exercise.leetcode;

class Link {
    public static class Node {
        Node next;
        int val;

        Node(int v) {
            val = v;
        }

    }

    public static Node buildLink(int n) {
        Node hair = new Node(0);
        Node pre = hair;
        int i = 1;
        while (i <= n) {
            Node node = new Node(i++);
            pre.next = node;
            pre = node;
        }
        return hair.next;
    }

    public static String readLink(Node head) {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;
        }

        return sb.toString();
    }

    public static void main(String[] avg) {
        Node head = buildLink(10);
        System.out.println(readLink(head));
        Node newHead = revertMToN(head, 3, 6);
        System.out.println(readLink(newHead));
    }

    public static Node revertMToN(Node head, int m, int n) {

        Node hair = new Node(-1);
        hair.next = head;
        Node pre = hair;
        Node start = pre, end = pre;
        for (int i = 0; i < m; i++) {
            if (start == null) {
                break;
            }
            if (i > 0) {
                pre = pre.next;
            }
            start = start.next;
        }
        for (int i = 0; i < n; i++) {
            if (end == null) {
                break;
            }
            end = end.next;
        }
        if (start == null || end == null) {
            return head;
        }
        pre.next = doRevert(start, end);
        return hair.next;
    }

    public static Node doRevert(Node start, Node end) {
        Node tail = end.next;
        Node pre = end.next;
        Node cur = start;
        while (cur != tail) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}

=======
//    public static class Node {
//        Node next;
//        int val;
//
//        Node(int v) {
//            val = v;
//        }
//    }
//
//    public static Node buildLink(int n) {
//        Node hair = new Node(0);
//        Node pre = hair;
//        int i = 1;
//        while (i <= n) {
//            Node node = new Node(i++);
//            pre.next = node;
//            pre = node;
//        }
//        return hair.next;
//    }
//
//    public static String readLink(Node head) {
//        StringBuilder sb = new StringBuilder();
//        Node cur = head;
//        while (cur != null) {
//            sb.append(cur.val);
//            if (cur.next != null) {
//                sb.append("->");
//            }
//            cur = cur.next;
//        }
//
//        return sb.toString();
//    }
//
//    public static void main(String[] avg) {
//        Node head = buildLink(10);
//        System.out.println(readLink(head));
//        Node newHead = revertMToN(head, 3, 6);
//        System.out.println(readLink(newHead));
//    }
//
//    public static Node revertMToN(Node head, int m, int n) {
//
//        Node hair = new Node(-1);
//        hair.next = head;
//        Node pre = hair;
//        Node start = pre, end = pre;
//        for (int i = 0; i < m; i++) {
//            if (start == null) {
//                break;
//            }
//            if (i > 0) {
//                pre = pre.next;
//            }
//            start = start.next;
//        }
//        for (int i = 0; i < n; i++) {
//            if (end == null) {
//                break;
//            }
//            end = end.next;
//        }
//        if (start == null || end == null) {
//            return head;
//        }
//        pre.next = doRevert(start, end);
//        return hair.next;
//    }
//
//    public static Node doRevert(Node start, Node end) {
//        Node tail = end.next;
//        Node pre = end.next;
//        Node cur = start;
//        while (cur != tail) {
//            Node next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }
//
//
>>>>>>> 288f4f61a2e55209ab7d247794c1bd1101321127:src/main/java/com/exercise/leetcode/Link.java
