package leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * 85. Maximal Rectangle
 * @author yutian
 * @since Nov 8, 2015
 */
public class MaximalRectangle {
	
	// DP
	/*
	left(i,j) = max(left(i-1,j), cur_left), cur_left can be determined from the current row
	right(i,j) = min(right(i-1,j), cur_right), cur_right can be determined from the current row
	height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
	height(i,j) = 0, if matrix[i][j]=='0'
	 */
	public int maximalRectangle(char[][] matrix) {
		int n = matrix.length;
		if (n == 0) return 0;
		int m = matrix[0].length;
		int[] left = new int[m];
		int[] right = new int[m];
		int[] height = new int[m];
		Arrays.fill(right, m);
		int max = 0;
		for (int i = 0; i < n; i++) {
			int cl = 0, cr = m; // current left and right
			// compute height
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == '1') height[j]++;
				else height[j] = 0;
			}
			// compute left
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == '1') left[j] = Math.max(left[j], cl);
				else {
					left[j] = 0;
					cl = j + 1;
				}
			}
			// compute right
			for (int j = m - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') right[j] = Math.min(right[j], cr);
				else {
					right[j] = m;
					cr = j;
				}
			}
			// compute the area of rectangle
			for (int j = 0; j < m; j++) {
				max = Math.max(max, (right[j] - left[j]) * height[j]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximalRectangle t = new MaximalRectangle();
		System.out.println(t.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, 
														{'1', '0', '1', '1', '1'}, 
														{'1', '1', '1', '1', '1'}, 
														{'1', '0', '0', '1', '0'}}));
		
	}
	
	/*
	 * Two pointers: Time ~O(MN)
	 */
	public int maximalRectangle2(char[][] matrix) {
		int M = matrix.length;
		if (M == 0) return 0;
		int N = matrix[0].length;
		
		int[] H = new int[N]; // histogram
		int[] L = new int[N]; // left index (where '1' starts)
		int[] R = new int[N]; // right index (where '1' ends + 1)
		Arrays.fill(R, N);
		
		int maxRect = 0;
		for (int i = 0; i < M; i++) {
			int left = 0, right = N; // left and right indices of '1's in current row
			
			// calculate L[] in row i
			for (int j = 0; j < N; ++j) {
				if (matrix[i][j] == '1') {
					H[j]++;
					L[j] = Math.max(L[j], left); // compare L[j] with previous row, take the rightmost
				} else {
					H[j] = 0;
					left = j + 1;
					L[j] = 0;
					R[j] = N;
				}
			}
			
			// calculate R[] and area in row i
			for (int j = N - 1; j >= 0; --j) {
				if (matrix[i][j] == '1') {
					R[j] = Math.min(R[j], right); // compare R[j] with previous row, take the leftmost
					maxRect = Math.max(maxRect, H[j] * (R[j] - L[j]));
				} else {
					right = j;
				}
			}
		}
		return maxRect;
	}

	

}
