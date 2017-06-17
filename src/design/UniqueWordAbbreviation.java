package design;

import java.util.HashMap;
import java.util.Map;

/**
 * 288. Unique Word Abbreviation
 * @author yutian
 * @since Dec 27, 2015
 */
public class UniqueWordAbbreviation {
	
	public static Map<String, String> map;
	
	public UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<String, String>();
        for (String s: dictionary) {
        	String key = encode(s);
        	if (map.containsKey(key)) { // if 2 words encode same, make it ""
        		if (!map.get(key).equals(s)) {
        			map.put(key, "");
        		}
        	} else {
        		map.put(key, s);
        	}
        }
    }

    public static boolean isUnique(String word) {
    	if (word == null) return false;
    	String key = encode(word);
    	return !map.containsKey(key) || map.get(key).equals(word);
    }
    
    private static String encode(String s) {
    	int n = s.length();
        if (n <= 2) return s;
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }

	public static void main(String[] args) {
		String[] s = new String[]{"hello"};
		UniqueWordAbbreviation t = new UniqueWordAbbreviation(s);
//		System.out.println(t.isUnique("dear"));
//		System.out.println(t.isUnique("cart"));
//		System.out.println(t.isUnique("cane"));
		System.out.println(t.isUnique("hello"));
	}

}
