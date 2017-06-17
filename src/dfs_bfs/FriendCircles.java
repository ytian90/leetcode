package dfs_bfs;
/**
 * 547. Friend Circles
 * @author ytian
 *
 */
public class FriendCircles {
	
	public static int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
        	if (!visited[i]) {
        		dfs(M, visited, i);
        		count++;
        	}
        }
        return count;
    }

	private static void dfs(int[][] M, boolean[] visited, int i) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(M, visited, j);
			}
		}
	}

	public static void main(String[] args) {
		int[][] t1 = new int[][] {
			{1, 1, 0},
			{1, 1, 0},
			{0, 0, 1}
		};
		int[][] t2 = new int[][] {
			{1, 1, 0},
			{1, 1, 1},
			{0, 1, 1}
		};
		System.out.println(findCircleNum(t1));
		System.out.println(findCircleNum(t2));
	}

}
