package mj.houzz;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Huffman Decoding
 * Huffman decoding given the relations of character and bianry representation, then decode input string
 * a -> [010]
 * e -> [000]
 * String input = "010000000000"; String output = "aeee";
 *
 */
public class HuffmanDecoding {

    public static String decode(String s, Map<Character, String> input) {
        if (input == null || input.size() == 0 || s.length() == 0) {
            return "";
        }
        Map<String, Character> dict = new HashMap<>();
        for (Map.Entry<Character, String> e : input.entrySet()) {
            dict.put(e.getValue(), e.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (String key : dict.keySet()) {
            if (s.startsWith(key)) {
                sb.append(dict.get(key) + decode(s.substring(key.length()), input));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Map<Character, String> map = new HashMap<>();
        map.put('a', "010");
        map.put('e', "000");
        System.out.println(decode("010000000000", map));

        String text = "Huffman coding is a data compression algorithm.";
        buildHuffmanTree(text);
    }

    // whole fuffman problem
    static class Node {
        char ch;
        int freq;
        Node left;
        Node right;

        public Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    public static void encode(Node root, String str, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            huffmanCode.put(root.ch, str);
        }

        encode(root.left, str + "0", huffmanCode);
        encode(root.right, str + "1", huffmanCode);
    }

    public static int decode(Node root, int index, StringBuilder sb) {
        if (root == null) {
            return index;
        }

        if (root.left == null && root.right == null) {
            System.out.print(root.ch);
            return index;
        }

        index++;

        if (sb.charAt(index) == '0') {
            index = decode(root.left, index, sb);
        } else {
            index = decode(root.right, index, sb);
        }
        return index;
    }

    public static void buildHuffmanTree(String input) {
        Map<Character, Integer> freq = new HashMap<>();
        for (Character c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            pq.add(new Node(e.getKey(), e.getValue()));
        }

        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            int sum = left.freq + right.freq;
            pq.add(new Node('\0', sum, left, right));
        }

        Node root = pq.peek();

        Map<Character, String> huffmanCode = new HashMap<>();
        encode(root, "", huffmanCode);

        for (Map.Entry e : huffmanCode.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }
        System.out.println(sb.toString());

        int index = -1;
        while (index < sb.length() - 2) {
            index = decode(root, index, sb);
        }
    }
}
