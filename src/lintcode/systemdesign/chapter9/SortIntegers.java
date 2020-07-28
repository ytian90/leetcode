package lintcode.systemdesign.chapter9;

import java.util.*;

/**
 * 554. Map Reduce
 */
public class SortIntegers {
    public static class Map {
        public void map(int _, List<Integer> value,
                        OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            Collections.sort(value);
            output.collect("ignore_key", value);
        }
    }

    public static class Reduce {
        public void reduce(String key, List<List<Integer>> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> res = new ArrayList<>();
            if (values.size() == 0) {
                output.collect(key, res);
                return;
            }
            int total = 0;
            Comparator<Element> elementComparator = new Comparator<Element>() {
                public int compare(Element left, Element right) {
                    return left.val - right.val;
                }
            };
            Queue<Element> q = new PriorityQueue<>(values.size(), elementComparator);
            int k = values.size();
            for (int i = 0; i < k; i++) {
                if (values.get(i).size() > 0) {
                    Element element = new Element(i, 0, values.get(i).get(0));
                    q.add(element);
                }
            }
            while (!q.isEmpty()) {
                Element element = q.poll();
                res.add(element.val);
                if (element.col + 1 < values.get(element.row).size()) {
                    element.col++;
                    element.val = values.get(element.row).get(element.col);
                    q.add(element);
                }
            }
            output.collect(key, res);
        }
    }
}

class Element {
    public int row, col, val;

    public Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

class OutputCollector<K, V> {
    public void collect(K key, V value){}
    // Adds a key/value pair to the output buffer
}