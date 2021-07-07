package company.uuba.mj;

public class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     * Time: O(M), where M is the key length.
     * Space: O(M)
     */
    public void insert(String word) {
        add(word);
    }

    private void add(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.endOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     * Time: O(M)
     * Space: O(1)
     */
    public boolean search(String word) {
        TrieNode n = find(word);
        return n != null && n.endOfWord;
    }

    private TrieNode find(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return null;
            }
            curr = curr.children[c - 'a'];
        }
        return curr;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * Time: O(M)
     * Space: O(1)
     */
    public boolean startsWith(String prefix) {
        TrieNode n = find(prefix);
        return n != null;
    }

    class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.endOfWord = false;
        }
    }
}
