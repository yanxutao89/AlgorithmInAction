package others;
/**
 * There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group. Given the array groupSizes of length n telling the group size each person belongs to, return the groups there are and the people's IDs each group includes.

You can return any solution in any order and the same applies for IDs. Also, it is guaranteed that there exists at least one solution.



Example 1:

Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation:
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
Example 2:

Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]


Constraints:

groupSizes.length == n
1 <= n <= 500
1 <= groupSizes[i] <= n
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
	/**
	 * Runtime: 5 ms, faster than 86.57% of Java online submissions for Group the People Given the Group Size They Belong To.
	 * Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Group the People Given the Group Size They Belong To.
	 * @param groupSizes
	 * @return
	 */
	 public List<List<Integer>> groupThePeople(int[] groupSizes) {
	       List<List<Integer>> lists = new ArrayList<List<Integer>>();
	       Map<Integer, List<Integer>> map = new HashMap<>();
	       for(int i = 0; i < groupSizes.length; ++i) {
	    	   List<Integer> list = map.get(groupSizes[i]);
	    	   if(list == null) {
	    		   map.put(groupSizes[i], new ArrayList<>());
	    	   }
	    	   map.get(groupSizes[i]).add(i);
	       }

	       for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
	    	   if (entry.getKey().equals(entry.getValue().size())) {
	    		   lists.add(entry.getValue());
	    	   } else {
	    		   int count = entry.getValue().size() / entry.getKey();
	    		   for (int i = 0; i < count; ++i) {
	    			   lists.add(entry.getValue().subList(i * entry.getKey(), (i + 1) * entry.getKey()));
	    		   }
	    	   }
	       }

	       return lists;
	 }

	public static void main(String[] args) {
		int[] groupSizes = {2,1,3,3,3,2};
		System.out.println(new GroupThePeopleGivenTheGroupSizeTheyBelongTo().groupThePeople(groupSizes));
	}
}
