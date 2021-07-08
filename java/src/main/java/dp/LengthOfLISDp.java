package dp;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 15:52
 */
public class LengthOfLISDp implements Dp {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[10];

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; ++i) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

	public static void main(String[] args) {
		int[] nums = {};
		System.out.println(new LengthOfLISDp().lengthOfLIS(nums));
	}
}
