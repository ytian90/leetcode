package dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 733. Flood Fill
 */
public class FloodFill {

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor) return image;
		helper(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	public static void helper(int[][] image, int r, int c, int color, int newColor) {
		if (r < 0 || r == image.length || c < 0
				|| c == image[0].length || image[r][c] != color)
			return;
		image[r][c] = newColor;
		helper(image, r + 1, c, color, newColor);
		helper(image, r - 1, c, color, newColor);
		helper(image, r, c - 1, color, newColor);
		helper(image, r, c + 1, color, newColor);
	}

	public static void main(String[] args) {
		int[][] image = new int[][]{
				{1, 1, 1},
				{1, 1, 0},
				{1, 0, 1}
		};
		for (int[] a : floodFill(image, 1, 1, 2)) {
			System.out.println(Arrays.toString(a));
		}
	}


	/**
	 * Flood Fill Algorithm
	 * https://shawnlincoding.wordpress.com/page/4/
	 * 就上面题目的各种变种，题目是有一个矩阵.
	 1代表已经染色，0代表没有染色。
	 完成一个函数，
	 输入：矩阵a，整数x， 整数y
	 输出:
	 返回一个矩阵，为以(x,y)点（0-based）为开始点的染色结果，将其周围区域染色，直到遇到已经染色的位置或边界为止。
	 若(x, y)已经染色则直接返回。注意：只能向上下左右四个方向染色。
	 * @author yutian
	 * @since Dec 14, 2015
	 */

	public int[][] floodFill(int[][] matrix, int x, int y) {
		if (matrix == null || matrix.length == 0) return null;
		if (!isValidIndex(matrix, x, y) || matrix[x][y] == 1) 
			return matrix;
		int m = matrix.length, n = matrix[0].length;
		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = matrix[i][j];
			}
		}
		boolean[][] visited = new boolean[m][n];
		dfs(result, x, y, visited);
		return result;
	}
	
	
	private void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
		if (!isValidIndex(matrix, i, j) || visited[i][j] || matrix[i][j] == 1)
			return;
		visited[i][j] = true;
		matrix[i][j] = 1;
		dfs(matrix, i + 1, j, visited);
		dfs(matrix, i - 1, j, visited);
		dfs(matrix, i, j + 1, visited);
		dfs(matrix, i, j - 1, visited);
	}


	private boolean isValidIndex(int[][] matrix, int i, int j) {
		return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
	}

//	public static void main(String[] args) {
//		int[][] matrix = {{1, 1, 0, 0, 1, 1},
//						  {1, 0, 0, 1, 0, 0},
//						  {1, 0, 1, 0, 1, 0}};
//		for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[0].length; j++){
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//		System.out.println();
//		int[][] res = new FloodFill().floodFill(matrix, 2, 1);
//		for(int i = 0; i < res.length; i++){
//            for(int j = 0; j < res[0].length; j++){
//                System.out.print(res[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//	}
	
	/*
	// Time O(N^2) Space O(N)
	public void FloodFill(char[][] arr, int r, int c) {
		if (arr[r][c] == 'P') {
			arr[r][c] = 'W';
			display(arr);
			FloodFill(arr, r + 1, c);
			FloodFill(arr, r - 1, c);
			FloodFill(arr, r, c - 1);
			FloodFill(arr, r, c + 1);
		}
	}

	private void display(char[][] arr) {
		System.out.println("\nGrid: ");
		for (int i = 1; i < arr.length - 1; i++) {
			for (int j = 1; j < arr[i].length - 1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Flood Fill Test\n");
		
		System.out.println("Enter dimensions of grid: ");
		int M = scan.nextInt();
		int N = scan.nextInt();
		
		// make grid with border as obstacle to avoid boundary conditions
		char[][] arr = new char[M + 2][N + 2];
		for (int i = 0; i < M + 2; i++) {
			Arrays.fill(arr[i], '0');
		}
		
		// accept grid
		System.out.println("Enter grid with 'P' for passage and 'O' for obstacle");
		for (int i = 1; i < M + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				arr[i][j] = scan.next().charAt(0);
			}
		}
		
		System.out.println("Enter coordinates to start");
		int sr = scan.nextInt();
		int sc = scan.nextInt();
		if (arr[sr][sc] != 'P') {
			System.out.println("Invalid coordinates");
			System.exit(0);
		}
		
		FloodFill ff = new FloodFill();
		ff.FloodFill(arr, sr, sc);
		scan.close();
	}
	*/
}
