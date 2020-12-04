package arrays;


/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 * Example 3:
 *
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * Example 4:
 *
 * Input: height = [1,2,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 *
 */
public class ContainerWithMostWater {

    /**
     * Runtime: 672 ms, faster than 11.11% of Java online submissions for Container With Most Water.
     * Memory Usage: 40.4 MB, less than 60.42% of Java online submissions for Container With Most Water.
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length - 1; ++i){
            for(int j = i + 1; j < height.length; ++j){
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }

        }
        return max;
    }

    public static int maxArea2(int[] height) {
        int len = height.length;
        int[] dp = new int[len];
        if (len < 2) {
            return 0;
        }
        if (len == 2) {
            return Math.min(height[0], height[1]);
        }
        for (int i = 3; i < len; ++i) {

        }
        return dp[len - 1];
    }

    public static void main(String[] args){
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(heights));
    }
}
