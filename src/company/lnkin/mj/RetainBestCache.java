package company.lnkin.mj;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RetainBestCache<K, T extends Rankable> {
    int entriesToRetain;
    Map<K, T> map = new HashMap<>();
    PriorityQueue<Wrapper<K, T>> pq;
    DataSource<K, T> ds;

    public RetainBestCache(DataSource<K, T> ds, int entriesToRetain) {
        this.pq = new PriorityQueue<>((a, b) -> Double.compare(a.data.getRank(), b.data.getRank()));
        this.ds = ds;
        this.entriesToRetain = entriesToRetain;
    }

    public T get(K key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (map.size() == entriesToRetain) {
            evict();
        }
        T data = ds.get(key);
        map.put(key, data);
        pq.offer(new Wrapper(key, data));
        return data;
    }

    private void evict() {
        Wrapper leastRank = pq.poll();
        map.remove(leastRank.key);
    }
}

class Wrapper<K, T> {
    K key;
    T data;

    public Wrapper(K key, T data) {
        this.key = key;
        this.data = data;
    }
}

interface DataSource<K, T extends Rankable> {
    T get(K key);
}

interface Rankable {
    long getRank();
}
