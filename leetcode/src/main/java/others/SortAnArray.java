package others;

import java.util.Arrays;
import java.util.PriorityQueue;

/*Given an array of integers nums, sort the array in ascending order.



Example 1:

Input: [5,2,3,1]
Output: [1,2,3,5]
Example 2:

Input: [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]


Note:

1 <= A.length <= 10000
-50000 <= A[i] <= 50000*/
public class SortAnArray {

	/*
	 * Runtime: 6 ms, faster than 58.11% of Java online submissions for Sort an Array.
	 * Memory Usage: 44.9 MB, less than 77.55% of Java online submissions for Sort an Array.
	 */
	public int[] sortArray(int[] nums) {

		mergeSort(nums, 0, nums.length - 1);
		return nums;
    }

	private static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int midlle, int end){

    	int n1 = midlle - start + 1;
        int n2 = end - midlle;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++){
            L[i] = arr[start + i];
        }
        L[n1] = Integer.MAX_VALUE;

        for (int i = 0; i < n2; i++){
            R[i] = arr[midlle + i + 1];
        }
        R[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for(int k = start; k <= end; k++){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
        }
    }

	/*
	 * Runtime: 15 ms, faster than 16.19% of Java online submissions for Sort an Array.
	 * Memory Usage: 44.3 MB, less than 85.71% of Java online submissions for Sort an Array.
	 */
    public int[] sortArray2(int[] nums) {

    	PriorityQueue<Integer> q = new PriorityQueue<>();

    	for(int num : nums) {
            q.add(num);
        }

    	for (int i = 0; i < nums.length; i++) {
            nums[i] = q.poll();
        }

    	return nums;
    }

	public static void main(String[] args) {

		int[] nums = {5,2,3,1};

		System.out.println(Arrays.toString(new SortAnArray().sortArray2(nums)));
	}
}
