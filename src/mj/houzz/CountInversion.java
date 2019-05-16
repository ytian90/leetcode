package mj.houzz;

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

    // merge sort
    public static int countInversion2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        sort(nums, 0, nums.length);
        return res;
    }

    public static void sort(int[] nums, int l, int r) {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(nums, l, m);
            sort(nums , m+1, r);

            // Merge the sorted halves
            merge(nums, l, m, r);
        }
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int i = l, j = m + 1;
        while (i <= m && j < r) {
            if (nums[i] > nums[j]) {
                res++;
                i++;
            } else {
                j++;
            }
        }
        while (i <= m) {
            res++;
            i++;
        }
    }

    public static void main(String[] args) {
//        System.out.println(countInversion(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println(countInversion2(new int[]{6, 5, 4, 3, 2, 1}));
    }
}
