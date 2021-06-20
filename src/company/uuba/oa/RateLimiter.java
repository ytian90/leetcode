package company.uuba.oa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RateLimiter {
    public int REQUEST_LIMIT = 100;
    public Long TIME_LIMIT = 1000L;

    public class HitCounter {
        public Queue<Long> q;
        public HitCounter() {
            q = new LinkedList<>();
        }

        public boolean hit(long timestamp) {
            while (!q.isEmpty() && q.peek() - timestamp >= TIME_LIMIT) {
                q.poll();
            }
            if (q.size() < 500) {
                q.add(timestamp);
                return true;
            }
            return false;
        }
    }

    public Map<String, HitCounter> clientTimeStampMap = new HashMap<>();

    public boolean isAllow(String clientId) {
        long currTime = System.currentTimeMillis();
        if (!clientTimeStampMap.containsKey(clientId)) {
            HitCounter counter = new HitCounter();
            counter.hit(currTime);
            return true;
        } else {
            HitCounter counter = clientTimeStampMap.get(clientId);
            return counter.hit(currTime);
        }
    }
}
