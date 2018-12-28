package graph;

import java.util.*;

/**
 * 399. Evaluate Division
 * @author yutian
 *
 */
public class EvaluateDivision {

	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, List<String>> pairs = new HashMap<>();
		Map<String, List<Double>> valuesPair = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			String[] e = equations[i];
			if (!pairs.containsKey(e[0])) {
				pairs.put(e[0], new ArrayList<>());
				valuesPair.put(e[0], new ArrayList<>());
			}
			if (!pairs.containsKey(e[1])) {
				pairs.put(e[1], new ArrayList<>());
				valuesPair.put(e[1], new ArrayList<>());
			}
			pairs.get(e[0]).add(e[1]);
			pairs.get(e[1]).add(e[0]);
			valuesPair.get(e[0]).add(values[i]);
			valuesPair.get(e[1]).add(1/values[i]);
		}
		double[] res = new double[queries.length];
		for (int i = 0; i < res.length; i++) {
			String[] query = queries[i];
			res[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<>(), 1.0);
			if (res[i] == 0.0) res[i] = -1.0;
		}
		return res;
	}

	public static double dfs(String start, String end, Map<String, List<String>> pairs, Map<String,
			List<Double>> values, Set<String> set, double value) {
		if (set.contains(start)) return 0.0;
		if (!pairs.containsKey(start)) return 0.0;
		if (start.equals(end)) return value;
		set.add(start);

		List<String> strList = pairs.get(start);
		List<Double> valueList = values.get(start);
		double res = 0.0;
		for (int i = 0; i < strList.size(); i++) {
			res = dfs(strList.get(i), end, pairs, values, set, value * valueList.get(i));
			if (res != 0.0) break;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(calcEquation(
				new String[][]{
						{"a", "b"},
						{"b", "c"}
				},
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
