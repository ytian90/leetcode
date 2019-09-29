package util;

import binaryTree.TreeNode;

import java.util.*;

public class test {

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (find(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private static boolean find(char[][] board, String word) {
        int n = board.length;
        if (n == 0) {
            return false;
        }
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int pos, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(pos)) {
            return false;
        }
        visited[i][j] = true;
        if (pos == word.length() - 1) {
            return true;
        }
        boolean ch = dfs(board, word, i - 1, j, pos + 1, visited)
                || dfs(board, word, i + 1, j, pos + 1, visited)
                || dfs(board, word, i, j - 1, pos + 1, visited)
                || dfs(board, word, i, j + 1, pos + 1, visited);
        visited[i][j] = false;
        return ch;
    }

    public static void main(String[] args) {
        System.out.println(findWords(new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        }, new String[]{"oath","pea","eat","rain"}));
    }
}