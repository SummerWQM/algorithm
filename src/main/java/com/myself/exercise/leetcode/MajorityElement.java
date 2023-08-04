package com.myself.exercise.leetcode;

import java.util.HashMap;

public class MajorityElement {

    /**
     * 空间复杂度 O(N)  时间复杂度 O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        int mid = nums.length / 2;

        return 0;
    }

    /**
     * 摩尔投票算法
     * <p>
     * 不需要使用 hash表来统计 每个数的次数
     * <p>
     * 相同票数  就 + 1 非 同票 就 -1   为0 的时候 就更新候选人 继续.
     * 结束后 cnt 机票还大于0 的 就是 票数最多的
     * 最后 loop 异常 统计所有票数 判断是否 过半
     * 时间复杂度 应是 2N
     * 时间复杂度 O(N) 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int major(int[] nums) {

        int major = 0, cnt = 0;


        for (int x : nums) {
            if (cnt == 0) {
                major = x;
                cnt++;
            } else {
                if (major == x)
                    cnt++;
                else
                    cnt--;
            }
        }

        if (cnt > 0) {
            int t = 0;
            for (int x : nums)
                if (x == major)
                    t++;
            if (t > nums.length / 2) return major;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 0, 1, 0, 1};

        System.out.println(MajorityElement.major(arr));
    }


}