//package com.exercise.leetcode;


/**
 * 翻转字符串
 */
public class ReversalString {


    public void leftReversalStr(char[] str) {

        if (str.length == 0) {
            return;
        }
        int indexCount = str.length - 1;
        char one = str[0];

        int r = indexCount, w = 0;
        for (int i = 0; i < indexCount; i++) {

            str[i] = str[indexCount];

            for (int j = indexCount - 1; j >= i + 1; j--) {
                str[j + 1] = str[j];
            }
        }

        str[str.length - 1] = one;

        System.out.println(str);
    }


    public char[] loopMethodStr(char[] str) {

        leftReversalStr(str);
        return str;

    }

    public static void main(String[] args) {

        ReversalString r = new ReversalString();

        System.out.println(r.loopMethodStr(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}));
    }

}

