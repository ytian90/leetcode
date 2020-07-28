package lintcode.systemdesign.chapter3;

import java.util.LinkedList;

/**
 * 505. Web logger
 */
public class WebLogger {
    LinkedList<Integer> times;
    public WebLogger() {
        // do intialization if necessary
        times = new LinkedList<>();
    }

    /*
     * @param timestamp: An integer
     * @return: nothing
     */
    public void hit(int timestamp) {
        // write your code here
        times.add(timestamp);
    }

    /*
     * @param timestamp: An integer
     * @return: An integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // write your code here
        while (!times.isEmpty() && times.getFirst() + 300 <= timestamp) {
            times.removeFirst();
        }
        return times.size();
    }
}
