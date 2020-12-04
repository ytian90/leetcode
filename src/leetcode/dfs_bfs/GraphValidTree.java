package leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * 261. adj Valid Tree
 * @author yutian
 * @since Jan 16, 2016
 */
public class GraphValidTree {
	
	// Solution 1: Union Find
	public static boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
		int[] nums = new int[n];
		Arrays.fill(nums, -1);
		
		// perform union find
		for (int i = 0; i < edges.length; i++) {
			int x = find(nums, edges[i][0]);
			int y = find(nums, edges[i][1]);
			// if two vertices happen to be in the same set
			// then there's a cycle
			if (x == y) return false;
			// union
			nums[x] = y;
		}
		return edges.length == n - 1;
    }

	// a utility function to find the subset of an element i
	private static int find(int[] nums, int i) {
		if (nums[i] == -1) return i;
		return find(nums, nums[i]);
	}
	
	// BFS use List<Set<Integer>>
	public static boolean validTree2(int n, int[][] edges) {
		// build the adj using adjacent list
		List<Set<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new HashSet<>());
		}
		for (int[] e: edges) {
			adj.get(e[0]).add(e[1]);
			adj.get(e[1]).add(e[0]);
		}
		// no cycle
		boolean[] visited = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (visited[curr]) return false;
			visited[curr] = true;
			for (int i: adj.get(curr)) {
				q.add(i);
				adj.get(i).remove(curr);
			}
		}
		for (boolean result: visited) {
			if (!result) return false;
		}
		return true;
	}
	
	// DFS use List<Set<Integer>>
	public static boolean validTree3(int n, int[][] edges) {
		List<Set<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new HashSet<>());
		}
		for (int[] e: edges) {
			adj.get(e[0]).add(e[1]);
			adj.get(e[1]).add(e[0]);
		}
		// no cycle
		boolean[] visited = new boolean[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		while (!stack.isEmpty()) {
			int curr = stack.pop();
			if (visited[curr]) return false;
			visited[curr] = true;
			for (int i: adj.get(curr)) {
				stack.push(i);
				adj.get(i).remove(curr);
			}
		}
		for (boolean result: visited) {
			if (!result) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] t1 = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}};
//		int[][] t2 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
//		System.out.println(validTree(5, t1));
		System.out.println(validTree(5, t1));
	}

}
