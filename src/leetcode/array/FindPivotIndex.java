package leetcode.array;

/**
 * 724. Find Pivot Index
 */
public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        int total = 0, sum = 0;
        for (int n : nums) total += n;
        for (int i = 0; i < nums.length; sum += nums[i++]) {
            if (2 * sum == total - nums[i]) return i;
        }
        return -1;
    }

//    public static int pivotIndexx(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        int i = 0, j = nums.length - 1;
//        int left = nums[i], right = nums[j];
//        while (i < j) {
//            if (left < right) {
//                left += nums[++i];
//            } else if (left > right) {
//                right += nums[--j];
//            } else {
//                left += nums[++i];
//                right += nums[--j];
//            }
//        }
//        if (left == right && i == j) return i;
//        else return -1;
//    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
        System.out.println(pivotIndex(new int[]{}));
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,-1,-1}));
        System.out.println(pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
    }
}
