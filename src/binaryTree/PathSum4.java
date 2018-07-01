package binaryTree;

/**
 * 666. Path Sum IV
 */
public class PathSum4 {

    public static int pathSum(int[] nums) {
        int[][] m = new int[5][8];
        for (int n : nums) {
            int i = n / 100;
            int j = (n % 100) / 10 - 1;
            int v = n % 10;
            m[i][j] = m[i - 1][j / 2] + v;
        }
        int res = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 4 || m[i][j] != 0 && m[i + 1][j * 2] == 0 && m[i + 1][j * 2 + 1] == 0) {
                    res += m[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(pathSum(new int[]{113, 215, 221}));
        System.out.println(pathSum(new int[]{113, 221}));
    }
}
