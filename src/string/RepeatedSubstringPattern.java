package string;
/**
 * 459. Repeated Substring Pattern
 * @author ytian
 *
 */
public class RepeatedSubstringPattern {

	public static boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				int len = n / i;
				String first = s.substring(0, i);
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < len; j++) {
					sb.append(first);
				}
				if (sb.toString().equals(s)) return true;
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
		System.out.println(repeatedSubstringPattern("abac"));
	}
}
