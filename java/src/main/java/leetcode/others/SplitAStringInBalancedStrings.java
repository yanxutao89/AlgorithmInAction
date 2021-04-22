package others;

/*Balanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.



Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".


Constraints:

1 <= s.length <= 1000
s[i] = 'L' or 'R'*/
public class SplitAStringInBalancedStrings {

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
	 * Memory Usage: 37.6 MB, less than 100.00% of Java online submissions for Split a String in Balanced Strings.
	 * @param s
	 * @return
	 */
	public int balancedStringSplit(String s) {

		int lCount = 0;
		int rCount = 0;
		int matches = 0;
		for (char c : s.toCharArray()) {
			if ('L' == c) {
				lCount++;
			}
			if ('R' == c) {
				rCount++;
			}
			if (lCount == rCount) {
				matches++;
			}
		}

		return matches;
    }

	public static void main(String[] args) {

		String s = "RLRRLLRLRL";
		System.out.println(new SplitAStringInBalancedStrings().balancedStringSplit(s));
	}

}
