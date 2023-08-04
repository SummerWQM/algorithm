package com.myself.exercise;

import java.util.*;

class StringSolution {
//    public static void main(String[] avg) {
//        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//
//        System.out.println(Arrays.toString(groupAnagrams(strs).toArray()));
//    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());

    }

    // 438  滑动窗口

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<Integer>();

        if (s == null || p == null || s.length() < p.length()) {
            return ans;
        }

        int sLen = s.length(), pLen = p.length();

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }


        return ans;
    }

    public static void main(String[] avg) {
        System.out.println(Arrays.toString(findAnagrams("abcabce", "abc").toArray()));

        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o1 - o2);

        que.add(3);
        que.add(2);
        que.add(5);



        System.out.println(que.remove());


    }

}