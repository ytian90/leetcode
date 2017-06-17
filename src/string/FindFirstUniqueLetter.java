package string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Find First Unique Letter
 * @author yutian
 * @since Jan 26, 2016
 */
public class FindFirstUniqueLetter {
	// Time O(N)
	public static char findFirstUniqueLetter(String s) {
		if (s == null || s.length() == 0)
			throw new IllegalArgumentException();
		ArrayList<Node> tab = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			tab.add(new Node());
		}
		char[] arr = s.toCharArray();
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int c = arr[i] - 'a';
			tab.get(c).count++;
			if (tab.get(c).index == -1)
				tab.get(c).index = i;
		}
		for (int i = 0; i < tab.size(); i++) {
			if (tab.get(i).count == 1) {
				result = Math.min(result, tab.get(i).index);
			}
		}
		return arr[result];
	}

	public static void main(String[] args) {
		System.out.println(findFirstUniqueLetter("geeksforgeeks"));
	}
	
	static class Node {
		int count;
		int index;
		public Node() {
			count = 0;
			index = -1;
		}
	}

}
