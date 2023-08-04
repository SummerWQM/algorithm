<<<<<<< HEAD:src/main/java/com/myself/exercise/leetcode/SolutionString.java
package com.myself.exercise.leetcode;

import java.util.HashMap;

class T {
    public static String fin(String s, String t) {
        if (t == null || t.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }

        String ans = "";

        int min = Integer.MAX_VALUE, win = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);

            if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) win++;

            while (j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j++;
            }
            if (win == t.length() && i - j + 1 < min) {
                min = i - j + 1;
                ans = s.substring(j, i + 1);
            }
        }

        return ans;
    }

}
=======
//    public static String fin(String s, String t) {
//        if (t == null || t.length() == 0) {
//            return "";
//        }
//        HashMap<Character, Integer> hs = new HashMap<>();
//        HashMap<Character, Integer> ht = new HashMap<>();
//        for (int i = 0; i < t.length(); i++) {
//            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
//        }
//
//        String ans = "";
//
//        int min =Integer.MAX_VALUE, win = 0;
//
//        for (int i = 0, j = 0; i < s.length(); i++) {
//            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
//
//            if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) win++;
//
//            while (j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
//                int count = hs.get(s.charAt(j)) - 1;
//                hs.put(s.charAt(j), count);
//                j++;
//            }
//            if (win == t.length() && i - j + 1 < min) {
//                min = i - j + 1;
//                ans = s.substring(j, i + 1);
//            }
//        }
//
//        return ans;
//    }
>>>>>>> 288f4f61a2e55209ab7d247794c1bd1101321127:src/main/java/com/exercise/leetcode/SolutionString.java
