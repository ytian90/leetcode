package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Digraph3 BFS for Course Schedule
 * @author yutian
 * @since Aug 25, 2015
 */
public class Digraph3 {
	private int V;
	private int E;
	private List<Integer>[] adj;
	private int[] indegree;
	private Queue<Integer> q; // store all vertices with 0 indegree
	
	public Digraph3(int n, int[][] edges) {
		this.V = n;
		this.E = edges.length;
		adj = (List<Integer>[]) new List[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		indegree = new int[V];
		for (int i = 0; i < E; i++) {
			int v = edges[i][1];
			int w = edges[i][0];
			adj[v].add(w); // add edge v->w
			indegree[w]++; // update indegree of w 
		}
	}
	
	// BFS
	public boolean hasTopologicalOrder() {
		q = new LinkedList<Integer>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) q.add(i);
			// add all vertices with 0 indegree
		}
		int count = 0; // number of vertices polled from queue
		while (!q.isEmpty()) {
			int v = q.poll();
			count++;
			for (int w : adj[v]) {
				if (--indegree[w] == 0) q.add(w);
				// add vertex if its in degree is 0
			}
		}
		if (count < V) return false;
		else return true; 
		// has topological order if all vertices polled from queue
	}
}
