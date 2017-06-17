package array;
/**
 * mulesoft OA
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=166277&highlight=MuleSoft
 * @author yutian
 * @since Jan 22, 2016
 */
public class FindPeak {

	public static int findPeak(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		if (nums.length == 2) return nums[0] == nums[1] ? 0: 2;
		// remove the duplicates
		int t = 0, j = 1;
        while (j < nums.length) {
            if (nums[t] != nums[j]) {
                nums[++t] = nums[j];
            }
            j++;
        }
        int len = t + 1;
        // count the extreme values
		int count = 0;
		for (int i = 1; i < len - 1; i++) {
			if ((nums[i] < nums[i + 1] && nums[i] < nums[i - 1])
					|| (nums[i] > nums[i + 1] && nums[i] > nums[i - 1])) {
				count++;
			}
		}
		return count + 2;
	}
	
	public static int findPeak2(int[] nums) {
		if (nums == null) return 0;
		if (nums.length <= 1) return nums.length;
		int t = 0, count = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) continue;
			if (t == 0) {
				t = nums[i] > nums[i - 1] ? 1 : -1;
				continue;
			}
			if ((nums[i] > nums[i - 1] && t == -1) || (nums[i] < nums[i - 1] && t == 1)) {
				count++;
				t = t == 1 ? -1: 1;
			}
		}
		return t == 0 ? 1: count + 2;
	}
	
	public static void main(String[] args) {
		System.out.println(findPeak(new int[]{2, 2, 3, 4, 3, 3, 2, 2, 1,1,2,5}));
		System.out.println(findPeak(new int[]{2, 2}));
		System.out.println(findPeak2(new int[]{1, 2, 1, 1}));
	}
}
