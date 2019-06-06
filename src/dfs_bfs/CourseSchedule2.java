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
        int V;
        int E;
        List<List<Integer>> adj;
        private int[] indegree;
        private Queue<Integer> q;

        public Graph(int V, int[][] edges) {
            this.V = V;
            this.E = edges.length;
            this.adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            indegree = new int[V];
            for (int[] e : edges) {
                adj.get(e[1]).add(e[0]);
                indegree[e[0]]++;
            }
        }

        public boolean hasTopologicalOrder() {
            q = new LinkedList<>();
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            int count = 0;
            while (!q.isEmpty()) {
                int curr = q.poll();
                count++;
                for (int n : adj.get(curr)) {
                    if (--indegree[n] == 0) q.add(n);
                }
            }
            return count == V ? true : false;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
	}
}
