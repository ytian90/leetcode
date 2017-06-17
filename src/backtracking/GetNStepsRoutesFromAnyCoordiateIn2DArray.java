package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Get N Steps Routes From Any Coordiate In 2D Array
 * http://www.1point3acres.com/bbs/thread-166837-1-1.html
 * @author yutian
 * @since Jan 28, 2016
 */
public class GetNStepsRoutesFromAnyCoordiateIn2DArray {
	
	private static ArrayList<String> result;
	private static boolean[][] visited;
	private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static ArrayList<String> get(int[][] map, int x, int y, int steps) {
		result = new ArrayList<>();
		visited = new boolean[map.length][map[0].length];
		visited[x][y] = true;
		StringBuilder sb = new StringBuilder();
		sb.append(map[x][y]);
		dfs(map, x, y, steps, sb);
		return result;
	}

	private static void dfs(int[][] map, int x, int y, int steps, StringBuilder path) {
		if (path.length() == steps) {
			result.add(path.toString());
		} else {
			for (int[] dir: dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length)
                	continue;
                if (!visited[nx][ny]) {
                	path.append(map[nx][ny]);
                	visited[nx][ny] = true;
                	dfs(map, nx, ny, steps, path);
                	path.deleteCharAt(path.length() - 1);
                	visited[nx][ny] = false;
                }
			}
		}
		
	}

	public static void main(String[] args) {
		System.out.println(get(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 0, 1, 3));
		System.out.println(get(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2, 2, 3));
	}

}
