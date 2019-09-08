package design;

import util.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 642. Design Search Autocomplete System
 * @author ytian
 *
 */
public class DesignSearchAutocompleteSystem {

	TrieNode root;
	String prefix;

	public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode();
		prefix = "";

		for (int i = 0; i < sentences.length; i++) {
			add(sentences[i], times[i]);
		}
	}

	public void add(String word, int time) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (!curr.children.containsKey(c)) {
				curr.children.put(c, new TrieNode());
			}
			curr = curr.children.get(c);
			curr.counts.put(word, curr.counts.getOrDefault(word, 0) + time);
		}
	}

	public List<String> input(char c) {
		List<String> res = new ArrayList<>();
		if (c == '#') {
			add(prefix, 1);
			prefix = "";
			return res;
		}

		prefix = prefix + c;
		TrieNode curr = root;
		for (char i : prefix.toCharArray()) {
			TrieNode next = curr.children.get(i);
			if (next == null) {
				return res;
			}
			curr = next;
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c) ? a.s.compareTo(b.s) : b.c - a.c);
		for (String s : curr.counts.keySet()) {
			pq.add(new Pair(s, curr.counts.get(s)));
		}

		for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
			res.add(pq.poll().s);
		}
		return res;
	}

	public class Pair {
		String s;
		int c;
		public Pair(String s, int c) {
			this.s = s;
			this.c = c;
		}
	}

	public class TrieNode {
		Map<Character, TrieNode> children;
		Map<String, Integer> counts;

		public TrieNode() {
			this.children = new HashMap<>();
			this.counts = new HashMap<>();
		}
	}

	public static void main(String[] args) {
		DesignSearchAutocompleteSystem t = new DesignSearchAutocompleteSystem(
				new String[]{"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});
		System.out.println(t.input('i'));
		System.out.println(t.input(' '));
		System.out.println(t.input('a'));
		System.out.println(t.input('#'));
		System.out.println(t.input('i'));
		System.out.println(t.input(' '));
		System.out.println(t.input('a'));
		System.out.println(t.input('#'));
		System.out.println(t.input('i'));
		System.out.println(t.input(' '));
		System.out.println(t.input('a'));
		System.out.println(t.input('#'));

	}
}
