package com.exercise.leetcode;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/comments/
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArraySolution {


    /**
     * 双指针发 i 是奇数位置  j 是偶数位置
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        // 偶数位置
        int j = 1;
        // 扫描 奇数位置，
        for (int i = 0; i < A.length - 1; i = i + 2) {
            // 如果不是奇数
            if ((A[i] & 1) != 0) {
                // 那么 偶数位置一定 有奇数， loop 找偶数位置，然后 交换。  奇数和偶数位置的值。
                // 继续扫描 下一个 奇数位置
                while ((A[j] & 1) != 0) {
                    j = j + 2;
                }

                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
