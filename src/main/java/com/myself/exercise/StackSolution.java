package com.myself.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 使用堆栈解决的问题
 * 1、二叉树层序遍历，右视图 ，左视图，
 * 2、数组中右边第一个 小于自己的
 * 3、字符串四则运算 etc.
 */
public class StackSolution {

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }

    /**
     * 括号是否有效
     */
    public static boolean logicStr(String str) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            // 是右括号就和栈顶比较， 弹出栈
            if (map.containsKey(str.charAt(i))) {
                // 弹出括号对
                char ele = stack.isEmpty() ? '#' : stack.pop();
                if (!map.get(str.charAt(i)).equals(ele)) {
                    return false;
                }
            } else {
                // 压入栈
                stack.push(str.charAt(i));
            }
        }
        //有效括号， 栈为空
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(logicStr("(){}{{{}}}}"));
    }
}
