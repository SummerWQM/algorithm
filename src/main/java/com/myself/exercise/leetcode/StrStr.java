package com.myself.exercise.leetcode;

public class StrStr {


    //最直接的方法 - 沿着字符换逐步移动滑动窗口，将窗口内的子串与 needle 字符串比较
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null || "".equals(needle)) {
            return 0;
        }

        int L = needle.length(), N = haystack.length();

        for (int start = 0; start < N - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;

    }

}
