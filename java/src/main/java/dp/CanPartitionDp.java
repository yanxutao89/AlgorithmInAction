package dp;

/**
 * 输入：[1, 5, 11, 5]， 输出：[1, 5, 5]和[11]
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 14:21
 */
public class CanPartitionDp implements Dp {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0, len = nums.length; i < len; ++i) {
			sum += nums[i];
		}
		if ((sum & 1) == 1) {
			return false;
		}

		int target = sum >> 1;
		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		for (int i = 0, len = nums.length; i < len; ++i) {
			for (int j = target; j >= nums[i]; --j) {
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		int[] nums = {1, 5, 11, 5, 2, 6};
		System.out.println(new CanPartitionDp().canPartition(nums));
	}
}
