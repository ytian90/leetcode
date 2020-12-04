package leetcode.dynamicProgramming;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 375. Guess Number Higher or Lower II
 * @author yutian
 * @since Jul 24, 2016
 */
public class GuessNumberHigherOrLower2 {
	
	public int getMoneyAmount(int n) {
        int[][] a = new int[n+2][n+2];
        for (int len = 2; len <= n; len++) {
        	for (int i = 1; i <= n - len + 1; i++) {
        		a[i][i + len - 1] = Integer.MAX_VALUE;
        		for (int j = i; j < i + len; j++) {
        			a[i][i + len - 1] = Math.min(a[i][i + len - 1], 
        					j + Math.max(a[i][j - 1],  a[j + 1][i + len - 1]));
        			
        		}
        	}
        }
        return a[1][n];
    }
	
	public static int getMoneyAmount1(int n) {
		int[][] t = new int[n + 1][n + 1];
		for (int j = 2; j <= n; j++) {
			for (int i = j - 1; i > 0; i--) {
				int globalMin = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					int localMax = k + Math.max(t[i][k - 1], t[k + 1][j]);
					globalMin = Math.min(globalMin, localMax);
				}
				t[i][j] = i + 1 == j ? i : globalMin;
			}
		}
		return t[1][n];
	}
	
	public static void main(String[] args) {
		System.out.println(getMoneyAmount1(10));
		
	}


	public int getMoneyAmount2(int n) {
		int[][] f = new int[n + 1][n + 1];
		Deque<Integer[]> q;
		int a, b, k0, v, f1, f2;
		for (b = 2; b <= n; b++) {
			k0 = b - 1;
			q = new LinkedList<Integer[]>();
			
			for (a = b - 1; a > 0; a--) {
				// find k0[a][b] by definition in O(1) time
				while (f[a][k0 - 1] > f[k0 + 1][b])
					k0--;
				
				// find f1[a][b] in O(1) time
				while (!q.isEmpty() && q.peekFirst()[0] > k0) {
					q.pollFirst();
				}
				
				v = f[a + 1][b] + a;
				
				while (!q.isEmpty() && v < q.peekLast()[1]) {
					q.pollLast();
				}
				
				q.offerLast(new Integer[]{a, v});
				
				f1 = q.peekFirst()[1];
				f2 = f[a][k0] + k0 + 1;
				f[a][b] = Math.min(f1, f2);
				
			}
		}
		return f[1][n];
	}
	
	
}
