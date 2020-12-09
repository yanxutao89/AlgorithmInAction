package others;

import java.util.*;

/**
 * Given a sorted array nums,
 * remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, y
 * ou must do this by modifying the input array in-place with O(1) extra memory.
 */

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int index, count = 0;
        for(int i = 0; i < nums.length; i = index){
            index = i + 1;
            while(index < nums.length){
                if(nums[i] != nums[index]){
                    nums[++count] = nums[index];
                    break;
                }
                else
                    index++;
            }
            if(index == nums.length - 1){
                nums[count] = nums[index];
                return count + 1;
            }

        }
        return count + 1;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
