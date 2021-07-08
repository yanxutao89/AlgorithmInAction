package leetcode.strings;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int[] dp = new int[chars.length];

        int count = 0;
        int delta = 0;
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (c == '(') {
                stack.push(c);
                if (stack.isEmpty()) {
                    count += delta;
                    delta = 0;
                }
            }
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    delta += 2;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        String s = "()(()";
        System.out.println(new LongestValidParentheses().longestValidParentheses(s));
    }
}
