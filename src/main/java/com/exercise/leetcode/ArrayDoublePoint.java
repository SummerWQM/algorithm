package com.exercise.leetcode;

/**
 * 双指针判断  a 字符串 是否 都在 字符B 字符串中
 */
public class ArrayDoublePoint {


    public static void main(String[] a) {

        System.out.println(getGB("fbc", "fbcadef"));
    }

    public static boolean getGB(String s1, String s2) {

        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i < s1.length()) {
            return false;
        }
        return true;


    }


}
