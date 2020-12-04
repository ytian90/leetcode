package leetcode.math;

/**
 * 458. Poor Pigs
 */
public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
