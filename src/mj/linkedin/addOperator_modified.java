package mj.linkedin;

import java.util.ArrayList;
import java.util.List;

/**
 Question:
 like 282, expression add operations, but we add an extra operations "/" here

 // T(N) = 3 * (T(N - 1) + T(N -2) + .... + T(1))
 // T(N - 1) = 3 * (T(N - 2) + T(N - 3) + .... + T(1))
 // T(N) = (4 * T(N -1))
 // T(N) = 4 ^ (N -1)
 // time complexity: O(4 ^ n)
 */
public class addOperator_modified {

    public static List<String> addOperators(String num, int target) {
        List<String> list = new ArrayList<>();
        if (num.length() == 0) return list;
        add(num, (long) target, list, "", 0, 0L, 0L);
        return list;
    }

    private static void add(String num, long target, List<String> list, String expr, int pos, long prev, long multi) {
        if (num.length() == pos && target == prev) {
            list.add(expr);
        } else {
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') return;
                long curr = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0) {
                    add(num, target, list, expr + curr, i + 1, curr, curr);
                } else {
                    add(num, target, list, expr + "+" + curr, i + 1, curr + prev, curr);
                    add(num, target, list, expr + "-" + curr, i + 1, prev - curr, -curr);
                    add(num, target, list, expr + "*" + curr, i + 1, prev - multi + multi * curr, multi * curr);
                    // need to check if curr is 0, as 0 is undividable
                    if (curr != 0) {
                        add(num, target, list, expr + "/" + curr, i + 1, prev - multi + multi / curr, multi / curr);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(addOperators("122", 6));
        System.out.println(addOperators("120", 6));
//        System.out.println(addOperators("123", 6));
//		System.out.println(addOperators("232", 8));
//		System.out.println(addOperators("105", 5));
//		System.out.println(addOperators("00", 0));
//		System.out.println(addOperators("3456237490", 9191));
    }
}
