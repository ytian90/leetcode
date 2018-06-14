package array;

import java.util.Arrays;

/**
 * 832. Flipping an Image
 */
public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A) {
            for (int i = 0; i * 2 < n; i++) {
                if (row[i] == row[n - 1 - i]) {
                    row[i] = row[n - i - 1] ^= 1;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        for (int[] a : flipAndInvertImage(new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        })) {
            System.out.println(Arrays.toString(a));
        }

        for (int[] a : flipAndInvertImage(new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        })) {
            System.out.println(Arrays.toString(a));
        }
    }
}
