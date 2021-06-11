package leetcode.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1192. Critical Connections in a Network
 */
public class CriticalConnectionsInANetwork {
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> conn : connections) {
            graph.get(conn.get(0)).add(conn.get(1));
            graph.get(conn.get(1)).add(conn.get(0));
        }
        boolean[] visited = new boolean[n];
        int[] rank = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        // call dfs on prev node and current node -> no previous, set prev to -1 to start.
        dfs(graph, -1, 0, 0, rank, visited, res);
        return res;
    }

    private static void dfs(List<List<Integer>> graph, int prev, int curr, int depth, int[] rank,
                            boolean[] visited, List<List<Integer>> res) {
        if (visited[curr]) return;
        // set visited and update rank to be current depth
        visited[curr] = true;
        rank[curr] = depth;
        for (int next : graph.get(curr)) {
            // prev is same node as next, ignore and continue
            if (prev == next) continue;
            // dfs if value has not been visited
            if (!visited[next]) {
                dfs(graph, curr, next, depth + 1, rank, visited, res);
            }
            // update current node to be min -> keep us in track in case of cycle
            rank[curr] = Math.min(rank[curr], rank[next]);
            // if not cycle, new node has larger rank, and it is critical connection
            if (rank[next] > depth) {
                res.add(Arrays.asList(curr, next));
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> conn = new ArrayList<>();
        conn.add(Arrays.asList(0, 1));
        conn.add(Arrays.asList(1, 2));
        conn.add(Arrays.asList(2, 0));
        conn.add(Arrays.asList(1, 3));
        System.out.println(criticalConnections(4, conn));
    }


    // low[u] records the lowest vertex u can reach
    // disc[u] records the time when u was discovered
    public static List<List<Integer>> criticalConnections2(int n, List<List<Integer>> connections) {
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

}
