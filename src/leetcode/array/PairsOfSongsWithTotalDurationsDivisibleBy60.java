package leetcode.array;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    // t is betwee 0 to 500, so 600 is the next smallest num bigger than 500.
    public static int numPairsDivisibleBy60(int[] time) {
        int[] c = new int[60];
        int res = 0;
        for (int t : time) {
            res += c[(600 - t) % 60];
            c[t % 60]++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}
