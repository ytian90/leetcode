package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. Surrounded Regions
 * @author yutian
 * @since Aug 23, 2015
 */
public class SurroundedRegions {
	// Solution 1: BFS
	public void solve(char[][] board) {
		int m = board.length;
		if (m < 1) return;
		int n = board[0].length;
		if (m <= 2 || n <= 2) return;
		
		// run flood fill algorithm (BFS) on every boundary point
		for (int i = 0; i < m; i++) {
			bfs(board, i, 0); // first column
			bfs(board, i, n - 1); // last column
		}
		
		for (int j = 1; j < n - 1; j++) {
			bfs(board, 0, j); // first row
			bfs(board, m - 1, j); // last row
		}
		
		// flip 'O' to 'X' and recover '#' to 'O'
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') board[i][j] = 'X';
				else if (board[i][j] == '#') board[i][j] = 'O';
			}
		}
		
	}
	
	private static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

	private void bfs(char[][] board, int i, int j) {
		Queue<Point> q = new LinkedList<>();
		visit(board, i, j, q);
		while (!q.isEmpty()) {
			Point curr = q.poll();
			for (int[] d : dirs) {
			    int x = curr.x + d[0];
			    int y = curr.y + d[1];
			    visit(board, x, y, q);
			}
		}
	}

	private void visit(char[][] board, int i, int j, Queue<Point> q) {
		if (i < 0 || i > board.length - 1 || j < 0 
				|| j > board[0].length - 1 || board[i][j] != 'O')
			return;
		// make 'O' on the boundary to be '#' (we can recover it to 'X' later)
		board[i][j] = '#'; 
		q.add(new Point(i, j));
	}
	
	class Point {
	    int x, y;
	    public Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
	
	// Solution 2
	int[] unionSet; // union find set
	boolean[] hasEdgeO; // whether an union has an '0' which is on the edge of the matrix

	public void solve2(char[][] board) {
		int m = board.length;
		if (m < 1) return;
		int n = board[0].length;
		if (m <= 2 || n <= 2) return;
		
		int len = m * n;
		unionSet = new int[len];
		hasEdgeO = new boolean[len];
		for (int i = 0; i < len; i++)
			unionSet[i] = i;
		for (int i = 0; i < len; i++) {
			int x = i / n, y = i % n;
			hasEdgeO[i] = (board[x][y] == 'O' && 
					(x == 0 || x == m - 1 || y == 0 || y == n - 1));
		}
		
		// iterate the matrix, for each char, union it + its upper char + its left char
		// if they equals to each other
		for (int i = 0; i < len; i++) {
			int x = i / n, y = i % n, up = x - 1, left = y - 1;
			if (up >= 0 && board[x][y] == board[up][y]) union(i, i - n);
			if (left >= 0 && board[x][y] == board[x][left]) union(i, i - 1);
		}
		
		// for each char in the matrix, if it is an '0' and its union doesn't has an
		// 'edge 0', the whole union should be settled as 'X'
		for (int i = 0; i < len; i++) {
			int x = i / n, y = i % n;
			if (board[x][y] == 'O' && !hasEdgeO[findSet(i)])
				board[x][y] = 'X';
		}
	}

	private void union(int x, int y) {
		int rx = findSet(x); // root x
		int ry = findSet(y);
		// if there is an union has an 'edge 0', the union after merge should 
		// be marked too
		unionSet[rx] = ry;
        this.hasEdgeO[ry] |= this.hasEdgeO[rx];
	}

	private int findSet(int x) {
		if (unionSet[x] == x) return x;
		x = unionSet[x]; // speed up
		unionSet[x] = findSet(unionSet[x]);
		return unionSet[x];
	}
	
	// Solution 3: DFS
	public void solve3(char[][] board) {
	    if (board.length == 0 || board[0].length == 0)
	        return;
	    if (board.length < 2 || board[0].length < 2)
	        return;
	    int m = board.length, n = board[0].length;
	    //Any 'O' connected to a boundary can't be turned to 'X', so ...
	    //Start from first and last column, turn 'O' to '*'.
	    for (int i = 0; i < m; i++) {
	        if (board[i][0] == 'O')
	            boundaryDFS(board, i, 0);
	        if (board[i][n-1] == 'O')
	            boundaryDFS(board, i, n-1); 
	    }
	    //Start from first and last row, turn '0' to '*'
	    for (int j = 0; j < n; j++) {
	        if (board[0][j] == 'O')
	            boundaryDFS(board, 0, j);
	        if (board[m-1][j] == 'O')
	            boundaryDFS(board, m-1, j); 
	    }
	    //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (board[i][j] == 'O')
	                board[i][j] = 'X';
	            else if (board[i][j] == '*')
	                board[i][j] = 'O';
	        }
	    }
	}
	//Use DFS algo to turn internal however boundary-connected 'O' to '*';
	private void boundaryDFS(char[][] board, int i, int j) {
	    if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
	        return;
	    if (board[i][j] == 'O')
	        board[i][j] = '*';
	    if (i > 1 && board[i-1][j] == 'O')
	        boundaryDFS(board, i-1, j);
	    if (i < board.length - 2 && board[i+1][j] == 'O')
	        boundaryDFS(board, i+1, j);
	    if (j > 1 && board[i][j-1] == 'O')
	        boundaryDFS(board, i, j-1);
	    if (j < board[i].length - 2 && board[i][j+1] == 'O' )
	        boundaryDFS(board, i, j+1);
	}
	
}
