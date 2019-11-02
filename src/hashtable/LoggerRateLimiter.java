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
		map = new HashMap<>();
	}

	/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	 If this method returns false, the message will not be printed.
	 The timestamp is in seconds granularity. */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (!map.containsKey(message)) {
			map.put(message, timestamp);
			return true;
		}
		if (timestamp - map.get(message) < 10) {
			return false;
		} else {
			map.put(message, timestamp);
			return true;
		}
	}

	public static void main(String[] args) {
		LoggerRateLimiter logger = new LoggerRateLimiter();
		// logging string "foo" at timestamp 1
		System.out.println(logger.shouldPrintMessage(1, "foo")); // true
		// logging string "bar" at timestamp 2
		System.out.println(logger.shouldPrintMessage(2,"bar")); // true
		// logging string "foo" at timestamp 3
		System.out.println(logger.shouldPrintMessage(3,"foo")); // false
		// logging string "bar" at timestamp 8
		System.out.println(logger.shouldPrintMessage(8,"bar")); // false
		// logging string "foo" at timestamp 10
		System.out.println(logger.shouldPrintMessage(10,"foo")); // false
		// logging string "foo" at timestamp 11
		System.out.println(logger.shouldPrintMessage(11,"foo")); // true
	}

}
