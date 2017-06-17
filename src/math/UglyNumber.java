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
	
	public static void main(String[] args) {
		System.out.println(isUgly(14));
	}
}
