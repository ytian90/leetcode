package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Word Search II
 * @author yutian
 * @since Aug 20, 2015
 */
public class WordSearch2 {
	private final int R = 26;
    private Node root;
    
    private class Node {
        private String val;
        private Node[] next = new Node[R];
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int m = board.length;
        if (m == 0) return result;
        int n = board[0].length;
        int ds = words.length;
        if (ds == 0) return result;
        for (int i = 0; i < ds; i++) {
            insert(words[i], words[i]);
        }
        
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = board[i][j] - 'a';
                dfs(board, visited, i, j, root.next[c], result);
            }
        }
        
        return result;
    }
    
    private void insert(String key, String val) {
        root = put(root, key, val, 0);
    }
    
    private Node put(Node n, String s, String v, int d) {
        if (n == null) n = new Node();
        if (s.length() == d) {
            n.val = v;
            return n;
        }
        int c = s.charAt(d) - 'a';
        n.next[c] = put(n.next[c], s, v, d + 1);
        return n;
    }
    
    private void dfs(char[][] board, boolean[][] visited, int i, int j, Node x, 
    		List<String> result) {
        if (x == null) return;
        if (x.val != null && !result.contains(x.val)) {
            result.add(x.val);
        }
        visited[i][j] = true;
        if (i > 0 && !visited[i - 1][j]) {
            dfs(board, visited, i - 1, j, x.next[board[i - 1][j] - 'a'], result);
        }
        if (i < board.length - 1 && !visited[i + 1][j]) {
            dfs(board, visited, i + 1, j, x.next[board[i + 1][j] - 'a'], result);
        }
        if (j > 0 && !visited[i][j - 1]) {
            dfs(board, visited, i, j - 1, x.next[board[i][j - 1] - 'a'], result);
        }
        if (j < board[0].length - 1 && !visited[i][j + 1]) {
            dfs(board, visited, i, j + 1, x.next[board[i][j + 1] - 'a'], result);
        }
        visited[i][j] = false;
    }
}
