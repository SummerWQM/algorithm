package com.exercise.leetcode;

import java.util.Arrays;

/**
 * 字符串解压缩
 * b3d3e2p3
 * b2ef3
 * <p>
 * 字符0-9的ASCII码：48-57；
 * <p>
 * 大写字母A-Z的ASCII码为：65-90；
 * <p>
 * 小写字母a-z的ASCII码为：97-122；
 */

public class Decompression {


    public static String decompress(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        char[] str = s.toCharArray();
        int anchor = 0;

        StringBuilder re = new StringBuilder();
        if (str.length <= 1) {
            return Arrays.toString(str);
        }

        for (int read = 0; read < str.length; ) {
            if (str[read + 1] > '0' && str[read + 1] < '9') {
                int b = str[read + 1] - '0';
                while (b > 0) {
                    re.append(str[anchor]);
                    b--;
                }
                read += 2;
                anchor = read;
            } else {
                re.append(anchor);
                anchor = read;
                read++;
            }

        }
        return re.toString();
    }


    public static void main(String[] a) {


        System.out.println(decompress("a2b3"));

    }

}
