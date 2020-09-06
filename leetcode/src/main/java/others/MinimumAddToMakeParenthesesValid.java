package others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.



Example 1:

Input: "())"
Output: 1
Example 2:

Input: "((("
Output: 3
Example 3:

Input: "()"
Output: 0
Example 4:

Input: "()))(("
Output: 4


Note:

S.length <= 1000
S only consists of '(' and ')' characters.*/
public class MinimumAddToMakeParenthesesValid {

	/*
	 * Runtime: 3 ms, faster than 5.48% of Java online submissions for Minimum Add to Make Parentheses Valid.
	 * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
	 */
	 public int minAddToMakeValid(String S) {

		 int left = 0, right = 0, valid = 0;
		 Stack<Character> stack = new Stack<Character>();

		 for(int i = 0; i < S.length(); i++) {

			 if(S.charAt(i) == ')') {
				 if(!stack.isEmpty() && stack.pop() == '(') {

					 continue;
				 } else {

					 left++;
				}
			 }

			 if(S.charAt(i) == '(') {

				 stack.push(S.charAt(i));
			 }
		 }

		 for(int i = S.length() - 1; i > -1; i--) {

			 if(S.charAt(i) == '(') {
				 if(!stack.isEmpty() && stack.pop() == ')') {

					 continue;
				 } else {

					 right++;
				}
			 }

			 if(S.charAt(i) == ')') {

				 stack.push(S.charAt(i));
			 }
		 }

		 return left + right;
	 }

	/*
	 * Runtime: 2 ms, faster than 39.16% of Java online submissions for Minimum Add to Make Parentheses Valid.
	 * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
	 */
	 public int minAddToMakeValid2(String S) {

		 int min = 0;
		 Stack<Character> stack = new Stack<Character>();

		 for(int i = 0; i < S.length(); i++) {

			 if(S.charAt(i) == ')') {
				 if(!stack.isEmpty() && stack.pop() == '(') {

					 continue;
				 } else {

					 min++;
				}
			 }

			 if(S.charAt(i) == '(') {

				 stack.push(S.charAt(i));
			 }
		 }

		 return min + stack.size();
	 }

	/*
	 * Runtime: 1 ms, faster than 47.29% of Java online submissions for Minimum Add to Make Parentheses Valid.
	 * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
	 */
	 public int minAddToMakeValid3(String S) {

		 int min = 0;
		 Queue<Character> queue = new LinkedList<Character>();

		 for(int i = 0; i < S.length(); i++) {

			 Character character = S.charAt(i);
			 if(character == ')') {
				 if(!queue.isEmpty() && queue.poll() == '(') {

					 continue;
				 } else {

					 min++;
				}
			 }

			 if(character == '(') {

				 queue.offer(character);
			 }
		 }

		 return min + queue.size();
	 }

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
	 * Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
	 */
	 public int minAddToMakeValid4(String S) {

		 int left = 0, right = 0;

		 for(char c : S.toCharArray()) {

			 if(c == ')') {

				 if(left > 0) {

					 left--;
				 } else {

					 right++;
				}
			 }  else {

				 left++;
			}
		 }

		 return left + right;
	 }

	 public static void main(String[] args) {

		 String S = "()))((";
		 System.out.println(new MinimumAddToMakeParenthesesValid().minAddToMakeValid4(S));
	 }
}
