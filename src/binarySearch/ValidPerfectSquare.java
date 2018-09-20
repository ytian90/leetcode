package binarySearch;
/**
 * 367. Valid Perfect Square
 * @author yutian
 * @since Jul 3, 2016
 */
public class ValidPerfectSquare {
	
	// Binary Search
	public static boolean isPerfectSquare(int num) {
		int lo = 1, hi = num;
        while (lo <= hi) {
            long mid = (lo + hi) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                lo = (int) mid + 1;
            } else {
                hi = (int) mid - 1;
            }
        }
        return false;
    }

	// use Newton Method to calculate the square root or num
	public static boolean isPerfectSquare3(int num) {
		long x = num;
		while (x * x > num) {
			x = (x + num / x) / 2;
		}
		return x * x == num;
	}
	
	public static boolean isPerfectSquare2(int num) {
        int i = 1;
        while (num > 0) {
        	num -= i;
        	i += 2;
        }
        return num == 0;
    }


	public static void main(String[] args) {
		System.out.println(isPerfectSquare(2));
		System.out.println(isPerfectSquare(9));
		System.out.println(isPerfectSquare(2147395600));
	}

}
