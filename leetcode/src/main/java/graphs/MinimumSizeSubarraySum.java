package graphs;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/09/07 11:04
 */
public class MinimumSizeSubarraySum {

	/**
	 * Runtime: 92 ms, faster than 9.22% of Java online submissions for Minimum Size Subarray Sum.
	 * Memory Usage: 39.7 MB, less than 56.16% of Java online submissions for Minimum Size Subarray Sum.
	 * @param s
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int s, int[] nums) {

		int min = Integer.MAX_VALUE;

		for (int start = 0; start < nums.length; ++start) {
			int sum = 0;
			for (int i = start; i < nums.length; ++i) {
				sum += nums[i];
				if (sum >= s) {
					min = Math.min(min, i + 1 - start);
					break;
				}
			}
			if (sum < s) {
				return min == Integer.MAX_VALUE ? 0 : min;
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;

	}

	public int minSubArrayLen2(int s, int[] nums) {

		int min = Integer.MAX_VALUE;

		return min == Integer.MAX_VALUE ? 0 : min;

	}

	private void dfs(int start, int offset, int s, int[] nums, int sum) {

		int index = start + offset;
		if (index == nums.length) {
			return;
		}

		sum += nums[index];

		dfs(start, offset + 1, s, nums, sum);

	}

	public static void main(String[] args) {
		int s = 11;
		int[] nums = {1,2,3,4,5};
		System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s, nums));
	}

}
