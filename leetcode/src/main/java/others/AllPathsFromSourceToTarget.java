package others;

import java.util.ArrayList;
import java.util.List;

/*Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.*/
public class AllPathsFromSourceToTarget {

	/*
	 * Runtime: 3 ms, faster than 48.29% of Java online submissions for All Paths From Source to Target.
	 * Memory Usage: 42.1 MB, less than 58.33% of Java online submissions for All Paths From Source to Target.
	 */
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		List<List<Integer>> ll = new ArrayList<List<Integer>>();
        dfs(0, new ArrayList<Integer>(), graph, ll);
        return ll;
    }

	 public void dfs(int cur, List<Integer> path, int[][] graph, List<List<Integer>> ll) {

		 int[] adj = graph[cur];

         if(adj.length == 0 && cur != graph.length-1) {
        	 return;
         }

         List<Integer> newpath = new ArrayList<Integer>(path);
         newpath.add(cur);

         if(cur == graph.length-1) {

        	 ll.add(newpath);
             return;
         }
         for(int i : adj) {

        	 dfs(i, newpath, graph, ll);
         }
    }

	public static void main(String[] args) {

		int[][] graph = {{1,2}, {3}, {3}, {}};

		System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph));
	}
}
