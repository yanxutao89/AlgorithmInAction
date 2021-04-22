package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 */
public class TwoSum {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
     * Memory Usage: 38.8 MB, less than 96.57% of Java online submissions for Two Sum.
     */
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        Integer j;

        for(int i = 0; i < len; ++i) {
            j = map.get(target - nums[i]);
            if(null != j) {
                res[0] = i;
                res[1] = j;
                break;
            }
            map.put(nums[i], i);
        }

        return res;

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
     * Memory Usage: 38.9 MB, less than 77.93% of Java online submissions for Two Sum.
     */
    public int[] twoSum2(int[] nums,int target) {

        int[] res = new int[2];
        int len = nums.length;

        outer: for(int i = 0; i < len - 1; ++i) {
            for(int j = i + 1; j < len; ++j) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break outer;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 7, 15};
        int target = 22;
        System.err.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
        System.err.println(Arrays.toString(new TwoSum().twoSum2(nums, target)));
    }

}
