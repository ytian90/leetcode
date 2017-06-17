package array;
/**
 * 277. Find the Celebrity
 * @author yutian
 * @since Jan 3, 2016
 */
public class FindTheCelebrity extends Relation {
	
	public int findCelebrity(int n) {
		int candidate = 0;
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i)) candidate = i;
		}
		for (int i = 0; i < n; i++) {
			if (i == candidate) continue;
			// if candidate knows other people or anyone doesn't know candidate
			if (knows(candidate, i) || !knows(i, candidate)) {
				return -1;
			}
		}
		return candidate;
	}

	public static void main(String[] args) {

	}

}
