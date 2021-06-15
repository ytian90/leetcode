package company.lnkin;

/**
 * LC 323. Number of Connected Components in an Undirected Graph
 *
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 *
 * Return the number of connected components in the graph.
 *
 * Example 1:
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 *
 * Example 2:
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
 * Output: 1
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] e : edges) {
            int i = find(root, e[0]);
            int j = find(root, e[1]);
            if (i != j) {
                root[i] = j;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (root[i] == i) {
                res++;
            }
        }
        return res;
    }

    private int find(int[] root, int i) {
        while (root[i] != i) {
            i = root[i];
            root[i] = root[root[i]];
        }
        return i;
    }
}
