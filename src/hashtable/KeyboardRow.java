package hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 500. Keyboard Row
 * @author ytian
 *
 */
public class KeyboardRow {

	public static String[] findWords(String[] words) {
        String[] strs = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
        	for (char c : strs[i].toCharArray()) {
        		map.put(c, i);
        	}
        }
        List<String> res = new LinkedList<>();
        for (String w : words) {
        	if (w.equals("")) continue;
        	int index = map.get(w.toLowerCase().charAt(0));
        	for (char c : w.toLowerCase().toCharArray()) {
        		if (map.get(c) != index) {
        			index = -1;
        			break;
        		}
        	}
        	if (index != -1) res.add(w); 
        }
        return res.toArray(new String[0]);
    }
	
	
	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		for (String s: findWords(words))
			System.out.println(s);
	}

}
