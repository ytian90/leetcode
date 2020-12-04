package leetcode.dfs_bfs;

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
        boolean[] onStack;

        public Graph(int V, int[][] edges) {
            this.V = V;
            this.E = edges.length;
            this.adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] e : edges) {
                adj.get(e[1]).add(e[0]);
            }
        }

        public boolean hasTopologicalOrder() {
            visited = new boolean[V];
            onStack = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            return !hasCycle;
        }

        public void dfs(int i) {
            if (hasCycle) return;
            visited[i] = true;
            onStack[i] = true;
            for (int j : adj.get(i)) {
                if (!visited[j]) dfs(j);
                else if (onStack[j]) hasCycle = true;
            }
            onStack[i] = false;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
	}
	
}
