package others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]*/
public class QueueReconstructionByHeight {

	/*
	 * Runtime: 7 ms, faster than 70.31% of Java online submissions for Queue Reconstruction by Height.
	 * Memory Usage: 45.5 MB, less than 59.57% of Java online submissions for Queue Reconstruction by Height.
	 */
	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
		});

		List<int[]> output = new LinkedList<int[]>();
		for (int[] person : people) {
			output.add(person[1], person);
		}
		return output.toArray(new int[people.length][2]);
    }

	public static void main(String[] args) {

		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

		System.out.println(Arrays.deepToString(new QueueReconstructionByHeight().reconstructQueue(people)));
	}
}
