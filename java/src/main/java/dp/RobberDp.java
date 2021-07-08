package dp;

/**
 * 强盗抢劫一排房间，每个房间都有钱，不能抢劫两个相邻的房间，要求抢的钱最多。数组如：[2,7,9,3,1]
 *
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/01 14:01
 */
public class RobberDp implements Dp {
    public int robber(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];
        for (int i = 2; i < len; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new RobberDp().robber(nums));
    }
}
