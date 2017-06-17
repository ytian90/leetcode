package dynamicProgramming;

import java.awt.Point;
import java.util.HashMap;

/**
 * https://www.careercup.com/question?id=5722807649435648
   There are N coins with coordinates (x, y) where x >0 and y >0 
   You start at (0, 0) and you can only do steps of form (dx, dy) where dx >0 and dy > 0 
   Print the maximum number of coins that you can collect. 
 * @author yutian
 * @since Apr 25, 2016
 */
public class CollectCoins {
	
	public int maxCoins(int[][] board) {
		return helper(board, 0, 0, new HashMap<>());
	}

	private int helper(int[][] board, int row, int col, HashMap<Point, Integer> cache) {
		if (row == board.length || col == board[0].length)
			return 0;
		Point p = new Point(row, col);
		if (cache.containsKey(p)) {
			return cache.get(p);
		}
		int count = 0;
		for (int dx = 1; dx + row < board.length; dx++) {
			for (int dy = 1; dy + col < board[0].length; dy++) {
				count = Math.max(count, helper(board, row + dx, col + dy, cache));
			}
		}
		count += board[row][col];
		cache.put(p, count);
		return count;	
	}

	public static void main(String[] args) {
		CollectCoins t = new CollectCoins();
		int[][] data = new int[][]{
				{0, -10, -10, -10},
				{5, -10, 6, -10},
				{15, 7, -10, -10},
				{-10, -10, -10, 20}
		};
		System.out.println(t.maxCoins(data));
	}

}
