package leetcode.uber;

import java.util.ArrayList;
import java.util.List;

public class FindNumPowTwo {
    public static List<Integer> findPowTwo(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            if (Integer.bitCount(i) == 1) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findPowTwo(new int[]{2, 3, 4, 5, 6, 7, 8, 20, 24, 32}));
    }


}
