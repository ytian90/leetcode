package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 212. Word Search II
 * @author yutian
 * @since Aug 20, 2015
 */
public class WordSearch2 {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0)
            return res;
        for (String word : words) {
            if (isOnboard(word, board)) {
                if (!res.contains(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }

    public static boolean isOnboard(String word, char[][] board) {
        boolean valid = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    valid = dfs(word, i, j, 0, board, visited);
                    if (valid) return valid;
                }
            }
        }
        return valid;
    }

    public static boolean dfs(String word, int i, int j, int k, char[][] board, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || k >= word.length() || board[i][j] != word.charAt(k) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (k == word.length() - 1) return true;
        boolean valid =
                dfs(word, i + 1, j, k + 1, board, visited) ||
                        dfs(word, i - 1, j, k + 1, board, visited) ||
                        dfs(word, i, j - 1, k + 1, board, visited) ||
                        dfs(word, i, j + 1, k + 1, board, visited);
        visited[i][j] = false;
        return valid;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = new String[]{
                "oath", "pea", "eat", "rain"
        };
        System.out.println(findWords(board, words));

        char[][] board2 = new char[][]{
                {'a', 'a'}
        };
        String[] words2 = new String[]{"aa"};
        System.out.println(findWords(board2, words2));

        char[][] board3 = new char[][]{
                {'a', 'b'},
                {'a', 'a'}
        };
        String[] words3 = new String[]{"aaba"};
        System.out.println(findWords(board3, words3));

        char[][] board4 = new char[][]{
                {'a', 'b', 'c'},
                {'a', 'e', 'd'},
                {'a', 'f', 'g'}
        };
        String[] words4 = new String[]{"eaabcdgfa"};
        System.out.println(findWords(board4, words4));
    }
}
