package others;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 */

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if(nums == null || len <= 2 || nums[0] > 0 || nums[len - 1] < 0)
            return res;
        for(int i = 2; i < len; i++){
            if(nums[0] + nums[1] + nums[i] == 0){
                int[] arr = {nums[0], nums[1], nums[i]};
                Arrays.sort(arr);
                res.add(Arrays.asList(arr[0], arr[1], arr[2]));
            }
        }
        for(int i = 0; i < len - 2; i++){
            if(nums[len - 1] + nums[len - 2] + nums[i] == 0) {
                int[] arr = {nums[len - 1], nums[len - 2], nums[i]};
                Arrays.sort(arr);
                res.add(Arrays.asList(arr[0], arr[1], arr[2]));
            }
        }
        for(int i = 2; i < len - 2 ; i++){
            int left = i - 1, right = i + 1;
            while(left > 1 && right < len - 1){
                int tmp = nums[left] + nums[right];
                if(tmp == - nums[i]){
                    int[] arr1 = {nums[left], nums[i], nums[right]};
                    Arrays.sort(arr1);
                    res.add(Arrays.asList(arr1[0], arr1[1], arr1[2]));
                    int neighbor = nums[left--] + nums[right++];
                    if(neighbor == - nums[i]){
                        int[] arr2 = {nums[left], nums[i], nums[right]};
                        Arrays.sort(arr2);
                        res.add(Arrays.asList(arr2[0], arr2[1], arr2[2]));
                    }else if(neighbor > - nums[i]){
                            left--;
                    }else {
                        right++;
                    }
                } else if(tmp > - nums[i]){
                    left--;
                } else{
                    right++;
                }
            }
        }
        Set set = new HashSet<>();
        set.addAll(res);
        res.clear();
        res.addAll(set);
        return res;
    }
    public static List<List<Integer>> threeSum1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1])
                            lo++;
                        while (lo < hi && num[hi] == num[hi-1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum)
                        lo++;
                    else
                        hi--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum1(nums).toArray()));
    }
}
