package others;

/*Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.



Example 1:

Input: A = [1], K = 0
Output: 0
Explanation: B = [1]
Example 2:

Input: A = [0,10], K = 2
Output: 6
Explanation: B = [2,8]
Example 3:

Input: A = [1,3,6], K = 3
Output: 0
Explanation: B = [3,3,3] or B = [4,4,4]


Note:

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000*/
public class SmallestRangeI {

	/*
	 * Runtime: 4 ms, faster than 25.06% of Java online submissions for Smallest Range I.
	 * Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Smallest Range I.
	 */
	public int smallestRangeI(int[] A, int K) {

		int min = Integer.MAX_VALUE;     //**MIN OF THE ORIGINAL ARRAY**
        int max = Integer.MIN_VALUE;     //**MAX OF THE ORIGINAL ARRAY**
        for(int i : A){
            min = Math.min(min , i);
            max = Math.max(max , i);
        }
        int mid = min + (max - min)/2;        //**AVERAGE OF MIN AND MAX**
        int min1 = Integer.MAX_VALUE;      //**TO RECORD THE MIN OF THE MODIFIED ARRAY**
        int max1 = Integer.MIN_VALUE;      //**TO RECORD THE MAX OF MODIFIED ARRAY**
        for(int i = 0 ; i < A.length ; i++){
            int x = A[i] - mid;
            A[i] = Math.abs(x) <= K ? mid : x > 0 ? A[i] - K : A[i] + K;   //**NEW VALUE**
            min1 = Math.min(min1 , A[i]);
            max1 = Math.max(max1 , A[i]);
        }
        return max1 - min1;
    }

	public static void main(String[] args) {

		int[] A = {};
		int K = 0;

		System.out.println(new SmallestRangeI().smallestRangeI(A, K));
	}
}
