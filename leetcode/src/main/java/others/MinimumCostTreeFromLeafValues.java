package others;

import java.util.ArrayList;
import java.util.List;

/*Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.



Example 1:

Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.

    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4


Constraints:

2 <= arr.length <= 40
1 <= arr[i] <= 15
It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 2^31).*/
public class MinimumCostTreeFromLeafValues {

	/*
	 * Runtime: 3 ms, faster than 54.80% of Java online submissions for Minimum Cost Tree From Leaf Values.
	 * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Minimum Cost Tree From Leaf Values.
	 */
	public int mctFromLeafValues(int[] arr) {
		int res = 0;
        List<Integer> nums = new ArrayList<>();
        for (int a : arr) {
        	nums.add(a);
        }

        while (nums.size() > 1) {

        	int min = Integer.MAX_VALUE, l = 0, r = 0;
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) * nums.get(i - 1) < min) {
                    min = nums.get(i) * nums.get(i - 1);
                    l = i - 1;
                    r = i;
                }
            }

            res += min;

            if (nums.get(l) > nums.get(r)) {
            	nums.remove(r);
            } else {
                nums.remove(l);
            }

        }
        return res;
    }

	public static void main(String[] args) {

		int[] arr = {6,2,4};

		System.out.println(new MinimumCostTreeFromLeafValues().mctFromLeafValues(arr));
	}
}
