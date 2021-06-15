package company.lnkin.mj;

import java.util.Arrays;

/**
 * Merge K Sorted Arrays
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=764189&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class MergeKSortedArrays {

    public int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[]{};
        }
        return divide_conquer(arrays);
    }

    private int[] divide_conquer(int[][] arrays) {
        while (arrays.length > 1) {
            int len = arrays.length;
            int n = len / 2;
            if (len % 2 == 1) n++;

            int[][] temp = new int[n][];
            int idx = 0;
            for (int i = 0; i < len && i + 1 < len; i += 2) {
                temp[idx++] = mergeTwoSortedArray(arrays[i], arrays[i + 1]);
            }
            if (len % 2 == 1) {
                temp[idx++] = arrays[len - 1];
            }
            arrays = temp;
        }
        return arrays[0];
    }

    public int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length == 0) return arr2;
        if(arr2 == null || arr2.length == 0) return arr1;

        int totalLen = arr1.length + arr2.length;
        int[] res = new int[totalLen];
        int idx = 0;
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                res[idx++] = arr1[i++];
            } else {
                res[idx++] = arr2[j++];
            }
        }

        while(i < arr1.length){
            res[idx++] = arr1[i++];
        }

        while(j < arr2.length){
            res[idx++] = arr2[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        MergeKSortedArrays obj = new MergeKSortedArrays();
        System.out.println(Arrays.toString(obj.mergeKSortedArrays(new int[][]{
                {1, 3, 5, 7},
                {2, 4, 6},
                {0, 8, 9, 10, 11}
        })));
        System.out.println(Arrays.toString(obj.mergeKSortedArrays(new int[][]{
                {1, 2, 3},
                {1, 2}
        })));
    }

}
