package array;

/**
 * 487. Max Consecutive Ones 2
 */
public class MaxConsecutiveOnes2 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int frontSum = 0, backSum = 0, maxSum = 0;
        for (int n : nums) {
            if (n == 0) {
                frontSum = backSum + 1;
                backSum = 0;
            }
            backSum += n;
            maxSum = Math.max(maxSum, frontSum + backSum);

        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
    }
}
