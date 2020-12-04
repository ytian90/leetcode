package leetcode.string;
/**
 * 557. Reverse Words in a String III
 * @author ytian
 *
 */
public class ReverseWordsInAString3 {

	public static String reverseWords(String s) {
		char[] c = s.toCharArray();
		int pos = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				reverse(c, pos, i - 1);
				pos = i + 1;
			}
		}
		reverse(c, pos, c.length - 1);
		return new String(c);
	}

	private static void reverse(char[] c, int i, int j) {
		while (i < j) {
			char t = c[i];
			c[i] = c[j];
			c[j] = t;
			i++; j--;
		}
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));

	}

}
