package bitManipulation;
/**
 * Single Number III
 * @author yutian
 * @since Aug 29, 2015
 */
public class SingleNumber3 {
	// Time: O(n) Space: O(1)
	public static int[] singleNumber(int[] nums) {
		// Pass 1:
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int n : nums) {
			diff ^= n;
		}
		// Get its last set bit
		//  53 --> 00110101
	    // -53 --> 11001010 + 1 = 11001011
		diff &= -diff;
		
		// Pass 2:
		int[] res = {0, 0}; // this array stores the two numbers we will return
		for (int n : nums) {
			if ((n & diff) == 0) // the bit is not set
				res[0] ^= n;
			else // the bit is set
				res[1] ^= n;
		}
		return res;
	}
	
	public static void main(String[] args) {
		for (int i: singleNumber(new int[]{1, 2, 1, 3, 2, 5})) {
			System.out.print(i + " ");
		}
	}
}
