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


//    public static void main(String[] args) {
//
//        System.out.println(maxCommonStr("abc", "cabc"));
//
//    }

    /**
     * 最长公共子串
     *
     * 动态规划 拆分子问题
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int maxCommonStr(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char char1 = str1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char char2 = str2.charAt(j - 1);

                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }

        return dp[m][n];


    }


}