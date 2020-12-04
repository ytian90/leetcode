package leetcode.string;
/**
 * 555. Split Concatenated Strings
 * @author ytian
 *
 */
public class SplitConcatenatedStrings {
	
	public static String splitLoopedString(String[] strs) {
        char max = 'a';
        for (int i = 0; i < strs.length; i++) {
        	for (char c : strs[i].toCharArray()) {
        		if (c > max) max = c;
        	}
        	String rev = new StringBuilder(strs[i]).reverse().toString();
        	if (strs[i].compareTo(rev) < 0) strs[i] = rev; 
        }
        String res = "";
        for (int i = 0; i < strs.length; i++) {
        	String rev = new StringBuilder(strs[i]).reverse().toString();
        	for (String str : new String[] {strs[i], rev}) {
        		for (int k = 0; k < str.length(); k++) {
        			if (str.charAt(k) != max) continue;
        			StringBuilder t = new StringBuilder(str.substring(k));
        			for (int j = i + 1; j < strs.length; j++) {
        				t.append(strs[j]);
        			}
        			for (int j = 0; j < i; j++) {
        				t.append(strs[j]);
        			}
        			t.append(str.substring(0, k));
        			if (t.toString().compareTo(res) > 0) {
        				res = t.toString();
        			}
        		}
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(splitLoopedString(new String[]{"abc", "xyz"}));
	}

}
