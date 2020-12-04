package leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Pair Palindrome
 * https://shawnlincoding.wordpress.com/page/2/
 * Given a leetcode.string list，find all pairs of strings which can be combined
 * to be a palindrome. 
 * eg: cigar + tragic -> cigartragic, none + xenon -> nonexenon
 * @author yutian
 * @since Feb 5, 2016
 */
public class PairPalindrome {
	
	public List<List<String>> pairPalindrome(List<String> words) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (words == null || words.size() == 0) return result;
		HashSet<String> hashset = new HashSet<>();
		for (String s: words) hashset.add(s);
		for (String word: words) {
			int N = word.length();
			for (int i = 0; i < N; i++) {
				String prefix = word.substring(0, i);
				String suffix = word.substring(i, N);
				String reverseSuffix = reverse(suffix);
				if (isPalindrome(prefix) && hashset.contains(reverseSuffix)) {
					List<String> list = new ArrayList<>();
					list.add(reverseSuffix);
					list.add(word);
					result.add(list);
				}
			}
		}
		return result;
	}

	private boolean isPalindrome(String word) {
		int start = 0, end = word.length() - 1;
		while (start < end) {
			if (word.charAt(start) != word.charAt(end)) {
				return false;
			}
			start++; end--;
		}
		return true;
	}

	private String reverse(String word) {
		char[] arr = word.toCharArray();
		int start = 0, end = arr.length - 1;
		while (start < end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++; end--;
		}
		return new String(arr);
		
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("cigar");
		list.add("tragic");
		list.add("none");
		list.add("xenon");
		PairPalindrome t = new PairPalindrome();
		System.out.println(t.pairPalindrome(list));
	
	
	}

}
