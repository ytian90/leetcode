package leetcode.array;

import java.util.Arrays;

/**
 * 667. Beautiful Arrangement 2
 */
public class BeautifulArrangement2 {

    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++) {
            if (k > 1) {
                if (k % 2 != 0) {
                    res[i] = l++;
                } else {
                    res[i] = r--;
                }
            } else {
                res[i] = l++;
            }
            k--;
        }
        return res;
    }

    public int[] constructAraay(int n, int k) {
        int[] res = new int[n];
        for (int i = 0, l = 1, r = n; l <= r; i++)
            res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(3, 1)));
        System.out.println(Arrays.toString(constructArray(3, 2)));
    }

}
