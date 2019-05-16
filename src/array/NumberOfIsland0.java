package array;
/**
 * 1-D sort islands
 * http://www.1point3acres.com/bbs/thread-161878-1-1.html
 * @author yutian
 * @since Jan 6, 2016
 */
public class NumberOfIsland0 {
	
	public static int numIslands(char[] map) {
		if (map == null || map.length == 0) return 0;
		int count = map[0] == '1' ? 1 : 0;
		for (int i = 1; i < map.length; i++) {
			if (map[i] == '1' && map[i - 1] == '0') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String s = "001100110101101";
		char[] test1 = s.toCharArray();
		System.out.println(numIslands(test1));
	}

}
