package others;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[len - 1], sum = 0;
        for(int i = 0; i < len - 2; i++){
            int lo = i + 1, hi = len - 1;
            while(lo < hi){
                sum = nums[lo] + nums[i] + nums[hi];
                if(sum > target){
                    hi--;
                }else{
                    lo++;
                }
                if(Math.abs(sum -target) < Math.abs(res - target))
                    res = sum;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int nums[] = {0, 2, 1, -3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
