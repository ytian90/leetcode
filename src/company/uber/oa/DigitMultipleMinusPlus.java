package company.uber.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作数字，把数字的每一位相乘减去数字的每一位相加
 */
public class DigitMultipleMinusPlus {

    public static int calculate(int num) {
        if (num < 10) return num;
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        long times = list.get(0);
        long plus = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            times *= list.get(i);
            plus += list.get(i);
        }
        return (int)(times - plus);
    }

    public static void main(String[] args) {
        System.out.println(calculate(5));
        System.out.println(calculate(123));
        System.out.println(calculate(123456));
        System.out.println(calculate(Integer.MAX_VALUE - 10));
    }
}
