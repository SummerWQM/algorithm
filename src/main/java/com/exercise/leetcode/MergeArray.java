package com.exercise.leetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class MergeArray {

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


    public static int[] merge(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int[] stored = new int[len1 + len2];
        int index = 0;
        while (i < len1 || j < len2) {
            if (i >= len1) {
                stored[index++] = nums2[j];
                j++;
            } else if (j >= len2) {
                stored[index++] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                stored[index++] = nums1[i];
                i++;
            } else {
                stored[index++] = nums2[j];
                j++;
            }
        }

        return stored;
    }


    public static void main(String[] avg) {
        int[] num1 = new int[]{1, 2, 3, 4, 9, 23};
        int[] num2 = new int[]{1, 2, 3, 7, 9, 11};
        System.out.println(Arrays.toString(merge(num1, num2)));
    }
}
