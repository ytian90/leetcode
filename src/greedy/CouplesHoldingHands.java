package greedy;

/**
 * 765. Couples Holding Hands
 */
public class CouplesHoldingHands {

    public static int minSwapsCouples(int[] row) {
        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            int target = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
            if (row[i + 1] == target) continue;
            for (int j = i + 2; j < row.length; j++) {
                if (row[j] == target) {
                    swap(row, i + 1, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void swap(int[] row, int i, int j) {
        int t = row[i];
        row[i] = row[j];
        row[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(minSwapsCouples(new int[]{3, 2, 0, 1}));
        System.out.println(minSwapsCouples(new int[]{5, 4, 2, 6, 3, 1, 0, 7}));
    }
}
