package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * @author yutian
 * @since Dec 30, 2015
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
	
	// union find
	public static int countComponents(int n, int[][] edges) {
        int[] set = new int[n];
        for (int i = 0; i < n; i++) set[i] = i;
        
        for (int[] e : edges) {
        	int i = find(set, e[0]);
        	int j = find(set, e[1]);
        	if (i != j) {
        		set[i] = j; // union
        		n--;
        	}
        }
        return n;
    }

	private static int find(int[] set, int i) {
		while (set[i] != i) {
			set[i] = set[set[i]]; // optional: path compression
			i = set[i];
		}
		return i;	
	}
	
	// DFS with recursion
	public static int countComponents2(int n, int[][] edges) {
		if (n <= 1) return n;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] e : edges) {
			adj.get(e[0]).add(e[1]);
			adj.get(e[1]).add(e[0]);
		}
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				count++;
				dfs(adj, visited, i);
			}
		}
		return count;
	}

	private static void dfs(List<List<Integer>> adj, boolean[] visited, int curr) {
		visited[curr] = true;
		for (int i : adj.get(curr)) {
			if (!visited[i]) {
				dfs(adj, visited, i);
			}
		}
	}
	
	// DFS with stack
	public static int countComponents4(int n, int[][] edges) {
		if (n <= 1) return n;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] e : edges) {
			adj.get(e[0]).add(e[1]);
			adj.get(e[1]).add(e[0]);
		}
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			count++;
			Stack<Integer> stack = new Stack<>();
			stack.push(i);
			while (!stack.isEmpty()) {
				int curr = stack.pop();
				visited[curr] = true;
				for (int j : adj.get(curr)) {
					if (!visited[j]) stack.push(j);
				}
			}
		}
		return count;
	}
	
	// BFS with Queue
	public static int countComponents3(int n, int[][] edges) {
		if (n <= 1) return n;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] e : edges) {
			adj.get(e[0]).add(e[1]);
			adj.get(e[1]).add(e[0]);
		}
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			count++;
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			while (!q.isEmpty()) {
				int curr = q.poll();
				visited[curr] = true;
				for (int j : adj.get(curr)) {
					if (!visited[j]) q.add(j);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] test = new int[][]{{2, 3}, {1, 2}, {1, 3}};
		System.out.println(countComponents(4, test));
	}

}
