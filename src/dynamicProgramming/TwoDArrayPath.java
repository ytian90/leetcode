package dynamicProgramming;
/**
 * Uber
 * Given a 2-D integer array, -1 means obstacle, can't pass, 0 and 1 can pass, 1 is bonus.
 * Q1: Is there a valid pass from top left to bottom right with only go bottom and go right?
 * Q2: Give 4 directions pass(go incr/decr/left/right), try to get maximum bonus.
 * @author ytian
 *
 */
public class TwoDArrayPath {
	
	public static boolean hasValidPath(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
        if (m == 0) return false;
        int n = obstacleGrid[0].length;
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    d[i][j] = (obstacleGrid[i][j] == -1) ? 0 : 1;
                } else {
                    d[i][j] = (obstacleGrid[i][j] == -1) ? 0 :
                        ((i > 0) ? d[i - 1][j] : 0) + 
                        ((j > 0) ? d[i][j - 1] : 0);
                }
            }
        }
        return d[m - 1][n - 1] > 0;
	}
	
	static boolean done = false;
	static int count = 0;
	
	public static int countMax(int[][] obstacleGrid) {
		boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
		dfs(obstacleGrid, 0, 0, visited);
		return (done) ? count : 0;
	}
	
	private static void dfs(int[][] obs, int i, int j, boolean[][] visited) {
		if (i < 0 || i >= obs.length || j < 0 || j >= obs[0].length || obs[i][j] == -1) {
			return;
		}
		if (!visited[i][j]) {
			if (i == obs.length - 1 && j == obs[0].length - 1) done = true;
			if (obs[i][j] == 1) count++;
			visited[i][j] = true;
			dfs(obs, i - 1, j, visited);
			dfs(obs, i + 1, j, visited);
			dfs(obs, i, j - 1, visited);
			dfs(obs, i, j + 1, visited);
		}
	}

	public static void main(String[] args) {
		int[][] t1 = new int[][] {
			{1, 0, 1},
			{1, -1, 0},
			{1, 1, 1}
		};
		System.out.println(hasValidPath(t1));
		System.out.println(countMax(t1));
		
	}

}
