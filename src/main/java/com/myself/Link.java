// public static class Node {
//        Node next;
//        int val;
//
//        Node(int k) {
//            val = k;
//        }
//    }
//
//    public static Node buildLink(int n) {
//        int i = 1;
//        Node hair = new Node(i);
//        Node cur = hair;
//        while (i <= n) {
//            cur.next = new Node(i++);
//            cur = cur.next;
//        }
//        return hair.next;
//    }
//
//    public static Node reversal(Node head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        Node newHead = reversal(head.next);
//        head.next.next = head;
//        head.next = null;
//        return newHead;
//    }
//
//    public static Node reversal(Node head, int k) {
//        Node hair = new Node(-1);
//        hair.next = head;
//        Node pre = hair;
//        Node start = head, end = pre;
//        while (start != null) {
//            for (int i = 0; i < k; i++) {
//                if (end.next == null) {
//                    break;
//                }
//                end = end.next;
//            }
//            Node next = end.next;
//            Node[] rev = reversal(start, end);
//            pre.next = rev[0];
//            pre = rev[1];
//            start = next;
//            end = rev[1];
//        }
//
//        return hair.next;
//    }
//
//    public static Node[] reversal(Node start, Node end) {
//        Node tail = end.next;
//        Node cur = start;
//        Node pre = end.next;
//        while (cur != tail) {
//            Node next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return new Node[]{end, start};
//    }
//
//    public static void printLink(Node head) {
//        Node cur = head;
//        StringBuilder sb = new StringBuilder();
//
//        while (cur != null) {
//            sb.append(cur.val);
//            if (cur.next != null) {
//                sb.append("->");
//            }
//            cur = cur.next;
//        }
//        System.out.println(sb.toString());
//    }
//
//    public static void main(String[] args) {
//
//        Node head = buildLink(11);
//
//        printLink(head);
//
//        Node newHead = reversal(head, 2);
//
//        printLink(newHead);
//
//    }
