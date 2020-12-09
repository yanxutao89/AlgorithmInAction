package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.border.EmptyBorder;

/*Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?*/
public class SingleNumberIII {

	/*
	 * Runtime: 536 ms, faster than 5.02% of Java online submissions for Single Number III.
	 * Memory Usage: 39 MB, less than 93.33% of Java online submissions for Single Number III.
	 */
	public int[] singleNumber(int[] nums) {

		List<Integer> list = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();

		for(int i : nums) {

			if(!set.add(i)) {
				list.add(i);
			}
		}

		int[] res = new int[nums.length - (list.size() << 1)];
		int index = 0;
		for(int i : nums) {
			if(!list.contains(i)) {
				res[index++] = i;
			}
		}

		return res;
    }

	/*
	 * Runtime: 6 ms, faster than 17.71% of Java online submissions for Single Number III.
	 * Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Single Number III.
	 */
	public int[] singleNumber2(int[] nums) {

		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {

			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				list.add(entry.getKey());
			}
		}

		int[] res = new int[list.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}

		return res;
    }

	public int[] singleNumber3(int[] nums) {

		List<Integer> list = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();

		for(int i : nums) {

			if(!set.add(i)) {
				list.add(i);
			}
		}

		int[] res = new int[nums.length - (list.size() << 1)];
		int index = 0;
		for(int i : nums) {
			if(!list.contains(i)) {
				res[index++] = i;
			}
		}

		return res;
    }

	public static void main(String[] args) {

		int[] nums = {1403617094,-490450406,-1756388866,-967931676,1878401007,1878401007,-74743538,1403617094,-1756388866,-74743538,-490450406,-1895772685};

		System.out.println(Arrays.toString(new SingleNumberIII().singleNumber3(nums)));
	}
}
