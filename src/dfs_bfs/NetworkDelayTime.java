package dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 743. Network Delay Time (Method 2)
 * @author ytian
 *
 */
public class NetworkDelayTime {

	// time O(N^2 + E) space O(N + E)
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] e : times) {
			if (!graph.containsKey(e[0])) {
				graph.put(e[0], new ArrayList<>());
			}
			graph.get(e[0]).add(new int[] {e[1], e[2]});
		}
		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		heap.add(new int[] {0, K});
		Map<Integer, Integer> dist = new HashMap<>();
		while (!heap.isEmpty()) {
			int[] curr = heap.poll();
			int d = curr[0], node = curr[1];
			if (dist.containsKey(node)) continue;
			dist.put(node, d);
			if (graph.containsKey(node)) {
				for (int[] e : graph.get(node)) {
					int n = e[0], d2 = e[1];
					if (!dist.containsKey(n)) {
						heap.offer(new int[] {d + d2, n});
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
