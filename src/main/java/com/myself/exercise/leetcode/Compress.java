package com.myself.exercise.leetcode;

import ch.qos.logback.core.util.SystemInfo;

/**
 * https://leetcode-cn.com/problems/string-compression/
 */
public class Compress {


    public int compress(char[] chars) {

        int anchor = 0, write = 0;

        for (int read = 0; read < chars.length; read++) {

            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    //赋值中间的字符 int 转 字符 char[2]='3';
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }



        }
        return write;

    }

    public static void main(String[] arg) {

        int i = 0;

        int[] a = new int[10];

        for (char c : ("" + (5 - 3 + 1)).toCharArray()) {
            System.out.println(3);
        }


    }
}
