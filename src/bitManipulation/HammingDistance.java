package bitManipulation;
/**
 * 461. Hamming Distance
 * @author yutian
 *
 */
public class HammingDistance {
	
	public static int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) count += (xor >> i) & 1;
        return count;
    }
	
	public static int hammingDistance1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingDistance(1, 4));
		
	}

}
