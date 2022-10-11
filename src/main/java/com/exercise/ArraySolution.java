package com.exercise;

import java.util.*;

class ArraySolution {

    public static void fns(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    // 递增数组 和为K
    public static ArrayList<Integer> findPair(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                list.add(nums[i]);
                list.add(nums[j]);
            }
        }
        return list;
    }

// 先递增再递减 不重复的元素个数

    public int diffnum(int[] nums) {
        int n = nums.length;
        if (n == 0 || nums == null) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int sum = 0;
        while (left <= right) {
            if (nums[left] == nums[right]) {
                sum++;
                int temp = nums[left];
                while (left <= right && nums[right] == temp)
                    right--;
                while (left <= right && nums[left] == temp)
                    left++;
            } else if (nums[left] < nums[right]) {
                sum++;
                int temp = nums[left];
                while (left <= right && nums[left] == temp)
                    left++;
            } else {
                sum++;
                int temp = nums[right];
                while (left <= right && nums[right] == temp)
                    right--;
            }
        }
        return sum;
    }


    // 找出数组 右边第一个 大于自己的数
    public static int[] find(int[] nums) {

        int[] re = new int[nums.length];

        int index = 0, size = nums.length;

        Stack<Integer> stack = new Stack<>();
        while (index < size) {
            // 如索引果入栈的元素  大于栈顶， 就 自选把栈 里的小于自己的 都压入栈
            if (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                re[stack.pop()] = nums[index];
            } else {
                stack.push(index++);
            }

        }
        // 最后都没 出栈的 说明后边没有大于自己的。
        while (!stack.isEmpty()) {
            re[stack.pop()] = -1;
        }

        return re;

    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    /**
     * 最早出现，且次数最多的元素,
     * int[] nums = new int[]{8, 3, 4, 4, 4, 2, 3, 4, 5, 1, 3, 3, 0};
     */
    public static int findMore(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        int max = 0, anchor = 0;
        for (int i = nums.length - 1; i >= 0; i--) {

            int count = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], count);
            if (count >= max) {
                max = count;
                anchor = nums[i];
            }
        }
        return anchor;

    }

    /**
     * 查找数组每一个位置 左边第一个小于自己的数
     * <p>
     * 单调递增
     * <p>
     * 01、 O(N*N) for i    j = i  j--
     * 02. stack 使用单调栈，空间换时间。
     *
     * @param
     */
    public static int[] findFirstLow(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        int[] re = new int[nums.length];

        int index = 0, size = nums.length;

        while (index < size) {
            // 左边第一个小于自己的，维护一个单调递增的 栈
            if (!stack.isEmpty() && nums[stack.peek()] >= nums[index]) {
                stack.pop();
            } else {
                re[index] = stack.isEmpty() ? -1 : nums[stack.peek()];
                stack.push(index++);
            }
        }
        return re;
    }

    /**
     * 每个位置 左边第一个 大于自己元素。
     * <p>
     * 单调递减 [3,2,1]
     *
     * @param
     */
    public static int[] findLeftFirstOver(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int index = 0, size = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] re = new int[size];
        while (index < size) {
            if (!stack.isEmpty() && nums[stack.peek()] <= nums[index]) {
                stack.pop();
            } else {
                re[index] = stack.isEmpty() ? -1 : nums[stack.peek()];
                stack.push(index++);
            }
        }
        return re;
    }


    /**
     * 右边第一个大于自己的数
     * <p>
     * 使用单调递增栈
     *
     * @param
     */

    public static int[] findROver(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int index = 0, size = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] re = new int[size];
        Arrays.fill(re, -1);
        while (index < size) {
            // 比较栈顶 元素 是否小于当前值
            if (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                re[stack.pop()] = nums[index];
            } else {
                stack.push(index++);
            }
        }

        return re;
    }


    public static void main(String[] avg) {

        int[] nums = new int[]{1, 3, 2, 3, 5, 4};

        System.out.println(Arrays.toString(findROver(nums)));

    }
}


