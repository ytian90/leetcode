package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer leetcode.array and a positive integer k, leetcode.sort all distinct pairs with difference equal to k.
 *
 * Input: arr[] = {1, 5, 3, 4, 2}, k = 3
 * Output: 2
 * There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2}
 *
 * Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4
 * Output: 5
 * There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8},
 * {8, 12}, {12, 16} and {16, 20}
 *
 * https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * leetcode.cc189: PAGE 67
 */
public class CountAllDistinctPairsWithDifferenceEqualToK {

    public static void main(String[] args) {
        for (List<Integer> list : count3(new int[]{8, 12, 16, 4, 0, 20}, 4)) {
            System.out.println(list);
        }
    }

    // brute force, time O(N^2)
    public static List<List<Integer>> count(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] - nums[j] == k || nums[j] - nums[i] == k) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j])));
                }
            }
        }
        return res;
    }

    // binary search time O(nlogn)
    public static List<List<Integer>> count2(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0, i, n = nums.length;
        Arrays.sort(nums);
        for (i = 0; i < n - 1; i++) {
            if (binarySearch(nums,i + 1, n - 1, nums[i] + k) != -1) {
                res.add(new ArrayList<>(Arrays.asList(nums[i], nums[i] + k)));
            }
        }
        return res;
    }

    private static int binarySearch(int[] nums, int lo, int hi, int x) {
        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == x) {
                return mid;
            } else if (nums[mid] < x) {
                return binarySearch(nums, mid + 1, hi, x);
            } else {
                return binarySearch(nums, lo, mid - 1, x);
            }
        }
        return -1;
    }

    // use hashing O(n)
    public static List<List<Integer>> count3(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] map = new boolean[100];

        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x - k >= 0 && map[x - k]) {
                res.add(new ArrayList<>(Arrays.asList(x, x - k)));
            }
            if (x + k < Integer.MAX_VALUE && map[x + k]) {
                res.add(new ArrayList<>(Arrays.asList(x, x + k)));
            }
            map[x] = false;
        }
        return res;
    }

}
