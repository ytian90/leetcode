package bitManipulation;
/**
 * 477. Total Hamming Distance
 * @author yutian
 *
 */
public class TotalHammingDistance {
	
	/*
	 * For each bit position 1-32 in a 32-bit integer, 
	 * we count the number of integers in the array 
	 * which have that bit set. Then, if there are n 
	 * integers in the array and k of them have a particular 
	 * bit set and (n-k) do not, then that bit contributes 
	 * k*(n-k) hamming distance to the total.
	 */
	public static int totalHammingDistance(int[] nums) {
		int res = 0;
		for (int j = 0; j < 32; j++) {
			int bitCount = 0;
			for (int n : nums) {
				bitCount += (n >> j) & 1;
			}
			res += bitCount * (nums.length - bitCount);
		}
		return res;
    }

	public static void main(String[] args) {
		int[] t = new int[]{4, 14, 2};
		System.out.println(totalHammingDistance(t));
		
	}

}
