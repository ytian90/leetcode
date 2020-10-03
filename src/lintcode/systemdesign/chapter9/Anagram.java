package lintcode.systemdesign.chapter9;

import java.util.*;

/**
 * 503. Anagram (Map Reduce)
 */
public class Anagram {
    public static class Map {
        public void map(String key, String value,
                        OutputCollector<String, String> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, String value);
            StringTokenizer tokenizer = new StringTokenizer(value);
            while (tokenizer.hasMoreTokens()) {
                String word = tokenizer.nextToken();
                char[] sc = word.toCharArray();
                Arrays.sort(sc);
                output.collect(new String(sc), word);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<String> values,
                           OutputCollector<String, List<String>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<String> value);
            List<String> results = new ArrayList<>();
            while (values.hasNext()) {
                results.add(values.next());
            }
            output.collect(key, results);
        }
    }
}
