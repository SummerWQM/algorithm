package com.myself.exercise;

import java.util.*;

class ArraySolution {

    /**
     * {1, 0, 1, 2, 2, 0};
     * 力扣 颜色排序
     * 双指针
     * {1}
     * p1 = 1
     * p0 = {0,1}
     *
     * @param nums
     */
    public static void colorSort(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                // 如果 0 在 1 前，将 1 移动到 0的位置
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

    // 从 i 的位置开始 和最后的交换
    public static void swap(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
    }


    /**
     * 递增数组 和为K ， 类似三数和 移动左右指针即可
     */
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

    /**
     * 先递增再递减(等价于两个有序数组) 不重复的元素个数
     */
    public int diffnum(int[] nums) {
        int n = nums.length;
        if (n == 0l) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        int sum = 0;
        while (left <= right) {
            if (nums[left] == nums[right]) {
                sum++;
                int temp = nums[left];
                // 移除两边 各自都相同的 元素
                while (left <= right && nums[right] == temp)
                    right--;
                while (left <= right && nums[left] == temp)
                    left++;
            } else if (nums[left] < nums[right]) {
                sum++;
                int temp = nums[left];
                // 右边大， 右边不动， 移动 左指针
                while (left <= right && nums[left] == temp)
                    left++;
            } else {
                sum++;
                // 左边大， 左边不动， 移动右指针 想通的数据
                int temp = nums[right];
                while (left <= right && nums[right] == temp)
                    right--;
            }
        }
        return sum;
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


//    public static void main(String[] avg) {
//
//        int[] nums = new int[]{2, 4};
//
//        System.out.println(Character.isLetter('*'));
//    }

    // 核心是判断 值一定在mid 左右 或mid 右边 即可
    public static int find(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                // 说明 目标在 mid 的左边
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[n - 1] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }


        }
        return -1;
    }

    /**
     * 三数和 双指针降维
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> sum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1, third = n - 1;

            while (second < third) {
                // 去重第二个值，下一个开始
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }
                // 去重第三个值，从最后一个开始
                if (third < n - 2 && nums[third] == nums[third + 1]) {
                    third--;
                    continue;
                }
                int sum = nums[second] + nums[third] + nums[first];
                if (sum > target) {
                    third--;
                } else if (sum < target) {
                    second++;
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                    third--;
                    second++;
                }


            }
        }

        return ans;

    }


    /**
     * 二分查找 重复元素的 首和尾部
     * <p>
     * 找第一高于目标值的位置
     * <p>
     * 找地位目标位置
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] findLocation(int[] nums, int target) {
        int left = findBetween(nums, target, true);
        // 找第一高位
        int right = findBetween(nums, target, false) - 1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    public static int findBetween(int[] nums, int target, boolean lower) {
        int n = nums.length, ans = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 旋转打印 二维数组  力扣 58 螺旋矩阵
     * <p>
     * 注意边界问题
     * <p>
     * 四个指针标记 边界， 模拟路径打印
     *
     * @param nums
     * @return
     */
    public static List<Integer> cyclePrint(int[][] nums) {

        int columns = nums[0].length, rows = nums.length;

        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        List<Integer> re = new ArrayList<>();
        while (left <= right && top <= bottom) {

            for (int column = left; column <= right; column++) {
                re.add(nums[top][column]);
            }

            for (int row = top + 1; row <= bottom; row++) {
                re.add(nums[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    re.add(nums[bottom][column]);
                }

                for (int row = bottom; row > top; row--) {
                    re.add(nums[row][left]);
                }
            }

            right--;
            left++;
            bottom--;
            top++;
        }
        return re;
    }

    /**
     * O(1) 空间消耗， 保持相对顺序不变， 将 0 移动到末尾
     * <p>
     * 快慢双指针
     *
     * @param nums
     */
    public static void removeZero(int[] nums) {
        int n = nums.length;
        int i = 0, j = i + 1;
        while (j < n) {
            if (nums[i] == 0) {
                if (nums[j] == 0) {
                    j++;
                } else {
                    swap(nums, i, j);
                }
            } else {
                i++;
                j++;
            }
        }
    }

    /**
     * 重复元素中， 出现一次的数据
     * 想同值 2次异或等于0
     *
     * @param nums
     * @return
     */
    public static int calc(int[] nums) {
        int r = 0;
        for (int num : nums) {
            r = r ^ num;
        }
        return r;
    }

    /**
     * 类似 循环俩表的思想，
     * 找存在环的数组， 数组前提是 [1,n] 的n+1个元素的数组
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return nums[slow];

            }
        }
    }

    public static int[] mergeSortArr(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] re = new int[l1 + l2];
        int r1 = 0, r2 = 0, w = 0;
        while (r1 < l1 || r2 < l2) {
            if (r1 >= l1) {
                re[w++] = nums2[r2++];
            } else if (r2 >= l2) {
                re[w++] = nums1[r1++];
            } else if (nums1[r1] < nums2[r2]) {
                re[w++] = nums1[r1++];
            } else {
                re[w++] = nums2[r2++];
            }
        }
        return re;
    }

    /**
     * 跳跃游戏
     * 判断 能走到右边的最大位置
     * 不断取 下标 + 值 的最大值， 看能否到达最后
     * 如果i > most 说明 不会到达 i的位置
     *
     * @param
     */
    public static boolean jump(int[] nums) {
        int rightMost = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
            }
            if (rightMost >= n - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并二维数组区间
     *
     * @param
     */

    public static int[][] merged(int[][] intervals) {

        return new int[][]{};
    }


    /**
     * 37 下一个排列， 按递增递减序列处理
     *
     * @param args
     */
    public static void nextOrder(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        //从后找递减区间 最后一个值
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //找到了
        if (i >= 0) {
            int j = nums.length - 1;
            //找到  第一个 大于 i 的值
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 反转 i 以后得为小区间
        swap(nums, i + 1);
    }

    /**
     * 41、缺失的正数
     * <p>
     * # 缺失的一定是[1->N+1] 的数。 如果出现负号 一定有确实
     *
     * @param nums
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 将负数 标记为正数, 不考虑 大于n 的数
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            // 将存在的位置的下标，一次标记为负数
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 便利大于 0 的数，缺失的索引 i +1 即为缺失的正数
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }


    public static void main(String[] args) {
//        int[][] nums = new int[][]{{1}, {3}};
//        System.out.println(Arrays.toString(cyclePrint(nums).toArray()));
        int[][] nums = new int[][]{{3, 4}, {2, 3}};

        //int[] nums1 = new int[]{4, 5, 6};
        // colorSort(nums);
        int[] nums1 = new int[]{1, -10, 2};
        //nextOrder(nums1);
        System.out.println(firstMissingPositive(nums1));
    }


}


