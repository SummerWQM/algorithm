package com.myself.exercise.leetcode;

public class Major {


    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        int major = 0;
        int count = 0;

        for (int x : nums) {
            if (count == 0) {
                major = x;
                count++;
            } else {
                if (major == x) {
                    count++;
                } else {
                    count--;
                }
            }
        }


        int c = 0;

        for (int x : nums) {
            if (x == major) {
                c++;
            }
        }

        if (c > 1) {
            return true;
        }

        return false;
    }


}


