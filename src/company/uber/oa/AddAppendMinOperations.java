package company.uber.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * 也是地里出现过好几次的题，input: nums {1,3,5,7,2}, ops = {{2},{0,1},{1,2},{2}}。因为只有操作2有输出值，所有output就是2的结果数列
 *
 * {0, x}：操作0，将数组中的每个元素加上x
 * {1, x}：操作1，append x to 数组
 * {2}: 操作2, 返回当前数组中的最小值
 */
public class AddAppendMinOperations {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static void op1(int x) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + x);
        }
    }

    public static void op2(int x) {
        list.add(x);
    }

    public static int op3() {
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            min = Math.min(min, i);
        }
        return min;
    }

}
