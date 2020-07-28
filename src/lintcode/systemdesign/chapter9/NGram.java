package lintcode.systemdesign.chapter9;

import java.util.Iterator;

/**
 * 537. N-Gram (Map Reduce)
 */
public class NGram {

    public static class Map {
        public void map(String s, int n, String str,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Integer value);
            for (int i = 0; i < str.length() - n + 1; i++) {
                output.collect(str.substring(i, i + n), 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            output.collect(key, sum);
        }
    }
}
