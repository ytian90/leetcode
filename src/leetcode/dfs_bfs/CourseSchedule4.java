package leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Course Schedule II with BFS
 * @author yutian
 * @since Aug 27, 2015
 */
public class CourseSchedule4 {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Graph obj = new Graph(numCourses, prerequisites);
		return obj.topologicalOrder();
	}
	
	public static class Graph {
		private int V, E;
		private List<List<Integer>> adj;
		private int[] indegree;
		private Queue<Integer> q;
		
		public Graph(int n, int[][] edges) {
			this.V = n;
			this.E = edges.length;
			adj = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				adj.add(new ArrayList<>());
			}
			indegree = new int[V];
			for (int i = 0; i < E; i++) {
				int v = edges[i][1];
				int w = edges[i][0];
				adj.get(v).add(w);
				indegree[w]++;
			}
			q = new LinkedList<Integer>();
		}
		
		// BFS
		public int[] topologicalOrder() {
			for (int i = 0; i < V; i++) {
				if (indegree[i] == 0) q.add(i);
			}
			int count = 0;
			int[] order = new int[V]; // modification: add order
			while (!q.isEmpty()) {
				int i = q.poll();
				order[count++] = i; // modification: record order
				for (int j : adj.get(i)) {
					if (--indegree[j] == 0) q.add(j);
				}
			}
			
			return (count < V) ? new int[0] : order; // modification: return empty leetcode.array or order
		}
	}
	
	public static void main(String[] args) {
//		for (int i: findOrder(2, new int[][]{{1, 0}, {0, 1}}))
//			System.out.println(i);
//		System.out.println();
		for (int i: findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}}))
			System.out.println(i);
	}
}
