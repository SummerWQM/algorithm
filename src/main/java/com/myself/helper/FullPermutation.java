package com.myself.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * a
 * 全排列 交换写法， 不使用 标记位 boolean[] 数组
 */
public class FullPermutation {

    public static <T> List<List<T>> getSingleFullPermutation(List<T> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<T>> resultlist = new ArrayList<>();
        arrange(resultlist, list, 0, list.size());
        return resultlist;
    }


    private static <T> void arrange(List<List<T>> resultlist, List<T> list, Integer start, Integer end) {
        // 走到最后一个元素
        if (start == end - 1) {
            // 将当前数组加到结果集中
            resultlist.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < end; i++) {
            swap(list, start, i);
            System.out.println(list);
            arrange(resultlist, list, start + 1, end);
            swap(list, start, i);
        }

    }

    // 交换元素位置
    private static <T> void swap(List<T> list, Integer i, Integer j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    public static void main(String[] s) {

        List<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);

        System.out.println(FullPermutation.getSingleFullPermutation(arr));
    }
}
