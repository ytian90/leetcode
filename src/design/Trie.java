package design;
/**
 * 208. Implement Trie (Prefix Tree)
 * @author yutian
 * @since Aug 20, 2015
 */
public class Trie {
	
	public static class TrieNode {
		boolean eow; // end of word
		TrieNode[] next;
		// Initialize your data structure here.
		public TrieNode() {
			eow = false;
			next = new TrieNode[26];
		}
	}
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	// Insert a word into the trie
	public void insert(String word) {
		root = put(root, word, 0);
	}
	
	private TrieNode put(TrieNode node, String str, int i) {
		if (node == null) node = new TrieNode();
		if (i == str.length()) {
			node.eow = true;
			return node;
		}
		int c = str.charAt(i) - 'a';
		node.next[c] = put(node.next[c], str, i + 1);
		return node;
	}

	// Return if the word is in the trie.
	public boolean search(String word) {
		TrieNode node = get(root, word, 0);
		return (node == null) ? false: node.eow;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix
	public boolean startsWith(String prefix) {
		TrieNode node = get(root, prefix, 0);
		return (node == null) ? false: true;
	}

	private TrieNode get(TrieNode node, String str, int i) {
		if (node == null) return null;
		if (i == str.length()) return node;
		int c = str.charAt(i) - 'a';
		return get(node.next[c], str, i + 1);
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("somestring");
		System.out.println(t.search("some"));
		System.out.println(t.startsWith("some"));
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");