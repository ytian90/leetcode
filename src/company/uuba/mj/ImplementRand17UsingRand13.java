package company.uuba.mj;

import java.util.Arrays;
import java.util.Random;

/**
 * Implement Rand17 using Rand13
 * https://www.1point3acres.com/bbs/thread-760923-1-1.html
 *
 */
public class ImplementRand17UsingRand13 {
    static Random random = new Random();

    public static int rand17() {
        int index = 32;
        while (index >= 32) {
            index = 2 * (rand13() - 1) + (rand13() - 1);
        }
        return (index % 17) + 1;
    }

    private static int rand13() {
        return random.nextInt(13) + 1;
    }

    public static void main(String[] args) {
        int[] res = new int[17];
        for (int i = 0; i < 10000; i++) {
            int a = rand17();
            res[a - 1]++;
        }
        System.out.println(Arrays.toString(res));
    }
}
