package others;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Students are asked to stand in non-decreasing order of heights for an annual photo.

Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)



Example 1:

Input: [1,1,4,2,1,3]
Output: 3
Explanation:
Students with heights 4, 3 and the last 1 are not standing in the right positions.


Note:

1 <= heights.length <= 100
1 <= heights[i] <= 100*/
public class HeightChecker {

	/*
	 * Runtime: 3 ms, faster than 8.20% of Java online submissions for Height Checker.
	 * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Height Checker.
	 */
	 public int heightChecker(int[] heights) {

		 int min = 0;
		 Integer[] h = new Integer[heights.length];

		 for(int i = 0; i < heights.length; i++) {

			 h[i] = heights[i];
		 }

		 List<Integer> list = Arrays.asList(h);

		 Collections.sort(list);

		 for(int i = 0; i < heights.length; i++) {

			 if(heights[i] != list.get(i)) {

				 min++;
			 }

		 }

		 return min;
	 }

	/*
	 * Runtime: 1 ms, faster than 87.56% of Java online submissions for Height Checker.
	 * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Height Checker.
	 */
	 public int heightChecker2(int[] heights) {

		 int min = 0;
		 int[] sorted = new int[heights.length];
		 for(int i = 0; i < heights.length; i++) {

			 sorted[i] = heights[i];
		 }

		 mergeSort(sorted, 0, sorted.length - 1);

		 int index = 0;
		 for(int i : sorted) {

			 if(heights[index++] != i) {

				 min++;
			 }
		 }

		 return min;
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

		 int[] heights = {1,1,4,2,1,3};

		 System.out.println(new HeightChecker().heightChecker2(heights));
	 }
}
