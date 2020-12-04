package leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1192. Critical Connections in a Network
 */
public class CriticalConnectionsInANetwork {
    // low[u] records the lowest vertex u can reach
    // disc[u] records the time when u was discovered
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n], low = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(disc, -1);
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> conn : connections) {
            int a = conn.get(0), b = conn.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, graph, res, i);
            }
        }
        return res;
    }

    private static int time = 0; // time when discover each vertex

    private static void dfs(int from, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int prev) {
        disc[from] = low[from] = time++;
        for (int to : graph[from]) {
            if (to == prev) {
                continue;
            }
            if (disc[to] == -1) {
                dfs(to, low, disc, graph, res, from);
                low[from] = Math.min(low[from], low[to]);
                if (low[to] > disc[from]) {
                    res.add(Arrays.asList(from, to));
                }
            } else {
                low[from] = Math.min(low[from], disc[to]);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> conn = new ArrayList<>();
        conn.add(new ArrayList<>(Arrays.asList(0, 1)));
        conn.add(new ArrayList<>(Arrays.asList(1, 2)));
        conn.add(new ArrayList<>(Arrays.asList(2, 0)));
        conn.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(criticalConnections(4, conn));
    }
}
