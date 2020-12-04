package leetcode.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 432. All O`one Data Structure
 * @author yutian
 *
 */
public class AllOneDataStructure {
	
	// maintain a doubly linked list of Buckets
    private Bucket head;
    private Bucket tail;
    // for accessing a specific Bucket among the Bucket list in O(1) time
    private Map<Integer, Bucket> countBucketMap;
    // keep track of leetcode.sort of keys
    private Map<String, Integer> keyCountMap;

    // each Bucket contains all the keys with the same leetcode.sort
    private class Bucket {
        int count;
        Set<String> keySet;
        Bucket next;
        Bucket prev;
        public Bucket(int cnt) {
            count = cnt;
            keySet = new HashSet<>();
        }
    }

    /** Initialize your data structure here. */
    public AllOneDataStructure() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyCountMap.put(key, 1);
            if (head.next.count != 1) 
                addBucketAfter(new Bucket(1), head);
            head.next.keySet.add(key);
            countBucketMap.put(1, head.next);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {
            int count = keyCountMap.get(key);
            if (count == 1) {
                keyCountMap.remove(key);
                removeKeyFromBucket(countBucketMap.get(count), key);
            } else {
                changeKey(key, -1);
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.prev == head ? "" : (String) tail.prev.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.keySet.iterator().next();        
    }
    
    // leetcode.sort function to make change on given key according to offset
    private void changeKey(String key, int offset) {
        int count = keyCountMap.get(key);
        int value = count + offset;
        keyCountMap.put(key, value);
        Bucket curBucket = countBucketMap.get(count);
        Bucket newBucket;
        if (countBucketMap.containsKey(value)) {
            // target Bucket already exists
            newBucket = countBucketMap.get(value);
        } else {
            // add new Bucket
            newBucket = new Bucket(value);
            countBucketMap.put(value, newBucket);
            addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.prev);
        }
        newBucket.keySet.add(key);
        removeKeyFromBucket(curBucket, key);
    }
    
    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keySet.remove(key);
        if (bucket.keySet.size() == 0) {
            removeBucketFromList(bucket);
            countBucketMap.remove(bucket.count);
        }
    }
    
    private void removeBucketFromList(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        bucket.next = null;
        bucket.prev = null;
    }
    
    // add newBucket after preBucket
    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.prev = preBucket;
        newBucket.next = preBucket.next;
        preBucket.next.prev = newBucket;
        preBucket.next = newBucket;
    }

}
