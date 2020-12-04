package leetcode.array;

/**
 * 775. Global and Local Inversions
 */
public class GlobalAndLocalInversions {
    public static boolean isIdealPermutation(int[] A) {
        if (A == null || A.length == 0)
            return true;
        int c1 = 0, c2 = 0, n = A.length;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (A[i] > A[j])
                    c1++;
            }
            if (A[j - 1] > A[j]) c2++;
        }
        return c1 == c2;
    }

    public static boolean isIdealPermutation2(int[] A) {
        int currMax = 0;
        for (int i = 0; i < A.length - 2; i++) {
            currMax = Math.max(currMax, A[i]);
            if (currMax > A[i + 2]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(isIdealPermutation(new int[]{1, 2, 0}));
    }
}
