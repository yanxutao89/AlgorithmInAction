package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]*/
public class Permutations {

	/*
	 * Runtime: 1 ms, faster than 97.64% of Java online submissions for Permutations.
	 * Memory Usage: 38.1 MB, less than 78.72% of Java online submissions for Permutations.
	 */
	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
	    if(nums.length <= 1) {

	    	res.add(new ArrayList<>(Arrays.asList(nums[0])));
	    } else {
	        int target = nums[nums.length - 1];
	        List<List<Integer>> temp = permute(Arrays.copyOfRange(nums, 0, nums.length - 1));
	        while(!temp.isEmpty()){
	            List<List<Integer>> k = new ArrayList<>();
	            permuteAdd(k, temp.remove(0), target);
	            res.addAll(k);
	        }
	    }

	    return res;
	}

	public void permuteAdd(List<List<Integer>> k, List<Integer> list, int target){
	    int pos = 0;
	    while(pos <= list.size()){
	        List<Integer> u = new ArrayList<>(list);
	        u.add(pos, target);
	        k.add(u);
	        pos = pos + 1;
	    }
	}

	public static void main(String[] args) {

		int[] nums = {1,2,3};

		System.out.println(new Permutations().permute(nums));
	}
}
