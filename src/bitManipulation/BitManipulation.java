package bitManipulation;
/**
 * 397. Integer Replacement
 * @author yutian
 *
 */
public class BitManipulation {

	public static int integerReplacement(int n) {
		int c = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n >>>= 1;
			} else if (n == 3 || ((n >>> 1) & 1) == 0) {
				n--;
			} else {
				n++;
			}
			c++;
		}
		return c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerReplacement(8));
		System.out.println(integerReplacement(7));
	}

}
