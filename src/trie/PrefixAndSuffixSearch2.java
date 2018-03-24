package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 745. Prefix and Suffix Search (Method 2)
 * if space complexity is concerned
 * @author ytian
 *
 */
public class PrefixAndSuffixSearch2 {
	
	HashMap<String, List<Integer>> mapPrefix = new HashMap<>();
	HashMap<String, List<Integer>> mapSuffix = new HashMap<>();
	
	public PrefixAndSuffixSearch2(String[] words) {
        for (int w = 0; w < words.length; w++) {
        		for (int i = 0; i <= 10 && i <= words[w].length(); i++) {
        			String s = words[w].substring(0, i);
        			if (!mapPrefix.containsKey(s)) {
        				mapPrefix.put(s, new ArrayList<>());
        			}
        			mapPrefix.get(s).add(w);
        		}
        		for (int i = 0; i <= 10 && i <= words[w].length(); i++) {
        			String s = words[w].substring(words[w].length() - i);
        			if (!mapSuffix.containsKey(s)) {
        				mapSuffix.put(s, new ArrayList<>());
        			}
        			mapSuffix.get(s).add(w);
        		}
        }
    }
    
    public int f(String prefix, String suffix) {
    		if (!mapPrefix.containsKey(prefix) || !mapSuffix.containsKey(suffix))
    			return -1;
    		List<Integer> p = mapPrefix.get(prefix);
    		List<Integer> s = mapSuffix.get(suffix);
    		int i = p.size() - 1, j = s.size() - 1;
    		while (i >= 0 && j >= 0) {
    			if (p.get(i) < s.get(j)) j--;
    			else if (p.get(i) > s.get(j)) i--;
    			else return p.get(i);
    		}
    		return -1;
    }

	public static void main(String[] args) {
		String[] words = new String[] {"apple"};
		PrefixAndSuffixSearch2 obj = new PrefixAndSuffixSearch2(words);
		System.out.println(obj.f("a", "e"));
		System.out.println(obj.f("b", ""));
	}

}
