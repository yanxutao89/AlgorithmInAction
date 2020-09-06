package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)



Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.


Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.*/
public class IntervalListIntersections {

	/*
	 * Runtime: 3 ms, faster than 83.94% of Java online submissions for Interval List Intersections.
	 * Memory Usage: 44.2 MB, less than 78.38% of Java online submissions for Interval List Intersections.
	 */
	public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> l = new ArrayList<>();
        int pa = 0, pb = 0;
        while(pa < A.length && pb < B.length) {
            int[] a = A[pa];
            int[] b = B[pb];
            if (b[1] < a[0]) {//interval b ends before a starts, pick next b interval
                pb++;
            } else if (a[1] < b[0]) {//interval a ends before b starts, pick next a interval
                pa++;
            } else {//intervals a and b overlap, merge
                int[] merge = new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
                l.add(merge);
                if(a[1] > b[1]) {
                    pb++;
                } else if (a[1] < b[1]) {
                    pa++;
                } else {
                    pb++;
                    pa++;
                }
            }
        }
        int[][] res = new int[l.size()][2];
        int i = 0;
        for(int[] interval : l) {
            res[i] = interval;
            i++;
        }
        return res;
    }

	public static void main(String[] args) {

		int[][] A = {{0,2},{5,10},{13,23},{24,25}};
		int[][] B = {{1,5},{8,12},{15,24},{25,26}};

		System.out.println(Arrays.toString(new IntervalListIntersections().intervalIntersection(A, B)));
	}
}
