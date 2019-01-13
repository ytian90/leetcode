package math;
/**
 * Is Prime
 * @author yutian
 * @since Dec 14, 2015
 */
public class IsPrime {
	
	// check incr to the sqrt root
	public static boolean isPrime(int n) {
		if (n < 2) return false;
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	// rule out even number first, then check incr to the square root
	public static boolean isPrime2(int n) {
		if (n <= 1) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		for (int i = 3; i <= Math.sqrt(n) + 1; i = i + 2) {
			if (n % i == 0) return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
		System.out.println(isPrime2(77));
	}

}
