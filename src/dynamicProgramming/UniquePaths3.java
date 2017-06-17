package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePaths3 {
	
	public static List<List<Integer>> pathSet;
	
	public static void getPaths(int[][] matrix, int i, int j, int m, int n, List<Integer> path) {
		if (i == m - 1) {
			int count = 0;
			for (int k = j; k < n; k++) {
				path.add(matrix[i][k]);
				count++;
			}
//			System.out.println(path);
			pathSet.add(new ArrayList<Integer>(path));
			while (count > 0) {
				path.remove(path.size() - 1);
				count--;
			}
			return;
		}
		if (j == n - 1) {
			int count = 0;
			for (int k = i; k < m; k++) {
				path.add(matrix[k][j]);
				count++;
			}
			
//			System.out.println(path);
			pathSet.add(new ArrayList<Integer>(path));
			while (count > 0) {
				path.remove(path.size() - 1);
				count--;
			}
			return;
		}
		path.add(matrix[i][j]);
		getPaths(matrix, i + 1, j, m, n, path);
		getPaths(matrix, i, j + 1, m, n, path);
		path.remove(path.size() - 1);
	}
	
	public static void getPaths(int[][] matrix, int i, int j, int m, int n, String path) {
		if (i == m - 1) {
			for (int k = j; k < n; k++) {
				path += matrix[i][k];
			}
			System.out.println("Path: ");
			return;
		}
		if (j == n - 1) {
			for (int k = i; k < m; k++) {
				path += matrix[k][j];
			}
			System.out.println("Path: ");
			return;
		}
		path += matrix[i][j];
		getPaths(matrix, i + 1, j, m, n, path);
		getPaths(matrix, i, j + 1, m, n, path);
	}
	
	

	public static void main(String[] args) {
		pathSet = new ArrayList<List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		int[][] t = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		getPaths(t, 0, 0, t.length, t[0].length, path);
		for (List<Integer> l: pathSet) {
			if (l.contains(5)) result.add(l);
		}
		for (List<Integer> l: result) {
			System.out.println(l);
		}
	}

}
