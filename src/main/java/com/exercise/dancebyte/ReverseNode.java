package com.exercise.dancebyte;

import com.helper.ListNode;

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
            // 这里翻转 1-3 start 开始的 1 -> 4
            // 3-2-1->4->5->6
            pre.next = reverse(start);
            start.next = next;// 指向下一个翻转的开始节点  1->4
            pre = start; // 1 节点付给 pre 方便 下一次 去 pre.next
            end = pre; // 1 给 end 方便下一次 end 的跳转到 next
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 返回翻转之后的链表
        return pre;
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

}
