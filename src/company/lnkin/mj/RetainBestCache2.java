package company.lnkin.mj;

import java.util.*;

public class RetainBestCache2<K, T extends Rankable> {
    private Map<K, T> cache;
    private TreeMap<Long, Set<K>> rankingOfObjects;
    private DataSource<K, T> dataSource;
    private int entriesToRetain;

    public RetainBestCache2(DataSource<K, T> ds, int entriesToRetain) {
        cache = new HashMap<>();
        rankingOfObjects = new TreeMap<>();
        dataSource = ds;
        entriesToRetain = entriesToRetain;
    }

    public T get(K key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (cache.size() == entriesToRetain) {
            evict();
        }
        T data = dataSource.get(key);
        cache.put(key, data);
        long rank = data.getRank();
        if (!rankingOfObjects.containsKey(rank)) {
            rankingOfObjects.put(rank, new HashSet<>());
        }
        rankingOfObjects.get(rank).add(key);
        return data;
    }

    private void evict() {
        Map.Entry<Long, Set<K>> entry = rankingOfObjects.pollFirstEntry();
        K key = entry.getValue().iterator().next();
        entry.getValue().remove(key);
        cache.remove(key);
        if (entry.getValue().isEmpty()) {
            rankingOfObjects.remove(entry.getKey());
        }
    }
}
