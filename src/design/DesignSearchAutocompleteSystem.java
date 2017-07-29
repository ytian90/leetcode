package design;

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
	
	class TrieNode {
		Map<Character, TrieNode> children;
		Map<String, Integer> counts;
		boolean isWord;
		public TrieNode() {
			children = new HashMap<>();
			counts = new HashMap<>();
			isWord = false;
		}
	}
	
	class Pair {
		String s;
		int c;
		public Pair(String s, int c) {
			this.s = s;
			this.c = c;
		}
	}
	
	TrieNode root;
	String prefix;
	
	public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
        	add(sentences[i], times[i]);
        }
    }
    
    private void add(String s, int count) {
    	TrieNode curr = root;
    	for (char c : s.toCharArray()) {
    		TrieNode next = curr.children.get(c);
    		if (next == null) {
    			next = new TrieNode();
    			curr.children.put(c, next);
    		}
    		curr = next;
    		curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
    	}
    	curr.isWord = true;
	}

	public List<String> input(char c) {
        if (c == '#') {
        	add(prefix, 1);
        	prefix = "";
        	return new ArrayList<>();
        }
        prefix = prefix + c;
        TrieNode curr = root;
        for (char l : prefix.toCharArray()) {
        	TrieNode next = curr.children.get(l);
        	if (next == null) {
        		return new ArrayList<>();
        	}
        	curr = next;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for (String s : curr.counts.keySet()) {
        	pq.add(new Pair(s, curr.counts.get(s)));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
        	res.add(pq.poll().s);
        }
        return res;
    }

	public static void main(String[] args) {
		DesignSearchAutocompleteSystem t = new DesignSearchAutocompleteSystem(
				new String[]{"i love you", "island","ironman", "i love leetcode"},
				new int[]{5,3,2,2});
		
		System.out.println(t.input('i'));
		System.out.println(t.input(' '));
		System.out.println(t.input('a'));
		System.out.println(t.input('#'));
	}

}
