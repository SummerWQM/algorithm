package com.myself.exercise.leetcode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/submissions/
 * <p>
 * 两数，链表值相加  考虑仅为  sum /10    sum%10 当前位值
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

}

