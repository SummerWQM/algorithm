package com.myself.exercise;

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

    /**
     * 返回相交链表的的节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public Node getIntersectionNode(Node headA, Node headB) {
        Node A = headA, B = headB;

        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }


    public static Node reversK(Node head, int m, int n) {
        Node hair = new Node(0);
        hair.next = head;
        Node start = hair, end = hair, pre = hair;

        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        for (int i = 0; i < m; i++) {
            if (i > 0) {
                pre = pre.next;
            }
            start = start.next;
        }
        pre.next = reverser(start, end);
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

        Node() {

        }

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

    /**
     * 合并
     *
     * @param lists
     * @return
     */
    public Node mergeKLists(Node[] lists) {
        Node ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    /**
     * 遍历每个节点 拼接链表，通过新建头节点 方便拼接链表。
     *
     * @param a
     * @param b
     * @return
     */
    public Node mergeTwoLists(Node a, Node b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        Node head = new Node(0);
        Node tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }


    /**
     * k 一个一组， 两两反转，指定区间反转，终极解法
     */
    public static Node reverseK(Node head, int k) {
        Node hair = new Node();
        hair.next = head;
        Node pre = hair;
        Node start = head, end = pre;
        while (end != null && start != null) {
            for (int i = 0; i < k; i++) {
                if (end.next != null) {
                    end = end.next;
                }
            }

            pre.next = reverser(start, end);
            pre = start;
            end = pre;
            start = pre.next;
        }
        return hair.next;
    }

    public static Node reverser(Node start, Node end) {
        Node tail = end.next, pre = end.next;
        Node cur = start;
        while (tail != cur) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

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
        pre.next = reverser(start, end);
        return hair.next;
    }
    //====================================== 以上是 各种反转链表======

}
