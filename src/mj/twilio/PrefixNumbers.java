package mj.twilio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays of strings, one containing the prefixes (area code) and one with a long string of numbers
 * (phone numbers), return the longest prefix corresponding to all phone numbers.
 *
 * Input: Area Code: ["213", "21358", "1234", "12"]
 * Phone Numbers: ["21349049", "1204539492", "123490485904"]
 * Output: ['213', '12', '1234']
 * Solution: Use Trie to store all the prefix strings and then search for the phone numbers in the prefix tree
 * (This solution passed all test cases)
 * Note: Keep in mind that Phone Numbers array can be very long
 *
 * https://leetcode.com/discuss/interview-question/394697/Twilio-or-OA-2019
 */
public class PrefixNumbers {
    public static class TrieNode {
        boolean eow; // end of word
        TrieNode[] next;
        // Initialize your data structure here.
        public TrieNode() {
            eow = false;
            next = new TrieNode[10];
        }
    }

    private TrieNode root;

    public PrefixNumbers() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        root = put(root, word, 0);
    }

    private TrieNode put(TrieNode node, String word, int i) {
        if (node == null) node = new TrieNode();
        if (i == word.length()) {
            node.eow = true;
            return node;
        }
        int c = word.charAt(i) - '0';
        node.next[c] = put(node.next[c], word, i + 1);
        return node;
    }

    public List<String> search(List<String> phones) {
        if (phones == null || phones.size() == 0) {
            return null;
        }
        List<String> res = new ArrayList<>();
        for (String phone : phones) {
            int pos = search(phone);
            if (pos != -1) {
                res.add(phone.substring(0, pos));
            }
        }
        return res;
    }

    // Return if the word is in the trie.
    public int search(String word) {
        int[] res = new int[1];
        res[0] = -1;
        get(root, word, 0, res);
        return res[0];
    }

    private void get(TrieNode node, String str, int i, int[] res) {
        if (node == null) return;
        if (node.eow) res[0] = i;
        int c = str.charAt(i) - '0';
        get(node.next[c], str, i + 1, res);
    }

    public static void main(String[] args) {
        PrefixNumbers prefixNumbers = new PrefixNumbers();
        prefixNumbers.insert("213");
        prefixNumbers.insert("21358");
        prefixNumbers.insert("1234");
        prefixNumbers.insert("12");
        System.out.println();
        System.out.println(prefixNumbers.search(Arrays.asList("21349049", "1204539492", "123490485904")));
    }
}
