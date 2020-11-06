package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 616. Add Bold Tag in String
 * @author ytian
 *
 */
public class AddBoldTaginString {

	public static String addBoldTag(String s, String[] dict) {
		if (s == null || s.length() == 0 || dict.length == 0) {
			return s;
		}
		boolean[] bold = new boolean[s.length()];
		for (int i = 0, end = 0; i < s.length(); i++) {
			for (String word : dict) {
				if (s.startsWith(word, i)) {
					end = Math.max(end, i + word.length());
				}
			}
			bold[i] = end > i;
		}
		StringBuilder sb = new StringBuilder();
		int i = 0, p = -1;
		while (i < s.length()) {
			if (bold[i]) {
				p = i;
				while (p < s.length() && bold[p]) {
					p++;
				}
				sb.append("<b>" + s.substring(i, p) + "</b>");
				i = p - 1;
			} else {
				sb.append(s.charAt(i));
			}
			i++;
		}
		return sb.toString();
	}

	public static String addBoldTag2(String s, String[] dict) {
		if (s == null || s.length() == 0 || dict.length == 0) {
			return s;
		}
		int maxLen = -1, minLen = Integer.MAX_VALUE;
		Set<String> set = new HashSet<>();
		for (String word : dict) {
			set.add(word);
			maxLen = Math.max(word.length(), maxLen);
			minLen = Math.min(word.length(), minLen);
		}
		boolean[] bold = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = minLen; j <= maxLen; j++) {
				if (i + j <= s.length() && set.contains(s.substring(i, i + j))) {
					int p = i;
					while (p < i + j) {
						bold[p] = true;
						p++;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int i = 0, p = -1;
		while (i < s.length()) {
			if (bold[i]) {
				p = i;
				while (p < s.length() && bold[p]) {
					p++;
				}
				sb.append("<b>" + s.substring(i, p) + "</b>");
				i = p - 1;
			} else {
				sb.append(s.charAt(i));
			}
			i++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc"})); // <b>aaabbc</b>c
		System.out.println(addBoldTag("abcxyz123", new String[]{"abc", "123"})); // <b>aaabbc</b>c
	}
}
