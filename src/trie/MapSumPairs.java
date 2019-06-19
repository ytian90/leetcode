package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. Map Sum Pairs
 */
public class MapSumPairs {

    TrieNode root;

    /** Initialize your data structure here. */
    public MapSumPairs() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
        }
        curr.eow = true;
        curr.val = val;
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                return 0;
            }
            curr = next;
        }
        return dfs(curr);
    }

    private int dfs(TrieNode root) {
        int sum = 0;
        for (char c : root.children.keySet()) {
            sum += dfs(root.children.get(c));
        }
        return sum + root.val;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean eow;
        int val;

        public TrieNode() {
            children = new HashMap<>();
            eow = false;
            val = 0;
        }
    }

    public static void main(String[] args) {
        MapSumPairs obj = new MapSumPairs();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
    }

//    Map<String, Integer> map;
//
//    /** Initialize your data structure here. */
//    public MapSumPairs() {
//        map = new HashMap<>();
//    }
//
//    public void insert(String key, int val) {
//        map.put(key, val);
//    }
//
//    public int sum(String prefix) {
//        int sum = 0;
//        for (String s : map.keySet()) {
//            if (s.startsWith(prefix)) {
//                sum += map.maxPerformance(s);
//            }
//        }
//        return sum;
//    }
}
