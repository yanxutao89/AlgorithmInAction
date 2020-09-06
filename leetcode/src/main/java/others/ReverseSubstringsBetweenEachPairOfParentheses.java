package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.



Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"


Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
*/
public class ReverseSubstringsBetweenEachPairOfParentheses {

	/*
	 * Runtime: 2 ms, faster than 64.54% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
	 * Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Reverse Substrings Between Each Pair of Parentheses.
	 */
	public String reverseParentheses(String s) {

		Stack<StringBuilder> stack = new Stack<StringBuilder>();

		s = "(" + s + ")";

		for(int i = 0; i < s.length(); i++) {

			Character c = s.charAt(i);
			if(')' == c) {
				if(i != s.length() - 1) {
					String string = stack.pop().reverse().toString();
					if(!stack.isEmpty()) {

						stack.peek().append(string);
					}
				}
			} else if('(' == c){

				StringBuilder sb = new StringBuilder();
				stack.push(sb);
			} else {

				stack.peek().append(c);
			}
		}

		return stack.pop().toString();
    }

	public static void main(String[] args) {

		String s = "a(bcdefghijkl(mno)p)q";

		System.out.println(new ReverseSubstringsBetweenEachPairOfParentheses().reverseParentheses(s));
	}
}
