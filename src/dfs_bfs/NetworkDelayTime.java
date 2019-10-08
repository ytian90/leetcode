package dfs_bfs;

import java.util.*;

/**
 * 743. Network Delay Time (Method 2)
 * @author ytian
 *
 */
public class NetworkDelayTime {

	public static int networkDelayTime(int[][] times, int N, int K) {
		if (times == null || times.length == 0) {
			return -1;
		}
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[K] = 0;

		for (int i = 0; i < N; i++) {
			for (int[] e : times) {
				int source = e[0], target = e[1], time = e[2];
				if (dp[source] != Integer.MAX_VALUE && dp[target] > dp[source] + time) {
					dp[target] = dp[source] + time;
				}
			}
		}
		int res = 0;
		for (int i = 1; i <= N; i++) {
			res = Math.max(res, dp[i]);
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static int networkDelayTime1(int[][] times, int N, int K) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int[] e : times) {
			map.putIfAbsent(e[0], new HashMap<>());
			map.get(e[0]).put(e[1], e[2]);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		pq.add(new int[]{0, K});
		boolean[] visited = new boolean[N + 1];
		int res = 0;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currDist = curr[0];
			int currNode = curr[1];
			if (visited[currNode]) {
				continue;
			}
			visited[currNode] = true;
			res = currDist;
			N--;
			if (map.containsKey(currNode)) {
				for (int next : map.get(currNode).keySet()) {
					pq.add(new int[]{currDist + map.get(currNode).get(next), next});
				}
			}
		}
		return N == 0 ? res : -1;
	}

	public static void main(String[] args) {
		System.out.println(networkDelayTime1(new int[][]{{3, 4, 1}, {2, 1, 1}, {2, 3, 1}}, 4, 2));
	}

	// time O(N^2 + E) space O(N + E)
	public int networkDelayTime11(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] e : times) {
			if (!graph.containsKey(e[0])) {
				graph.put(e[0], new ArrayList<>());
			}
			graph.get(e[0]).add(new int[] {e[1], e[2]});
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		pq.add(new int[] {0, K});
		Map<Integer, Integer> dist = new HashMap<>();
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int time = curr[0], target = curr[1];
			if (dist.containsKey(target)) continue;
			dist.put(target, time);
			if (graph.containsKey(target)) {
				for (int[] e : graph.get(target)) {
					int localTarget = e[0], localTime = e[1];
					if (!dist.containsKey(localTarget)) {
						pq.offer(new int[] {time + localTime, localTarget});
					}
				}
			}
		}
		if (dist.size() != N) return -1;
		int res = 0;
		for (int c : dist.values()) {
			res = Math.max(res, c);
		}
		return res;
	}
	
	// simple
	Map<Integer, Integer> dist;
	
	public int networkDelayTime2(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] e : times) {
			if (!graph.containsKey(e[0])) {
				graph.put(e[0], new ArrayList<>());
			}
			graph.get(e[0]).add(new int[] {e[1], e[2]});
		}
		dist = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			dist.put(i, Integer.MAX_VALUE);
		}
		dist.put(K, 0);
		boolean[] seen = new boolean[N + 1];
		while (true) {
			int cNode = -1;
			int cDist = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				if (!seen[i] && dist.get(i) < cDist) {
					cDist = dist.get(i);
					cNode = i;
				}
			}
			if (cNode < 0) break;
			seen[cNode] = true;
			if (graph.containsKey(cNode)) {
				for (int[] i : graph.get(cNode)) {
					dist.put(i[0], Math.min(dist.get(i[0]), dist.get(cNode) + i[1]));
				}
			}
		}
		int res = 0;
		for (int c : dist.values()) {
			if (c == Integer.MAX_VALUE) return -1;
			res = Math.max(res, c);
		}
		return res;
	}
}
