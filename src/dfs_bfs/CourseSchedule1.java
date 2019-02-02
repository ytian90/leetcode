package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Course Schedule with DFS
 * @author yutian
 * @since Aug 25, 2015
 */
public class CourseSchedule1 {
	// Solution 1 DFS
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Graph obj = new Graph(numCourses, prerequisites);
		return obj.hasTopologicalOrder();
	}

    public static class Graph {
        int V;
        int E;
        List<List<Integer>> adj;
        boolean hasCycle;
        boolean[] visited;
        boolean[] onstack;

        public Graph(int n, int[][] edges) {
            this.V = n;
            this.E = edges.length;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int a = edges[i][1];
                int b = edges[i][0];
                adj.get(a).add(b);
            }
        }

        public boolean hasTopologicalOrder() {
            visited = new boolean[V];
            onstack = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) dfs(i);
            }
            return !hasCycle;
        }

        public void dfs(int i) {
            visited[i] = true;
            onstack[i] = true;
            for (int j : adj.get(i)) {
                if (hasCycle) return;
                else if (!visited[j]) dfs(j);
                else if (onstack[j]) hasCycle = true;
            }
            onstack[i] = false;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
	}
	
}
