package company.lnkin;

/**
 * LC 261. Graph Valid Tree
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Example 1:
 *
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 * Example 2:
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] e : edges) {
            if (!unionFind.union(e[0], e[1])) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        private int[] root;

        public UnionFind(int n) {
            this.root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public int find(int i) {
            while (i != root[i]) {
                i = root[i];
                root[i] = root[root[i]];
            }
            return i;
        }

        public boolean union(int i, int j) {
            int x = find(i);
            int y = find(j);
            if (x == y) {
                return false;
            }
            root[x] = y;
            return true;
        }
    }
    /**
     * Time: O(V + E)
     * Space: O(V)
     */
}
