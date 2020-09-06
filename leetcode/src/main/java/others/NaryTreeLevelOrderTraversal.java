package others;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import bean.Node;

public class NaryTreeLevelOrderTraversal {

	/*
	 * Runtime: 2 ms, faster than 84.20% of Java online submissions for N-ary Tree Level Order Traversal.
	 * Memory Usage: 46.5 MB, less than 75.00% of Java online submissions for N-ary Tree Level Order Traversal.
	 */
	public List<List<Integer>> levelOrder(Node root) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root == null) {

			return list;
		}

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Node> rootList = new ArrayList<Node>();
		rootList.add(root);

		recursive(rootList, map, 0);

		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

			list.add(entry.getValue());
		}

		return list;

    }

	private void recursive(List<Node> nodes, Map<Integer, List<Integer>> map, int depth) {

		if(nodes == null || nodes.size() == 0) {
			return;
		}

		if(map.get(depth) == null) {
			map.put(depth, new ArrayList<Integer>());
		}

		for(Node node : nodes) {
			map.get(depth).add(node.val);

			recursive(node.children, map, depth + 1);
		}
	}

	/*
	 * Runtime: 3 ms, faster than 77.09% of Java online submissions for N-ary Tree Level Order Traversal.
	 * Memory Usage: 49.5 MB, less than 17.50% of Java online submissions for N-ary Tree Level Order Traversal.
	 */
	public List<List<Integer>> levelOrder2(Node root) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(root == null) {

			return list;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		bfs(queue, list);

		return list;

    }

	private void bfs(Queue<Node> queue, List<List<Integer>> list) {

		while(!queue.isEmpty()) {

			int size = queue.size();
			List<Integer> list2 = new ArrayList<Integer>(size);
			for(int i = 0; i < size; i++) {

				Node node = queue.remove();
				list2.add(node.val);

				if(node.children != null && node.children.size() > 0) {
					queue.addAll(node.children);
				}
			}

			list.add(list2);
		}
	}

	public static void main(String[] args) {


	}
}
