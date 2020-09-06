package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]*/
public class FindAllDuplicatesInAnArray {

	/*
	 * Runtime: 22 ms, faster than 23.59% of Java online submissions for Find All Duplicates in an Array.
	 * Memory Usage: 48.6 MB, less than 36.11% of Java online submissions for Find All Duplicates in an Array.
	 */
	public List<Integer> findDuplicates(int[] nums) {

		List<Integer> list  = new ArrayList<Integer>();
		Arrays.sort(nums);

		for(int i = 0; i < nums.length - 1; i++) {

			if(nums[i] == nums[i + 1]) {

				list.add(nums[i]);
			} else {

				continue;
			}
		}

		return list;
    }

	/*
	 * Runtime: 24 ms, faster than 17.44% of Java online submissions for Find All Duplicates in an Array.
	 * Memory Usage: 49 MB, less than 36.11% of Java online submissions for Find All Duplicates in an Array.
	 */
	public List<Integer> findDuplicates2(int[] nums) {

		List<Integer> list  = new ArrayList<Integer>();
		Arrays.sort(nums);

		int index = 0;
		while(index < nums.length - 1) {

			if(nums[index] == nums[index + 1]) {

				list.add(nums[index]);
				index += 2;
			} else {

				index += 1;
			}
		}

		return list;
    }

	/*
	 * Runtime: 20 ms, faster than 25.90% of Java online submissions for Find All Duplicates in an Array.
	 * Memory Usage: 53.2 MB, less than 25.00% of Java online submissions for Find All Duplicates in an Array.
	 */
	public List<Integer> findDuplicates3(int[] nums) {

		List<Integer> list  = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();

		for(int i : nums) {

			if(!set.add(i)) {

				list.add(i);
			}
		}

		return list;
    }

	/*
	 * Runtime: 4 ms, faster than 100.00% of Java online submissions for Find All Duplicates in an Array.
	 * Memory Usage: 47.2 MB, less than 94.44% of Java online submissions for Find All Duplicates in an Array.
	 */
	public List<Integer> findDuplicates4(int[] nums) {

		List<Integer> list  = new ArrayList<Integer>();
		int[] arr = new int[nums.length + 1];

		for(int i = 0; i < nums.length; i++) {

			arr[nums[i]]++;
		}

		for(int i = 0; i < arr.length; i++) {

			if(arr[i] == 2) {

				list.add(i);
			}
		}

		return list;
    }

	public static void main(String[] args) {

		int[] nums = {4,3,2,7,8,2,3,1};

		System.out.println(new FindAllDuplicatesInAnArray().findDuplicates3(nums));
	}
}
