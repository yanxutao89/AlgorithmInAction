package others;

import java.util.ArrayList;
import java.util.List;

/*Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.

Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.



Example 1:

Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation:
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
Example 2:

Input: [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.


Note:

1 <= A.length <= 100
A[i] is a permutation of [1, 2, ..., A.length]*/
public class PancakeSorting {

	/*
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Pancake Sorting.
	 * Memory Usage: 36.3 MB, less than 94.74% of Java online submissions for Pancake Sorting.
	 */
	public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length - 1; i++) {
            int maxPancakeIndex = findMax(A, A.length - i);
            if (maxPancakeIndex == A.length - 1 - i) {
            	continue;
            }
            if (maxPancakeIndex != 0) {
                reverse(A, maxPancakeIndex);
                list.add(maxPancakeIndex + 1);
            }
            reverse(A, A.length - 1 - i);
            list.add(A.length - i);
        }
        return list;
    }

    private int findMax(int[] A, int len) {
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = A[i] > A[res] ? i : res;
        }
        return res;
    }

    private void reverse(int[] A, int end) {
        int left = 0, right = end;
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }

	 public static void main(String[] args) {

		 int[] A = {};

		 System.out.println(new PancakeSorting().pancakeSort(A));
	 }
}
