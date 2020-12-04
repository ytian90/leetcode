package leetcode.bitManipulation;
/**
 * 190. Reverse Bits
 * @author yutian
 * @since Aug 6, 2015
 */
public class ReverseBits {
	public static void main(String[] args) {
		int test = 43261596;
		System.out.println(reverseBits(test));
	}
	
	public static int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
        	n = swapBits(n, i, 31 - i);
        }
        return n;
    }

	private static int swapBits(int n, int i, int j) {
		int a = (n >> i) & 1; // a = (1 << i) & n won't work
		int b = (n >> j) & 1;
		
		if ((a ^ b) == 1) { // a and b are different, so need to change
			n ^= (1 << i) | (1 << j); // 0 ^ 1 = 1, 1 ^ 1 = 0, so ^ 1 can flip bit
		}
		return n;
	}
}