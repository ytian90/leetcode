package leetcode.mj.houzz;

import java.util.Arrays;

/**
 * 给一个字符串 举例 2012 02 09 222 让你求2012年几月几号过222天之后是什么日子 类似的
 *
 */
public class CalculateDate {

    private static int[] monthTable = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? true : false;
    }

    private static int calcOffset(int year, int month, int day) {
        int offSet = day;
        int m = month;
        while (m > 0) {
            offSet += monthTable[m--];
        }
        return (isLeap(year) && month > 2) ? ++offSet : offSet;
    }

    private static int[] findDay(int offSet, int year) {
        int[] res = new int[3];
        for (int i = 1; i <= 12; i++) {
            int days = monthTable[i];
            if (i == 2 && isLeap(year)) days++;
            if (offSet - days > 0) {
                offSet -= days;
            } else {
                res[0] = i - 1;
                res[1] = offSet;
                break;
            }
        }
        res[2] = year;
        return res;
    }

    public static int[] addDay(int year, int month, int day, int diff) {
        int offSet = calcOffset(year, month, day);
        int remainDay = isLeap(year) ? 366 - offSet : 365 - offSet;
        int y = year, offSetFuture = offSet + diff;
        if (diff >= remainDay) {
            diff -= remainDay;
            y++;
            int yDays = isLeap(y) ? 366 : 365;
            while (diff >= yDays) {
                diff -= yDays;
                y++;
                yDays = isLeap(y) ? 366 : 365;
            }
            offSetFuture = diff;
        }
        return findDay(offSetFuture, y);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(addDay(2019, 5, 1, 3)));
        System.out.println(Arrays.toString(addDay(2019, 5, 1, 365)));
    }
}
