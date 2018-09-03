package bitManipulation;
/**
 * 191. Number of 1 Bits
 * @author yutian
 * @since Aug 6, 2015
 */
public class NumberOf1Bits {
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(11));
	}

	public static int hammingWeightt(int n) {
		return Integer.bitCount(n);
	}

	// Solution 2
	public static int hammingWeight2(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) != 0) count++;
			n >>= 1;
		}
		return count;
	}
	
	// Solution 1 Time O(N)
	public static int hammingWeight(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if (getBit(n, i)) {
				count++;
			}
		}
		return count;
	}

	private static boolean getBit(int n, int i) {
		return (n & (1 << i)) != 0;
	}
	
	
}
