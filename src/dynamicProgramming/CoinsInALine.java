package dynamicProgramming;
/**
 * Coins in a Line
 * @author yutian
 * @since Aug 1, 2015
 */
public class CoinsInALine {
	public final int MAX_N = 100;
	
	public int maxMoney(int A[], int N) {
		int P[][] = new int[MAX_N][MAX_N];
		int a, b, c; // a = P[m+2][n], b = P[m+1][n-1], c = P[m][n-2]
		for (int i = 0; i < N; i++) {
			for (int m = 0, n = i; n < N; m++, n++) {
				assert(m < N);
				assert(n < N);
				a = ((m + 2 <= N - 1) ? P[m + 2][n]: 0);
				b = ((m + 1 <= N - 1 && n - 1 >= 0) ? P[m + 1][n - 1]: 0);
				c = ((n - 2 >= 0) ? P[m][n - 2]: 0);
				P[m][n] = Math.max(A[m] + Math.min(a, b), A[n] + Math.min(b, c));
			}
		}
//		printMoves(P, A, N);
		return P[0][N-1];
	}
}
