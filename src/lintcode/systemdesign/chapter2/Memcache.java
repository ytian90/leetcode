package lintcode.systemdesign.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * 538. 内存缓存
 */
public class Memcache {
    class Resource {
        int value;
        int expireTime;
        public Resource(int value, int expireTime) {
            this.value = value;
            this.expireTime = expireTime;
        }
    }

    Map<Integer, Resource> map;

    public Memcache() {
        // do intialization if necessary
        map = new HashMap<>();
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {
        // write your code here
        if (!map.containsKey(curtTime)) {
            return Integer.MAX_VALUE;
        }
        Resource resource = map.get(curtTime);
        if (curtTime <= resource.expireTime || resource.expireTime == -1) {
            return resource.value;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {
        // write your code here
        int expireTime = (ttl == 0) ? -1 : curtTime + ttl - 1;
        map.put(key, new Resource(value, expireTime));
        System.out.println(map.get(key).value);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return;
        }
        map.remove(key);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {
        // write your code here
        if (get(curtTime, key) == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        map.get(key).value += delta;
        return map.get(key).value;
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {
        // write your code here
        if (get(curtTime, key) == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        map.get(key).value -= delta;
        return map.get(key).value;
    }

    public static void main(String[] args) {
        Memcache memcache = new Memcache();
        System.out.println(memcache.get(1, 0));
        memcache.set(2, 1, 1, 2);
        System.out.println(memcache.get(3, 1));
        System.out.println(memcache.get(1, 0));
        memcache.set(2, 1, 1, 2);
        System.out.println(memcache.get(3, 1));
        System.out.println(memcache.get(4, 1));
        System.out.println(memcache.incr(5, 1, 1));
        memcache.set(6, 1, 3, 0);
        System.out.println(memcache.incr(7, 1, 1));
        System.out.println(memcache.decr(8, 1, 1));
        System.out.println(memcache.get(9, 1));
        memcache.delete(10, 1);
        System.out.println(memcache.get(11, 1));
        System.out.println(memcache.incr(12, 1, 1));
    }
}
