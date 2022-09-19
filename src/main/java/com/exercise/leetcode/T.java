package com.exercise.leetcode;

import java.util.ArrayList;

class T {

    public long[] map = new long[10];

//    public static void main(String[] args) {
//
//        String b = "A001";
//        T t = new T();
//        for (int i = 0; i < b.length(); i++) {
//            t.set(b.charAt(i));
//        }
//        System.out.println(t.transfer().toCharArray());
//    }

    public void set(int ansi) {

        int location = ansi / 64;
        int move = ansi % 64;
        map[location] = 1L << move;

    }

    public String transfer() {
        ArrayList<Long> re = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            long val = 0;
            for (long j = 0; j < 64; j++) {
                long t = map[i] & (1 << j);
                if (t > 0) {
                    val = i * 64 + j;
                }
                re.add(val);
            }
        }

        if (re.isEmpty()) {
            return "";
        }

        String s = "";
        for (Long i : re) {
            if (i > 0) {
                s += Character.toChars(i.byteValue());
            }
        }

        return s;
    }


    public static void main(String[] a) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(Integer.MAX_VALUE));
    }


    public static int reverse(int x) {

        int rev = 0;

        while (x != 0) {
            int tmp = rev % 10;
            if ((rev < Integer.MIN_VALUE / 10) || (rev > Integer.MAX_VALUE / 10)) {
                return 0;
            }

            int cur = x % 10;

            rev = rev * 10 + cur;

            x /= 10;

        }

        return rev;


    }

}