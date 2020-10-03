package lintcode.systemdesign.chapter10;

import java.util.*;

/**
 * 500. Inverted Index
 */
public class InvertedIndex {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        Map<String, List<Integer>> res = new HashMap<>();
        for (Document doc : docs) {
            String[] split = doc.content.split(" +");
            Set<String> set = new HashSet<>(Arrays.asList(split));
            for(String key : set) {
                if (!res.containsKey(key)) {
                    res.put(key, new ArrayList<>());
                }
                res.get(key).add(doc.id);
            }
        }
        return res;
    }
}