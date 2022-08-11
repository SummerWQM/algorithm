//package com.exercise.leetcode;
//
//import java.util.*;
//
//public class MaxSlidingWindow {
//
//
//    public static void main(String[] avg) {
//
//
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        priorityQueue.add(4);
//        priorityQueue.add(3);
//        priorityQueue.add(35);
//        priorityQueue.add(8);
////
////        String b;
////
////
////        StringBuilder sb = new StringBuilder();
////
////        sb.reverse().toString()
////
////        Arrays.sort(;);
////        System.out.println(priorityQueue.peek());
////
//
//    }
//
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length < 2) {
//            return nums;
//        }
//        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
//        LinkedList<Integer> queue = new LinkedList();
//        // 结果数组
//        int[] result = new int[nums.length - k + 1];
//        // 遍历nums数组
//        for (int i = 0; i < nums.length; i++) {
//            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
//            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
//                queue.pollLast();
//            }
//            // 添加当前值对应的数组下标
//            queue.addLast(i);
//            // 判断当前队列中队首的值是否有效
//
//            // 队首的值，一定是 在   0 < =  0 -3
//
//            if (queue.peek() <= i - k) {
//                queue.poll();
//            }
//            // 当窗口长度为k时 保存当前窗口中最大值
//            if (i + 1 >= k) {
//                result[i + 1 - k] = nums[queue.peek()];
//            }
//        }
//        return result;
//    }
//
//
//    class Solution {
//        public List<List<Integer>> threeSum(int[] nums) {
//
//            List<List<Integer>> resut = new ArrayList();
//            if(nums==null || nums.length==0) {
//                return resut;
//            }
//
//            Arrays.sort(nums);
//
//            for(int k=0;k<nums.length-2;k++) {
//
//                if(nums[k]>0) {
//                    return resut;
//                }
//
//                if(k>0 && nums[k]==nums[k+1]) {
//                    continue;
//                }
//
//                int l=k+1,r=nums.lenght-1, sum = 0-nums[k];
//
//
//                while(l<r) {
//                    int toal = nums[i]+nums[j];
//                    if(toal==sum) {
//                        resut.add(Arrays.asList(nums[k],nums[l],nums[r]));
//
//                        while(l<r && nums[l]==nums[l+1]) {
//                            l++;
//                        }
//                        while(l<r && nums[r]==nums[r-1]) {
//                            r--;
//                        }
//                        l++;
//                        r--;
//                    }else if(toal<sum) {
//                        l++;
//                    }else {
//                        r--;
//                    }
//
//                }
//
//                return resut;
//
//            }
//
//String b ;
//
//            Character
//
//
//        }
//    }
//
//}
//
//
