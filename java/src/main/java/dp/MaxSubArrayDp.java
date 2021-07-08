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

        int pre = 0, max = nums[0];
        for (int i = 1; i < len; ++i) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(new MaxSubArrayDp().maxSubArray(nums));
	}
}
