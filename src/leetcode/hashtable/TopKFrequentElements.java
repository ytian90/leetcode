package leetcode.hashtable;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * @author yutian
 * @since May 7, 2016
 */
public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int num: map.keySet()) {
			int freq = map.get(num);
			if (!freqMap.containsKey(freq)) {
				freqMap.put(freq, new LinkedList<>());
			}
			freqMap.get(freq).add(num);
		}
		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
			res.addAll(entry.getValue());
		}
		return res;
	}

	public static void main(String[] args) {
		TopKFrequentElements t = new TopKFrequentElements();
		System.out.println(t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
		System.out.println(t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4}, 2));
		System.out.println(t.topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4}, 3));
	}

	public List<Integer> topKFrequent2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
				new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
		}
		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			res.add(entry.getKey());
		}
		return res;
	}

	public List<Integer> topKFrequent1(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<>();
			}
			bucket[freq].add(key);
		}
		List<Integer> res = new ArrayList<>();
		for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
			if (bucket[i] != null) {
				res.addAll(bucket[i]);
			}
		}
        return res;
    }

}
