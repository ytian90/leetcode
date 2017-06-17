package string;

import java.util.List;
/**
 * Find Unique Prefixes
 * Implementation of Trie
 * http://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/
 * @author yutian
 * @since Jan 26, 2016
 */
public class Trie {
	class TrieNode {
	    int freq;
	    TrieNode[] next;
	    // Initialize your data structure here.
	    public TrieNode() {
	        freq = 0;
	        next = new TrieNode[26];
	    }
	}
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		root = put(root, word, 0);
	}
	
	private TrieNode put(TrieNode n, String word, int i) {
		if (n == null) n = new TrieNode();
		n.freq++;
		if (word.length() == i) {
			return n;
		}
		int c = word.charAt(i) - 'a';
		n.next[c] = put(n.next[c], word, i + 1);
		return n;
	}
	
	private String get(TrieNode n, String word, int i) {
		if (n == null) return word;
		if (n.freq == 1) return word.substring(0, i);
		int c = word.charAt(i) - 'a';
		return get(n.next[c], word, i + 1);
	}
	
	public String getPrefix(String prefix) {
		return get(root, prefix, 0);
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		String[] words = {"by", "sea", "sells", "she", "shells", "shore", "the"};
		String[] words1 = {"zebra", "dog", "duck", "dove"};
		for(String word : words1){
			trie.insert(word);
		}
		String[] res = new String[words1.length];
		for(int i = 0; i < words1.length; i++){
			res[i] = trie.getPrefix(words1[i]);
			System.out.println(res[i]);
		}
	}
	
}
