package leetcode.mj.houzz;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给一个数列，数出inversion的数量（如果一个靠前的数字比靠后的数字大就算一个inversion）。没在地里见到过的题目，
 * 一开始只想出来暴力解法，面试官提醒了可以用NlogN的想到可以用类似merge sort的解法后写出来了。
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=499517&extra=page%3D1%26filter%3Dsortid%26sortid%3D192%26searchoption%5B3046%5D%5Bvalue%5D%3D103%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D192%26orderby%3Ddateline
 */
public class CountInversion {

    public static int countInversion(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    res++;
                }
            }
        }
        return res;
    }

    static int res = 0;

    // binary search
    public static int countInversion2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int n = nums.length;
        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }
        Arrays.sort(sorted, Collections.reverseOrder());

        int dec = 0;
        for (int i = 0; i < n; i++) {
            int index = binarySearchIterative(sorted, 0, n - 1, nums[i]);
            if (index > i) dec += index - i;
        }

        return n * (n - 1) / 2 - dec;
    }

    public static int binarySearch(Integer[] array, int left, int right, int key) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == key) {
            return mid;
        }
        if (array[mid] > key) {
            return binarySearch(array, mid + 1, right, key);
        } else {
            return binarySearch(array, left, mid - 1, key);
        }
    }

    public static int binarySearchIterative(Integer[] array, int left, int right, int key) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] > key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(countInversion(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println(countInversion2(new int[]{6, 3, 5, 4, 1, 2}));
    }
}
