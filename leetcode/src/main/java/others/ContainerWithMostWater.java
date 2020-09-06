package others;

import java.util.HashMap;

/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 */

public class ContainerWithMostWater {
    public static int maxArea(int[] heights) {
        int max = 0;
        for(int i = 0; i < heights.length - 1; i++){
            for(int j = i + 1; j < heights.length; j++){
                int tmp = Math.min(heights[i], heights[j]) * (j - i);
                max = Math.max(max, tmp);
            }

        }
        return max;
    }

    public static int maxArea2(int[] heights){
        int max = 0;
        int left = heights.length >> 1, right = left + 1;
        while(left > -1 && right < heights.length){
            int tmp = Math.min(heights[left], heights[right]) * (right - left);
            max = Math.max(max, tmp);

        }
        return max;
    }


    public static void main(String[] args){
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }
}
