package company.uuba;

import java.util.*;

/**
 * LC 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class TopKFrequentElements {
    /**
     * Time: O(N * logK)
     * Space: O(K)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }
        int[] res = new int[k];
        int j = 0;
        while (j < k) {
            res[j++] = pq.poll()[0];
        }
        return res;
    }

    /**
     * Time: O(N * logK)
     * Space: O(K)
     */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new ArrayList<>());
            }
            freqMap.get(freq).add(n);
        }
        int[] res = new int[k];
        int j = 0;
        while (j < k) {
            for (int i : freqMap.pollLastEntry().getValue()) {
                res[j++] = i;
            }
        }
        return res;
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<>();
            }
            bucket[freq].add(n);
        }
        int[] res = new int[k];
        int j = 0;
        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                List<Integer> l = bucket[i];
                for (int a : l) {
                    res[j++] = a;
                }
                k -= l.size();
            }
        }
        return res;
    }
}
