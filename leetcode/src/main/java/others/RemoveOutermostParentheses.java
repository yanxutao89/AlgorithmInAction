package others;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.



Example 1:

Input: "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".


Note:

S.length <= 10000
S[i] is "(" or ")"
S is a valid parentheses string*/

public class RemoveOutermostParentheses {

	/*
	 * Runtime: 13 ms, faster than 24.38% of Java online submissions for Remove Outermost Parentheses.
	 * Memory Usage: 39.2 MB, less than 5.19% of Java online submissions for Remove Outermost Parentheses.
	 */

	public static String removeOuterParentheses(String string) {

		StringBuffer sb = new StringBuffer();
		List<String> strings = toPrimitiveDecomposition(string);
		for(String string2 : strings) {

			sb.append(removeRightMost(string2));
		}

		return sb.toString();
    }

	private static String removeLeftMost(String string) {

		Deque<String> queue = new LinkedList<String>();
		Character character0 =  string.charAt(0);
		int count = 0;

		for(int i = 0; i < string.length(); i++) {

			Character character = string.charAt(i);
			if(i == 0) {

				count++;
				continue;
			} else {

				if(character.equals(character0)) {

					count++;
					queue.addLast(character.toString());
				} else {

					count--;
					if(count == 0) {

						queue.addLast(i + 1 > string.length() ? "" : string.substring(i + 1));

						StringBuffer sb = new StringBuffer();
						for(String string2 : queue) {

							sb.append(string2);
						}
						return sb.toString();
					} else {

						queue.addLast(character.toString());;
					}
				}
			}
		}

		return string;

	}

	private static String removeRightMost(String string) {

		Deque<String> queue = new LinkedList<String>();
		Character character0 =  string.charAt(string.length() - 1);
		int count = 0;

		for(int i = string.length() - 1; i > -1; i--) {

			Character character = string.charAt(i);
			if(i == string.length() - 1) {

				count++;
				continue;
			} else {

				if(character.equals(character0)) {

					count++;
					queue.addFirst(character.toString());
				} else {

					count--;
					if(count == 0) {

						queue.addFirst(i - 1 < 0 ? "" : string.substring(0, i));

						StringBuffer sb = new StringBuffer();
						for(String string2 : queue) {

							sb.append(string2);
						}
						return sb.toString();
					} else {

						queue.addFirst(character.toString());;
					}

				}
			}
		}

		return string;
	}

	private static List<String> toPrimitiveDecomposition(String string) {

		List<String> list = new ArrayList<String>();

		Character character0 = string.charAt(0);
		StringBuffer sb = new StringBuffer();
		sb.append(character0);
		int count = 0;

		for(int i = 0; i < string.length(); i++) {

			Character character = string.charAt(i);
			if(i == 0) {

				count++;
				continue;
			} else {

				sb.append(character);
				if(character.equals(character0)) {

					count++;
				} else {

					count--;
				}
			}

			if(count == 0) {

				list.add(sb.toString());
				sb = new StringBuffer();
			}
		}

		return list;
	}

	/*
	 * Runtime: 2 ms, faster than 97.57% of Java online submissions for Remove Outermost Parentheses.
	 * Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Remove Outermost Parentheses.
	 */
	public static String removeOuterParentheses2(String string) {

        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {

        	if(i == 0) {

        		continue;
        	}
        	if (string.charAt(i) == '(') {

        		sb.append(string.charAt(i));
                count++;
            } else {

            	if (count == 1) {

            		i++;
            	} else {

                	sb.append(string.charAt(i));
                    count--;
            	}
            }
        }

        return sb.toString();
    }

	public static void main(String[] args) {

		String string = "(()())(())(()(()))";
		System.out.println(removeOuterParentheses2(string));
	}
}
