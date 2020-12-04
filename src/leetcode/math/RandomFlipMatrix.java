package leetcode.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 519. Random Flip Matrix
 */
public class RandomFlipMatrix {
    Random rand;
    int n_rows, n_cols, total;
    Map<Integer, Integer> map;

    public RandomFlipMatrix(int n_rows, int n_cols) {
        this.rand = new Random();
        this.n_rows = n_rows;
        this.n_cols = n_cols;
        this.total = n_rows * n_cols;
        this.map = new HashMap<>();
    }

    public int[] flip() {
        int pos = rand.nextInt(total--);
        // check if we have already add something in this index
        int x = map.getOrDefault(pos, pos);
        // swap - add total at index we generated
        map.put(pos, map.getOrDefault(total, total));
        return new int[]{x / n_cols, x % n_cols};
    }

    public void reset() {
        map.clear();
        total = n_cols * n_rows;
    }

    public static void main(String[] args) {

    }
}
