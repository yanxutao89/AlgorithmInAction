package leetcode.designs;

import java.util.Arrays;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Implement KthLargest class:
 *
 * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 * int add(int val) Returns the element representing the kth largest element in the stream.
 *
 *
 * Example 1:
 *
 * Input
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 * [null, 4, 5, 5, 8, 8]
 *
 * Explanation
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 *
 * Constraints:
 *
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * At most 104 calls will be made to add.
 * It is guaranteed that there will be at least k elements in the array when you search for the kth element.
 */
public class KthLargest {

    private int kthMax;
    private int[] arr;

    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        arr = new int[k];
        int i = nums.length - k;
        int min = Math.min(nums.length, k);
        System.arraycopy(nums, i < 0 ? 0 : i, arr, 0, min);
        kthMax = min == 0 ? Integer.MIN_VALUE : nums[0];
    }

    public int add(int val) {
        int i = 0;
        while (arr[i] < val && i < arr.length - 1) {
            arr[i] = arr[i + 1];
            ++i;
        }
        if (i == arr.length - 1) {
            arr[i] = val;
        }
        kthMax = arr[0];
        return kthMax;
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2, new int[]{0});
        System.out.println(kthLargest.add(-1));   // return 4
        System.out.println(kthLargest.add(1));;   // return 5
        System.out.println(kthLargest.add(-2));;  // return 5
        System.out.println(kthLargest.add(-4));;   // return 8
        System.out.println(kthLargest.add(4));;   // return 8
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
