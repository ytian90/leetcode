package hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. Sort Characters By Frequency
 * @author ytian
 *
 */
public class SortCharactersByFrequency {
	
	public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        		(a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
        	Map.Entry<Character, Integer> e = pq.poll();
        	for (int i = 0; i < (int) e.getValue(); i++) {
        		sb.append(e.getKey());
        	}
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("Aabb"));
	}

}
