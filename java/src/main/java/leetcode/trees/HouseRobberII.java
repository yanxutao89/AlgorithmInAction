package trees;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 3:
 *
 * Input: nums = [0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/11/30 10:13
 */
public class HouseRobberII {

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
	 * Memory Usage: 36.5 MB, less than 30.76% of Java online submissions for House Robber II.
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		int len = nums.length;
		if(len == 0) {
			return 0;
		}
		if(len == 1) {
			return nums[0];
		}
		if(len == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] dp = new int[len];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < len - 1; i++){
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		int ans1 = dp[len - 2];

		dp = new int[len];
		dp[1] = nums[1];
		dp[2] = Math.max(nums[1], nums[2]);
		for(int i = 3; i < len; i++){
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		int ans2 = dp[len - 1];

		return Math.max(ans1, ans2);
	}

	public static void main(String[] args) {
		int[] nums = {2, 3, 2};
		System.out.println(new HouseRobberII().rob(nums));
	}
}
