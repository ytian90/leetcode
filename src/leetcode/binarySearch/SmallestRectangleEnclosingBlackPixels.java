package leetcode.binarySearch;
/**
 * 302. Smallest Rectangle Enclosing Black Pixels
 * @author yutian
 * @since Feb 15, 2016
 */
public class SmallestRectangleEnclosingBlackPixels {
	
	// Solution 1: binary search
	// time O(m log n + n log m), m and n are rows and cols
	
	private char[][] image;
	
	public int minArea(char[][] Image, int x, int y) {
        image = Image;
        int m = image.length, n = image[0].length;
        int left = searchCol(0, y, 0, m, true);
        int right = searchCol(y + 1, n, 0, m, false);
        int top = searchRow(0, x, left, right, true);
        int bottom = searchRow(x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }
	
	private int searchCol(int i, int j, int top, int bottom, boolean opt) {
		while (i != j) {
			int k = top, mid = i + (j - i) / 2;
			while (k < bottom && image[k][mid] == '0') ++k;
			if (k < bottom == opt) {
				j = mid;
			} else {
				i = mid + 1;
			}
		}
		return i;
	}

	private int searchRow(int i, int j, int left, int right, boolean opt) {
		while (i != j) {
			int k = left, mid = i + (j - i) / 2;
			while (k < right && image[mid][k] == '0') ++k;
			if (k < right == opt) {
				j = mid;
			} else {
				i = mid + 1;
			}
		}
		return i;
	}

	
	
	// solution 2 DFS
	// time O(m * n)
	
	private int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE,
			maxX = 0, maxY = 0;
	
	public int minArea2(char[][] image, int x, int y) {
		int m = image.length, n = image[0].length;
		if (image == null || m == 0 || n == 0)
			return 0;
		dfs(image, x, y, m, n);
		return (maxX - minY + 1) * (maxY - minY + 1);
	}

	private void dfs(char[][] image2, int x, int y, int m, int n) {
		if (x < 0 || y < 0 || x >= m || y >= n || image[x][y] == '0') {
			return;
		}
		image[x][y] = '0';
		minX = Math.min(minX, x);
		minY = Math.min(minY, y);
		maxX = Math.max(maxX, x);
		maxY = Math.max(maxY, y);
		dfs(image, x + 1, y, m, n);
		dfs(image, x - 1, y, m, n);
		dfs(image, x, y - 1, m, n);
		dfs(image, x, y + 1, m, n);
	}

	public static void main(String[] args) {
		SmallestRectangleEnclosingBlackPixels t =
				new SmallestRectangleEnclosingBlackPixels();
		System.out.println(
				t.minArea(new char[][]{{'0', '0', '1', '0'}, 
							   		   {'0', '1', '1', '0'}, 
							   		   {'0', '1', '0', '0'}}, 0, 2));
		
		
	}

}
