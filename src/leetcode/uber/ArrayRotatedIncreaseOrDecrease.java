package leetcode.uber;

/**
 * Arra题判断给的array是不是逐一递增或递减的rotated array
 * 比如说 4 5 6 7 1 2 3  -> True
 * 4 5 6 8 1 2 3  -> False
 * 4 3 2 1 7 6 5  -> True
 */
public class ArrayRotatedIncreaseOrDecrease {

    public static boolean check(int[] A) {
        if (A == null || A.length < 2) {
            return false;
        }
        int diff = A[1] - A[0];
        if (Math.abs(diff) != 1 && Math.abs(diff) != A.length - 1) {
            return false;
        }
        if (Math.abs(diff) != 1) {
            if (diff > 0) {
                diff = -1;
            } else {
                diff = 1;
            }
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] == diff) {
                continue;
            }
            if (A[i] - A[i - 1] != diff && Math.abs(A[i] - A[i - 1]) != (A.length - 1)) {
                return false;
            }
        }
        return true;
    }

    // only ascending sorted array
    public boolean check2(int[] nums) {
        int k = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                k++;
            }
            if (k > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{4, 5, 6, 7, 1, 2, 3})); // true
        System.out.println(check(new int[]{4, 5, 6, 8, 1, 2, 3})); // false
        System.out.println(check(new int[]{4, 3, 2, 1, 7, 6, 5})); // true
        System.out.println(check(new int[]{4, 3, 2, 1, 8, 7, 6})); // false
        System.out.println(check(new int[]{1, 4, 3, 2})); // true
        System.out.println(check(new int[]{4, 1, 2, 3})); // true
        System.out.println(check(new int[]{4, 1, 2, 1})); // false
    }

}
