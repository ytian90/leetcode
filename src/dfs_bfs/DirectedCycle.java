package dfs_bfs;

import java.util.Stack;

/**
 * Course Schedule I DFS v1
 * @author yutian
 * @since Aug 25, 2015
 */
public class DirectedCycle {
	private Stack<Integer> cycle;
	private boolean[] marked;
	private boolean[] onStack;
	private int[] edgeTo;
	
	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V];
		onStack = new boolean[G.V];
		edgeTo = new int[G.V];
		for (int v = 0; v < G.V; v++) {
			if (!marked[v]) dfs(G, v); // call DFS to find directed cycles
		}
	}

	public boolean hasCycle() {
		return cycle != null;
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		onStack[v] = true;
		for (int w : G.adj[v]) {
			if (cycle != null) return; // stop when directed cycle found
			else if (!marked[w]) { // recursion when new vertex found
				edgeTo[w] = v;
				dfs(G, w);
			} else if (onStack[w]) { // track back directed cycle
				cycle = new Stack<Integer>();
				for (int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v] = false;
	}

}
