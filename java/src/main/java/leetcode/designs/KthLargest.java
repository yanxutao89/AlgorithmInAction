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

    /**
     * Runtime: 69 ms, faster than 11.49% of Java online submissions for Kth Largest Element in a Stream.
     * Memory Usage: 43 MB, less than 90.38% of Java online submissions for Kth Largest Element in a Stream.
     */
    private int[] data;

    public KthLargest(int k, int[] nums) {
        data = new int[k];
        int len = Math.min(nums.length, k);
        Arrays.sort(nums);
        System.arraycopy(nums, nums.length - len, data, 0, len);
        for (int i = len; i < k; ++i) {
            data[i] = Integer.MIN_VALUE;
        }
        Arrays.sort(data);
    }

    public int add(int val) {
        int i = 0;
        while (i < data.length && val > data[i]) {
            i++;
        }
        for (int j = 0; j < i - 1; ++j) {
            data[j] = data[j + 1];
        }
        if (i > 0) {
            data[i - 1] = val;
        }
        return data[0];
    }

    /**
     * Runtime: 550 ms, faster than 5.37% of Java online submissions for Kth Largest Element in a Stream.
     * Memory Usage: 46.5 MB, less than 7.59% of Java online submissions for Kth Largest Element in a Stream.
     */
//    private int[] data;
//    private int kth;
//
//    public KthLargest(int k, int[] nums) {
//        data = new int[nums.length];
//        System.arraycopy(nums, 0, data, 0, nums.length);
//        Arrays.sort(data);
//        kth = k;
//    }
//
//    public int add(int val) {
//        int[] temp = new int[data.length];
//        System.arraycopy(data, 0, temp, 0, data.length);
//        data = new int[temp.length + 1];
//        System.arraycopy(temp, 0, data, 0, temp.length);
//        data[data.length - 1] = val;
//        Arrays.sort(data);
//        return data[data.length - kth];
//    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3)); // return 4
        System.out.println(kthLargest.add(5)); // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9)); // return 8
        System.out.println(kthLargest.add(4)); // return 8
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
