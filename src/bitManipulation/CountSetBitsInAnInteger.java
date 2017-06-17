package bitManipulation;
/**
 * Count set bits in an integer
 * http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
 * @author yutian
 * @since Feb 4, 2016
 */
public class CountSetBitsInAnInteger {
	
	// simple method: Theta of logn (-)(logn)
	public static int countSetBits(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}
	
	// brian kernighan's algorithm O(logN)
	public static int countSetBits2(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n &= (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countSetBits(7));
		System.out.println(countSetBits2(7));
	}

}
