package array;

import java.util.Arrays;

/**
 * 661. Image Smoother
 * @author ytian
 *
 */
public class ImageSmoother {
	
	public static int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        int[] dirs = new int[]{-1, 0, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                int sum = 0;
                for (int a : dirs) {
                    for (int b : dirs) {
                        if (isValid(i + a, j + b, m, n)) {
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
