package lintcode.systemdesign.chapter8;

import java.util.ArrayList;
import java.util.List;

/**
 * 555. Counting Bloom Filter
 */
public class CountingBloomFilter {
    public int[] bits;
    public int k;
    public List<Hash> hashFunc;

    /*
     * @param k: An integer
     */
    public CountingBloomFilter(int k) {
        this.k = k;
        hashFunc = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            hashFunc.add(new Hash(100000 + i, 2 * i + 3));
        }
        bits = new int[100000 + k];
    }

    /*
     * @param word: A leetcode.string
     * @return: nothing
     */
    public void add(String word) {
        for (int i = 0; i < k; i++) {
            int position = hashFunc.get(i).hash(word);
            bits[position]++;
        }
    }

    /*
     * @param word: A leetcode.string
     * @return: nothing
     */
    public void remove(String word) {
        for (int i = 0; i < k; i++) {
            int position = hashFunc.get(i).hash(word);
            bits[position]--;
        }
    }

    /*
     * @param word: A leetcode.string
     * @return: True if contains word
     */
    public boolean contains(String word) {
        for (int i = 0; i < k; i++) {
            int position = hashFunc.get(i).hash(word);
            if (bits[position] <= 0) {
                return false;
            }
        }
        return true;
    }
}