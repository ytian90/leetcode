package binarySearch;
/**
 * 29. Divide Two Integers
 * @author yutian
 * @since Aug 18, 2015
 */
public class DivideTwoIntegers {
	
	// Solution 1 Time ~O(logN) Space ~O(1)
	public static int divide(int dividend, int divisor) {
		if (divisor == 0) throw new IllegalArgumentException("divisor can't be zero.");
		if (divisor == 1) return dividend;
		if (divisor == -1) return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
		// convert int to long, otherwise Math.abs(Integer.MIN_VALUE) will overflow
		long p = Math.abs((long) dividend);
		long q = Math.abs((long) divisor);
		long res = 0;
		int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
		while (p >= q) {
			int count = 0;
			while (p >= (q << count)) // q * 2 ^ n < p < q * 2 ^ (n + 1)
				count++;
			//dividend minus the largest shifted divisor
			count--;
			res += (long) 1 << count; // add 2 ^ n
			p -= q << count; // p <= p - q * 2 ^ n
		}
		return sign == 1 ? (int) res : (int) -res;
	}

	public static void main(String[] args) {
		System.out.println(divide(15, 4));
		System.out.println(divide(Integer.MAX_VALUE, 1));
		System.out.println(divide(-2147483648, -1));
		System.out.println(divide(Integer.MAX_VALUE + 2, -1));
		System.out.println(divide(Integer.MIN_VALUE, -1));
		System.out.println(divide(Integer.MIN_VALUE, 1));
		
	}
	
	// Solution 2
	public int divide2(int dividend, int divisor) {
		long result = divideLong(dividend, divisor);
		return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)result;
	}

	private long divideLong(long dividend, long divisor) {
		// Remember the sign
		boolean negative = dividend < 0 != divisor < 0;
		
		// Make dividend and divisor unsign
		if (dividend < 0) dividend = -dividend;
		if (divisor < 0) divisor = -divisor;
		
		// Return if nothing to divide
		if (dividend < divisor) return 0;
		
		// Sum divisor 2, 4, 8, 16, 32 ... times
		long sum = divisor;
		long divide = 1;
		while ((sum + sum) <= dividend) {
			sum += sum;
			divide += divide;
		}
		
		// Make a recursive call for (devided - sum) and add it to the result
		return negative ? -(divide + divideLong((dividend - sum), divisor)) : 
			(divide + divideLong((dividend - sum), divisor));
	}
	
}
