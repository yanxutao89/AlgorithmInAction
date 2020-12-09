package others;

/**
 * Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).



Example 1:

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.


Constraints:

1 <= num <= 10^4
num's digits are 6 or 9.
 * @author Administrator
 *
 */
public class Maximum69Number {

	/**
	 * Runtime: 1 ms, faster than 62.57% of Java online submissions for Maximum 69 Number.
	 * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Maximum 69 Number.
	 * @param num
	 * @return
	 */
    public int maximum69Number (int num) {

    	StringBuffer sb = new StringBuffer();
    	boolean isFirst = false;
    	for (char c : String.valueOf(num).toCharArray()) {
    		if (!isFirst && c == '6') {
    			sb.append("9");
    			isFirst = true;
    		} else {
				sb.append(c);
			}
    	}

    	return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
		int num = 9669;
		System.out.println(new Maximum69Number().maximum69Number(num));
	}
}
