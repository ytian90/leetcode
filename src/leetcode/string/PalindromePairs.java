package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 336. Palindrome Pairs
 * @author yutian
 * @since Apr 8, 2016
 */
public class PalindromePairs {
	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		if (words == null || words.length < 0)
			return res;
		Map<String, Integer> map = new HashMap<>();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= words[i].length(); j++) {
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j);
				if (isPalindrome(s1)) {
					String rev_s2 = new StringBuilder(s2).reverse().toString();
					if (map.containsKey(rev_s2) && map.get(rev_s2) != i) {
						res.add(new ArrayList<>(Arrays.asList(map.get(rev_s2), i)));
					}
				}
				if (isPalindrome(s2) && s2.length() != 0) { // s2 == 0 cause duplicates
					String rev_s1 = new StringBuilder(s1).reverse().toString();
					if (map.containsKey(rev_s1) && map.get(rev_s1) != i) {
						res.add(new ArrayList<>(Arrays.asList(i, map.get(rev_s1))));
					}
				}
			}
		}
		return res;
	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
		System.out.println(palindromePairs(new String[]{"bat", "tab", "cat"}));
	}

	// Method 1 hashmap Time ~O(n*k^2)
	public List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;
        HashMap<String, Integer> map = new HashMap<>();
        // add word itself as key, position as value in hashmap
        for (int i = 0; i < words.length; i++) {
        	map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
        	int l = 0, r = 0;
        	while (l <= r) {
        		String s = words[i].substring(l, r);
        		String rev_s = new StringBuilder(s).reverse().toString();
        		Integer j = map.get(rev_s);
        		if (j != null && i != j && 
        				isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l)))
        			result.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
        		if (r < words[i].length()) r++;
        		else l++;
        	}
        }
        return result;
    }
	
	// Method 2 Trie O(n*k^2)
	class Node {
		Node[] next;
		int index;
		List<Integer> list;
		Node() {
			next = new Node[26];
			index = -1;
			list = new ArrayList<>();
		}
	}
	
	public List<List<Integer>> palindromePairs2(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		Node root = new Node();
		for (int i = 0; i < words.length; i++) {
			addWord(root, words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			search(words, i, root, res);
		}
		return res;
	}
	
	void addWord(Node root, String word, int index) {
		char[] arr = word.toCharArray();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (root.next[arr[i] - 'a'] == null) {
				root.next[arr[i] - 'a'] = new Node();
			}
			if (isPalindrome(word, 0, i)) {
				root.list.add(index);
			}
			root = root.next[arr[i] - 'a'];
		}
		root.list.add(index);
		root.index = index;
	}
	
	void search(String[] words, int i, Node root, List<List<Integer>> res) {
		for (int j = 0; j < words[i].length(); j++) {
			if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
				res.add(Arrays.asList(i, root.index));
			}
			root = root.next[words[i].charAt(j) - 'a'];
			if (root == null) return;
		}
		for (int j : root.list) {
			if (i == j) continue;
			res.add(Arrays.asList(i, j));
		}
	}
	
	boolean isPalindrome(String word, int i, int j) {
		
		while (i < j) {
			if (word.charAt(i++) != word.charAt(j--)) return false;
		}
		
		return true;
	}

}
