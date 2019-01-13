package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 269. Alien Dictionary
 * https://leetcode.com/discuss/78602/3ms-clean-java-solution-dfs
 * https://leetcode.com/discuss/77078/easiest-java-bfs-solution
 * @author yutian
 * @since Feb 6, 2016
 */
public class AlienDictionary {

	private static final int N = 26;
	/*
	 * visited[i] = -1. Not even exist.
	 * visited[i] = 0. Exist. Non-visited.
	 * visited[i] = 1. Visiting.
	 * visited[i] = 2. Visited.
	 */
	// DFS
	public static String alienOrder(String[] words) {
		boolean[][] adj = new boolean[N][N];
		int[] visited = new int[N];
		buildGraph(words, adj, visited);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (visited[i] == 0) {
				if (!dfs(adj, visited, sb, i)) return "";
			}
		}
		return sb.reverse().toString();
	}

	private static boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
		visited[i] = 1;
		for (int j = 0; j < N; j++) {
			if (adj[i][j]) {
				if (visited[j] == 1) return false;
				if (visited[j] == 0) {
					if (!dfs(adj, visited, sb, j)) return false;
				}
			}
		}
		visited[i] = 2;
		sb.append((char) (i + 'a'));
		return true;
	}

	private static void buildGraph(String[] words, boolean[][] adj, int[] visited) {
		Arrays.fill(visited, -1); // -1 not even existed
		for (int i = 0; i < words.length; i++) {
			for (char c : words[i].toCharArray())
				visited[c - 'a'] = 0; // exist not visited
			if (i != 0) {
				String w1 = words[i - 1], w2 = words[i];
				int len = Math.min(w1.length(), w2.length());
				for (int j = 0; j < len; j++) {
					char c1 = w1.charAt(j), c2 = w2.charAt(j);
					if (c1 != c2) {
						adj[c1 - 'a'][c2 - 'a'] = true;
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] t = new String[]{"wrtkj","wrt"};
		System.out.println(alienOrder(t));
	}

	public static String alienOrder1(String[] words) {
		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> degree = new HashMap<>();
		String result = "";
		if (words == null || words.length == 0)
			return result;
		for (String s : words) {
			for (char c : s.toCharArray()) {
				degree.put(c, 0);
			}
		}
		for (int i = 0; i < words.length - 1; i++) {
			String curr = words[i];
			String next = words[i + 1];
			int length = Math.min(curr.length(), next.length());
			for (int j = 0; j < length; j++) {
				char c1 = curr.charAt(j);
				char c2 = next.charAt(j);
				if (c1 != c2) {
					Set<Character> set = new HashSet<>();
					if (map.containsKey(c1))
						set = map.get(c1);
					if (!set.contains(c2)) {
						set.add(c2);
						map.put(c1, set);
						degree.put(c2, degree.get(c2) + 1);
					}
					break;
				}
			}
		}
		Queue<Character> q = new LinkedList<>();
		for (char c : degree.keySet()) {
			if (degree.get(c) == 0) q.add(c);
		}
		while (!q.isEmpty()) {
			char c = q.remove();
			result += c;
			if (map.containsKey(c)) {
				for (char c2 : map.get(c)) {
					degree.put(c2, degree.get(c2) - 1);
					if (degree.get(c2) == 0) q.add(c2);
				}
			}
		}
		if (result.length() != degree.size()) return "";
		return result;
	}

	// BFS
	public String alienOrder2(String[] words) {
		List<Set<Integer>> adj = new ArrayList<>(N);
		int[] degree = new int[N];
		buildGraph(words, adj, degree);
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (degree[i] == 0) q.add(i);
		}
		while (!q.isEmpty()) {
			int i = q.poll();
			sb.append((char) ('a' + i));
			for (int j : adj.get(i)) {
				if (--degree[j] == 0) q.add(j);
			}
		}
		for (int d: degree) if (d > 0) return "";
		return sb.toString();
	}

	private void buildGraph(String[] words, List<Set<Integer>> adj, int[] degree) {
		for (int i = 0; i < N; i++) {
			adj.add(new HashSet<Integer>());
		}
		Arrays.fill(degree, -1);
		for (int i = 0; i < words.length; i++) {
			for (char c : words[i].toCharArray()) {
				if (degree[c - 'a'] < 0) degree[c - 'a'] = 0;
			}
			if (i != 0) {
				String w1 = words[i - 1], w2 = words[i];
				int len = Math.min(w1.length(), w2.length());
				for (int j = 0; j < len; j++) {
					if (w1.charAt(j) != w2.charAt(j)) {
						int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
						if (!adj.get(c1).contains(c2)) {
							adj.get(c1).add(c2);
							degree[c2]++;
							break;
						}
					}
				}
			}
		}
	}

}
