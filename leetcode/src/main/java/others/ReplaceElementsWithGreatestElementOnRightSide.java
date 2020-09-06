package others;

import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

/**
 * Share
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.



Example 1:

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]


Constraints:

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5
 * @author Administrator
 *
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

	/**
	 * Runtime: 2 ms, faster than 32.53% of Java online submissions for Replace Elements with Greatest Element on Right Side.
	 * Memory Usage: 52.6 MB, less than 100.00% of Java online submissions for Replace Elements with Greatest Element on Right Side.
	 * @param arr
	 * @return
	 */
    public int[] replaceElements(int[] arr) {

        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for(int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if(temp > max) {
                max = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//		int[] arr = {17,18,5,4,6,1};
//		System.out.println(Arrays.toString(new ReplaceElementsWithGreatestElementOnRightSide().replaceElements(arr)));

		int i = 0;
		int j = i % 65;
		int k = j + 65;
		System.out.println(((char)k) + (++j) + "");
	}

}
