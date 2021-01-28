//package com.exercise.leetcode;


import java.util.Vector;

/**
 * 翻转字符串
 */
public class ReversalString {


    public void leftReversalStr(char[] str, int from, int to) {

        if (str.length == 0) {
            return;
        }
        while (from < to) {
            char t = str[from];
            str[from++] = str[to];
            str[to--] = t;
        }

    }


    public char[] loopMethodStr(char[] str) {

        leftReversalStr(str, 0, str.length - 1);


        return str;

    }

    public static void main(String[] args) {

        ReversalString r = new ReversalString();

        System.out.println(r.loopMethodStr(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}));
    }

}

