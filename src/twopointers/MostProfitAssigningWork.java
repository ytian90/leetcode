package twopointers;

import java.util.*;

/**
 * 826. Most Profit Assigning Work
 */
public class MostProfitAssigningWork {


    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> jobs = new ArrayList<>();
        int n = profit.length, res = 0, index = 0, currMax = 0;
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{difficulty[i], profit[i]});
        }
        Collections.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);
        for (int w : worker) {
            while (index < n && w >= jobs.get(index)[0]) {
                currMax = Math.max(currMax, jobs.get(index)[1]);
                index++;
            }
            res += currMax;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitAssignment(
                new int[]{2, 4, 6, 8, 10},
                new int[]{10, 20, 30, 40, 50},
                new int[]{4, 5, 6, 7}));

        System.out.println(maxProfitAssignment(
                new int[]{85, 47, 57},
                new int[]{24, 66, 99},
                new int[]{40, 25, 25}));

        System.out.println(maxProfitAssignment(
                new int[]{68, 35, 52, 47, 86},
                new int[]{67, 17, 1, 81, 3},
                new int[]{92, 10, 85, 84, 82}));
    }

    // something wrong
    public static int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], profit[i]);
        }
        for (int w : worker) {
            int curr = -1;
            while (w > 0) {
                if (map.containsKey(w)) {
                    curr = Math.max(curr, map.get(w));
                }
                w--;
            }
            max += (w == 0 && curr == -1) ? 0 : curr;
        }
        return max;
    }
}
