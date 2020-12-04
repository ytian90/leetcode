package leetcode.mj.houzz;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named RotateImage.
 *
 * If you need more classes, simply define them inline.
 */

class RotateImage {
    /**

     1 2  3  4
     5 6  7  8
     9 10 11 12
     13 14 15 16

     13 9 5 1
     14 10 6 2
     15 11 7 3
     16 12 8 4

     */
    public static void main(String[] args) {
        int[][] t = new int[4][4];
        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                t[i][j] = count;
                count++;
            }
        }
        rotate(t);

        for (int[] a : t) {
            System.out.println(Arrays.toString(a));
        }
    }


    public static void rotate(int[][] matrix) {
        int N = matrix.length;
        int n = (N % 2 == 0) ? N / 2 : N / 2 + 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                int p = N - 1 - i, q = N - 1 - j;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[q][i];
                matrix[q][i] = matrix[p][q];
                matrix[p][q] = matrix[j][p];
                matrix[j][p] = tmp;
            }
        }
    }
}
