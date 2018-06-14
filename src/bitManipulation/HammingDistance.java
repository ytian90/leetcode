package bitManipulation;
/**
 * 461. Hamming Distance
 * @author yutian
 *
 */
public class HammingDistance {
	
	public static int hammingDistance(int x, int y) {
        int xor = x ^ y, res = 0;
        for (int i = 0; i < 32; i++) {
            res += (xor >> i) & 1;
        }
        return res;
    }
	
	public static int hammingDistance1(int x, int y) {
	    return Integer.bitCount(x ^ y);
    }

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}

}
