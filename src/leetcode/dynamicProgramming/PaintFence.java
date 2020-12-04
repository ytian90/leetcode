package leetcode.dynamicProgramming;
/**
 * 276. Paint Fence
 * @author yutian
 * @since Dec 27, 2015
 */
public class PaintFence {
	// time O(n) space O(1)
	public static int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        else if (n == 1) return k;
        int diff = k * (k - 1);
        int same = k;
        for (int i = 2; i < n; i++) {
        	int temp = diff;
        	diff = (diff + same) * (k - 1);
        	same = temp;
        }
        return diff + same;
    }
	
	// time O(n) space O(n)
	public static int numWays2(int n, int k) {
		if (n == 0 || k == 0) return 0;
		if (n == 1) return k;
		// same[i] means the ith post has the same color with the (i - 1)th post
		int[] same = new int[n];
		// diff[i] means the ith post has a different color with the (i - 1)th post
		int[] diff = new int[n];
		same[0] = same[1] = k;
		diff[0] = k;
		diff[1] = k * (k - 1);
		for (int i = 2; i < n; i++) {
			same[i] = diff[i - 1];
			diff[i] = (k - 1) * same[i - 1] + (k - 1) * diff[i - 1];
		}
		return same[n - 1] + diff[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(numWays(3, 3));
	}

}
