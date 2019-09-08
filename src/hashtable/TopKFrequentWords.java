package hashtable;

import java.util.*;

/**
 * 692. Top K Frequent Words
 */
public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>
                ((a, b) -> (map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a)));
        pq.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                res.add(pq.poll());
            }
        }
        return res;
    }

    public static List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        TreeMap<Integer, List<String>> freqMap = new TreeMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : map.keySet()) {
            int freq = map.get(s);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new ArrayList<>());
            }
            freqMap.get(freq).add(s);
        }
        List<String> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, List<String>> e = freqMap.pollLastEntry();
            List<String> list = e.getValue();
            Collections.sort(list);
            if (list.size() + res.size() < k) {
                res.addAll(list);
            } else {
                int a = k - res.size();
                for (int i = 0; i < a; i++) {
                    res.add(list.get(i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
        System.out.println(topKFrequent(new String[]{"a", "aa", "aaa"}, 2));
    }
}
