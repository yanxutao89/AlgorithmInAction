package others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * @author Dell
 *
 */
public class TwoSum {

    /**
     * improved method -- HashMap
     * @param nums
     * @param target
     * @return
     * Runtime: 2 ms, faster than 99.72% of Java online submissions for Two Sum.
     * Memory Usage: 39.2 MB, less than 22.95% of Java online submissions for Two Sum.
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            Integer temp = target - nums[i];
            if(map.containsKey(temp)) {

                res[0] = i;
                res[1] = map.get(temp);
                return res;
            }
            map.put(nums[i], i);
        }

        return res;
    }

    /**
     * traditional method -- double foreach
     * @param nums
     * @param target
     * @return
     * Runtime: 60 ms, faster than 5.26% of Java online submissions for Two Sum.
     * Memory Usage: 38.4 MB, less than 58.40% of Java online submissions for Two Sum.
     */
    public static int[] twoSum2(int[] nums,int target) {

        int res[] = new int[2];

        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i + 1; j < nums.length; j++) {

                if(nums[i] + nums[j] == target)
                    res = new int[]{i,j};
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums= {1, 2, 7, 15};
        int target=22;
        System.err.println(Arrays.toString(twoSum2(nums, target)));
    }

}
