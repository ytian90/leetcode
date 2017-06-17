package array;
/**
 * Sort Colors
 * @author yutian
 * @since Aug 19, 2015
 */
public class SortColors {
	/**
	 * Solution 1: Two pass: radix sort
	 * Time ~ O(2N), Space ~ O(1) 
	 * @param nums
	 */
	public static void sortColors(int[] nums) {
		int[] count = new int[3];
		for (int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}
		int pos = 0;
		for (int i = 0; i < count[0]; i++) nums[pos++] = 0;
		for (int i = 0; i < count[1]; i++) nums[pos++] = 1;
		for (int i = 0; i < count[2]; i++) nums[pos++] = 2;
	}
	/**
	 * Solution 2: One-pass
	 * Time ~ O(N), Space ~ O(1) 
	 * @param nums
	 */
	public static void sortColors2(int[] nums) {
		// 0 - red, 1 - while, 2 - blue
		int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r; i++) { // this is right ptr, not nums.length
            if (nums[i] == 0) {
                swap(nums, i, l++);
            } else if (nums[i] == 2) {
                swap(nums, i--, r--);
            }
        }
	}

	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	// follow up
	// category: low={a,c,d}, median={f,w}, high={t,b}, sort as low, median high
	public static void sortChars(char[] chars) {
		int j = 0, k = chars.length;
		for (int i = 0; i < k; i++) {
			if (chars[i] == 'a' || chars[i] == 'c' || chars[i] == 'd') {
				swap(chars, i, j++);
			} else if (chars[i] == 't' || chars[i] == 'b') {
				swap(chars, i--, --k);
			}
		}
	}
	
	private static void swap(char[] chars, int i, int j) {
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
	}
	
	public static void main(String[] args) {
		int[] t = new int[]{2};
		sortColors2(t);
		for (int i: t) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] t1 = new int[]{0, 1, 0};
		sortColors2(t1);
		for (int i: t1) {
			System.out.print(i + " ");
		}
		
		char[] t2 = new char[]{'b', 'f', 'w', 'a', 't', 't', 'c', 'd', 'c', 'f'};
		sortChars(t2);
		for (char i: t2) {
			System.out.print(i + " ");
		}
	}

}
