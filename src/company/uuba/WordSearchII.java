package company.uuba;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 212. Word Search II
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example 1:
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 */
public class WordSearchII {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] b, int i, int j, TrieNode p, List<String> res) {
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length) {
            return;
        }
        char c = b[i][j];
        if (c == '#' || p.children[c - 'a'] == null) {
            return;
        }
        p = p.children[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;
        }
        b[i][j] = '#';
        for (int[] d : dirs) {
            dfs(b, i + d[0], j + d[1], p, res);
        }
        b[i][j] = c;
    }

    private void buildTrie(String[] words) {
        for (String word : words) {
            buildTrie(word);
        }
    }

    private void buildTrie(String word) {
        TrieNode p = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (p.children[i] == null) {
                p.children[i] = new TrieNode();
            }
            p = p.children[i];
        }
        p.word = word;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    /**
     * Time: O(M * 4 * 3 ^ (L - 1)), M is the number of cells in the board and
     * L is the maximum length of words, initially we have at most 4 directions
     * to explore, during the exploration, we have at most 3 neighbor cells
     * (excluding the cell where we come from).
     * Space: O(N), where N is the total number of letters in the dictionary.
     */
}
