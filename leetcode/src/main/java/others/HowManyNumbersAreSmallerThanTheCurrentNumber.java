package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.



Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]


Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100
 * @author Administrator
 *
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

	/**
	 * Runtime: 10 ms, faster than 50.37% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
	 * Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
	 * @param nums
	 * @return
	 */
    public int[] smallerNumbersThanCurrent(int[] nums) {

    	int[] counts = new int[nums.length];

    	for (int i = 0; i < nums.length; i++) {
    		getCount(i, counts, nums);
    	}

    	return counts;
    }

    private void getCount(int index, int[] counts, int[] nums) {

    	for (int i : nums) {
    		if (i < nums[index]) {
    			++counts[index];
    		}
    	}
    }

    /**
     * Runtime: 1 ms, faster than 99.64% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
     * Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent2(int[] nums) {

    	int[] counts = new int[101];
    	for (int i = 0; i < nums.length; i++) {
    		counts[nums[i]]++;
    	}

    	int count = 0;
    	int[] smaller = new int[101];
    	for (int i = 0; i < 101; i++) {
    		if(counts[i] == 0) {
    			continue;
    		}
    		smaller[i] = count;
    		count += counts[i];
    	}

    	int[] res = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		res[i] = smaller[nums[i]];
    	}

    	return res;
    }

    /**
     * Runtime: 17 ms, faster than 5.86% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
     * Memory Usage: 41.3 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent3(int[] nums) {

    	List<Integer> list = new ArrayList<Integer>(nums.length);
    	for (int num : nums) {
    		list.add(num);
    	}
    	Collections.sort(list);

    	for (int i = 0; i < nums.length; i++) {
    		nums[i] = list.indexOf(nums[i]);
    	}

    	return nums;
    }

    public static void main(String[] args) {

    	int[] nums = {8,1,2,2,3};
    	System.out.println(Arrays.toString(new HowManyNumbersAreSmallerThanTheCurrentNumber().smallerNumbersThanCurrent(nums)));
    	System.out.println(Arrays.toString(new HowManyNumbersAreSmallerThanTheCurrentNumber().smallerNumbersThanCurrent2(nums)));
    	System.out.println(Arrays.toString(new HowManyNumbersAreSmallerThanTheCurrentNumber().smallerNumbersThanCurrent3(nums)));
	}
}
