package com.exercise.dancebyte;

import com.helper.ListNode;

import java.util.List;

// K 个一组 翻转链表
public class ReverseNode {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            // 这里翻转 1-3 start 开始的 1 . 4
            // 3-2-1.4.5.6
            pre.next = reverse(start);
            start.next = next;// 指向下一个翻转的开始节点  1.4
            pre = start; // 1 节点付给 pre 方便 下一次 去 pre.next
            end = pre; // 1 给 end 方便下一次 end 的跳转到 next
        }
        return dummy.next;
    }

    private ListNode reverse1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    private ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = reverse(head.next);

        // 空间变化 修改指针
        head.next.next = head;

        head.next = null;

        // 返回头指针

        return tail;

    }

    // 翻转一个链表
    public ListNode reverses(ListNode head) {
        if (head == null) return null;

        ListNode newList = null, node;

        while (head != null) {
            //取出当前节点
            node = head;
            // 移动下一个head节点
            head = head.next;
            // 取出当前节点，指向 翻转的节点
            node.next = newList;
            // 移动newlist 指针 指向最新的 翻转节点
            newList = node;
        }
        return newList;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        // 链表翻转 需要记录 前驱 pre 节点 所以加入 dummy 方便记录。

        for (int i = 1; i < left; i++) pre = pre.next;

        // 翻转头节点
        head = pre.next;

        for (int i = left; i < right; i++) {

            ListNode nxt = head.next; // 指向 head 之后的节点
            //head节点连接nxt节点之后链表部分，也就是向后移动一位
            head.next = nxt.next;
            //nxt节点移动到需要反转链表部分的首部
            nxt.next = pre.next;
            pre.next = nxt;//pre继续为需要反转头节点的前驱节点

        }



        return dummy.next;

    }

}
