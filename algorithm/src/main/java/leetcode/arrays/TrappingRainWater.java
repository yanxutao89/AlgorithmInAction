package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/12/6 19:47
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < height.length; ++i) {
            int size = list.size();
            if ((size & 1) == 0) {
                if (size == 0) {
                    if (height[i] > 0 ) {
                        list.add(i);
                    }
                } else {
                    if (height[i] < height[list.get(size - 1)]) {
                        list.add(i - 1);
                    }
                }
            } else {
                if (height[i] > height[list.get(size - 1)]) {
                    list.add(i);
                }
            }
        }
        System.out.println(list);

        return 0;

    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
