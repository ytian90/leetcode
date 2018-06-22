package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 244. Shorteset Word Distance 2
 * @author yutian
 * @since Jan 1, 2016
 */
public class ShortestWordDistance2 {

    private static HashMap<String, List<Integer>> map;

    public ShortestWordDistance2(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public static int shortest(String word1, String word2) {
        if (!map.containsKey(word1) || !map.containsKey(word2)) {
            return 0;
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int a = list1.get(i), b = list2.get(j);
            min = Math.min(min, Math.abs(a - b));
            if (a < b) i++;
            else j++;
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
