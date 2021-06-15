package company.lnkin;

import java.util.Random;

public class RandomPickWithWeight {
    private int[] sums;
    private Random random;

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        sums = w;
    }

    public int pickIndex() {
        int n = sums.length;
        int target = random.nextInt(sums[n - 1]) + 1;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sums[mid] == target) {
                return mid;
            } else if (sums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        RandomPickWithWeight obj = new RandomPickWithWeight(new int[]{1, 3});
        for (int i = 0; i < 4; i++) {
            System.out.println(obj.pickIndex());
        }
    }
}
