package dp;

/**
 * 输入：[1, 5, 11, 5]， 输出：[1, 5, 5]和[11]
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 14:21
 */
public class CnaPartitionDp implements Dp {

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0, len = nums.length; i < len; ++i) {
			sum += nums[i];
		}

		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;

		boolean[] dp = new boolean[target + 1];
		dp[0] = true;

		for (int i = 0, len = nums.length; i < len; ++i) {
			for (int j = target; j >= nums[i]; --j) {
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}

		return dp[target];
	}
}
