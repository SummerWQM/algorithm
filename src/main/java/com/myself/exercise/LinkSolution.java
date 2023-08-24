package com.myself.exercise;

import com.myself.helper.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LinkSolution {

    // 环连链表 入口
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
        Node random;

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

    public static Node buildLinkRandom(int n) {
        Node head = new Node(0);
        Node pre = head;
        int i = n;
        while (i > 0) {
            pre.next = new Node((int) Math.ceil(Math.random() * n));
            pre = pre.next;
            i--;
        }
        return head.next;
    }


    public static Node mergeNLink(List<Node> list) {

        Node hair = null;

        for (Node link : list) {
            hair = merge2Link(hair, link);
        }
        return hair;
    }

    /**
     * 类似有序数组合并
     *
     * @param l1
     * @param l2
     * @return
     */
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
     * 合并K 个链表
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

    // 链表重排 143 力扣
    public void reorderList(Node head) {
        if (head == null) {
            return;
        }
        // 将链表三列到数组，让数组引用，并通过下标访问
        List<Node> list = new ArrayList<Node>();
        Node cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        // l0 - ln -> l1 -> ln-1
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }

        list.get(i).next = null;
    }

    /**
     * 1、回文链表的 递归写法, 空间复杂度O(1)
     * <p>
     * 2、O(N)复杂度 三列到数组 双指针
     */
    private Node frontPointer;

    private boolean recursivelyCheck(Node currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(Node head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    /**
     * 链表排序
     *
     * @param
     */
    public static Node sortLink(Node head) {
        return doSortLink(head, null);
    }

    /**
     * 链表排序
     * 递归分割链表， 再有序合并, 时间复杂度  O(NlogN) ,空间复杂度O(logN)
     */
    public static Node doSortLink(Node head, Node tail) {
        if (head == null) {
            return null;
        }
        // 分割到相临的节点
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        Node slow = head, fast = head;
        // 到达尾指针便利结束
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        Node mid = slow;
        Node list1 = doSortLink(head, mid);
        Node list2 = doSortLink(mid, tail);
        // 分割节点合并
        return merge(list1, list2);
    }

    public static Node merge(Node head1, Node head2) {
        Node dummyHead = new Node(0);
        Node temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    // 递归反转
    public static Node reverse(Node node) {
        if (node.next == null) {
            return node;
        }
        Node head = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }

    /**
     * 138 赋值待 随机指针链表
     * Hash 表保存节点， hash 表用来去重 random 的指向
     */
    static Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 已经赋值了的节点， 放入hash 表，防止 random 节点 重复创建
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    /**
     * 61 旋转链表
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        // 便利一次 统计节点数量
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        // 计算k 到那个节点之间转换
        int add = n - k % n;
        // 等于n 直接返回头
        if (add == n) {
            return head;
        }
        // 尾指针，指向新的头。
        iter.next = head;
        // 移动k 个位置，即为新的头
        while (add-- > 0) {
            iter = iter.next;
        }
        // 产生新的头，从当前断开， 即为新的链表
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }


    //===
    public static void main(String[] avg) {
        Node head = buildLinkRandom(10);
        System.out.println(printLink(head));
        System.out.println(printLink(reverse(head)));
    }

}
