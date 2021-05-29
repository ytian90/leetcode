package leetcode.uber;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 1640. Check Array Formation Through Concatenation
 */
public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int i = 0;
        while (i < arr.length) {
            int[] piece = map.get(arr[i]);
            if (piece == null) {
                return false;
            }
            for (int j : piece) {
                if (arr[i] != j) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

}
