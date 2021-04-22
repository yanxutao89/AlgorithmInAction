package others;

import java.util.HashMap;
import java.util.Map;

/*We have a set of items: the i-th item has value values[i] and label labels[i].

Then, we choose a subset S of these items, such that:

|S| <= num_wanted
For every label L, the number of items in S with label L is <= use_limit.
Return the largest possible sum of the subset S.



Example 1:

Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
Output: 9
Explanation: The subset chosen is the first, third, and fifth item.
Example 2:

Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
Output: 12
Explanation: The subset chosen is the first, second, and third item.
Example 3:

Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
Output: 16
Explanation: The subset chosen is the first and fourth item.
Example 4:

Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
Output: 24
Explanation: The subset chosen is the first, second, and fourth item.


Note:

1 <= values.length == labels.length <= 20000
0 <= values[i], labels[i] <= 20000
1 <= num_wanted, use_limit <= values.length*/
public class LargestValuesFromLabels {

	/*
	 * Runtime: 1162 ms, faster than 5.07% of Java online submissions for Largest Values From Labels.
	 * Memory Usage: 50.4 MB, less than 100.00% of Java online submissions for Largest Values From Labels.
	 */
	public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

		for(int i = 0; i < values.length; i++) {
			for(int j = i + 1; j < values.length; j++) {
				if (values[i] < values[j]) {
		            int temp = values[i];
		            int temp2 = labels[i];
		            values[i] = values[j];
		            labels[i] = labels[j];
		            values[j] = temp;
		            labels[j] = temp2;
		        }
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		for(int i = 0; i < values.length; i++) {

			if(map.containsKey(labels[i]) && map.get(labels[i]) != use_limit) {
				int pc = map.get(labels[i]);
				map.remove(labels[i]);
				pc++;
				map.put(labels[i], pc);
				sum = sum + values[i];
				count++;
			} else if(!map.containsKey(labels[i])){
				map.put(labels[i], 1);
				sum = sum + values[i];
				count++;
			}

			if(count == num_wanted)
				break;
		}
		return sum;
    }

	public static void main(String[] args) {

		int[] values = {5,4,3,2,1};
		int[] labels = {1,1,2,2,3};
		int num_wanted = 3;
		int use_limit = 1;

		System.out.println(new LargestValuesFromLabels().largestValsFromLabels(values, labels, num_wanted, use_limit));
	}
}
