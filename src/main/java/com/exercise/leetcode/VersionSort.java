package com.exercise.leetcode;

public class VersionSort {


    public static void main(String[] avg) {

        String[] versions = new String[]{"2","1.9.0.1", "5", "3.11.1", "3.1", "1.7.1", "4.1.1", "2.1.3", "2.1.3", "2.0", "2.0.1", "2.1.3.0"};

        sortVersion(versions);

        ThreadLocal<String> local = new ThreadLocal<>();

        for (String s : versions) {
            System.out.println(s);
        }

    }


    public static void sortVersion(String[] versions) {
        if (versions == null || versions.length == 0) {
            return;
        }
        for (int i = 0; i < versions.length; i++) {
            for (int j = i + 1; j < versions.length; j++) {
                String temp = versions[j];
                if (compare(versions[i], versions[j]) < 0) {
                    versions[j] = versions[i];
                    versions[i] = temp;
                }
            }
        }

    }

    public static int compare(String o1, String o2) {
        int min = Math.min(o1.length(), o2.length()) - 1;
        int p = 0;
        while (p <= min + 1) {
            if (p > min) {
                return o1.length() > p ? 1 : -1;
            }
            if (o1.charAt(p) != o2.charAt(p)) {
                return o1.charAt(p) - o2.charAt(p);
            }
            p++;

        }
        return 0;
    }
}
