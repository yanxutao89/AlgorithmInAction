package dp;

/**
 * 求最长回文子串。输入: "babad"，输出: "bab"。注意: "aba" 也是一个有效答案。
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 15:43
 */
public class LongestPalindromeDp implements Dp {

	public String longestPalindrome(String s) {
		int len = s.length();
		int[][] dp = new int[len][len];
		String res = "";
		for (int k = 0; k < len; ++k) {
			for (int i = 0; i + k < len; ++i) {
				int j = i + k;
				if (k == 0) {
					dp[i][j] = 1;
				} else if (k == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 0;
				} else {
					dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1 ? 1 : 0;
				}
				
				if (dp[i][j] == 1 && k + 1 > res.length()) {
					res = s.substring(i, k + 1);
				}
			}
		}
		return res;
	}

}
