package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * On an infinite number line (x-axis), we drop given squares in the order they are given.
 *
 * The i-th square dropped (positions[i] = (left, side_length)) is a square with the left-most point being positions[i][0] and sidelength positions[i][1].
 *
 * The square is dropped with the bottom edge parallel to the number line, and from a higher height than all currently landed squares. We wait for each square to stick before dropping the next.
 *
 * The squares are infinitely sticky on their bottom edge, and will remain fixed to any positive length surface they touch (either the number line or another square). Squares dropped adjacent to each other will not stick together prematurely.
 *
 *
 * Return a list ans of heights. Each height ans[i] represents the current highest height of any square we have dropped, after dropping squares represented by positions[0], positions[1], ..., positions[i].
 *
 * Example 1:
 *
 * Input: [[1, 2], [2, 3], [6, 1]]
 * Output: [2, 5, 5]
 * Explanation:
 * After the first drop of positions[0] = [1, 2]: _aa _aa ------- The maximum height of any square is 2.
 *
 * After the second drop of positions[1] = [2, 3]: __aaa __aaa __aaa _aa__ _aa__ -------------- The maximum height of any square is 5. The larger square stays on top of the smaller square despite where its center of gravity is, because squares are infinitely sticky on their bottom edge.
 *
 * After the third drop of positions[1] = [6, 1]: __aaa __aaa __aaa _aa _aa___a -------------- The maximum height of any square is still 5. Thus, we return an answer of [2, 5, 5].
 *
 *
 *
 *
 * Example 2:
 *
 * Input: [[100, 100], [200, 100]]
 * Output: [100, 100]
 * Explanation: Adjacent squares don't get stuck prematurely - only their bottom edge can stick to surfaces.
 *
 *
 * Note:
 *
 * 1 <= positions.length <= 1000.
 * 1 <= positions[i][0] <= 10^8.
 * 1 <= positions[i][1] <= 10^6.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/09/24 9:32
 */
public class FallingSquares {

	/**
	 * Runtime: 52 ms, faster than 16.10% of Java online submissions for Falling Squares.
	 * Memory Usage: 40 MB, less than 86.44% of Java online submissions for Falling Squares.
	 * @param positions
	 * @return
	 */
	public List<Integer> fallingSquares(int[][] positions) {

		List<Integer> res = new ArrayList<>();
		List<long[]> list = new ArrayList<>();
		list.add(new long[]{0, Integer.MAX_VALUE, 0});
		long max = 0;

		for(int i = 0; i < positions.length; ++i){
			int position[] = positions[i];
			long len = position[1];
			long l = position[0];
			long r = l + len - 1;
			long h = 0;

			for(long[] pos : list){
				if(pos[0] > r) {
					continue;
				}
				if(pos[1] < l) {
					continue;
				}
				h = Math.max(h, pos[2] + len);
			}
			list.add(new long[]{l, r, h});
			max = Math.max(max, h);
			res.add((int) max);
		}

		return res;

	}

	/**
	 * Runtime: 15 ms, faster than 93.64% of Java online submissions for Falling Squares.
	 * Memory Usage: 42.5 MB, less than 7.63% of Java online submissions for Falling Squares.
	 */
	public List<Integer> fallingSquares2(int[][] positions) {

		List<Integer> res = new ArrayList<>();
		Node root = new Node(0, 1000_000_10, 0);
		for (int[] p : positions) {
			int val = query(root, p[0], p[0] + p[1] - 1);
			update(root, p[0], p[0] + p[1] - 1, p[1] + val);
			res.add(root.val);
		}
		return res;

	}

	class Node {
		int low, high;
		int val;
		Node left, right;
		public Node(int low, int high, int val) {
			this.low = low;
			this.high = high;
			this.val = val;
		}
	}

	private int query(Node root, int l, int r) {
		if (l <= root.low && root.high <= r) {
			return root.val;
		}
		int mid = (root.low + root.high) / 2;
		int res = Integer.MIN_VALUE;
		if (root.left == null) {
			root.left = new Node(root.low, mid, root.val);
		}
		if (root.right == null) {
			root.right = new Node(mid + 1, root.high, root.val);
		}
		if (l <= mid) {
			res = Math.max(res, query(root.left, l, r));
		}
		if (r > mid) {
			res = Math.max(res, query(root.right, l, r));
		}
		return res;
	}

	private void update(Node root, int l, int r, int val) {
		if (l <= root.low && root.high <= r) {
			root.val = val;
			root.left = null;
			root.right = null;
			return;
		}
		int mid = (root.low + root.high) / 2;
		if (root.left == null) {
			root.left = new Node(root.low, mid, root.val);
		}
		if (root.right == null) {
			root.right = new Node(mid + 1, root.high, root.val);
		}
		if (l <= mid) {
			update(root.left, l, r, val);
		}
		if (r > mid) {
			update(root.right, l, r, val);
		}
		root.val = Math.max(root.left.val, root.right.val);
	}

	public static void main(String[] args) {
		int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
		System.out.println(new FallingSquares().fallingSquares(positions));
		System.out.println(new FallingSquares().fallingSquares2(positions));
	}
}
