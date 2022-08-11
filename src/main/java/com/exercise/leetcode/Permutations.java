package com.exercise.leetcode;


import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 全排列
 * https://leetcode.cn/problems/permutations/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];

        dfs(nums, len, 0, path, used, res);
        return res;
    }


    /**
     * 深度优先遍历
     *
     * @param nums   树的元素
     * @param len    数的节点个数
     * @param depath 当前数的深度层级
     * @param path   记录当前树分支所有节点
     * @param used   当前节点 是否 已经在当前树种被使用
     * @param res    所有的结果集
     */
    private void dfs(int[] nums, int len, int depath, Deque<Integer> path, boolean[] used
            , List<List<Integer>> res) {

        if (depath == len) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            //记录当前节点的数
            path.addLast(nums[i]);

            //标记已使用
            used[i] = true;
            // 进入下一层
            dfs(nums, len, depath + 1, path, used, res);

            // 撤销当前节点的使用， 以便在其他depath 中可以继续使用
            path.removeLast();
            // 撤销使用状态
            used[i] = false;
        }

    }

    public static void main(String[] avg) {


//        String s = "abc";
//
//        System.out.println(s.substring(0, 3));
//
//        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//
//
//        Map<Character, Character> hashMap = new HashMap<Character, Character>() {{
//
//
//            put(")", "(");
//
//        }};
//
//
//        List<int[]> merged = new ArrayList<>();
//
//
//        for (int i = 0; i <)
//
//
//            Deque<Character> stack = new LinkedList<>();


//        List<List<Integer>> res = per.permute(nums);
//
//        res.forEach(
//                (i) -> {
//
//                    Gson gson = new Gson();
//                    System.out.println(gson.toJson(i));
//
//                }
//        );

        String s = "abba";
        int maxLen = Integer.MIN_VALUE;


        int start = 0, end = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (end = 0; end < s.length(); end++) {
            if (map.get(s.charAt(end)) != null) {
                maxLen = Math.max(maxLen, end - start);
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end - start + 1);

        }
        System.out.println(Math.max(maxLen, end - start + 1));

        Queue<TreeNode> queue = new LinkedList<>();

    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }

        });


        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }

        res.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }


    public List<Integer> topK(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 排序桶
        List<Integer>[] list = new List[nums.length + 1];

        for (Integer key : map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }


        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) {
                continue;
            }
            res.addAll(list[i]);
        }

        return res;


    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        List<int[]> merged = new ArrayList<>();


        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];

            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {

                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1],
                        R);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }


    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            Deque<Integer> deque = new LinkedList<Integer>();


            for (int i = 0; i < k; ++i) {
                //不会为 并且 当前  nums[i] > 最后一个 就删除 最后一个
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                // 加入索引
                deque.offerLast(i);
            }


            int[] ans = new int[n - k + 1];


            ans[0] = nums[deque.peekFirst()];

            for (int i = k; i < n; ++i) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
            return ans;
        }
    }






}
