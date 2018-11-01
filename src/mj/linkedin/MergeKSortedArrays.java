package mj.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * time : O(nlogn)
 * merge k sorted arrays
 */
public class MergeKSortedArrays {

    public static List<Integer> mergeKSortedArrays(List<List<Integer>> input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.size() == 0)
            return res;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (List<Integer> list : input) {
            pq.addAll(list);
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>(Arrays.asList(1, 2)));
        t.add(new ArrayList<>(Arrays.asList(4, 5)));
        t.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(mergeKSortedArrays(t));
    }
}
