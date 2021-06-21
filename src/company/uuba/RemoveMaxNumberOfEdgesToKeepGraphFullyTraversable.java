package company.uuba;

import java.util.Arrays;

/**
 * LC 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
 *
 * Alice and Bob have an undirected graph of n nodes and 3 types of edges:
 *
 * Type 1: Can be traversed by Alice only.
 * Type 2: Can be traversed by Bob only.
 * Type 3: Can by traversed by both Alice and Bob.
 * Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any node, they can reach all other nodes.
 *
 * Return the maximum number of edges you can remove, or return -1 if it's impossible for the graph to be fully traversed by Alice and Bob.
 *
 * Example 1:
 *
 * Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
 * Output: 2
 * Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.
 * Example 2:
 *
 * Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
 * Output: 0
 * Explanation: Notice that removing any edge will not make the graph fully traversable by Alice and Bob.
 * Example 3:
 *
 * Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
 * Output: -1
 * Explanation: In the current graph, Alice cannot reach node 4 from the other nodes. Likewise, Bob cannot reach 1. Therefore it's impossible to make the graph fully traversable.
 */
public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> (b[0] - a[0]));
        int add = 0;
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        for (int[] e : edges) {
            int type = e[0], a = e[1], b = e[2];
            if (type == 3) {
                // Both will run because it is using bitwise OR(|) and not logical OR(||)
                if (alice.union(a, b) | bob.union(a, b)) {
                    add++;
                }
            } else if (type == 2) {
                if (bob.union(a, b)) {
                    add++;
                }
            } else if (type == 1) {
                if (alice.union(a, b)) {
                    add++;
                }
            }
        }
        return (alice.united() && bob.united()) ? edges.length - add : -1;
    }

    private class UnionFind {
        int[] root;
        int n;

        public UnionFind(int n) {
            this.root = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                root[i] = i;
            }
            this.n = n;
        }

        private boolean union(int a, int b) {
            int x = find(a), y = find(b);
            if (x != y) {
                root[x] = y;
                n--;
                return true;
            }
            return false;
        }

        private int find(int i) {
            while (root[i] != i) {
                i = root[i];
                root[i] = root[root[i]];
            }
            return i;
        }

        private boolean united() {
            return n == 1;
        }

    }
}
