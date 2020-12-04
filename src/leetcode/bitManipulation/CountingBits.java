package leetcode.bitManipulation;
/**
 * 338. Counting Bits
 * @author yutian
 * @since Apr 8, 2016
 */
public class CountingBits {
	
	// Method 1: time ~O(32N)
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int count = 0, c = 32;
            int n = i;
            while (c > 0 && n != 0) {
                if ((n & 1) == 1) count++;
                n >>= 1;
            }
            res[i] = count;
        }
        return res;
    }
	
	// Method 2: time ~O(N)
	// check the left part digits except the last digit
	public int[] countBits2(int num) {
		int[] res = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			res[i] = res[i / 2] + (i & 1); // or use res[i >> 1]
		}
		return res;
	}

	public static void main(String[] args) {
		CountingBits t = new CountingBits();
		for (int i: t.countBits2(7)) {
			System.out.print(i + " ");
		}
	}

}
