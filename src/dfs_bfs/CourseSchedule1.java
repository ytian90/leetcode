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
        private int V;
        private int E;
        private List<List<Integer>> adj;
        private boolean hasCycle;
        private boolean[] visited;
        private boolean[] onStack;
        
        public Graph(int n, int[][] edges) {
            this.V = n;
            this.E = edges.length;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int v = edges[i][1];
                int w = edges[i][0];
                adj.get(v).add(w);
            }
        }
        
        public boolean hasTopologicalOrder() {
            visited = new boolean[V];
            onStack = new boolean[V];
            for (int v = 0; v < V; v++) {
                if (!visited[v]) dfs(v);
            }
            return !hasCycle;
        }
        
        private void dfs(int v) {
            visited[v] = true;
            onStack[v] = true;
            for (int w : adj.get(v)) {
                if (hasCycle) return;
                else if (!visited[w]) dfs(w);
                else if (onStack[w]) hasCycle = true;
            }
            onStack[v] = false;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
	}
	
}
