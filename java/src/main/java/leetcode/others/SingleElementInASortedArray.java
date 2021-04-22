package others;

/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.



Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10


Note: Your solution should run in O(log n) time and O(1) space.*/
public class SingleElementInASortedArray {

	/*
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Element in a Sorted Array.
	 * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Single Element in a Sorted Array.
	 */
	public int singleNonDuplicate(int[] nums) {

		return bf(nums, 0, nums.length - 1);
    }

    public int bf(int[] nums, int s, int e) {

    	if(s == e) {
        	return nums[s];
        }

        int m = s + (e - s) / 2;

        if((m - s) % 2 == 1) {
            if(nums[m] == nums[m - 1]) {
                return bf(nums, m + 1, e);
            } else {
            	return bf(nums, s, m - 1);
			}
        } else {
            if(nums[m] == nums[m -1]) {
                return bf(nums, s, m);
            } else {
            	return bf(nums, m, e);
			}
		}
    }

	public static void main(String[] args) {

		int[] nums = {1,1,2,3,3,4,4,8,8};

		System.out.println(new SingleElementInASortedArray().singleNonDuplicate(nums));
	}
}
