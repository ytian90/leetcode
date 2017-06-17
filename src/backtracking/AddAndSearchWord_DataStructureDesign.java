package backtracking;
/**
 * Add and Search Word - Data Structure design
 * @author yutian
 * @since Aug 27, 2015
 */
public class AddAndSearchWord_DataStructureDesign {
	private final static int L = 26; // lowercase letters a through z
	private TrieNode root; // root of trie
	
	// R-way trie node
	private class TrieNode {
		boolean eow;
		TrieNode[] next;
		public TrieNode() {
			eow = false;
			next = new TrieNode[L];
		}
	}
	
	public AddAndSearchWord_DataStructureDesign() {
		// root = new TrieNode();
	}
	
	// Adds a word into the data structure.
	public void addWord(String word) {
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
	
	// Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode x = get(root, word, 0);
        if (x == null) return false;
        else return x.eow;
    }

	private TrieNode get(TrieNode node, String str, int i) {
		if (node == null) return null;
		if (i == str.length()) return node;
		if (str.charAt(i) == '.') { // '.' represents any letter
			for (int c = 0; c < L; c++) { // search R branches
				TrieNode nn = get(node.next[c], str, i + 1);
				if (nn != null && nn.eow) return nn;
			}
			return null;
		} else { // search cth branch
			int c = str.charAt(i) - 'a';
			return get(node.next[c], str, i + 1);
		}
	}
}

//Your WordDictionary object will be instantiated and called as such:
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("word");
//wordDictionary.search("pattern");