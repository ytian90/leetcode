package string;
/**
 * 521. Longest Uncommon Subsequence I
 * @author ytian
 *
 */
public class LongestUncommonSubsequence1 {
	
	public static int findLUSlength(String a, String b) {
		return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

	public static void main(String[] args) {
		System.out.println(findLUSlength("aba", "cdc"));
	}

}
