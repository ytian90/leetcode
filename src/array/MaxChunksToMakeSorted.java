package array;

/**
 * 769. Max Chunks To Make Sorted
 */
public class MaxChunksToMakeSorted {

    public static int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    }
}
