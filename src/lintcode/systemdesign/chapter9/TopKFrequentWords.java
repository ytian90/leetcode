package lintcode.systemdesign.chapter9;

import java.util.*;

/**
 * 549. Top K Frequent words
 */
public class TopKFrequentWords {
    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int id = value.id;
            String content = value.content;
            String[] words = content.split(" ");
            for (String word : words)
                if (word.length() > 0) {
                    output.collect(word, 1);
                }
        }
    }

    public static class Reduce {
        private PriorityQueue<Pair> q;
        private int k;

        private Comparator<Pair> cmp = new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.value != b.value) {
                    return a.value - b.value;
                }
                return b.key.compareTo(a.key);
            }
        };

        public void setup(int k) {
            // initialize your data structure here
            q = new PriorityQueue<Pair>(k, cmp);
            this.k = k;
        }

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            Pair curr = new Pair(key, sum);
            if (q.size() < k) {
                q.add(curr);
            } else {
                Pair peek = q.peek();
                if (cmp.compare(curr, peek) > 0) {
                    q.poll();
                    q.add(curr);
                }
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<Pair> res = new ArrayList<>();
            while (!q.isEmpty()) {
                res.add(q.poll());
            }
            for (int i = res.size() - 1; i >= 0; i--) {
                Pair curr = res.get(i);
                output.collect(curr.key, curr.value);
            }
        }
    }
}

class Pair {
    String key;
    int value;
    public Pair (String key, int value) {
        this.key = key;
        this.value = value;
    }
}