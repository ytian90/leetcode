package leetcode.dfs_bfs;
/**
 * 547. Friend Circles
 * @author ytian
 *
 */
public class FriendCircles {

	// method 1
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

	// method 2
	public static int findCircleNums(int[][] M) {
		int res = 0;
		for (int i = 0; i < M.length; i++) {
			if (M[i][i] == 1) {
				dfs(M, i);
				res++;
			}
		}
		return res;
	}

	private static void dfs(int[][] M, int i) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1) {
				M[i][j] = M[j][i] = 0;
				dfs(M, j);
			}
		}
	}

	// method 3
	public int findCircleNumm(int[][] M) {
		int n = M.length;
		UnionFind uf = new UnionFind(n);
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (M[i][j] == 1)
					uf.union(i, j);
			}
		}
		return uf.count();
	}

	class UnionFind {
		private int count = 0;
		private int[] parent, rank;

		public UnionFind(int n) {
			this.count = n;
			this.parent = new int[n];
			this.rank = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		public int find(int p) {
			while (p != parent[p]) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			return p;
		}

		public void union(int p, int q) {
			int i = find(p);
			int j = find(q);
			if (i == j) return;
			if (rank[j] > rank[i]) {
				parent[i] = j;
			} else {
				parent[j] = i;
				if (rank[i] == rank[j]) {
					rank[i]++;
				}
			}
			count--;
		}

		public int count() {
			return count;
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
//		System.out.println(findCircleNum(t2));
	}

}
