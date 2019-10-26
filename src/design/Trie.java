package design;
/**
 * 208. Implement Trie (Prefix Tree)
 * @author yutian
 * @since Aug 20, 2015
 */
public class Trie {

	public class TrieNode {
		public TrieNode[] children;
		public boolean eow;

		public TrieNode() {
			this.children = new TrieNode[26];
			this.eow = false;
		}
	}

	TrieNode root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';
			if (curr.children[c] == null) {
				curr.children[c] = new TrieNode();
			}
			curr = curr.children[c];
		}
		curr.eow = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = get(word);
		return (node == null) ? false : node.eow;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode node = get(prefix);
		return (node == null) ? false : true;
	}

	public TrieNode get(String target) {
		TrieNode curr = root;
		for (int i = 0; i < target.length(); i++) {
			int c = target.charAt(i) - 'a';
			if (curr.children[c] == null) {
				return null;
			}
			curr = curr.children[c];
		}
		return curr;
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("somestring");
		System.out.println(t.search("some"));
		System.out.println(t.startsWith("some"));
		t.insert("apple");
		System.out.println(t.search("apple"));
		System.out.println(t.search("app"));
		System.out.println(t.startsWith("app"));
		t.insert("app");
		System.out.println(t.search("app"));
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");