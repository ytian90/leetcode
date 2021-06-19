package company.uber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * LC 465. Optimal Account Balancing
 *
 * You are given an array of transactions transactions where transactions[i] = [fromi, toi, amounti] indicates that the person with ID = fromi gave amounti $ to the person with ID = toi.
 *
 * Return the minimum number of transactions required to settle the debt.
 *
 * Example 1:
 *
 * Input: transactions = [[0,1,10],[2,0,5]]
 * Output: 2
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #2 gave person #0 $5.
 * Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
 * Example 2:
 *
 * Input: transactions = [[0,1,10],[1,0,1],[1,2,5],[2,0,5]]
 * Output: 1
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #1 gave person #0 $1.
 * Person #1 gave person #2 $5.
 * Person #2 gave person #0 $5.
 * Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 */
public class OptimalAccountBalancing {
    public static int minTransfers(int[][] transactions) {
        int[] debt = buildDebtArray(transactions);
        return getMinTransactions(0, debt);
    }

    private static int getMinTransactions(int currId, int[] debt) {
        while (currId < debt.length && debt[currId] == 0) {
            currId++;
        }
        if (currId == debt.length) {
            return 0;
        }
        int minTrans = Integer.MAX_VALUE / 2;
        for (int i = currId + 1; i < debt.length; i++) {
            if (debt[currId] * debt[i] < 0) {
                debt[i] += debt[currId];
                minTrans = Math.min(minTrans, 1 + getMinTransactions(currId + 1, debt));
                debt[i] -= debt[currId];
            }
        }
        return minTrans;
    }

    private static int[] buildDebtArray(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            int sender = t[0];
            int receiver = t[1];
            int amount = t[2];
            map.put(sender, map.getOrDefault(sender, 0) + amount);
            map.put(receiver, map.getOrDefault(receiver, 0) - amount);
        }
        int[] res = new int[map.size()];
        Iterator<Integer> iterator = map.values().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            res[i++] = iterator.next();
        }
        return res;
    }

    /**
     * Time: O(N!)
     * Space: O(N!)
     */

    public static void main(String[] args) {
        System.out.println(minTransfers(new int[][]{
                {0, 1, 10}, {2, 0, 5}
        }));
        System.out.println(minTransfers(new int[][]{
                {0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}
        }));
    }
}
