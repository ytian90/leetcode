package leetcode.others;

import java.util.Arrays;

public class Filter {

	public static void main(String[] args) {
		
		double[][] m = new double[][]{
				{0, 0, 0, 0, 0, 0},
				{0, 9, 11, 12, 10, 0},
				{0, 14, 15, 26, 13, 0},
				{0, 27, 17, 17, 19, 0},
				{0, 18, 18, 19, 16, 0},
				{0, 0, 0, 0, 0, 0},
		};

		double[][] r = new double[6][6];
		double[][] rr = new double[6][6];
		for (int i = 1; i < r.length - 1; i++) {
			for (int j = 1; j < r[0].length - 1; j++) {
				r[i][j] = calc5(m, i, j);
			}
		}
		
		for (int i = 1; i < rr.length - 1; i++) {
			for (int j = 1; j < rr[0].length - 1; j++) {
				rr[i][j] = calc4(r, i, j);
			}
		}
		System.out.println();
	}
	
	static double calc(double[][] m, int x, int y) {
		int tt = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				tt += m[i][j];
			}
		}
		return tt / 9;
	}

	static double calc2(double[][] m, int x, int y) {
		double[] tt = new double[9];
		int t = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				tt[t++] = m[i][j];
			}
		}
		Arrays.sort(tt);
		return tt[4];
	}
	
	static double calc3_x(double[][] m, int x, int y) {
		double a = 0.5 * (m[x][y - 1] - m[x][y + 1]);
		return a;
	}
	
	static double calc3_y(double[][] m, int x, int y) {
		double a = 0.5 * (m[x + 1][y] - m[x - 1][y]);
		return a;
	}
	
	static double calc4(double[][] m, int x, int y) {
//		System.out.println(m[x][y] + " " + m[x-1][y] + " " + m[x+1][y] + " " + m[x][y-1] + " " + m[x][y+1]);
		
		return 5 * m[x][y] - m[x-1][y] - m[x+1][y] - m[x][y-1] - m[x][y+1];
	}
	
	static double calc5(double[][] m, int x, int y) {
		return m[x][y] + m[x][y+1];
	}
	
}
