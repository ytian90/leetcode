package array;

import java.util.Arrays;

/**
 * 905. Sort Array By Parity
 */
public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int start = 0, end = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[start++] = A[i];
            } else {
                res[end--] = A[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
    }
}
