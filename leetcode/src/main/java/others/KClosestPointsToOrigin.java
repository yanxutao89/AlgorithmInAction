package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)


Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000*/
public class KClosestPointsToOrigin {

	/*
	 * Runtime: 49 ms, faster than 41.64% of Java online submissions for K Closest Points to Origin.
	 * Memory Usage: 67.6 MB, less than 5.59% of Java online submissions for K Closest Points to Origin.
	 */
	 public int[][] kClosest(int[][] points, int K) {

		 int[][] res = new int[K][2];

		 List<Double> list = new ArrayList<Double>(points.length);
		 Map<Double, Integer> map = new HashMap<Double, Integer>();

		 for(int i = 0; i < points.length; i++) {

			 Double distance = (double) (points[i][0] * points[i][0] + points[i][1] * points[i][1]);

			 if(map.containsKey(distance)) {

				 map.put(distance - 0.1, i);
				 list.add(distance - 0.1);
			 } else {

				 map.put(distance, i);
				 list.add(distance);
			 }
		 }

		 Collections.sort(list);

		 int index = 0;
		 for(int i = 0; i < K; i++) {

			 res[index][0] = points[map.get(list.get(i))][0];
			 res[index][1] = points[map.get(list.get(i))][1];
			 index++;
		 }

		 return res;
	 }

	 public static void main(String[] args) {

		 int[][] points = {{0,1},{1,0}};
		 int K = 2;

		 System.out.println(Arrays.deepToString(new KClosestPointsToOrigin().kClosest(points, K)));
	 }
}
