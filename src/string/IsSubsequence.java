package string;
/**
 * 392. Is Subsequence
 * @author yutian
 * @since Sep 5, 2016
 */
public class IsSubsequence {
	// Two pointers
	public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int is = 0, it = 0;
        while (it < t.length()) {
        	if (t.charAt(it) == s.charAt(is)) {
        		is++;
        		if (is == s.length()) return true;
        	}
        	it++;
        }
        return false;
    }
	
	public static boolean isSubsequence2(String s, String t) {
		if (t.length() < s.length()) return false;
		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			char tempChar = s.charAt(i);
			prev = t.indexOf(tempChar, prev);
			if (prev == -1) return false;
			prev++;
		}
		return true;
	}
	

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
		System.out.println(isSubsequence("axc", "ahbgdc"));
		
	}

}
