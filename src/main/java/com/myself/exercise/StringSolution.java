package com.myself.exercise;

import java.util.*;
import java.util.concurrent.TimeUnit;

class StringSolution {
//    public static void main(String[] avg) {
//        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//
//        System.out.println(Arrays.toString(groupAnagrams(strs).toArray()));
//    }

    /**
     * 3、无重复字符串的最大长度
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 避免回文串 "a b b a"  left 要取最大值。
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


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

    /**
     * 438 找到字符串中所有字母异位词
     * <p>
     * p 字符串 的所有以为词的 起始索引， ==》 滑动窗口
     */
    public static List<Integer> findAnagrams(String s, String p) {

        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 只同时移动 滑块个长度 判断两个滑块是否相等

        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }
        // 初始滑块在0 位置 // 判断两个滑块是否相同，即数组相等。
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        // 开始移动 目标窗口，
        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];// 移动滑动 从 0 到i
            ++sCount[s.charAt(i + pLen) - 'a']; // 右移一位。
            // 相等即为 新的异位词，起始点。
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

//    public static void main(String[] args) {
//
//        System.out.println(maxCommonStr("abc", "cabc"));
//
//    }

    /**
     * 最长公共子串
     * <p>
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

    /**
     * 224 , 利用栈，去括号，拆解符号计算
     * Str = 1+2-(-3+4)
     *
     * @param str
     */
    public static int T(String str) {

        int sign = 1;

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        int ret = 0, n = str.length(), i = 0;
        while (i < n) {
            char c = str.charAt(i);
            if (c == ' ') {
                i++;
            } else if (c == '+') {
                sign = stack.peek();
                i++;
            } else if (c == '-') {
                sign = -stack.peek();
                i++;
            } else if (c == '(') {
                stack.add(sign);
                i++;
            } else if (c == ')') {
                stack.pop();
                i++;
            } else {
                int num = 0;
                while (i < n && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
                ret += sign * num;
            }

        }

        return ret;

    }

    /**
     * 227 字符串加减乘除
     * 前置默认一个符号
     */
    public static void StringCalc() {

        String s = "3 + 5 * 2";

        char preSign = '+';
        int num = 0, index = 0;
        Stack<Integer> stack = new Stack<>();
        while (index < s.length()) {

            if (Character.isDigit(s.charAt(index))) {
                num = num * 10 + (s.charAt(index) - '0');
            }
            if (!Character.isDigit(s.charAt(index)) && s.charAt(index) != ' ' || index == s.length() - 1) {
                //遇到了下一个符号是，处理上一个符号
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                // 更新当前符号
                preSign = s.charAt(index);
                //重置数据
                num = 0;

            }
            index++;
        }

        int re = 0;
        while (!stack.isEmpty()) {
            re += stack.pop();
        }
        System.out.println(re);

    }

    public static String reverseWords(String s) {
        StringBuilder sb = trimSpaces(s);
        // "abc  jack" => "cba kcaj" =>  kacj abc
        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    public static StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
                // 最后一个部位空，就追加一个空进去，保留单词之间一个空格
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public static void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 反转字符从 start 到 end, 此时end 指向 空格 ' '
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            // 指向下一个单词
            ++end;
        }
    }

    /**
     * 76. 最小覆盖子串 - 滑动窗口
     */

    public static String minWindow(String s, String t) {
        int[] hash = new int[128];

        for (char ch : t.toCharArray()) {
            hash[ch]--;
        }
        String res = "";
        int cnt = 0, len = s.length() + 1;
        char ch;
        for (int r = 0, l = 0; r < s.length(); r++) {
            ch = s.charAt(r);
            // 不存在字符将大于 0
            hash[ch]++;
            // 存在字符时 移动 右边指针
            if (hash[ch] <= 0) cnt++;
            // 缩小左边指针, 左边指针超过 0 时有超过区间
            // 左边大于 0，不存在字符，或者 重复字符 缩减 左边指针
            while (l < r && hash[s.charAt(l)] > 0) {
                hash[s.charAt(l++)]--;
            }
            // cnt == t 字符大小时 更新最小值
            if (cnt == t.length() && len > r - l + 1) {
                len = r - l + 1;
                res = s.substring(l, r + 1);
            }
        }
        return res;
    }

    /**
     * 394 字符串解压
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     *
     * @param a
     */
    static int ptr = 0;

    public static String getString(String s) {
        if (ptr == s.length() || s.charAt(ptr) == ']') {
            return "";
        }
        char cur = s.charAt(ptr);
        int repTime;
        String ret = "";
        if (Character.isDigit(cur)) {

            repTime = getDigit(s);
            // 过滤左括号
            ++ptr;
            String str = getString(s);
            // 过滤右括号
            ++ptr;
            while (repTime-- > 0) {
                ret += str;
            }

        } else if (Character.isLetter(cur)) {
            ret = String.valueOf(s.charAt(ptr++));
        }
        return ret + getString(s);
    }

    public static int getDigit(String s) {
        int sum = 0;
        while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
            sum = sum * 10 + (s.charAt(ptr++) - '0');
        }
        return sum;
    }

    /**
     * 14 最长公共前缀
     *
     * @param avg
     * @throws InterruptedException
     */
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

    /**
     * 162. 寻找峰值
     * 限制时间复杂度 O(logN)
     *
     * @param
     */
    public static int findPeakElement(int[] nums) {

        return 0;
    }

    /**
     * 128  连续序列的长度
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        int longest = 0;

        for (int num : nums) {
            // 不包含 num - 1 ，即 num 是连续 序列的开头。
            //从每一个开头的元素去找
            if (!numsSet.contains(num - 1)) {
                int currentNum = num;
                int curLen = 1;
                while (numsSet.contains(currentNum + 1)) {
                    currentNum++;
                    curLen++;
                }

                longest = Math.max(longest, curLen);
            }
        }
        return longest;
    }

    /**
     * 中心扩散，边边界计算  start = i - （len-1)/2
     * <p>
     * end = i+len/2;
     * <p>
     * return  start,end+1;
     */

    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            }
            return right - left - 1;
        }
    }


    public static void main(String[] avg) throws InterruptedException {

        //System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(Arrays.toString(findAnagrams("fffabc", "abc").toArray()));

    }

}
