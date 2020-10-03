package lintcode.systemdesign.chapter10;

import java.util.*;

/**
 * 1787. Google Suggestion (Map Reduce)
 */
public class GoogleSuggestion {
    public static class Map {
        public void map(Document value,
                        OutputCollector<String, Pair> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Pair value);
            String content = value.content;
            String words = "";
            Pair value_pair = new Pair(content, value.count);
            for (int i = 0; i < content.length(); i++) {
                words += content.charAt(i);
                output.collect(words, value_pair);
            }
        }
    }

    public static class Reduce {
        public void setup() {
            // initialize your data structure here
        }
        private Comparator<Pair> cmp = new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.getCount() != b.getCount()) {
                    return a.getCount() - b.getCount();
                }
                return b.getContent().compareTo(a.getContent());
            }
        };
        public void reduce(String key, Iterator<Pair> values, OutputCollector<String, Pair> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Pair value);
            PriorityQueue<Pair> pq = new PriorityQueue<>(cmp);
            List<Pair> list = new ArrayList<>();
            while (values.hasNext()) {
                pq.add(values.next());
                if (pq.size() > 10) {
                    pq.poll();
                }
            }
            while (!pq.isEmpty()) {
                list.add(pq.poll());
            }
            int n = list.size();
            for (int i = n - 1; i >= 0; i--) {
                output.collect(key, list.get(i));
            }
        }
    }

}

class OutputCollector<K, V> {
    public void collect(K key, V value) {
    }
}

class Document {
    public int count;
    public String content;
    public int id;
}

class Pair {
    private String content;
    private int count;

    Pair(String key, int value) {
        this.content = key;
        this.count = value;
    }

    public String getContent() {
        return this.content;
    }

    public int getCount() {
        return this.count;
    }
}