package com.myself.exercise.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ https://leetcode-cn.com/problems/valid-parentheses/submissions/
 * {[()]} true
 * [(]) false;
 * ()[]{} true
 */
class Bracket {

    // Hash table that takes care of the mappings.
    private static HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    static {
        mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (mappings.containsKey(s.charAt(i))) {

                char ele = stack.isEmpty() ? '#' : stack.pop();

                if (ele != mappings.get(s.charAt(i))) {
                    return false;
                }


            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] avg) {
        System.out.println(isValid("(){}{{{}}}"));
    }
}