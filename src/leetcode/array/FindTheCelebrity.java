package leetcode.array;
/**
 * 277. Find the Celebrity
 * @author yutian
 * @since Jan 3, 2016
 */
public class FindTheCelebrity {
	
	public static int findCelebrity(int n) {
		int c = 0;
		for (int i = 1; i < n; i++) {
			if (knows(c, i))
				c = i;
		}
		for (int i = 0; i < n; i++) {
			if (c == i) continue;
			// if candidate knows other people or anyone doesn't know candidate
			if (knows(c, i) || !knows(i, c))
				return -1;
		}
		return c;
	}

	public static void main(String[] args) {
		// hard to implement
	}

	static boolean knows(int a, int b) {
		return true;
	}
}
