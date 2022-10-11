package com.exercise;


/**
 * 判断 字符串 A 中 是否 完全包含B
 */
public class AinB {

    /**
     *  方法一 轮询 b 判断是否 每个4字符 都在a 中N) （N*N)
     *
     */


    /**
     *
     * 方法二  为 a 的字符 每个分配一个 素数 2，3 ，5 ，7   同样为 B 每个元素 分配素数，
     *
     *
     * 分别计算 A B 乘积，  然后  用B 除 A  如果 有余数 戝为 false
     *
     * 因为  只有  b 是  a 的 子集  才能 结果为0N) （2*
     *
     *
     *
     */

    /**
     *
     *  方法三  a 散列 到hash 表  然后 轮询 b 就行了。（2 * N)
     *
     */

    /**
     * 方法四
     * <p>
     * 如何不使用 hash 表 怎么实现呢，
     * <p>
     * 这里就用到了 我最近看的  布鲁克隆的 移动位运算
     * <p>
     * <p>
     * 因为 我们long 是64 位  但是字母 只有 26个  所以可以将 字母通过 位预算 三列到 long 64 个 二进制位置
     * <p>
     * 写入A 字符串  hash =  （ 1<< strA[i] -'A'） 那么 第 i 个 bit 位置 就是 字符串A 了
     * <p>
     * 判断B 是否 在A 中 (（1<< StrB[j - 'A']）&&  hash  ) != 0 则 这个字符 在A 中
     */

    public boolean ainB(String A, String B) {

        return false;
    }
}
