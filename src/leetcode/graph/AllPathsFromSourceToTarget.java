package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 */
public class AllPathsFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(graph, 0, path, res);
        return res;
    }

    private static void helper(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[node]) {
            path.add(next);
            helper(graph, next, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        for (List<Integer> l : allPathsSourceTarget(new int[][]{
                {1, 2},
                {3},
                {3},
                {}
        })) {
            System.out.println(l);
        }
    }
}
