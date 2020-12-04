package leetcode.binarySearch;
/**
 * 374. Guess Number Higher or Lower
 * @author yutian
 * @since Jul 24, 2016
 */
public class GuessNumberHigherOrLower {
	
	public static int target;
	
	public static int guessNumber(int n) {
        int i = 1, j = n;
        while (i < j) {
        	int mid = i + (j - i) / 2;
        	if (guess(mid) == 0) {
        		return mid;
        	} else if (guess(mid) == 1) {
        		i = mid + 1;
        	} else {
        		j = mid;
        	}
        }
        return i;
    }

	private static int guess(int n) {
		if (target < n) {
			return -1;
		} else if (target > n) {
			return 1;
		} else {
			return 0;			
		}
	}

	public static void main(String[] args) {

	}

}
