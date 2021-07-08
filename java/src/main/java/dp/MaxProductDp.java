package dp;

/**
 * 输入一个整形数组，数组里有正数也有负数。数组中连续的一个，或多个整数组成一个子数组，每个子数组都有一个和。求所有子数组的和的最大值。
 *
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 14:28
 */
public class MaxProductDp implements Dp {
    public int maxProduct(int[] nums) {
		int length = nums.length;
		int[] maxes = new int[length];
        int[] mines = new int[length];

        for (int i = 1, len = length; i < len; ++i) {
            maxes[i] = Math.max(maxes[i - 1] * nums[i], Math.max(nums[i], mines[i - 1] * nums[i]));
            mines[i] = Math.min(mines[i - 1] * nums[i], Math.max(nums[i], maxes[i - 1] * nums[i]));
        }
        return maxes[length - 1];
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(new MaxProductDp().maxProduct(nums));
	}
}
