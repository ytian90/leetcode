package mj.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * lc834
 */
public class SumOfDistancesInTree {
    int[] res, count;
    List<Set<Integer>> tree;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N; i++) {
            tree.add(new HashSet<>());
        }
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return res;
    }

    public void dfs(int root, int prev) {
        for (int i : tree.get(root)) {
            if (i == prev) {
                continue;
            }
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }

    public void dfs2(int root, int prev) {
        for (int i : tree.get(root)) {
            if (i == prev) {
                continue;
            }
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
        }
    }
}
