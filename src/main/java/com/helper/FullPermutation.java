package com.helper;

import java.util.ArrayList;
import java.util.List;

public class AllRange {

    public static <T> List<List<T>> getSingleFullPermutation(List<T> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<T>> resultlist = new ArrayList<>();
        arrange(resultlist, list, 0, list.size());
        return resultlist;
    }



    private static <T> void arrange(List<List<T>> resultlist, List<T> list, Integer start, Integer end) {
        if (start == end - 1) {
            // 将当前数组加到结果集中
            resultlist.add(new ArrayList<>(list));
            return;
        }

        // 将当前位置的数跟后面的数交换，并搜索解
        for (int i = start; i < end; i++) {
            swap(list, start, i);
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

        System.out.println(AllRange.getSingleFullPermutation(arr));
    }
}
