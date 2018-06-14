package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 760. Find Anagram Mappings
 */
public class FindAnagramMappings {

    public static int[] anagramMappings(int[] A, int[] B) {
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int z = find(B, A[i]);
            res[i] = z;
        }
        return res;
    }

    public static int find(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static int[] anagramMapping(int[] A, int[] B) {
        int[] res = new int[A.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) {
                map.put(B[i], i);
            }
        }
        for (Integer i : A) {
            if (map.containsKey(i)) {
                res[index++] = map.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28})));

    }
}
