package dynamicProgramming;
/**
 * 308. Range Sum Query 2D - Mutable
 * @author yutian
 * @since Feb 19, 2016
 */
public class RangeSumQuery2DMutable_BIT {

	// time O(log(m) * log(n))

	int[][] tree;
	int[][] nums;
	int m;
	int n;
	
	public RangeSumQuery2DMutable_BIT(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return;
		m = matrix.length;
		n = matrix[0].length;
		tree = new int[m + 1][n + 1];
		nums = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				update(i, j, matrix[i][j]);
			}
		}
	}

	void update(int row, int col, int val) {
		if (m == 0 || n == 0) return;
		int delta = val - nums[row][col];
		nums[row][col] = val;
		for (int i = row + 1; i <= m; i+= i & (-i)) {
			for (int j = col + 1; j <= n; j += j & (-j)) {
				tree[i][j] += delta;
			}
		}
	}
	
	int sumRegion(int row1, int col1, int row2, int col2) {
		if (m == 0 || n == 0) return 0;
		return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
	}

	int sum(int row, int col) {
		int sum = 0;
		for (int i = row; i > 0; i -= i & (-i)) {
			for (int j = col; j > 0; j -= j & (-j)) {
				sum += tree[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		RangeSumQuery2DMutable_BIT numMatrix = new RangeSumQuery2DMutable_BIT(new int[][]{
				{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}
		});
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
		numMatrix.update(3, 2, 2);
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
	}

}
