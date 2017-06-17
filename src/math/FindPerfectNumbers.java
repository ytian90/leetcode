package math;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

/**
 * Find all the perfect number in a given range of input.
 * Perfect number is: sum of all its positive divisors == number / 2
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=165505&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 13, 2016
 */
public class FindPerfectNumbers {
	
	public static List<Integer> findPerfectNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int i: nums) {
			if (isPerfectNumber(i)) result.add(i);
		}
		return result;
	}

	private static boolean isPerfectNumber(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) sum += i;
		}
		return (sum == n / 2) ? true: false;
	}

	public static void main(String[] args) {
		int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> list = findPerfectNumbers(test);
		for (int i: list) {
			System.out.println(i);
		}
	}

}
