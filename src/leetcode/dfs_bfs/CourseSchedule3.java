package leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Course Schedule II with DFS
 * @author yutian
 * @since Aug 27, 2015
 */
public class CourseSchedule3 {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Graph obj = new Graph(numCourses, prerequisites);
		return obj.topologicalOrder();
	}
	public static class Graph {
		private int V, E;
		private List<List<Integer>> adj;
		private boolean hasCycle;
		private boolean[] visited, onStack;
		private Stack<Integer> memo; // modification: add post order
		
		public Graph(int n, int[][] edges) {
			this.V = n;
			this.E = edges.length;
			adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
			for (int[] e : edges) {
				adj.get(e[1]).add(e[0]);
			}
			visited = new boolean[V];
			onStack = new boolean[V];
			memo = new Stack<>(); // modification: add post order
		}
		
		public int[] topologicalOrder() {
			for (int i = 0; i < V; i++) {
                if (!visited[i]) dfs(i);
            }
			if (hasCycle) return new int[0]; // modification: return an empty leetcode.array
			else {
				int[] order = new int[V];
				for (int i = 0; i < V; i++) {
					order[i] = memo.pop();
				}
				return order;
			}
		}

		private void dfs(int i) {
			visited[i] = true;
			onStack[i]= true;
			for (int j : adj.get(i)) {
				if (hasCycle) return;
				else if (!visited[j]) dfs(j);
				else if (onStack[j]) hasCycle = true;
			}
			memo.push(i); // modification: record memo
			onStack[i] = false;
		}
	}
	
	public static void main(String[] args) {
//		for (int i: findOrder(2, new int[][]{{1, 0}, {0, 1}}))
//			System.out.println(i);
//		System.out.println();
		for (int i: findOrder(3, new int[][]{{1, 0}, {2, 1}}))
			System.out.println(i);
	}
}
