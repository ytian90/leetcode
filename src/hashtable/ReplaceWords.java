package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 648. Replace Words
 * @author ytian
 *
 */
public class ReplaceWords {
	
	// hashset
	public static String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0) return sentence;
        Set<String> set = new HashSet<>(dict);
        
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");
        
        for (String word : words) {
        	String prefix = "";
        	for (int i = 1; i <= word.length(); i++) {
        		prefix = word.substring(0, i);
        		if (set.contains(prefix)) break;
        	}
        	sb.append(" " + prefix);
        }
        return sb.deleteCharAt(0).toString();
    }

	public static void main(String[] args) {
		List<String> t = new ArrayList<>(Arrays.asList("cat", "bat", "rat"));
		System.out.println(replaceWords(t, "the cattle was rattled by the battery"));
	}

}
