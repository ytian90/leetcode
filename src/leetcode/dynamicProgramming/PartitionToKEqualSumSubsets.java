package leetcode.dynamicProgramming;

/**
 * 698. Partition to K Equal Sum Subsets
 */
public class PartitionToKEqualSumSubsets {

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (k <= 0 || sum % k != 0) return false;
        boolean[] visited = new boolean[nums.length];
        return helper(nums, k, visited, 0, 0, 0, sum / k);
    }

    private static boolean helper(int[] nums, int k, boolean[] visited, int start_index,
                           int curr_sum, int curr_num, int target) {
        if (k == 1) return true;
        if (curr_sum == target && curr_num > 0)
            return helper(nums, k - 1, visited, 0, 0, 0, target);
        for (int i = start_index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (helper(nums, k, visited, i + 1, curr_sum + nums[i], curr_num++, target))
                    return true;
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(canPartitionKSubsets(new int[]{-1, 1, 0, 0}, 4));
        System.out.println(canPartitionKSubsets(new int[]{-1, 1}, 1));
        System.out.println(canPartitionKSubsets(new int[]{-1, 1}, 2));
        System.out.println(canPartitionKSubsets(new int[]{-1, 1, 0}, 2));
    }
}
