package leetcode.trie;

import java.util.HashMap;

/**
 * 745. Prefix and Suffix Search (Method 1)
 * if f is called more frequently than constructor
 * @author ytian
 *
 */
public class PrefixAndSuffixSearch1 {
	
	HashMap<String, Integer> map = new HashMap<>();
	
	public PrefixAndSuffixSearch1(String[] words) {
        for (int w = 0; w < words.length; w++) {
        		for (int i = 0; i <= 10 && i <= words[w].length(); i++) {
        			for (int j = 0; j <= 10 && j <= words[w].length(); j++) {
        				map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length() - j), w);
        			}
        		}
        }
    }
    
    public int f(String prefix, String suffix) {
    		String target = prefix + "#" + suffix;
        return (map.containsKey(target)) ? map.get(target) : -1;
    }

	public static void main(String[] args) {
		String[] words = new String[] {"apple"};
		PrefixAndSuffixSearch1 obj = new PrefixAndSuffixSearch1(words);
		System.out.println(obj.f("a", "e"));
		System.out.println(obj.f("b", ""));
	}

}
