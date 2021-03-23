package com.exercise.leetcode;

import org.apache.logging.log4j.util.Strings;

import java.util.Comparator;

public class CommonPrefix {


    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        if (prefix == "") {
            return "";
        }
        for (String s : strs) {

            while (!s.startsWith(prefix)) {
                if (s.equals("")) return "";
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;

    }



}
