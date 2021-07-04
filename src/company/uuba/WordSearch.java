package company.uuba;

/**
 * LC 79. Word Search
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example 1:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 */
public class WordSearch {
    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || pos < word.length() && word.charAt(pos) != board[i][j]) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '*';
        boolean res = false;
        for (int[] d : dirs) {
            res = res || dfs(board, word, i + d[0], j + d[1], pos + 1);
        }
        board[i][j] = c;
        return res;
    }
    /**
     * Time: O(N * 4 * 3 ^ L), N is the number of cells in the board and
     * L is the length of the word to be matched.
     * Space: O(L)
     */
}
