package others;

import java.util.Stack;

/*Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.



Example 1:

Input: "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".


Note:

1 <= S.length <= 20000
S consists only of English lowercase letters.*/
public class RemoveAllAdjacentDuplicatesInString {

	/*
	 * Runtime: 47 ms, faster than 50.31% of Java online submissions for Remove All Adjacent Duplicates In String.
	 * Memory Usage: 38.3 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
	 */
	public String removeDuplicates(String S) {

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();

		for(Character character : S.toCharArray()) {

			if(stack.isEmpty()) {

				stack.push(character);
			} else if(stack.peek() == character) {

				stack.pop();
			} else {

				stack.push(character);
			}
		}

		while(!stack.isEmpty()) {

			sb.append(stack.pop());
		}

		sb.reverse();

		return sb.toString();
    }

	public static void main(String[] args) {

		String S = "abbaca";

		System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates(S));
	}
}
