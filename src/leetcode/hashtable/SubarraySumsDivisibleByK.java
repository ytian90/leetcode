package leetcode.hashtable;

/**
 * 874. Subarray Sums Divisible by K
 */
public class SubarraySumsDivisibleByK {
    public static int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int count = 0, sum = 0;
        for (int a : A) {
            sum = (sum + a) % K;
            if (sum < 0) {
                sum += K;
            }
            count += map[sum];
            map[sum]++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(subarraysDivByK(new int[]{-5}, 5));
        System.out.println(subarraysDivByK(new int[]{0, -5}, 5));
    }
}
