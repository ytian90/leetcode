package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 * @author yutian
 * @since Aug 20, 2015
 */
public class WordSearch2 {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (find(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    public static boolean find(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String s, int start, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != s.charAt(start)) {
            return false;
        }
        if (start == s.length() - 1) {
            return true;
        }
        boolean ch = false;
        visited[i][j] = true;
        ch = dfs(board, s, start + 1, i + 1, j, visited)
                || dfs(board, s, start + 1, i - 1, j, visited)
                || dfs(board, s, start + 1, i, j + 1, visited)
                || dfs(board, s, start + 1, i, j - 1, visited);
        visited[i][j] = false;
        return ch;
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
