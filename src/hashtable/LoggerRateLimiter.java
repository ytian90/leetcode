package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 * @author yutian
 * @since Jul 16, 2016
 */
public class LoggerRateLimiter {
	
	private Map<String, Integer> map;
	
	/** Initialize your data structure here. */
    public LoggerRateLimiter() {
        this.map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp < map.getOrDefault(message, 0)) {
        	return false;
        }
        map.put(message, timestamp + 10);
        return true;
    }
	

	public static void main(String[] args) {
		LoggerRateLimiter logger = new LoggerRateLimiter();
		System.out.println(logger.shouldPrintMessage(1, "foo"));
		System.out.println(logger.shouldPrintMessage(2, "bar"));
		System.out.println(logger.shouldPrintMessage(3, "foo"));
		System.out.println(logger.shouldPrintMessage(8, "bar"));
		System.out.println(logger.shouldPrintMessage(10, "foo"));
		System.out.println(logger.shouldPrintMessage(11, "foo"));		
	}

}
