package mj.houzz;

import java.util.Arrays;

public class QuickSort {

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            sort(nums, low, pi - 1);
            sort(nums, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] t = new int[]{10, 7, 8, 9, 1, 5};
        sort(t, 0, t.length - 1);
        System.out.println(Arrays.toString(t));
    }
}
