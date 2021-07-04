package company.uuba;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[numCourses];
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            degree[p[0]]++;
        }
        List<Integer> plan = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                plan.add(i);
            }
        }
        for (int i = 0; i < plan.size(); i++) {
            for (int j : graph.get(plan.get(i))) {
                if (--degree[j] == 0) {
                    plan.add(j);
                }
            }
        }
        return plan.size() == numCourses;
    }
    /**
     * Time: O(E + V), V is the number of courses, E is the number of dependencies.
     * Space: O(E + V)
     */

    public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] visited = new int[numCourses];
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int i) {
        if (visited[i] == 1) return false; // visited
        if (visited[i] == 2) return true; // completed
        visited[i] = 1;
        for (int j : graph.get(i)) {
            if (!dfs(graph, visited, j)) {
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }
    /**
     * Time: O(E + V), V is the number of courses, E is the number of dependencies.
     * Space: O(E + V)
     */
}
