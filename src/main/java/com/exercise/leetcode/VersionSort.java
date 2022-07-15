package com.exercise.leetcode;

public class VersionSort {


    public static void main(String[] avg) {

        String[] versions = new String[]{"3.0", "3.1", "1.7.1", "4.1.1", "2.1.3", "2.1.3", "2.0", "2.0.1"};

        sortVersion(versions);


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

        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }


        String[] a = o1.split("\\.");
        String[] b = o1.split("\\.");
        int min = Math.min(a.length, b.length) - 1;
        int dif = 0;
        int p = 0;
        while (p <= min + 1) {
            if (p > min) {
                return a.length > p ? 1 : -1;
            }
            dif = o1.charAt(p) - o2.charAt(p);
            if (dif == 0) {
                p++;
                continue;
            }
            return dif;
        }

        return dif;
    }
}
