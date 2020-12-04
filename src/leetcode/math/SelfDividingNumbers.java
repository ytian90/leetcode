package leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. Self Dividing Numbers
 */
public class SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if ((j % 10) == 0 || i % (j % 10) != 0) break;
            }
            if (j == 0) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }
}
