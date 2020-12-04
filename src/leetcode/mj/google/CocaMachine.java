package leetcode.mj.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 18. Coca Machine
 */
public class CocaMachine {
    public static boolean canMakeIt(List<Soda> sodas, int volLower, int volUpper, int targetLower, int targetUpper, Map<String, Boolean> memo) {
        Boolean val = memo.get(volLower + "-" + volUpper);
        if (val != null) {
            return val;
        }
        if (volLower >= targetLower && volUpper <= targetUpper) {
            return true;
        }
        if (volUpper > targetUpper) {
            return false;
        }
        if (volUpper - volLower > targetUpper - targetLower) {
            return false;
        }
        for (Soda soda : sodas) {
            if (canMakeIt(sodas, volLower + soda.lower, volUpper + soda.upper, targetLower, targetUpper, memo)) {
                memo.put(volLower + "-" + volUpper, true);
                return true;
            }
        }
        memo.put(volLower + "-" + volUpper, false);
        return false;
    }

    public static boolean coke(List<List<Integer>> buttons, List<Integer> target) {
        int lower = target.get(0);
        int upper = target.get(1);
        boolean[][] dp = new boolean[lower + 1][upper + 1];
        for (int i = 0; i <= lower; i++) {
            for (int j = 0; j <= upper; j++) {
                for (List<Integer> button : buttons) {
                    if (i <= button.get(0) && j >= button.get(1)) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i <= lower; i++) {
            for (int j = 0; j <= upper; j++) {
                for (List<Integer> button : buttons) {
                    int preL = i - button.get(0);
                    int preR = j - button.get(1);
                    if (preL >= 0 && preR >= 0 && dp[preL][preR]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        return dp[lower][upper];
    }

    public static void main(String[] args) {
        List<Soda> sodas = new ArrayList<>();
        sodas.add(new Soda(100, 120));
        sodas.add(new Soda(200, 240));
        sodas.add(new Soda(400, 410));
        System.out.println(canMakeIt(sodas, 0, 0, 100, 110, new HashMap<>()));
        System.out.println(canMakeIt(sodas, 0, 0, 90, 120, new HashMap<>()));
        System.out.println(canMakeIt(sodas, 0, 0, 300, 360, new HashMap<>()));
        System.out.println(canMakeIt(sodas, 0, 0, 310, 360, new HashMap<>()));
        System.out.println(canMakeIt(sodas, 0, 0, 1, 9999999, new HashMap<>()));
    }

    private static class Soda {
        int lower;
        int upper;
        public Soda(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }
    }
}
