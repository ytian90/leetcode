package dfs_bfs;

import java.util.*;

/**
 * 332. Reconstruct Itinerary
 * @author yutian
 * @since Feb 14, 2016
 */
public class ReconstructItinerary {

	public static List<String> findItinerary(List<List<String>> tickets) {
		List<String> path = new LinkedList<>();
		if (tickets.size() == 0) {
			return path;
		}
		Map<String, PriorityQueue<String>> flights = new HashMap<>();
		for (List<String> l : tickets) {
			if (!flights.containsKey(l.get(0))) {
				flights.put(l.get(0), new PriorityQueue<>());
			}
			flights.get(l.get(0)).add(l.get(1));
		}
		dfs("JFK", flights, path);
		return path;
	}

	private static void dfs(String departure, Map<String, PriorityQueue<String>> flights, List<String> path) {
		PriorityQueue<String> arrivals = flights.get(departure);
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll(), flights, path);
		}
		path.add(0, departure);
	}

	public static List<String> findItinerary2(List<List<String>> tickets) {
		List<String> res = new ArrayList<>();
		if (tickets.size() == 0) {
			return res;
		}
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> t : tickets) {
			if (!map.containsKey(t.get(0))) {
				map.put(t.get(0), new PriorityQueue<>());
			}
			map.get(t.get(0)).add(t.get(1));
		}
		String curr = "JFK";
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < tickets.size(); i++) {
			while (!map.containsKey(curr) || map.get(curr).isEmpty()) {
				stack.push(curr);
				curr = res.remove(res.size() - 1);
			}
			res.add(curr);
			curr = map.get(curr).poll();
		}
		res.add(curr);
		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}
		return res;
	}

	public static void main(String[] args) {
		List<List<String>> t = new ArrayList<>();
		t.add(new ArrayList<>(Arrays.asList("JFK", "SFO")));
		t.add(new ArrayList<>(Arrays.asList("JFK", "ALT")));
		t.add(new ArrayList<>(Arrays.asList("SFO", "ALT")));
		t.add(new ArrayList<>(Arrays.asList("ALT", "JFK")));
		t.add(new ArrayList<>(Arrays.asList("ALT", "SFO")));
		System.out.println(findItinerary2(t));

		List<List<String>> t2 = new ArrayList<>();
		t2.add(new ArrayList<>(Arrays.asList("JFK", "NRT")));
		t2.add(new ArrayList<>(Arrays.asList("JFK", "KUL")));
		t2.add(new ArrayList<>(Arrays.asList("NRT", "JFK")));
		System.out.println(findItinerary2(t2));
	}
}
