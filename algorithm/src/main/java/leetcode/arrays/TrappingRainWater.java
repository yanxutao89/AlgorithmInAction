package leetcode.arrays;

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
        int start = 1;
        for (int i = 0; i < height.length - 1; ) {
            int nextStart = find(height, start, list);
            if(nextStart != -1) {
                i = nextStart;
                start = nextStart;
            } else {
                list.remove(list.size() - 1);
                i++;
                start = i;
            }
        }

        int water = 0;
        for (int i = 0; i < list.size() - 1; ++i) {
            int min = Math.min(height[list.get(i)], height[list.get(i + 1)]);
            for (int j = list.get(i) + 1; j < list.get(i + 1); ++j) {
                water += (min - height[j]);
            }
        }

        System.out.println(list);

        return water;

    }

    private int find(int[] height, int start, List<Integer> list) {

        for (int i = start; i < height.length; ++i) {
            if ((list.size() & 1) == 0) {
                if (height[i] < height[i - 1]) {
                    list.add(i - 1);
                }
            } else {
                Integer left = list.get(list.size() - 1);
                if (height[i] >= height[left]) {
                    list.add(i);
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 3};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
