package leetcode.array;

/**
 * 665. Non-decreasing Array
 */
public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i < 2 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];
                else
                    nums[i] = nums[i - 1];
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
        System.out.println(checkPossibility(new int[]{4, 2, 1}));
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
