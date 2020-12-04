package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Based Key-Value Store
 */
public class TimeBasedKeyValueStore {
    class Node {
        String value;
        int timestamp;
        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Node>> map;

    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Node> curr = map.get(key);
        if (curr == null) {
            return "";
        }
        for (int i = curr.size() - 1; i >= 0; i--) {
            if (curr.get(i).timestamp <= timestamp) {
                return curr.get(i).value;
            }
        }
        return "";
    }
}
