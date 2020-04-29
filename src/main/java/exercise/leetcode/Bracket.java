package exercise.leetcode;

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
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Bracket() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            // 如果是闭合区间
            if (this.mappings.containsKey(c)) {
                char ele = stack.empty() ? '#' : stack.pop();
                // 栈中元素 不等于 开括号
                if (ele != this.mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }
}