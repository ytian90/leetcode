package math;

/**
 * 458. Poor Pigs
 */
public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(base));
    }
}
