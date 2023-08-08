package com.myself.exercise;

import java.util.Arrays;

/**
 * 快速排序是一种高效的排序算法，它的时间复杂度为O(nlogn)。以下是Java实现的快速排序算法：
 * 快速排序的基本思想是：选定一个基准元素，然后将数组分成左右两个子数组，
 * 使得左子数组的所有元素都小于基准元素，右子数组的所有元素都大于基准元素。
 * 然后递归地对左右子数组进行快速排序，最终将子数组合并成一个有序的数组。在实现中，
 * 通常采用双指针法来实现分割操作，即从左右两端分别向中间扫描，找到需要交换的元素，并将它们交换位置，直到左右指针相遇。
 */

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // 分割位置
            quickSort(arr, low, pivotIndex - 1);  // 递归排序左子数组
            quickSort(arr, pivotIndex + 1, high); // 递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // 选定基准元素 nums[0]
        int i = low, j = high;
        while (i < j) {
            // 从右向左找第一个小于基准元素的位置
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            // arr[j] < 基准 并且 不是  地位 i
            // arr[i] = 第一个小于 基准  i++ =1
            if (i < j) {
                arr[i++] = arr[j];
            }
            // 从左向右找第一个大于基准元素的位置
            // 从 1 的位置 找到 第一个 大于或等于 基准 5 的 并且不是 基准下标
            while (i < j && arr[i] < pivot) {
                i++;
            }
            // i= 2 = 8
            // 把 j = 6  和 2 =8 互换。
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = pivot; // 把基准元素放到最终位置上
        return i; // 返回分割位置
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
