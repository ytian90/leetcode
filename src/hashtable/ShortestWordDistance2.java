package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 244. Shorteset Word Distance 2
 * @author yutian
 * @since Jan 1, 2016
 */
public class ShortestWordDistance2 {

    Map<String, List<Integer>> map;

    public ShortestWordDistance2(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        if (!map.containsKey(word1) || !map.containsKey(word2)) {
            return -1;
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        return shortestHelper(list1, list2);
    }

    private int shortestHelper(List<Integer> list1, List<Integer> list2) {
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
	public static void main(String[] args) {
		String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
		ShortestWordDistance2 wd = new ShortestWordDistance2(words);
		System.out.println(wd.shortest("coding", "practice"));
		System.out.println(wd.shortest("makes", "coding"));
		
	}

}
