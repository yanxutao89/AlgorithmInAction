package dp;

/**
 * 求一个数组中等差递减区间个数，等差数列必须是连续的。
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 15:38
 */
public class NumberOfArithmeticSlicesDp implements Dp {

	public int numberOfArithmeticSlices(int[] nums, int n) {
		int res = 0;
		int[] dp = new int[10];
		for (int i = 2; i < n; ++i) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				dp[i] = dp[i - 1] + 1;
			}
			res += dp[i];
		}
		return res;
	}
}
