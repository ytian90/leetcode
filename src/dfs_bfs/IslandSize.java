package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://shawnlincoding.wordpress.com/2015/04/08/island-size/
 * Island size
 * 
 * @author yutian
 *
 */
public class IslandSize {
	
	/*
	// 给定二维数组，表示一片海洋，1代表有岛，0代表没岛。返回相连岛屿的大小。
	 
	// Input:
	//[["1", "0", "0", "1"],
	// ["1", "0", "0", "1"],
	// ["1", "1", "0", "0"]]
	// Output:
	// [4, 2]
	 
	// Input:
	//[["1", "1", "1", "0"],
	// ["1", "0", "1", "0"],
	// ["1", "1", "1", "0"]]
	// Output:
	// [8]
	*/
	
	public List<Integer> getSize(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0) {
			return result;
		}
		int m = matrix.length, n = matrix[0].length;
		boolean[][] marked = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!marked[i][j] && matrix[i][j] == 1) {
					result.add(dfs(matrix, i, j, marked));
				}
			}
		}
		return result;
	}

	private int dfs(int[][] matrix, int i, int j, boolean[][] marked) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return 0;
		}
		if (marked[i][j] || matrix[i][j] == 0) return 0;
		marked[i][j] = true;
		return 1 + dfs(matrix, i + 1, j, marked) 
				 + dfs(matrix, i, j + 1, marked) 
				 + dfs(matrix, i - 1, j, marked) 
				 + dfs(matrix, i, j - 1, marked);
	}


	public static void main(String[] args) {
		int[][] matrix = {{1, 1, 1, 0},
						  {1, 0, 1, 0},
						  {1, 1, 0, 1}};
		IslandSize ins = new IslandSize();
		System.out.println(ins.getSize(matrix));
		
	}

}
