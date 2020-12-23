package leetcode.arrays;

import java.util.*;

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

        Set<Integer> points = new TreeSet<>();
        possiblePoints(height, points);
        if (points.size() == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        for (int point : points) {
            refinePoints(height, point, list);
        }

        if (list.size() > 2) {
            int adjoining;
            while ((adjoining = isAdjoining(height, list)) != -1) {
                list.remove(adjoining);
                list.remove(adjoining);
            }
        }

        int water = 0;
        for (int i = 0; i < list.size() - 1; ++i) {
            int min = Math.min(height[list.get(i)], height[list.get(i + 1)]);
            for (int j = list.get(i) + 1; j < list.get(i + 1); ++j) {
                water += (min > height[j] ? min - height[j] : 0);
            }
        }

        System.out.println(list);

        return water;

    }

    private void possiblePoints(int[] height, Set<Integer> set) {
        for (int i = 1; i < height.length - 1; ++i) {
            if (height[i] < height[i - 1] && height[i] < height[i + 1]) {
                set.add(i);
            }
        }
        for (int i = 1; i < height.length - 2; ++i) {
            if (height[i] == height[i + 1]) {
                if (height[i - 1] > height[i] || height[i + 2] > height[i + 1]) {
                    set.add(i);
                }
            }
        }
    }

    private void refinePoints(int[] height, int point, List<Integer> list) {

        int i = point;
        for ( ; i > 0; --i) {
            if (height[i - 1] < height[i]) {
                list.add(i);
                break;
            }
        }
        if (i == 0) {
            list.add(i);
        }

        for (i = point; i < height.length - 1; ++i) {
            if (height[i + 1] < height[i]) {
                list.add(i);
                break;
            }
        }
        if (i == height.length - 1) {
            list.add(i);
        }

    }

    private int isAdjoining(int[] height, List<Integer> list) {
        for (int i = 1; i < list.size() - 2; ++i) {
            int max = Math.max(height[list.get(i)], height[list.get(i + 1)]);
            if (height[list.get(i - 1)] >= max && height[list.get(i + 2)] >= max) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
