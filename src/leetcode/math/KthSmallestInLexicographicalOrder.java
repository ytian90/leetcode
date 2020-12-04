package leetcode.math;
/**
 * 440. K-th Smallest in Lexicographical Order
 * @author yutian
 *
 */
public class KthSmallestInLexicographicalOrder {
	
	public static int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
        	int steps = helper(n, curr, curr + 1);
        	if (steps <= k) {
        		curr += 1;
        		k -= steps;
        	} else {
        		curr *= 10;
        		k -= 1;
        	}
        }
        return curr;
    }
	
	public static int helper(int n, long n1, long n2) {
		int steps = 0;
		while (n1 <= n) {
			steps += Math.min(n + 1, n2) - n1;
			n1 *= 10;
			n2 *= 10;
		}
		return steps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findKthNumber(13, 2));
	}

}
