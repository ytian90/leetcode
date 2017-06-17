package dynamicProgramming;
/**
 * Maximal Square
 * @author yutian
 * @since Aug 13, 2015
 */
public class MaximalSquare {
	// Solution 1: 2-d DP
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		if (m == 0) return 0;
		int n = matrix[0].length;
		int[][] d = new int[m][n];
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					d[i][j] = 0;
				} else {
					if (i == 0 || j == 0) {
						d[i][j] = 1;
					} else {
						d[i][j] = 1 + Math.min(Math.min(d[i - 1][j - 1], d[i - 1][j]), 
								d[i][j - 1]); // don't forget add 1
					}
				}
				max = Math.max(max, d[i][j]);
			}
		}
		return max * max;
	}
	
	public static void main(String[] args) {
		MaximalSquare t = new MaximalSquare();
		System.out.println(t.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, 
														{'1', '0', '1', '1', '1'}, 
														{'1', '1', '1', '1', '1'}, 
														{'1', '0', '0', '1', '0'}}));
	}
	
	
	// Solution 2: 1-d DP
	public int maximalSquare2(char[][] matrix) {
		int m = matrix.length;
		if (m == 0) return 0;
		int n = matrix[0].length;
		int[] d = new int[Math.min(m, n)];
		int max = 0, prev = d[0], curr = d[0];
		for (int i = 0; i < Math.max(m, n); i++) {
			for (int j = 0; j < Math.min(m, n); j++) {
				curr = d[j];
				int entry = m > n ? matrix[i][j] : matrix[j][i];
				if (entry == '0') {
					d[j] = 0;
				} else {
					if (i == 0 || j == 0) {
						d[j] = 1;
					} else {
						d[j] = 1 + Math.min(Math.min(prev, d[j]), d[j - 1]);
					}
				}
				prev = curr;
				max = Math.max(max, d[j]);
			}
		}
		return max * max;
	}
}
