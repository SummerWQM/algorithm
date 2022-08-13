package com.exercise.leetcode;

public class VersionSort {


    public static void main(String[] avg) {

        String[] versions = new String[]{"2", "1.9.0.1", "5", "3.11.1", "3.1", "1.7.1", "4.1.1", "2.1.3", "2.1.3", "2.0", "2.0.1", "2.1.3.0"};

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
        int n1 = o1.length();
        int n2 = o2.length();
        int i = 0, j = 0;
        while (i < n1 || j < n2) {

            long num1 = 0;
            while (i < n1 && o1.charAt(i) != '.') {
                num1 = num1 * 10 + (o1.charAt(i) - '0');
                i++;
            }
            i++;

            long num2 = 0;

            while (j < n2 && o2.charAt(j) != '.') {
                num2 = num2 * 10 + (o2.charAt(j) - '0');
                j++;
            }

            j++;

            if (num1 > num2) {
                return 1;
            }
            if (num1 < num2) {
                return -1;
            }

        }

        return 0;
    }
}
