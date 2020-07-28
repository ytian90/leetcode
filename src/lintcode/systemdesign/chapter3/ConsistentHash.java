package lintcode.systemdesign.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * 519. 一致性哈希
 */
public class ConsistentHash {
    public static List<List<Integer>> consistentHashing(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> machine = new ArrayList<>();
        machine.add(0);
        machine.add(359);
        machine.add(1);
        res.add(machine);
        for (int i = 1; i < n; i++) {
            List<Integer> nextMachine = new ArrayList<>();
            int index = 0;
            for (int j = 1; j < i; j++) {
                if (res.get(j).get(1) - res.get(j).get(0) > res.get(index).get(1) - res.get(index).get(0)) {
                    index = j;
                }
            }
            int x = res.get(index).get(0);
            int y = res.get(index).get(1);
            res.get(index).set(1, (x + y) / 2);
            nextMachine.add((x + y) / 2 + 1);
            nextMachine.add(y);
            nextMachine.add(i + 1);
            res.add(nextMachine);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(consistentHashing(1));
        System.out.println(consistentHashing(2));
        System.out.println(consistentHashing(3));
    }
}
