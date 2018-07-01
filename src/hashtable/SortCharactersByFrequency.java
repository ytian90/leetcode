package hashtable;

import java.util.*;

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
			Map.Entry<Character, Integer> entry = pq.poll();
			for (int i = 0; i < entry.getValue(); i++) {
				sb.append(entry.getKey());
			}
		}
		return sb.toString();
    }

    public static String frequencySrot(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		List<Character> [] bucket = new List[s.length() + 1];
		for (char key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}
		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >=0; pos--) {
			if (bucket[pos] != null) {
				for (char num : bucket[pos]) {
					for (int i = 0; i < map.get(num); i++) {
						sb.append(num);
					}
				}
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
