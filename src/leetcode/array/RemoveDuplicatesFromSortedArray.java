package leetcode.array;
/**
 * 26. Remove Duplicates from Sorted Array
 * @author yutian
 * @since Aug 9, 2015
 */
public class RemoveDuplicatesFromSortedArray {
	
	// Solution 1
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
        if (n < 2) return n;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[j]) 
                nums[++j] = nums[i];
        }
        return j + 1;
	}
	
	// Solution 2
	public int removeDuplicates2(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int i = 0;
		int j = 1;
		while (j < nums.length) {
			if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
		}
		return i + 1;
	}
	
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray t = new RemoveDuplicatesFromSortedArray();
		System.out.println(t.removeDuplicates(new int[]{1, 1}));
		System.out.println(t.removeDuplicates(new int[]{1, 2}));
		System.out.println(t.removeDuplicates(new int[]{1, 1, 3}));
		System.out.println(t.removeDuplicates(new int[]{1, 2, 3, 3}));
	}
}
