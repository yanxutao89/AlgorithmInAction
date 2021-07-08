package dp;

/**
 * 求最长回文子串。输入: "babad"，输出: "bab"。注意: "aba" 也是一个有效答案。
 *
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 15:43
 */
public class LongestPalindromeDp implements Dp {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        String res = "";
        char[] chars = s.toCharArray();

        for (int k = 0; k < len; ++k) {
            for (int i = 0; i + k < len; ++i) {
                int j = i + k;
                if (k == 0) {
                    dp[i][j] = 1;
                }
                else if (k == 1) {
                    dp[i][j] = chars[i] == chars[j] ? 1 : 0;
                }
                else {
                    dp[i][j] = chars[i] == chars[j] && dp[i + 1][j - 1] == 1 ? 1 : 0;
                }

                if (dp[i][j] == 1 && k + 1 > res.length() && (k + 1 - i) > 0) {
                    res = s.substring(i, k + 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "上海自来水来自海上aaaaaaaaaaaaaaaaa";
        System.out.println(new LongestPalindromeDp().longestPalindrome(s));
    }
}
