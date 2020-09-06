package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*In an infinite binary tree where every node has two children, the nodes are labelled in row order.

In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.



Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.



Example 1:

Input: label = 14
Output: [1,3,4,14]
Example 2:

Input: label = 26
Output: [1,2,6,10,26]


Constraints:

1 <= label <= 10^6*/
public class PathInZigzagLabelledBinaryTree {


	/*
	 * Runtime: 3 ms, faster than 10.71% of Java online submissions for Path In Zigzag Labelled Binary Tree.
	 * Memory Usage: 33.7 MB, less than 100.00% of Java online submissions for Path In Zigzag Labelled Binary Tree.
	 */
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public List<Integer> pathInZigZagTree(int label) {

		List<Integer> list = new ArrayList<Integer>();
		if(label == 1) {

			list.add(1);
			return list;
		}

		int depth = (int) Math.floor(Math.log(label) / Math.log(2));

		getParentLabel(label, depth);

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

			list.add(entry.getValue());
		}

		list.add(label);

		return list;
    }

	private void getParentLabel(int label, int depth) {

		if(depth == 0) {

			return;
		}

		int lower = (int) Math.pow(2, depth);
		int parentPos = (int) Math.floor((label - lower) / 2);
		int parentLower =  (int) Math.pow(2, depth - 1), parentUpper = lower - 1;

		int index = 0;

		for(int i = parentUpper; i >= parentLower; i--) {

			if(parentPos == index) {

				map.put(depth, i);
				break;
			}
			index++;
		}

		getParentLabel(map.get(depth), depth - 1);

	}

	/*
	 * Runtime: 1 ms, faster than 35.50% of Java online submissions for Path In Zigzag Labelled Binary Tree.
	 * Memory Usage: 33.7 MB, less than 100.00% of Java online submissions for Path In Zigzag Labelled Binary Tree.
	 */
	public List<Integer> pathInZigZagTree2(int label) {

		List<Integer> list = new ArrayList<Integer>();

		if(label == 1) {
			list.add(1);
			return list;
		}

		int depth = (int) Math.floor(Math.log(label) / Math.log(2));
		int[] arr = new int[depth + 1];

		getParentLabel2(label, depth, arr);

		for(int i = 1; i < (depth + 1); i++) {

			list.add(arr[i]);
		}

		list.add(label);

		return list;
    }

	private void getParentLabel2(int label, int depth, int[] arr) {

		if(depth == 0) {

			arr[0] = 1;
			return;
		}

		int lower = (int) Math.pow(2, depth);
		int parentPos = (int) Math.floor((label - lower) / 2);
		int parentUpper = lower - 1;

		arr[depth] = parentUpper - parentPos;

		getParentLabel2(arr[depth], depth - 1, arr);

	}

	public static void main(String[] args) {

		int label = 14;
		System.out.println(new PathInZigzagLabelledBinaryTree().pathInZigZagTree2(label));
	}
}
