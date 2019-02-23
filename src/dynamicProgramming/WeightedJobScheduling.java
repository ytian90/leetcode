package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Job Scheduling Problem
 * Given certain jobs with start and end time and amount you make on finishing the job,
 * find the maximum value you can make by scheduling jobs in non-overlapping way.
 * https://www.geeksforgeeks.org/weighted-job-scheduling/
 */
public class WeightedJobScheduling {
    static class Job {
        int start;
        int end;
        int profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int maxProfit(Job[] jobs) {
        if (jobs == null || jobs.length == 0)
            return 0;
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.end - o2.end;
            }
        });
        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(jobs[i].profit, dp[i - 1]);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j].end <= jobs[i].start) {
                    dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                    break;
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(5,8,11);
        jobs[5] = new Job(7,9,2);
        WeightedJobScheduling mp = new WeightedJobScheduling();
        System.out.println(mp.maxProfit(jobs));
    }

}
