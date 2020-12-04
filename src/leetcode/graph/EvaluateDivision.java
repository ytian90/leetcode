package leetcode.graph;

import java.util.*;

/**
 * 399. Evaluate Division
 * @author yutian
 *
 */
public class EvaluateDivision {

	public static double[] calcEquation(List<List<String>> equations, double[] values, String[][] queries) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			String src = equations.get(i).get(0), dst = equations.get(i).get(1);
			map.putIfAbsent(src, new HashMap<>());
			map.putIfAbsent(dst, new HashMap<>());
			map.get(src).put(src, 1.0);
			map.get(dst).put(dst, 1.0);
			map.get(src).put(dst, values[i]);
			map.get(dst).put(src, 1 / values[i]);
		}
		double[] res = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String[] query = queries[i];
			res[i] = dfs(query[0], query[1], map, new HashSet<>(), 1.0);
			if (res[i] == 0.0) res[i] = -1;
		}
		return res;
	}

	private static double dfs(String start, String end, Map<String, Map<String, Double>> map, Set<String> set, double value) {
		if (set.contains(start) || !map.containsKey(start)) {
			return 0.0;
		}
		if (start.equals(end)) {
			return value;
		}
		set.add(start);
		double temp = 0.0;
		Map<String, Double> tMap = map.get(start);
		for (Map.Entry<String, Double> e : tMap.entrySet()) {
			temp = dfs(e.getKey(), end, map, set, value * e.getValue());
			if (temp != 0) {
				break;
			}
		}
		set.remove(start);
		return temp;
	}

	public static void main(String[] args) {
		List<List<String>> t = new ArrayList<>();
		t.add(Arrays.asList("a", "b"));
		t.add(Arrays.asList("b", "c"));

		System.out.println(Arrays.toString(calcEquation(
				t,
				new double[] {2.0, 3.0},
				new String[][] {
						{"a", "c"},
						{"b", "a"},
						{"a", "e"},
						{"a", "a"},
						{"x", "x"},
				}
		)));
	}

}
