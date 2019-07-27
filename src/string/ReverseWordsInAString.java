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
		if (s == null || s.length() == 0) {
			return s;
		}
		String[] strs = s.split("\\s+");
		if (strs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			if (strs[i].length() > 0) {
				sb.append(strs[i]);
				sb.append(" ");
			}
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
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
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords("  hello world!  "));
		System.out.println(reverseWords("a good   example"));
	}

}
