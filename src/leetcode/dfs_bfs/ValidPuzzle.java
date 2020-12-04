package leetcode.dfs_bfs;
/**
 * Valid Puzzle
 * https://shawnlincoding.wordpress.com/page/10/
 * @author yutian
 * @since Feb 16, 2016
 */
public class ValidPuzzle {
	
	public boolean isValid(int[][] puzzle) {
		if (puzzle == null || puzzle.length == 0) {
			return false;
		}
		int m = puzzle.length, n = puzzle[0].length;
		boolean[][] marked = new boolean[m][n];
		dfs(puzzle, 0, 0, marked);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (puzzle[i][j] == 0 && !marked[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	private void dfs(int[][] puzzle, int i, int j, boolean[][] marked) {
		if (!isValidIdx(puzzle, i, j)) {
			return;
		}
		if (marked[i][j]) return;
		if (puzzle[i][j] != 0) {
			return;
		} else {
			marked[i][j] = true;
			dfs(puzzle, i - 1, j, marked);
			dfs(puzzle, i + 1, j, marked);
			dfs(puzzle, i, j - 1, marked);
			dfs(puzzle, i, j + 1, marked);
		}
	}

	private boolean isValidIdx(int[][] puzzle, int i, int j) {
		int m = puzzle.length, n = puzzle[0].length;
		return i >= 0 && i < m && j >= 0 && j < n;
	}

	public static void main(String[] args) {
		int[][] puzzle = {{0, 0, 0, 1}, 
						  {0, 0, 1, 0}, 
						  {0, 1, 0, 0}, 
						  {1, 0, 0, 0}};
		int[][] puzzle2 = {{0, 0}, {1, 0}};
		System.out.println(new ValidPuzzle().isValid(puzzle));
        
	}

}
