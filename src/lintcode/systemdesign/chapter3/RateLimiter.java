package lintcode.systemdesign.chapter3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 215. 限制器
 */
public class RateLimiter {
    Map<String, List<Integer>> map = new HashMap<>();
    /*
     * @param timestamp: the current timestamp
     * @param event: the string to distinct different event
     * @param rate: the format is [integer]/[s/m/h/d]
     * @param increment: whether we should increase the counter
     * @return: true or false to indicate the event is limited or not
     */
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        String[] rates = rate.split("/");
        int limit = Integer.valueOf(rates[0]);
        String type = rates[1];
        int duration = 1;
        if (type.equals("m")) {
            duration = duration * 60;
        } else if (type.equals("h")) {
            duration = duration * 60 * 60;
        } else if (type.equals("d")) {
            duration = duration * 60 * 60 * 24;
        }

        int startTimeStamp = timestamp - duration + 1;
        if (!map.containsKey(event)) {
            map.put(event, new ArrayList<>());
        }
        int count = count_events(map.get(event), startTimeStamp);
        boolean is_rated_limited = (count >= limit);
        if (increment && !is_rated_limited) {
            insert_event(map.get(event), timestamp);
        }
        return is_rated_limited;
    }

    private void insert_event(List<Integer> event, int timestamp) {
        event.add(timestamp);
    }

    private int count_events(List<Integer> event, int startTimeStamp) {
        if (event == null || event.size() == 0) {
            return 0;
        }
        int l = 0, r = event.size() - 1, res = 0;
        if (event.get(r) < startTimeStamp) {
            return 0;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (event.get(mid) >= startTimeStamp) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return event.size() - 1 - res + 1;

    }
}
