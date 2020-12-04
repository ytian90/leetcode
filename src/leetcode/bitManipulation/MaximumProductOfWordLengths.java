package leetcode.bitManipulation;
/**
 * 318. Maximum Product of Word Lengths
 * @author yutian
 * @since Dec 31, 2015
 */
public class MaximumProductOfWordLengths {
	
	public static int maxProduct(String[] words) {
		int max = 0, n = words.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			for (Character c : words[i].toCharArray()) {
				res[i] |= 1 << (c - 'a');
			}
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((res[i] & res[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		return max;
    }

	public static void main(String[] args) {
		String[] t1 = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		String[] t2 = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		String[] t3 = new String[]{"a", "aa", "aaa", "aaaa"};
		System.out.println(maxProduct(t1));
		System.out.println(maxProduct(t2));
		System.out.println(maxProduct(t3));
	}

}
