package company.uuba;

import java.util.*;

/**
 * LC 399. Evaluate Division
 *
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> e = equations.get(i);
            map.putIfAbsent(e.get(0), new HashMap<>());
            map.putIfAbsent(e.get(1), new HashMap<>());
            map.get(e.get(0)).put(e.get(1), values[i]);
            map.get(e.get(1)).put(e.get(0), 1 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1, map, new HashSet<>());
        }
        return res;
    }

    private double dfs(String start, String end, double value, Map<String, Map<String, Double>> map, Set<String> visited) {
        if (!map.containsKey(start) || visited.contains(start)) {
            return -1;
        }
        if (start.equals(end)) {
            return value;
        }
        visited.add(start);
        Map<String, Double> next = map.get(start);
        for (String s : next.keySet()) {
            double res = dfs(s, end, value * next.get(s), map, visited);
            if (res != -1) {
                return res;
            }
        }
        return -1;
    }
    /**
     * Time: O(E + Q * (V + E)), V is number of nodes, E is number of edges,
     * Construct the adjacent list O(E),  DFS of graph (V + E), Q is the number of queries
     * Space: O(2 * E + Q)
     */

}
