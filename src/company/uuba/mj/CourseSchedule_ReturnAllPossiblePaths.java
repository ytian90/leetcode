package company.uuba.mj;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.1point3acres.com/bbs/thread-774605-1-1.html
 * uber eats小哥 course schedule 返回所有的结果
 * https://www.techiedelight.com/find-all-possible-topological-orderings-of-dag/
 */
public class CourseSchedule_ReturnAllPossiblePaths {
    public static List<List<Integer>> findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            degree[p[0]]++;
        }
        List<List<Integer>> res = new ArrayList<>();
        findAllTopologicalOrders(graph, degree, new Stack<>(),
                new boolean[numCourses], numCourses, res);
        return res;
    }

    private static void findAllTopologicalOrders(List<List<Integer>> graph, int[] degree,
                                          Stack<Integer> path, boolean[] visited,
                                          int numCourses, List<List<Integer>> res) {
        for (int v = 0; v < numCourses; v++) {
            if (degree[v] == 0 && !visited[v]) {
                for (int u : graph.get(v)) {
                    degree[u]--;
                }
                path.add(v);
                visited[v] = true;
                findAllTopologicalOrders(graph, degree, path, visited, numCourses, res);
                for (int u : graph.get(v)) {
                    degree[u]++;
                }
                path.pop();
                visited[v] = false;
            }
        }
        if (path.size() == numCourses) {
            res.add(new ArrayList<>(path));
        }
    }

    public static void main(String[] args) {
        System.out.println(findOrder(8, new int[][]{
                {6, 0}, {2, 1}, {4, 1}, {6, 1},
                {0, 3}, {4, 3}, {1, 5}, {0, 7}, {1, 7}
        }));
        System.out.println(findOrder(4, new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        }));
    }
}
