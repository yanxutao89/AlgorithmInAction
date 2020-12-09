package others;

/*Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning.



Example 1:

Input: A = [1,15,7,9,2,5,10], K = 3
Output: 84
Explanation: A becomes [15,15,15,9,10,10,10]


Note:

1 <= K <= A.length <= 500
0 <= A[i] <= 10^6*/
public class PartitionArrayForMaximumSum {

	/*
	 * Runtime: 3 ms, faster than 99.02% of Java online submissions for Partition Array for Maximum Sum.
	 * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Partition Array for Maximum Sum.
	 */
	public int maxSumAfterPartitioning(int[] A, int K) {

		int[] DP = new int[A.length];
        int max = A[0];
        for(int i = 0; i < K; i++){
            if(A[i] > max) {
            	max = A[i];
            }
            DP[i] = max * (i + 1);
        }

        for(int i = K; i < A.length; i++){
            max = A[i];
            for(int j = i - 1; j >= i - K; j--){
                if(A[j + 1] >  max) {
                	max = A[j+1];
                }
                DP[i] = Math.max(DP[i], DP[j] + max * (i - j));
            }
        }

        return DP[DP.length-1];
    }

	public static void main(String[] args) {

		int[] A = {1,15,7,9,2,5,10};
		int K = 3;

		System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(A, K));
	}
}
