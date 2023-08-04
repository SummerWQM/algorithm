package com.myself.exercise.leetcode;


import com.myself.helper.ListNode;

/**
 * 判断链表是否是回文
 */
class Solution3 {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;

        }

        ListNode slow = head, fast = head;

        ListNode pre = null;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            ListNode temp = slow.next;

            slow.next = pre;

            pre = slow;

            slow = temp;

            // 快指针每次 走两个， 满指针 每次 翻转一个

        }

        // 为奇数的时候 不为空 ， 就只需要比较  翻转后的  个数 减 一个 所以是 show = show.next.;
        if (fast != null) {
            slow = slow.next;
        }


        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

}