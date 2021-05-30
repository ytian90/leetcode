package leetcode.uber;

import java.util.Arrays;

/**
 * 提供一个一维坐标objects ex. [1,2,3,5,7,9], 和一个路灯能照到的radius， 返回一个坐标使得radius范围内照射到的objects最多。
 * 这题我先用画出从最小值到最大值的数组，使用sliding window， hidden case超时。 然后用binary search全过。
 *
 * https://instant.1point3acres.com/thread/742670
 */
public class LightRadius {
    public static int findPosition(int[] nums, int radius) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int res = 0, range = 0;
        for (int i = 0; i < n; i++) {
            int left = Arrays.binarySearch(nums, 0, i, nums[i] - radius);
            if (left < 0) {
                left = - (left + 1);
            }
            int right = Arrays.binarySearch(nums, i, n, nums[i] + radius);
            boolean notIncludeRight = false;
            if (right < 0) {
                right = - (right + 1);
                notIncludeRight= true;
            }
            int curr = notIncludeRight ? right - left : right - left + 1;
            if (curr > range) {
                range = right - left;
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findPosition(new int[]{1, 2, 3, 5, 7, 9}, 2));
    }

}
