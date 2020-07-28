package lintcode.systemdesign.chapter8;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class StandardBloomFilter {
    public BitSet bits;
    public int k;
    public List<Hash> hashFunc;

    /*
     * @param k: An integer
     */
    public StandardBloomFilter(int k) {
        this.k = k;
        hashFunc = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            hashFunc.add(new Hash(10000 + i, 2 * i + 3));
        }
        bits = new BitSet(10000 + k);
    }

    /*
     * @param word: A string
     * @return: nothing
     */
    public void add(String word) {
        for (int i = 0; i < k; i++) {
            int position = hashFunc.get(i).hash(word);
            bits.set(position);
        }
    }

    /*
     * @param word: A string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        for (int i = 0; i < k; i++) {
            int position = hashFunc.get(i).hash(word);
            if (!bits.get(position)) {
                return false;
            }
        }
        return true;
    }
}

class Hash {
    public int capacity, seed;

    public Hash(int capacity, int seed) {
        this.capacity = capacity;
        this.seed = seed;
    }

    public int hash(String value) {
        int res = 0;
        int n = value.length();
        for (int i = 0; i < n; i++) {
            res += seed * res + value.charAt(i);
            res %= capacity;
        }
        return res;
    }
}
