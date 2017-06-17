package string;
/**
 * 161. One Edit Distance
 * @author yutian
 * @since Jul 25, 2015
 */
public class OneEditDistance {
	// O(N) runtime, O(1) space - simple one pass
	/*
	 * We make a first pass over S and T concurrently and stop at the 
	 * first non-matching character between S and T.
	1. If S matches all characters in T, then check if there is an extra 
	character at the end of T. (Modify operation)
	2. If | n – m | == 1, that means we must skip this non-matching 
	character only in T and make sure the remaining characters between 
	S and T are exactly matching. (Insert operation)
	3. If | n – m | == 0, then we skip both non-matching characters in S 
	and T and make sure the remaining characters between S and T are 
	exactly matching. (Append operation)
	 */
	public static boolean isOneEditDistance(String s, String t) {
		int m = s.length(), n = t.length();
		// make sure s is smaller than t
		if (m > n) return isOneEditDistance(t, s);
		// if difference of length is greater than 1, false
		if (n - m > 1) return false;
		int i = 0, shift = n - m;
		// extra at tail
		while (i < m && s.charAt(i) == t.charAt(i)) i++;
		if (i == m) return shift > 0; // append
		if (shift == 0) i++; // modify
		while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
		return i == m; // insert
	}

	public static void main(String[] args) {
		String s1 = "abcde", t1 = "abXde";
		String s2 = "abcde", t2 = "abcXde";
		String s3 = "abcde", t3 = "abcdeX";
		
		System.out.println(isOneEditDistance(s1, t1));
		System.out.println(isOneEditDistance(s2, t2));
		System.out.println(isOneEditDistance(s3, t3));
	}

}
