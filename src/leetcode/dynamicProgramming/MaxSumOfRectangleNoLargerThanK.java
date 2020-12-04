package leetcode.dynamicProgramming;

import java.util.TreeSet;

/**
 * 363. Max Sum of Rectangle No Larger Than K
 * @author yutian
 * @since Jul 3, 2016
 */
public class MaxSumOfRectangleNoLargerThanK {
	public static int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix.length == 0) {
			return 0;
		}
		int n = matrix.length, m = matrix[0].length;
		int res = Integer.MIN_VALUE;
		for (int left = 0; left < m; left++) {
			int[] sums = new int[n];
			for (int right = left; right < m; right++) {
				for (int i = 0; i < n;  i++) {
					sums[i] += matrix[i][right];
				}
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0);
				int currSum = 0;
				for (int sum : sums) {
					currSum += sum;
					Integer num = set.ceiling(currSum - k);
					if (num != null) {
						res = Math.max(res, currSum - num);
					}
					set.add(currSum);
				}
			}
		}
		return res;
	}

	// TreeSet
	public static int maxSumSubmatrix1(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int minDf = Integer.MAX_VALUE;
        for (int left = 0; left < col; left++) {
        	int[] temp = new int[row];
        	for (int right = left; right < col; right++) {
        		TreeSet<Integer> set = new TreeSet<>();
        		int cursum = 0;
        		for (int i = 0; i < row; i++) {
        			temp[i] += matrix[i][right];
        			cursum += temp[i];
        			if (cursum == k) return k;
                    if (cursum < k) minDf = Math.min(minDf,k-cursum);
                    Integer x = set.ceiling(cursum-k);
                    if (x != null && cursum - x <= k) minDf = Math.min(minDf, k - cursum + x);
                    if (minDf == 0) return k;
                    set.add(cursum);
        		}
        	}
        }
        return k - minDf;
    }
	
	// DP
	public static int maxSumSubmatrix2(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int maxValue = Integer.MIN_VALUE, h = matrix.length, w = matrix[0].length;
		int[] dp = new int[h];
		for (int i = 0; i < w; i++) {
			dp = new int[h];
			for (int j = i; j < w; j++) {
				for (int s = 0; s < h; s++) {
					dp[s] = dp[s] + matrix[s][j];
				}
				int p = getVal(dp, k);
				if (maxValue < p) {
					maxValue = p;
				}
			}
		}
		return maxValue;
	}
	

	private static int getVal(int[] dp, int k) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			sum += dp[i];
			int cur = sum;
			for (int j = -1; j <= i; j++) {
				if (j == -1) cur = sum;
				else cur -= dp[j];
				if (cur > k) continue;
				if (i != j) max = Math.max(max, cur);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] t1 = new int[][]{{1, 0, 1}, {0, -2, 3}};
		System.out.println(maxSumSubmatrix(t1, 2));
	}

}
