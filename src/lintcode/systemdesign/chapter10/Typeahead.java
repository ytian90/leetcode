package lintcode.systemdesign.chapter10;

import java.util.*;

/**
 * 231, auto suggestion
 */
public class Typeahead {
    private Map<String, List<String>> map = new HashMap<>();
    /*
     * @param dict: A dictionary of words dict
     */
    public Typeahead(Set<String> dict) {
        for (String str : dict) {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    String temp = str.substring(i, j);
                    if (!map.containsKey(temp)) {
                        map.put(temp, new ArrayList<>());
                        map.get(temp).add(str);
                    } else {
                        List<String> list = map.get(temp);
                        if (!str.equals(list.get(list.size() - 1))) {
                            list.add(str);
                        }
                    }
                }
            }
        }
    }

    /*
     * @param str: a string
     * @return: a list of words
     */
    public List<String> search(String str) {
        if (!map.containsKey(str)) {
            return new ArrayList<>();
        }
        return map.get(str);
    }
}
