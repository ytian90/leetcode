package leetcode.array;

import java.util.Arrays;

/**
 * 867. Transpose Matrix
 */
public class TransposeMatrix {

    public static int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        for (int[] a : transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })) {
            System.out.println(Arrays.toString(a));
        }

        for (int[] a : transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        })) {
            System.out.println(Arrays.toString(a));
        }
    }

}
