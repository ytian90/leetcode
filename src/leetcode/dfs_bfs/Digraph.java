package leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Directed Graph Class DFS v1
 * @author yutian
 * @since Aug 25, 2015
 */
public class Digraph {
	public int V; // number of vertices
	public int E; // number of edges
	public List<Integer>[] adj; // adjacency list
	
	public Digraph(int n, int[][] edges) {
		this.V = n;
		this.E = edges.length;
		adj = (List<Integer>[]) new List[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>(); // initialize adj
		}
		for (int i = 0; i < E; i++) {
			int v = edges[i][1];
			int w = edges[i][0];
			adj[v].add(w); // add edge v -> w
		}
	}
}
