package mj.twilio;

/**
 * lc: 974
 * https://www.1point3acres.com/bbs/thread-560264-1-1.html
 */
public class KSubsequences {

    public static int subarrayDivByK(int[] A, int K) {
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
        System.out.println(subarrayDivByK(new int[]{5, 10, 11, 9, 5}, 5));
    }
}
