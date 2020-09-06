package others;

/**
 * Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.

The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.



Example 1:

Input: n = 4
Output: "pppz"
Explanation: "pppz" is a valid string since the character 'p' occurs three times and the character 'z' occurs once. Note that there are many other valid strings such as "ohhh" and "love".
Example 2:

Input: n = 2
Output: "xy"
Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once. Note that there are many other valid strings such as "ag" and "ur".
Example 3:

Input: n = 7
Output: "holasss"


Constraints:

1 <= n <= 500
 * @author Administrator
 *
 */
public class GenerateAStringWithCharactersThatHaveOddCounts {

	/**
	 * Runtime: 1 ms, faster than 68.21% of Java online submissions for Generate a String With Characters That Have Odd Counts.
	 * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Generate a String With Characters That Have Odd Counts.
	 * @param n
	 * @return
	 */
	public String generateTheString(int n) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n - 1; i++) {
			sb.append("x");
		}
		if ((n & 1) == 1) {
			sb.append("x");
		} else {
			sb.append("t");
		}

		return sb.toString();
    }

	public static void main(String[] args) {
		int n = 5;
		System.out.println(new GenerateAStringWithCharactersThatHaveOddCounts().generateTheString(n));
	}
}
