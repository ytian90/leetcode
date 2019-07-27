package backtracking;

/**
 * 211. Add and Search Word - Data Structure design
 * @author yutian
 * @since Aug 27, 2015
 */
public class AddAndSearchWord_DataStructureDesign {
	TrieNode root;

	/** Initialize your data structure here. */
	public AddAndSearchWord_DataStructureDesign() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		add(word, 0, root);
	}

	private TrieNode add(String word, int pos, TrieNode node) {
		if (node == null) {
			node = new TrieNode();
		}
		if (pos == word.length()) {
			node.eow = true;
			return node;
		}
		int i = word.charAt(pos) - 'a';
		node.children[i] = add(word, pos + 1, node.children[i]);
		return node;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		TrieNode node = search(word, 0, root);
		if (node == null) {
			return false;
		}
		return node.eow;
	}

	private TrieNode search(String word, int pos, TrieNode node) {
		if (node == null) {
			return null;
		}
		if (pos == word.length()) {
			return node;
		}
		if (word.charAt(pos) == '.') {
			for (int i = 0; i < 26; i++) {
				TrieNode next = search(word, pos + 1, node.children[i]);
				if (next != null && next.eow) {
					return next;
				}
			}
		} else {
			int i = word.charAt(pos) - 'a';
			return search(word, pos + 1, node.children[i]);
		}
		return null;
	}

	public class TrieNode {
		boolean eow;
		TrieNode[] children;
		TrieNode() {
			this.eow = false;
			this.children = new TrieNode[26];
		}
	}

	public static void main(String[] args) {
		AddAndSearchWord_DataStructureDesign wordDictionary = new AddAndSearchWord_DataStructureDesign();
		wordDictionary.addWord("a");
		System.out.println(wordDictionary.search("aa"));
	}
}

//Your test object will be instantiated and called as such:
//test wordDictionary = new test();
//wordDictionary.addWord("word");
//wordDictionary.search("pattern");