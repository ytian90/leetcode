package leetcode.mj.google;

import leetcode.binaryTree.TreeNode;

import java.util.Arrays;

/**
 * Question 2
 *
 */
public class BinaryTreeDeleteSide {
    // lc 684
    public static int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[]{-1, -1};
        }
        int n = edges.length;
        int[] map = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = i;
        }
        for (int[] e : edges) {
            int x = find(map, e[0]);
            int y = find(map, e[1]);
            if (x == y) {
                return new int[]{e[0], e[1]};
            }
            map[x] = y;
        }
        return new int[]{-1, -1};
    }

    private static int find(int[] map, int i) {
        while (map[i] != i) {
            map[i] = map[map[i]];
            i = map[i];
        }
        return i;
    }

    // lc 685
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1], disjoinSet = new int[n + 1];
        Arrays.fill(parent, -1);
        int first = -1, second = -1, last = -1;
        for (int i = 0; i < n; i++) {
            int x = edges[i][0], y = edges[i][1];
            if (parent[y] != -1) {
                first = parent[y];
                second = i;
                continue;
            }
            parent[y] = i;
            int nx = find2(disjoinSet, x);
            if (nx == y) {
                last = i;
            } else {
                disjoinSet[y] = nx;
            }
        }
        if (last == -1) {
            return edges[second];
        }
        if (second == -1) {
            return edges[last];
        }
        return edges[first];
    }

    private static int find2(int[] ds, int i) {
        return ds[i] == 0 ? i : (ds[i] = find2(ds, ds[i]));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));
    }

    // follow up 1: delete extra edge for bineary search tree
    public void deleteEdge(TreeNode root) {
        if (root == null) return;
        root = dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(TreeNode root, int left, int right) {
        if (root == null) {
            return null;
        }
        if (root.val <= left || root.val >= right) {
            return null;
        }
        root.left = dfs(root.left, left, root.val);
        root.right = dfs(root.right, root.val, right);
        return root;
    }
}
