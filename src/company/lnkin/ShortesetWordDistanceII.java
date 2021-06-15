package company.lnkin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 244. Shortest Word Distance II
 *
 * Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest
 * distance between two different strings from the array.
 *
 * Implement the WordDistance class:
 *
 * WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
 * int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
 *
 *
 * Example 1:
 *
 * Input
 * ["WordDistance", "shortest", "shortest"]
 * [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
 * Output
 * [null, 3, 1]
 *
 * Explanation
 * WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
 * wordDistance.shortest("coding", "practice"); // return 3
 * wordDistance.shortest("makes", "coding");    // return 1
 *
 */
public class ShortesetWordDistanceII {
    Map<String, List<Integer>> map = new HashMap<>();

    public ShortesetWordDistanceII(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<>());
            }
            map.get(word).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        if (!map.containsKey(word1) || !map.containsKey(word2)) {
            return -1;
        }
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0, j = 0; i < l1.size() && j < l2.size();) {
            res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }

    public static void main(String[] args) {
        ShortesetWordDistanceII obj = new ShortesetWordDistanceII(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(obj.shortest("coding", "practice"));
        System.out.println(obj.shortest("makes", "coding"));
    }
}
