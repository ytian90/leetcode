package leetcode.mj.houzz;

/**
 * Given a number, find the next smallest palindrome
 * input 23545, output 23632
 * input 999, output 1001
 * input 1234, output 1331
 * input 1221, output 1331
 *
 * https://www.1point3acres.com/bbs/thread-454843-1-1.html
 */
public class NextPalindrome {

    public static void helper(int nums[], int n) {
        int mid = n / 2;
        int i = mid - 1; // end of left side is always 'mid - 1'
        int j = (n % 2 == 0) ? mid : mid + 1; // beginning of right side depends on n is odd or even
        // a boolean variable to check if copy of left side to right is sufficient or not
        boolean leftsmaller = false;
        // ignore the middle same digits
        while (i >= 0 && nums[i] == nums[j]) {
            i--;
            j++;
        }
        // Find if the middle digit(s) need to be incremented or not
        if (i < 0 || nums[i] < nums[j]) {
            leftsmaller = true;
        }
        // copy the middle of left to right
        while (i >= 0) {
            nums[j++] = nums[i--];
        }
        // handle the case where the middle digit(s) must increment
        if (leftsmaller) {
            int carry = 1;
            // if odd digits, increment the middle digit and store the carry
            if (n % 2 == 1) {
                nums[mid] += 1;
                carry = nums[mid] / 10;
                nums[mid] %= 10;
            }
            i = mid - 1;
            j = (n % 2 == 0) ? mid : mid + 1;
            // add 1 to the rightmost digit of the left side, propagate the carry, simultaneously copying the mirror of the left to right
            while (i >= 0) {
                nums[i] = nums[i] + carry;
                carry = nums[i] / 10;
                nums[i] %= 10;
                nums[j] = nums[i];
                i--;
                j++;
            }
        }
    }

    public static boolean isAll9(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            if (nums[i] != 9) {
                return false;
            }
        }
        return true;
    }

    public static int nextPalindrome(int[] nums, int n) {
        StringBuilder sb = new StringBuilder();
        if (isAll9(nums, n)) {
            sb.append(1);
            for (int i = 0; i < n -1; i++) {
                sb.append(0);
            }
            sb.append(1);
        } else {
            helper(nums, n);
            for (int i = 0; i < n; i++) {
                sb.append(nums[i]);
            }
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(nextPalindrome(new int[]{2, 3, 5, 4, 5}, 5));
        System.out.println(nextPalindrome(new int[]{9, 9, 9}, 3));
        System.out.println(nextPalindrome(new int[]{1, 2, 3, 4}, 4));
        System.out.println(nextPalindrome(new int[]{1, 2, 2, 1}, 4));
    }
}
