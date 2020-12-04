package lintcode.systemdesign.chapter10;

public class Trie {
    class TrieNode {
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

    /** Inserts a word into the leetcode.trie. */
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

    /** Returns if the word is in the leetcode.trie. */
    public boolean search(String word) {
        TrieNode node = get(word);
        return (node != null) && node.eow;
    }

    /** Returns if there is any word in the leetcode.trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = get(prefix);
        return node != null;
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
}