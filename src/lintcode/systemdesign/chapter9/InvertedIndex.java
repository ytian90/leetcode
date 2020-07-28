package lintcode.systemdesign.chapter9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 504. Inverted Index(Map Reduce)
 */
public class InvertedIndex {
    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int id = value.id;
            StringTokenizer tokenizer = new StringTokenizer(value.content);
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                output.collect(word, id);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> res = new ArrayList<>();
            int prev = -1;
            while (values.hasNext()) {
                int curr = values.next();
                if (prev != curr) {
                    res.add(curr);
                }
                prev = curr;
            }
            output.collect(key, res);
        }
    }
}

class Document {
    public int id;
    public String content;
}