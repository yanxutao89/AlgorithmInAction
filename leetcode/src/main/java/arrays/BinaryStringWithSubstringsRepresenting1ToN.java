package arrays;

/**
 * Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "0110", N = 3
 * Output: true
 * Example 2:
 *
 * Input: S = "0110", N = 4
 * Output: false
 *
 *
 * Note:
 *
 * 1 <= S.length <= 1000
 * 1 <= N <= 10^9
 */
public class BinaryStringWithSubstringsRepresenting1ToN {

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary String With Substrings Representing 1 To N.
	 * Memory Usage: 36.7 MB, less than 8.10% of Java online submissions for Binary String With Substrings Representing 1 To N.
	 * @param S
	 * @param N
	 * @return
	 */
	public boolean queryString(String S, int N) {

		for(int i = 1; i <= N; ++i) {
			if(!S.contains(Integer.toBinaryString(i))) {
				return false;
			}
		}

		return true;

    }

	public static void main(String[] args) {

		String S = "0110";
		int N = 4;
		System.out.println(new BinaryStringWithSubstringsRepresenting1ToN().queryString(S, N));
	}
}
