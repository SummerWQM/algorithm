package com.exercise.leetcode;

import java.util.*;

/**
 * 合并两个有序数组
 */
public class MergeArray {

    Map<Character, String> dict = new HashMap() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     * 合并制定长度 数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p = 0, q = 0;
        int[] sorted = new int[m + n];

        int cur;

        while (p < m || q < n) {
            if (p == m) {
                cur = nums2[q++];
            } else if (q == n) {
                cur = nums1[p++];
            } else if (nums1[p] < nums2[q]) {
                cur = nums1[p++];
            } else {
                cur = nums2[q++];
            }
            sorted[p + q - 1] = cur;
        }

        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }


    /**
     * 合并有序数组
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] merge(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int[] stored = new int[len1 + len2];
        int index = 0;
        while (i < len1 || j < len2) {
            if (i >= len1) {
                stored[index++] = nums2[j++];
            } else if (j >= len2) {
                stored[index++] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                stored[index++] = nums1[i++];
            } else {
                stored[index++] = nums2[j++];
            }
        }

        return stored;
    }


//    public static void main(String[] avg) {
//        int[] num1 = new int[]{1, 2, 3, 4, 9, 23};
//        int[] num2 = new int[]{1, 2, 2, 3, 7, 9, 11};
//        System.out.println(Arrays.toString(merge(num1, num2)));
//        System.out.println(Arrays.toString(intersection(num1, num2)));
//    }

    /**
     * 求数组交集，排序+双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int[] re = new int[len1 + len2];
        int index = 0;
        int pre = re[0];

        while (i < len1 && j < len2) {

            if (nums1[i] == nums2[j]) {
                // 不记录 pre 指针，就记录了 所有交集元素
                if (index == 0 || pre != nums1[i]) {
                    re[index++] = nums1[i];
                    pre = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }

        }

        StringBuffer buffer;


        return Arrays.copyOfRange(re, 0, index);


    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 要取到 最右边的点， "abba" left = 2; 最后进来的i+1 如果取 a left 反而变小了。
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    public static void main(String[] avg) {

        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Queue<Integer> s = new ArrayDeque<>();

//        s.offer();
//        s.poll();
//        s.isEmpty();
//
//        s.poll();
//        s.peek();

        System.out.println(stack.peek());

       // System.out.println(lengthOfLongestSubstring("abba"));
    }
}
























































