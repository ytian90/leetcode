package math;

/**
 * 754. Reach a Number
 */
public class ReachANumber {

    // explain: https://leetcode.com/problems/reach-a-number/discuss/112968/Short-JAVA-Solution-with-Explanation

    public static int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(reachNumber(2));
        System.out.println(reachNumber(3));
    }
}
