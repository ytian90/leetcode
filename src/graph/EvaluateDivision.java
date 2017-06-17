package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 399. Evaluate Division
 * @author yutian
 *
 */
public class EvaluateDivision {
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
        	String[] e = equations[i];
        	if (!pairs.containsKey(e[0])) {
        		pairs.put(e[0], new ArrayList<String>());
        		valuesPair.put(e[0], new ArrayList<Double>());
        	}
        	if (!pairs.containsKey(e[1])) {
        		pairs.put(e[1], new ArrayList<String>());
        		valuesPair.put(e[1], new ArrayList<Double>());
        	}
        	pairs.get(e[0]).add(e[1]);
        	pairs.get(e[1]).add(e[0]);
        	valuesPair.get(e[0]).add(values[i]);
        	valuesPair.get(e[1]).add(1/values[i]);
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
        	String[] query = queries[i];
        	result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
        	if (result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }

	private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs,
			HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
		if (set.contains(start)) return 0.0;
		if (!pairs.containsKey(start)) return 0.0;
		if (start.equals(end)) return value;
		
		set.add(start);
		ArrayList<String> strList = pairs.get(start);
		ArrayList<Double> valueList = values.get(start);
		double res = 0.0;
		for (int i = 0; i < strList.size(); i++) {
			res = dfs(strList.get(i), end, pairs, values, set, value * valueList.get(i));
			if (res != 0.0) break;
		}
		set.remove(start);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
