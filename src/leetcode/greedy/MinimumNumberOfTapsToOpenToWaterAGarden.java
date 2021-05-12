package leetcode.greedy;

// Leetcode: 1326 Minimum Number of Taps to Open to Water a Garden
public class MinimumNumberOfTapsToOpenToWaterAGarden {
    public static int minTaps(int n, int[] ranges) {
        int[] nums = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            nums[left] = Math.max(nums[left], i + ranges[i]);
        }
        int res = 0, maxReach = 0, maxEnd = 0;
        for (int i = 0; i < nums.length && maxEnd < n; maxEnd = maxReach) {
            res++;
            while (i < nums.length && i <= maxEnd) {
                maxReach = Math.max(maxReach, nums[i++]);
            }
            if (maxEnd == maxReach) return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minTaps(5, new int[]{3, 4, 1, 1, 0, 0}));
    }
}
