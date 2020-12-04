package leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Digraph 2 (better than 1) v2
 * @author yutian
 * @since Aug 25, 2015
 */
public class Digraph2 {
	private int V;
	private int E;
	private List<Integer>[] adj;
	private boolean hasCycle;
	private boolean[] marked;
	private boolean[] onStack;
	
	public Digraph2(int n, int[][] edges) {
		this.V = n;
		this.E = edges.length;
		adj = (List<Integer>[]) new List[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < E; i++) {
			int v = edges[i][1]; // prerequired
			int w = edges[i][0]; // want
			adj[v].add(w); // add edge v -> w
		}
	}
	
	public boolean hasTopologicalOrder() {
		marked = new boolean[V];
		onStack = new boolean[V];
		for (int v = 0; v < V; v++) {
			if (!marked[v]) dfs(v); // call DFS to find directed cycles
		}
		return !hasCycle;
	}

	private void dfs(int v) {
		marked[v] = true;
		onStack[v] = true;
		for (int w : adj[v]) {
			if (hasCycle) return; // stop when directed cycle found
			else if (!marked[w]) dfs(w); // recursion when new vertex found
			else if (onStack[w]) hasCycle = true; // directed cycle found
		}
		onStack[v] = false;
	}
}
