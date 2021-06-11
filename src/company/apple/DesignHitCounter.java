package company.apple;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=762167&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D4%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class DesignHitCounter {
    private int[] times;
    private int[] hits;

    /** Initialize your data structure here. */
    public DesignHitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int i = timestamp % 300;
        if (times[i] != timestamp) {
            times[i] = timestamp;
            hits[i] = 1;
        } else {
            hits[i]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                res += hits[i];
            }
        }
        return res;
    }

}
