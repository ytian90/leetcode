package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 888. Uncommon Words from Two Sentences
 */
public class UncommonWordsFromTwoSentences {

    public static String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = (A + " " + B).split(" ");
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String w : map.keySet()) {
            if (map.get(w) == 1)
                res.add(w);
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet",
                "this apple is sour")));
        System.out.println(Arrays.toString(uncommonFromSentences("apple apple",
                "banana")));

    }
}
