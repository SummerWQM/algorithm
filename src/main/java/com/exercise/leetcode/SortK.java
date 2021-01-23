package com.exercise.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * <p>
 * 返回前K 高的元素
 */
public class SortK {


    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        return nums;
    }

}
