package bitManipulation;
/**
 * Bitwise AND of Numbers Range
 * @author yutian
 * @since Aug 24, 2015
 */
public class BitwiseANDOfNumbersRange {
	
	//https://leetcode.com/discuss/67187/java-python-easy-solution-with-explanation
	public static int rangeBitwiseAnd(int m, int n) {
		int i = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			i++;
		}
		return n << i;
	}
	
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 7));
	}
	
	public int rangeBitwiseAnd1(int m, int n) {
		int x = m ^ n;
		int s = x >> 1;
		while (s > 0) {
			x = x | s;
			s >>= 1;
		}
		return m & n & ~x;
		
		/*
		 * The only bits that will be 1 will be bits that are common 
		 * to the upper bits of A and B. 
		 */
	}
	
	// Solution 2
	public int rangeBitwiseAnd2(int m, int n) {
		int r = Integer.MAX_VALUE;
		while ((m & r) != (n & r)) r <<= 1;
		return n & r;
	}
	
	// Solution 3
	public int rangeBitwiseAnd3(int m, int n) {
		while (n > m) n &= n - 1;
		return n;
	}
}
