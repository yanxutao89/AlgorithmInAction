package others;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c,
 * and d in nums such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if(len < 4)
            return res;
        if(len == 4){
            if(nums[0] + nums[1] + nums[2] + nums[3] == target)
                res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return res;
        }

        for(int i = 0; i < len - 3; i++){
            for(int j = i+1; j < len - 2; j++){
                int tmp = target - nums[i] - nums[j];
                System.out.println(tmp);
                if(nums[j] != nums[j - 1]){
                    int lo = j + 1, hi = len -1;
                    System.err.println("lo " + lo + ";" + "hi " + hi);
                    while(lo < hi ){
                        int sum = nums[lo] + nums[hi];
                        System.err.println(sum);
                        if(sum == tmp){
                            res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                            while(lo < hi && nums[lo] == nums[lo + 1])
                                lo++;
                            while(lo < hi && nums[hi] == nums[hi - 1])
                                hi--;
                            lo++;
                            hi--;
                        }else if(sum < tmp){
                            lo++;
                        }else{
                            hi--;
                        }
                    }
                }
            }
        }
        Set<List<Integer>> set =new HashSet<>();
        set.addAll(res);
        res.clear();
        res.addAll(set);
        return res;
    }
    public static void main(String[] args){
        int[] nums = {-1,-1,0,1,2};
        int  target = - 1;
        System.out.println(fourSum(nums, target));
    }
}
