package leetcode.arrays;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * Example 4:
 *
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * Example 5:
 *
 * Input: nums = [1], target = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class SearchInsertPosition {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
     * Memory Usage: 38.6 MB, less than 62.27% of Java online submissions for Search Insert Position.
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return 0;
        }
        if (target == nums[left]) {
            return left;
        }
        if (target == nums[right]) {
            return right;
        }
        if (target > nums[left] && target < nums[left + 1]) {
            return left + 1;
        }
        if (target > nums[right - 1] && target < nums[right]) {
            return right;
        }
        int mid = (left + right) >> 1;
        if (target < nums[mid]) {
            return binarySearch(nums, left, mid, target);
        }
        else if (target > nums[mid]){
            return binarySearch(nums, mid, right, target);
        }
        else {
            return mid;
        }
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (right - left > 1) {
            mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid;
            }
            else if (target > nums[mid]){
                left = mid;
            }
            else {
                return mid;
            }
        }
        return target > nums[mid] ? mid + 1 : mid;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        int target = 0;
        System.out.println(new SearchInsertPosition().searchInsert(nums, target));
        System.out.println(new SearchInsertPosition().searchInsert2(nums, target));
    }
}
