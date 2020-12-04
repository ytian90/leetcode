package leetcode.string;
/**
 * Shortest Unique Prefix to represent word in an leetcode.array
 * https://shawnlincoding.wordpress.com/page/6/
 * @author yutian
 * @since Feb 5, 2016
 */
public class TriePrefix {
	
	public static final int R = 256;
	private Node root;
	
	private class Node {
		private int count;
		private boolean isEnd;
		private Node next[] = new Node[R];
		public Node() {
			count = 0;
			isEnd = false;
		}
		public Node (int c, boolean i) {
			count = c;
			isEnd = i;
		}
	}
	
	public void insert(String str) {
		if (root == null) root = new Node();
		Node curr = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (curr.next[c] == null) {
				curr.next[c] = new Node(1, false);
			} else {
				curr.next[c].count++;
			}
			curr = curr.next[c];
		}
		curr.isEnd = true;
	}
	
	public String shortestPrefix(String str) {
		Node curr = root;
		int len = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			curr = curr.next[c];
			len++;
			if (curr.count == 1) break;
		}
		return str.substring(0, len);
	}

	public static void main(String[] args) {
		TriePrefix trie = new TriePrefix();
		String[] words = {"by", "sea", "sells", "she", "shells", "shore", "the"};
		String[] words1 = {"zebra", "dog", "duck", "dove"};
		for(String word : words1){
			trie.insert(word);
		}
		String[] res = new String[words1.length];
		for(int i = 0; i < words1.length; i++){
			res[i] = trie.shortestPrefix(words1[i]);
			System.out.println(res[i]);
		}
	}

}

