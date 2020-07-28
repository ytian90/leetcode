package lintcode.systemdesign.chapter7;

import java.util.*;

/**
 * 565. HeartBeat
 */
public class HeartBeat {
    public Map<String, Integer> map;
    public int k;

    public HeartBeat() {
        map = new HashMap<>();
    }

    public void initialize(List<String> list, int k) {
        this.k = k;
        for (String ip : list) {
            map.put(ip, 0);
        }
    }

    public void ping(int timestamp, String ip) {
        if (!map.containsKey(ip)) {
            return;
        }
        map.put(ip, timestamp);
    }

    public List<String> getDiedSlaves(int timestamp) {
        List<String> res = new ArrayList<>();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String ip = (String) entry.getKey();
            int time = (Integer) entry.getValue();
            if (time <= timestamp - 2 * k) {
                res.add(ip);
            }
        }
        return res;
    }
}
