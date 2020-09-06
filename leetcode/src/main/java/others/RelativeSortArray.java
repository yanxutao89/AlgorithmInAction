package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.



Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]


Constraints:

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.*/
public class RelativeSortArray {

	/*
	 * Runtime: 1 ms, faster than 77.85% of Java online submissions for Relative Sort Array.
	 * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Relative Sort Array.
	 */
	 public int[] relativeSortArray(int[] arr1, int[] arr2) {

		 int[] res = new int[arr1.length];
		 mergeSort(arr1, 0, arr1.length - 1);

		 int leftIndex = 0;
		 int rightIndex = arr1.length - 1;
		 for(int i = 0; i < arr2.length; i++) {
			 int count = count(arr1, arr2[i]);
			 if(count > 0) {
				 int tempIndex = 0;
				 while(tempIndex < count) {

					 res[leftIndex++] = arr2[i];
					 tempIndex++;
				 }
			 }
		 }

		 for(int i = arr1.length - 1; i > -1; i--) {

			 if(count(arr2, arr1[i]) == 0) {

				 res[rightIndex--] = arr1[i];
			 }
		 }

		 return res;

	 }

	 private int count(int[] arr1, int i) {

		 int count = 0;
		 for(int in : arr1) {

			 if(in == i) {

				 count++;
			 }
		 }

		 return count;
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

	 public static void main(String[] args) {

		 int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		 int[] arr2 = {2,1,4,3,9,6};

		 System.out.println(Arrays.toString(new RelativeSortArray().relativeSortArray(arr1, arr2)));

	 }
}
