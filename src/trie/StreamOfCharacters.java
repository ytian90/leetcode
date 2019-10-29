package trie;

public class StreamOfCharacters {
    class TrieNode{
        boolean eow;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamOfCharacters(String[] words) {
        createTrie(words);
    }

    private void createTrie(String[] words) {
        for (String s : words) {
            TrieNode curr = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                int c = s.charAt(i) - 'a';
                if (curr.next[c] == null) {
                    curr.next[c] = new TrieNode();
                }
                curr = curr.next[c];
            }
            curr.eow = true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        for (int i = sb.length() - 1; i >= 0 && curr != null; i--) {
            int c = sb.charAt(i) - 'a';
            curr = curr.next[c];
            if (curr != null && curr.eow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        StreamOfCharacters t = new StreamOfCharacters(new String[]{"cd", "f", "kl"});
        for (int i = 0; i < 12; i++) {
            System.out.println((char)('a' + i) + " ans: " + t.query((char)('a' + i)));
        }
    }

    // TLE
//    int max;
//    Set<String> dict;
//    StringBuilder prefix;
//
//    public test(String[] words) {
//        this.max = 0;
//        this.dict = new HashSet<>();
//        this.prefix = new StringBuilder();
//        for (String word : words) {
//            max = Math.max(max, word.length());
//            dict.add(word);
//        }
//    }
//
//    public boolean query(char letter) {
//        prefix.append(letter);
//        while (prefix.length() > max) {
//            prefix.deleteCharAt(0);
//        }
//        for (int i = prefix.length() - 1; i >= 0; i--) {
//            if (dict.contains(prefix.substring(i))) {
//                return true;
//            }
//        }
//        return false;
//    }
}
