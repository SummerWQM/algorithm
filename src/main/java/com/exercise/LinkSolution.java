package com.exercise;

import java.util.Arrays;
import java.util.List;

class LinkSolution {

    public Node hasCycle(Node head) {
        Node fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    public Node getIntersectionNode(Node headA, Node headB) {
        Node A = headA, B = headB;

        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }


    public static Node reversK(Node head, int k) {
        Node hair = new Node(0);
        hair.next = head;
        Node pre = hair;
        while (head != null) {
            Node tail = pre;
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            Node next = tail.next;
            Node[] rev = doRevers(head, tail);
            pre.next = rev[0];
            pre = rev[1];


            head = next;
        }
        return hair.next;
    }


    public static Node reversK(Node head, int m, int n) {
        Node hair = new Node(0);
        hair.next = head;
        Node start = hair, end = hair, pre = hair;

        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        System.out.println(end.val);
        for (int i = 0; i < m; i++) {
            if(i>0) {
                pre = pre.next;
            }
            start = start.next;
        }
        System.out.println(start.val);
        System.out.println(pre.val);
        Node[] rev = doRevers(start, end);

        pre.next = rev[0];

        return hair.next;
    }


    public static Node reverseD(Node head) {
        if (head.next == null) return head;
        Node result = reverseD(head.next);
        head.next.next = head;
        head.next = null;
        return result;

    }

    public static Node[] doRevers(Node head, Node tail) {
        Node pre = tail.next;
        Node cur = head;
        while (pre != tail) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return new Node[]{tail, head};
    }

    public static Node merge(Node l1, Node l2) {
        Node dumy = new Node(-1);
        Node pre = dumy;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pre.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                pre.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        return dumy.next;
    }

    public static Node add(Node l1, Node l2) {
        int carry = 0, sum = 0;
        Node hair = new Node(-1);
        Node pre = hair;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            sum = x + y + carry;
            Node node = new Node(sum % 10);
            carry = sum / 10;
            pre.next = node;
            pre = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            pre.next = new Node(carry);
        }

        return hair.next;
    }

    static class Node {
        Node next;
        int val;

        public Node(int value) {
            val = value;
        }

    }

    public static String printLink(Node h) {
        StringBuilder sb = new StringBuilder();
        Node cur = h;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) {
                sb.append("->");
            }
            cur = cur.next;
        }
        return sb.toString();
    }

    public static Node buildLink(int k) {
        Node head = new Node(0);
        Node pre = head;
        int i = 1;
        while (i <= k) {
            pre.next = new Node(i++);
            pre = pre.next;
        }
        return head.next;
    }


    public static void main(String[] avg) {
        Node l1 = buildLink(5);

        System.out.println(printLink(l1));

        System.out.println(printLink(reversK(l1, 2, 4)));

    }

    public static Node mergeNLink(List<Node> list) {

        Node hair = null;

        for (Node link : list) {
            hair = merge2Link(hair, link);
        }
        return hair;
    }

    public static Node merge2Link(Node l1, Node l2) {
        Node hair = new Node(0);
        Node pre = hair;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pre.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                pre.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }

        return hair.next;
    }


    public static String nodeToStr(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            if (node.next != null) {
                sb.append(node.val).append("->");
            } else {
                sb.append(node.val);
            }
            node = node.next;
        }
        return sb.toString();
    }

    public static Node build(int k) {
        Node hair = new Node(0);
        Node pre = hair;
        while (k > 0) {
            pre.next = new Node(k--);
            pre = pre.next;
        }
        return hair.next;
    }

    public static Node fs(Node node) {
        if (node.next == null) {
            return node;
        }
        Node newH = fs(node.next);
        node.next.next = node;
        node.next = null;
        return newH;
    }


}
