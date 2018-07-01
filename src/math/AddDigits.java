package math;
/**
 * 258. Add Digits
 * @author yutian
 * @since Aug 29, 2015
 */
public class AddDigits {
	
	// Recursion
	public static int addDigits(int num) {
		if (num < 10) return num;
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return addDigits(sum);
	}

	public static int addDigit(int num) {
		if (num == 0) {
			return 0;
		}
		if (num % 9 == 0) {
			return 9;
		} else {
			return num % 9;
		}
	}
	
	// Math 
	public static int addDigits2(int num) {
		return num - 9 * ((num - 1) / 9);
	}
	
	public static void main(String[] args) {
		System.out.println(addDigits(38));
	}
}
