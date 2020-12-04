package leetcode.math;
/**
 * 507. Perfect Number
 * @author ytian
 *
 */
public class PerfectNumber {
	
	public static boolean checkPerfectNumber(int num) {
        if (num < 2) return false;
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i;
				sum += num / i;
			}
        }
        return sum == num;
    }
	
	public static void main(String[] args) {
		System.out.println(checkPerfectNumber(28));
	}
}
