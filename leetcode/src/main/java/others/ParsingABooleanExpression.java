package others;

import java.util.Stack;

/*Return the result of evaluating a given boolean expression, represented as a string.

An expression can either be:

"t", evaluating to True;
"f", evaluating to False;
"!(expr)", evaluating to the logical NOT of the inner expression expr;
"&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
"|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...


Example 1:

Input: expression = "!(f)"
Output: true
Example 2:

Input: expression = "|(f,t)"
Output: true
Example 3:

Input: expression = "&(t,f)"
Output: false
Example 4:

Input: expression = "|(&(t,f,t),!(t))"
Output: false


Constraints:

1 <= expression.length <= 20000
expression[i] consists of characters in {'(', ')', '&', '|', '!', 't', 'f', ','}.
expression is a valid expression representing a boolean, as given in the description.*/
public class ParsingABooleanExpression {

	/*
	 * Runtime: 29 ms, faster than 6.88% of Java online submissions for Parsing A  Boolean Expression.
	 * Memory Usage: 38.1 MB, less than 100.00% of Java online submissions for Parsing A Boolean Expression.
	 */
	public boolean parseBoolExpr(String expression) {

		boolean res = false;
		Stack<Character> stack = new Stack<Character>();

		for(char c : expression.toCharArray()) {

			if(')' == c) {

				StringBuffer sb = new StringBuffer(")");
				while('(' != stack.peek()) {

					sb.append(stack.pop());
				}
				sb.append(stack.pop());
				sb.append(stack.pop());

				res = parse(sb.reverse().toString());
				stack.push(res == true ? 't' : 'f');
			} else {
				stack.push(c);
			}
		}

		return res;
    }

	private boolean parse(String string) {

		if(string.length() == 1) {

			return "t".equals(string) ? true : false;
		} else if(string.length() == 4) {

			if("!".equals(string.substring(0, 1))) {
				return "t".equals(string.substring(2, 3)) ? false : true;
			} else {
				return "t".equals(string.substring(2, 3)) ? true : false;
			}
		} else {

			String str = string.substring(string.indexOf("(") + 1, string.lastIndexOf("") - 1);
			String[] arr = str.split(",");
			boolean[] boo = new boolean[arr.length];

			for(int i = 0; i < arr.length; i++) {

				if(arr[i].length() == 1) {
					boo[i] = "t".equals(arr[i]) ? true : false;
				} else {
					if("!".equals(arr[i].substring(0, 1))) {
						return "t".equals(arr[i].substring(2, 3)) ? false : true;
					} else {
						return "t".equals(arr[i].substring(2, 3)) ? true : false;
					}
				}
			}

			boolean b = boo[0];
			if("&".equals(string.substring(0, 1))) {
				for(int i = 1; i < arr.length; i++) {

					b &= boo[i];
				}
			} else {
				for(int i = 1; i < arr.length; i++) {

					b |= boo[i];
				}
			}

			return b;
		}
	}

	public static void main(String[] args) {

		String expression = "!(&(!(&(f)),&(t),|(f,f,t)))";

		System.out.println(new ParsingABooleanExpression().parseBoolExpr(expression));
	}

}
