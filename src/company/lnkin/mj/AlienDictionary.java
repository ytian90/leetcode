package company.lnkin.mj;

import java.util.*;

/**
 * LC 269. Alien Dictionary
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 *
 * You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.
 *
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
 *
 * A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.
 *
 * Example 1:
 *
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 *
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 *
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 */
public class AlienDictionary {
    private final int N = 26;

    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        if (!buildGraph(words, adj, visited)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                if (!dfs(adj, visited, sb, i)) {
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }

    private boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;
        for (int j = 0; j < N; j++) {
            if (adj[i][j]) {
                if (visited[j] == 1) return false;
                if (visited[j] == 0) {
                    if (!dfs(adj, visited, sb, j)) {
                        return false;
                    }
                }
            }
        }
        visited[i] = 2;
        sb.append((char) (i + 'a'));
        return true;
    }

    private boolean buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                visited[c - 'a'] = 0;
            }
            if (i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                if ((w1.length() > w2.length()) && (w1.startsWith(w2))) {
                    return false;
                }
                for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
        return true;
    }
    /**
     * Time: O(L), where L is the total length of all the words in the input string
     * Space: O(1)
     */

    public String alienOrder_bfs(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degrees = new HashMap<>();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degrees.put(c, 0);
            }
        }
        int n = words.length;
        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = map.getOrDefault(c1, new HashSet<>());
                    if (!set.contains(c2)) {
                        set.add(c2);
                        map.put(c1, set);
                        degrees.put(c2, degrees.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        String res = "";
        for (char c : degrees.keySet()) {
            if (degrees.get(c) == 0) {
                q.add(c);
            }
        }
        while (!q.isEmpty()) {
            char c = q.poll();
            res += c;
            if (map.containsKey(c)) {
                for (char ch : map.get(c)) {
                    degrees.put(ch, degrees.get(ch) - 1);
                    if (degrees.get(ch) == 0) {
                        q.add(ch);
                    }
                }
            }
        }
        if (res.length() != degrees.size()) {
            return "";
        }
        return res;
    }
}
