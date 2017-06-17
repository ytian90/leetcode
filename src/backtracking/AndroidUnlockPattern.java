package backtracking;
/**
 * 351. Android Unlock Patterns
 * @author yutian
 * @since May 29, 2016
 */
public class AndroidUnlockPattern {
	
	public int numberOfPatterns(int m, int n) {
        int[][] map = new int[10][10];
        map[1][3] = map[3][1] = 2;
        map[1][7] = map[7][1] = 4;
        map[3][9] = map[9][3] = 6;
        map[7][9] = map[9][7] = 8;
        map[1][9] = map[9][1] = map[2][8] = map[8][2] 
        		= map[3][7] = map[7][3] = map[4][6] = map[6][4] = 5;
        boolean[] marked = new boolean[10];
        int res = 0;
        for (int i = m; i <= n; i++) {
        	res += dfs(map, marked, 1, i - 1) * 4; // 1, 3, 7, 9 are symmetric
        	res += dfs(map, marked, 2, i - 1) * 4; // 2, 4, 6, 8 are symmetric
        	res += dfs(map, marked, 5, i - 1); // 5
        }
        return res;
    }
	
	/*
	 * curr : the current position
	 * remain : the steps remaining
	 */
	private int dfs(int[][] map, boolean[] marked, int curr, int remain) {
		if (remain < 0) return 0;
		if (remain == 0) return 1;
		marked[curr] = true;
		int res = 0;
		for (int i = 1; i <= 9; i++) {
			if (!marked[i] && (map[i][curr] == 0 || (marked[map[i][curr]]))) {
				res += dfs(map, marked, i, remain - 1);
			}
		}
		marked[curr] = false;
		return res;
	}

	public static void main(String[] args) {

	}

}
