package leetcode.dfs_bfs;
/**
 * Find whether there's a path between 2 nodes
 * https://shawnlincoding.wordpress.com/page/2/
 * 第一轮的问题是：给一个int矩阵，0代表empty，1代表obstacle，
 * find whether there's a path between 2 nodes.  
 * 我这道题上来直接就用了dfs，而且写的磕磕绊绊，大概半小时才完全写好，导致整轮只做了一道题。
 * 后来想想这道题用bfs 或者 bidirectional bfs会更好。
 * follow up是当图变得极大时，dfs会有什么问题。还有当我们有一个计算机集群的时候，
 * 可以如何加速算法。面试之后两天都没有消息，我就知道不妙。
 * @author yutian
 * @since Feb 5, 2016
 */
public class FindPathBetween2Nodes {
	
	private int[][] id;
	private int count;
	private boolean[][] marked;
	
	public FindPathBetween2Nodes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) 
			throw new IllegalArgumentException();
		int m = matrix.length, n = matrix[0].length;
		id = new int[m][n];
		count = 1;
		marked = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!marked[i][j] && matrix[i][j] == 0) {
					dfs(matrix, i, j);
					count++;
				}
			}
		}
	}

	private void dfs(int[][] matrix, int i, int j) {
		if (!isValid(matrix, i, j) || marked[i][j] || matrix[i][j] == 1)
			return;
		marked[i][j] = true;
		id[i][j] = count;
		dfs(matrix, i + 1, j);
        dfs(matrix, i - 1, j);
        dfs(matrix, i, j + 1);
        dfs(matrix, i, j - 1);
	}
	
	private boolean isValid(int[][] matrix, int i, int j) {
		return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
	}
	
	public boolean isConnected(int x, int y, int x1, int y1) {
		if (!isValid(id, x, y) || !isValid(id, x1, y1)) {
			throw new IllegalArgumentException();
		}
		return id[x][y] == id[x1][y1];
	}

	public static void main(String[] args) {
		int[][] matrix = {{0, 1, 1, 1, 0, 0, 0},
                		  {0, 1, 0, 0, 0, 0, 0},
                		  {0, 1, 0, 0, 0, 0, 0}};
		FindPathBetween2Nodes ins = new FindPathBetween2Nodes(matrix);
		System.out.println(ins.isConnected(0, 4, 2, 2));
		System.out.println(ins.isConnected(0, 4, 0, 0));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 7; j++){
				System.out.print(ins.id[i][j]);
			}
			System.out.println();
		}
	}

}
