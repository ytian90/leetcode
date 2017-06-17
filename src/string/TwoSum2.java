package string;
/**
 * Two Sum II - Input array is sorted
 * @author yutian
 * @since Jul 24, 2015
 */
public class TwoSum2 {

	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		
		// Check solution 1
		int[] solution1 = twoSum(numbers, target);
		System.out.println(solution1[0]);
		System.out.println(solution1[1]);
		
		// Check solution 2
		int[] solution2 = twoSum2(numbers, target);
		System.out.println(solution2[0]);
		System.out.println(solution2[1]);
		
	}

	// Solution 1
	public static int[] twoSum(int[] numbers, int target) {
		// Assume input is already sorted.
		for (int i = 0; i < numbers.length; i++) {
			int j = bsearch(numbers, target - numbers[i], i + 1);
			if (j != -1) {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	private static int bsearch(int[] numbers, int key, int start) {
		int L = start, R = numbers.length - 1;
		while (L < R) {
			int M = (L + R) / 2;
			if (numbers[M] < key) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return (L == R && numbers[L] == key)? L : -1;
	}
	
	// Solution 2
	public static int[] twoSum2(int[] numbers, int target) {
		// Assume input is already sorted.
		int i = 0, j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
}
