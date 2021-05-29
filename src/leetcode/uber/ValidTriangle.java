package leetcode.uber;

import java.util.Arrays;

/**
 * 给一个int array，每个value是三角形的一条边，判断每连续三个value能不能构成一个三角形。三角形判断方法是任意两边的和大于第三边
 */
public class ValidTriangle {

    private static int[] validTriangle(int[] A) {
        if (A == null || A.length < 3) {
            return new int[]{};
        }
        int n = A.length;
        int[] res = new int[n - 2];
        for (int i = 2; i < n; i++) {
            int a = A[i - 2], b = A[i - 1], c = A[i];
            if (a + b > c && b + c > a && a + c > b) {
                res[i - 2] = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(validTriangle(new int[]{1, 2, 2, 5, 5, 4})));
    }
}
