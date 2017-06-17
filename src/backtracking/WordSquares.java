package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 425. Word Squares
 * @author yutian
 *
 */
public class WordSquares {
	
	public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
        	return res;
        }
        int len = words[0].length();
        Trie trie = new Trie(words);
        List<String> list = new ArrayList<>();
        for (String s : words) {
        	list.add(s);
        	helper(len, trie, res, list);
        	list.remove(list.size() - 1);
        }
        return res;
    }
	

	private void helper(int len, Trie trie, List<List<String>> res, List<String> list) {
		if (list.size() == len) {
			res.add(new ArrayList<>(list));
			return;
		}
		int i = list.size();
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s.charAt(i));
		}
		List<String> startWith = trie.findByPrefix(sb.toString());
		for (String sw : startWith) {
			list.add(sw);
			helper(len, trie, res, list);
			list.remove(list.size() - 1);
		}
	}


	public static void main(String[] args) {

	}
	
	class TrieNode {
		List<String> startWith;
		TrieNode[] children;
		
		TrieNode() {
			startWith = new ArrayList<>();
			children = new TrieNode[26];
		}
	}
	
	class Trie {
		TrieNode root;
		
		Trie(String[] words) {
			root = new TrieNode();
			for (String w : words) {
				TrieNode curr = root;
				for (char ch : w.toCharArray()) {
					int i = ch - 'a';
					if (curr.children[i] == null)
						curr.children[i] = new TrieNode();
					curr.children[i].startWith.add(w);
					curr = curr.children[i];
				}
			}
		}
		
		List<String> findByPrefix(String prefix) {
			List<String> res = new ArrayList<>();
			TrieNode curr = root;
			for (char ch : prefix.toCharArray()) {
				int i = ch - 'a';
				if (curr.children[i] == null)
					return res;
				curr = curr.children[i];
			}
			res.addAll(curr.startWith);
			return res;
		}
	}

}
