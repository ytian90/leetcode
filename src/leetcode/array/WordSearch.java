package leetcode.array;
/**
 * 79. Word Search
 * @author yutian
 * @since Aug 19, 2015
 */
public class WordSearch {
	// time O(m^2*n^2), space O(m*n)
	public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

	private boolean helper(char[][] b,
			int i, int j, int curr, String word, boolean[][] visited) {
        if (i < 0 || i >= b.length || j < 0 || j >= b[0].length || b[i][j] != word.charAt(curr) || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (curr == word.length() - 1) return true;
        boolean ch = helper(b, i + 1, j, curr + 1, word, visited)
                || helper(b, i - 1, j, curr + 1, word, visited)
                || helper(b, i, j + 1, curr + 1, word, visited)
                || helper(b, i, j - 1, curr + 1, word, visited);
        visited[i][j] = false;
        return ch;
	}

	public boolean exists(char[][] board, String word) {
	    char[] w = word.toCharArray();
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[0].length; j++) {
	            if (helper(board, i, j, w, 0)) return true;
            }
        }
	    return false;
    }

    private boolean helper(char[][] board, int i, int j, char[] w, int p) {
	    if (i == w.length) return true;
	    if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != w[p])
	        return false;
	    board[i][j] ^= 256;
	    boolean ch = helper(board, i, j + 1, w, p + 1)
                  || helper(board, i + 1, j, w, p + 1)
                  || helper(board, i - 1, j, w, p + 1)
                  || helper(board, i , j - 1, w, p + 1);
	    board[i][j] ^= 256;
	    return ch;
    }

    public static void main(String[] args) {
		WordSearch a = new WordSearch();
		char[][] t = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(a.exist(t, "ABCCED"));
		System.out.println(a.exist(t, "SEE"));
		System.out.println(a.exist(t, "ABCB"));
		
	}
}
