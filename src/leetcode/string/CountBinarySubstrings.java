package leetcode.string;
/**
 * 696. Count Binary Substrings
 * @author ytian
 *
 */
public class CountBinarySubstrings {
	
	public static int countBinarySubstrings(String s) {
		int prev = 0, curr = 1, res = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				curr++;
			} else {
				prev = curr;
				curr = 1;
			}
			if (prev >= curr) res++;
		}
		return res;
    }

	public static void main(String[] args) {
		System.out.println(countBinarySubstrings("00110011"));
		System.out.println(countBinarySubstrings("10101"));
	}

}
