package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Course Schedule with BFS
 * @author yutian
 * @since Aug 27, 2015
 */
public class CourseSchedule2 {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Graph obj = new Graph(numCourses, prerequisites);
		return obj.hasTopologicalOrder();
	}
	
	public static class Graph {
        private int V;
        private int E;
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
        }
        
        public boolean hasTopologicalOrder() {
            q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) q.add(i);
            }
            int count = 0;
            while (!q.isEmpty()) {
                int v = q.poll();
                count++;
                for (int w : adj.get(v)) {
                    if (--indegree[w] == 0) q.add(w);
                }
            }
            return count == V ? true : false;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
	}
}
