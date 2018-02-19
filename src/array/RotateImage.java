package array;
/**
 * 48. Rotate Image
 * @author yutian
 * @since Aug 18, 2015
 */
public class RotateImage {
	
	/*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/
	public void rotate(int[][] matrix) {
		int s = 0, e = matrix.length - 1;
		while (s < e) {
			int[] t = matrix[s];
			matrix[s] = matrix[e];
			matrix[e] = t;
			s++; e--;
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		}
	}
	
	// Solution 1
	public void rotate1(int[][] matrix) {
		int N = matrix.length;
		int n = (N % 2 == 0) ? N / 2 : N / 2 + 1;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < N - i - 1; j++) {
				int p = N - i - 1, q = N - j - 1;
				int temp = matrix[i][j];
				matrix[i][j] = matrix[q][i];
				matrix[q][i] = matrix[p][q];
				matrix[p][q] = matrix[j][p];
				matrix[j][p] = temp;
			}
		}
	}
	
	// Solution 2
	public static void rotate2(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] test = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		rotate2(test);
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[0].length; j++) {
				System.out.print(test[i][j] + " ");
			}
			System.out.println();
		}
	}
}
