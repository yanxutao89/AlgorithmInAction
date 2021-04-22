package dp;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 15:57
 */
public class MaxSubArrayDp implements Dp {

	public int maxSubArray(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		int pre = 0, maxAns = nums[0];
		for (int n : nums) {
			pre = Math.max(pre + n, n);
			maxAns = Math.max(maxAns, pre);
		}
		return maxAns;
	}

}
