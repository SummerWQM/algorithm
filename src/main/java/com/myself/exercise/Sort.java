package com.myself.exercise;

/**
 * 快速排序是一种高效的排序算法，它的时间复杂度为O(nlogn)。以下是Java实现的快速排序算法：
 * 快速排序的基本思想是：选定一个基准元素，然后将数组分成左右两个子数组，
 * 使得左子数组的所有元素都小于基准元素，右子数组的所有元素都大于基准元素。
 * 然后递归地对左右子数组进行快速排序，最终将子数组合并成一个有序的数组。在实现中，
 * 通常采用双指针法来实现分割操作，即从左右两端分别向中间扫描，找到需要交换的元素，并将它们交换位置，直到左右指针相遇。
 * <p>
 * 堆排序、TapN 问题
 */

public class Sort {

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

    /**
     * 维护堆的性质
     * 父节点 大于 左右 孩子
     * <p>
     * 下标为i的节点父节点下标: (i-1)/2
     * 下标为i的节点左节点下标: i * 2 + 1
     * 下标为i的节点又节点下标: i * 2 +2
     * 复杂度 O(logN)
     * n 数组长度， i 是维护的位置
     *
     * @param nums
     * @param n
     * @param i
     */
    public static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int lson = i * 2 + 1, rson = i * 2 + 2;

        if (lson < n && nums[largest] < nums[lson]) {
            largest = lson;
        }
        if (rson < n && nums[largest] < nums[rson]) {
            largest = rson;
        }
        // 如果最大的值 不是i 就交换节点 （是做或是右）
        if (largest != i) {
            swap(nums, largest, i);

            heapify(nums, n, largest);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 堆排序
     * 1、第一步 建堆， 复杂度O(N)
     * * 下标为i的节点父节点下标: (i-1)/2
     * * 下标为i的节点左节点下标: i * 2 + 1
     * * 下标为i的节点又节点下标: i * 2 +2
     * 复杂度 N * log(N)
     */

    public static void heapSort(int[] nums, int n) {

        buildHeap(nums, n);
        int i;
        for (i = n - 1; i > 0; i--) {
            // 取出最堆，最后一个， 维护 i个堆性质， 再继续取一个
            // 解决 top N 问题，类似
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    public static void buildHeap(int[] nums, int n) {

        int i;
        // 从最后一个值建堆，(i-1)/2 <=> (n-1-1)/2 =  n/2 -1
        // 从数组最优一个元素的 父节点开始，计算堆性质。 i-- ，继续判断上一个父节点，，直到对顶元素
        for (i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }

    /**
     * TOP N 问题
     *
     * @param
     */
    public static int topN(int[] nums, int k) {
        int len = nums.length;
        buildHeap(nums, len);
        int i;
        for (i = len - 1; i >= len - k + 1; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 2, 4, 1, 3, 9};

        //heapSort(nums, nums.length);

        System.out.println(topN(nums, 4));
    }

}
