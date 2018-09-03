package math;
/**
 * 263. Ugly Number
 * @author yutian
 * @since Aug 29, 2015
 */
public class UglyNumber {
	// Time ~(N), Space ~O(1)
	public static boolean isUgly(int num) {
		if (num <= 0) return false;
		for (int i = 2; i <= 5; i++) {
			while (num % i == 0)
				num /= i;
		}
		return num == 1;
	}

	public static boolean isUglyy(int num) {
		if (num <= 0) return false;
		while (num % 2 == 0) num /= 2;
		while (num % 3 == 0) num /= 3;
		while (num % 5 == 0) num /= 5;
		return num == 1;
	}
	
	public static void main(String[] args) {
		System.out.println(isUgly(6));
		System.out.println(isUgly(8));
		System.out.println(isUgly(14));
	}
}
