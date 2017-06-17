package dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 332. Reconstruct Itinerary
 * @author yutian
 * @since Feb 14, 2016
 */
public class ReconstructItinerary {
	
	public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.length == 0) return result;
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
        	if (!map.containsKey(tickets[i][0]))
        		map.put(tickets[i][0], new PriorityQueue<String>());
        	map.get(tickets[i][0]).add(tickets[i][1]);
        }
        String curr = "JFK";
        Stack<String> drawBack = new Stack<String>();
        for (int i = 0; i < tickets.length; i++) {
        	while (!map.containsKey(curr) || map.get(curr).isEmpty()) {
        		drawBack.push(curr); 
        		curr = result.remove(result.size() - 1);
        	}
        	result.add(curr);
        	curr = map.get(curr).poll();
        }
        result.add(curr);
        while (!drawBack.isEmpty()) result.add(drawBack.pop());
        return result;
    }

	public static void main(String[] args) {
		ReconstructItinerary t = new ReconstructItinerary();
		System.out.println(t.findItinerary(new String[][]{{"MUC", "LHR"}, 
				{"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}));
		System.out.println(t.findItinerary(new String[][]{{"JFK","SFO"}, 
				{"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}}));
	}

}
