package greedy;

/**
 * 765. Couples Holding Hands
 */
public class CouplesHoldingHands {

    public static int minSwapsCouples(int[] row) {
        if (row.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < row.length; i = i + 2) {
            int num = row[i], target = 0;
            if (num % 2 == 0) {
                target = num + 1;
            } else {
                target = num - 1;
            }
            for (int j = i + 2; j < row.length; j++) {
                if (row[j] == target) {
                    swap(row, i + 1, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(minSwapsCouples(new int[]{0, 2, 1, 3}));
        System.out.println(minSwapsCouples(new int[]{3, 2, 0, 1}));
        System.out.println(minSwapsCouples(new int[]{5, 4, 2, 6, 3, 1, 0, 7}));
    }

    public static int minSwapsCouples2(int[] row) {
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

}
