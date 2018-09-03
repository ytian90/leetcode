package math;
/**
 * 326. Power of Three
 * @author yutian
 * @since Jan 16, 2016
 */
public class PowerOfThree {
	
	// iterative 
	public static boolean isPowerOfThree(int n) {
		if (n <= 0) return false;
        while (n % 3 == 0) {
        	n /= 3;
        }
        return n == 1;
    }

    public static boolean isPowerOfThreee(int n) {
		double x = (double) n;
		while (x > 3) {
			x /= 3;
		}
		return x == 1 || x == 3;
	}
	
	// recursive
	public static boolean isPowerOfThree2(int n) {
		return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree2(n / 3)));
	}
	
	// math way
	/*
	 * This works because 3 is a prime number. A 32 bit positive integer 
	 * is a power of 3 is equivalent to it is a factor of 3^19 = 1162261467.
	 */
	public static boolean isPowerOfThree3(int n) {
		return n > 0 && (1162261467 % n == 0);
	}

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(3));
		System.out.println(isPowerOfThree2(3));
		System.out.println(isPowerOfThree3(3));
		
		System.out.println(isPowerOfThree(59049)); // pow (3, 10)
		System.out.println(isPowerOfThree2(59049));
		System.out.println(isPowerOfThree3(59049));
		
		System.out.println(isPowerOfThree(59048));
		System.out.println(isPowerOfThree2(59048));
		System.out.println(isPowerOfThree3(59048));
	}

}
