package company.lnkin;

/**
 * LC 360. Sort Transformed Array
 *
 * Given a sorted integer array nums and three integers a, b and c, apply a quadratic function of the form f(x) = ax2 + bx + c to each element nums[i] in the array, and return the array in a sorted order.
 *
 * Example 1:
 *
 * Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
 * Output: [3,9,15,33]
 * Example 2:
 *
 * Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
 * Output: [-23,-5,1,7]
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1, k = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            int l = calculate(nums[i], a, b, c), r = calculate(nums[j], a, b, c);
            if (a >= 0) {
                if (l > r) {
                    res[k--] = l; i++;
                } else {
                    res[k--] = r; j--;
                }
            } else {
                if (l > r) {
                    res[k++] = r; j--;
                } else {
                    res[k++] = l; i++;
                }
            }
        }
        return res;
    }

    private int calculate(int n, int a, int b, int c) {
        return a * n * n + b * n + c;
    }

    /**
     * a > 0, two ends in the original array are bigger than center
     * a < 0, center is bigger than two ends
     */
}
