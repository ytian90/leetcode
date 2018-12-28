package string;

import java.util.Arrays;
import java.util.Collections;

/**
 * 151. Reverse Words in a String
 * @author yutian
 * @since Jul 24, 2015
 */
public class ReverseWordsInAString {

	public static String reverseWords(String s) {
		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		return String.join(" " , words);
	}
	
	// Time ~ O(N), Space ~ O(N) 
	public static String reverseWords2(String s) {
		StringBuilder sb = new StringBuilder();
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (sb.length() != 0) {
					sb.append(' ');
				}
				sb.append(s.substring(i, j));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords("  the sky"));
		System.out.println(reverseWords("the sky  "));
		System.out.println(reverseWords("  the sky  "));
		System.out.println(reverseWords("the  sky    is blue"));
	}

}
