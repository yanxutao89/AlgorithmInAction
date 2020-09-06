package others;

import java.util.Stack;

/*Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

*Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6


Note:

S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50
*
*/
public class ScoreOfParentheses {

	/*
	 * Runtime: 1 ms, faster than 61.61% of Java online submissions for Score of Parentheses.
	 * Memory Usage: 33.9 MB, less than 100.00% of Java online submissions for Score of Parentheses.
	 */
	public int scoreOfParentheses(String S) {

		Stack<Integer> stack = new Stack<Integer>();
        int ans = 0;

        for(char c : S.toCharArray()){
            if(c == '(') {
            	stack.push(0);
            } else{
                if(stack.peek()==0){
                    stack.pop();
                    stack.push(1);
                    continue;
                }

                int temp = 0;
                while(!stack.isEmpty() && stack.peek()!=0){
                    temp += stack.pop();
                }
                stack.pop();
                stack.push(2 * temp);
            }
        }

        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        return ans;
    }

	public static void main(String[] args) {

		String S = "()";

		System.out.println(new ScoreOfParentheses().scoreOfParentheses(S));
	}
}
