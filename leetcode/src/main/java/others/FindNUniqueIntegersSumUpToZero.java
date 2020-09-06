package others;

import java.util.Arrays;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.



Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
Example 2:

Input: n = 3
Output: [-1,0,1]
Example 3:

Input: n = 1
Output: [0]


Constraints:

1 <= n <= 1000
 * @author Administrator
 *
 */
public class FindNUniqueIntegersSumUpToZero {

	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
	 * Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
	 * @param n
	 * @return
	 */
    public int[] sumZero(int n) {

    	int[] arr = new int[n];
    	int num = n >> 1;
    	for (int i = 1, index = 0; i <= num; i++, index += 2) {
    		arr[index] = i;
    		arr[index + 1] = -i;
    	}
    	if ((n & 1) == 1) {
    		arr[n - 1] = 0;
    	}

    	return arr;
    }

    public static void main(String[] args) {
		int n = 4;
		System.out.println(Arrays.toString(new FindNUniqueIntegersSumUpToZero().sumZero(n)));
	}
}
