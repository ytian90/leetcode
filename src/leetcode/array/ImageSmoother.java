package leetcode.array;

import java.util.Arrays;

/**
 * 661. Image Smoother
 * @author ytian
 *
 */
public class ImageSmoother {
	
	public static int[][] imageSmoother(int[][] M) {
        int n = M.length, m = M[0].length;
        int[][] res = new int[n][m];
        int[] dirs = new int[]{-1, 0, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                int sum = 0;
                for (int a : dirs) {
                    for (int b : dirs) {
                        if (isValid(i + a, j + b, n, m)) {
                            count++;
                            sum += M[i + a][j + b];
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
    
    private static boolean isValid(int x, int y, int r, int c) {
        if (x < 0 || x >= r || y < 0 || y >= c) return false;
        return true;
    }

	public static void main(String[] args) {
		int[][] t = new int[][]{
			{1, 1, 1},
			{1, 0, 1},
			{1, 1, 1}
		};
		
		System.out.println(Arrays.asList(imageSmoother(t)));
	}

}
