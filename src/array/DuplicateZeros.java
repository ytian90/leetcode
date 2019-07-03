package array;

import java.util.Arrays;

/**
 * 1089. Duplicate Zeros
 */
public class DuplicateZeros {

    public static void duplicateZeros(int[] arr) {
        int n = arr.length, i = 0, j = 0;
        for (i = 0; i < n; i++, j++) {
            if (arr[i] == 0) {
                j++;
            }
        }
        for (i = i - 1; i >= 0; i--) {
            if (--j < n) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0 && --j < n) {
                arr[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] t = new int[]{8,4,5,0,0,0,0,7};
        duplicateZeros(t);
        System.out.println(Arrays.toString(t));
    }
}
