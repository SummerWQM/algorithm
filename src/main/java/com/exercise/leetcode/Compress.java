package com.exercise.leetcode;

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
        for (char c : ("" + (5 - 3 + 1)).toCharArray()) {
           System.out.println(c);
        }
    }
}
