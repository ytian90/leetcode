package mj.google;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=3Q_oYDQ2whs
 */
public class MergeCalendar {

    /**
     Sample Input:
     [['9:00', '10:30'], ['12:00', '13:00'], ['16:00', '17:00']]
     ['9:00', '20:00']
     [['10:00', '11:30'], ['12:30', '14:30'], ['14:30', '15:00'], ['16:00', '17:00']]
     ['10:00', '18:30']
     30
     Sample output: [['11:30', '12:00'], ['15:00', '16:00'], ['17:00', '18:30']]
     */

    public static void main(String[] args) {
        Assert.check(getStringFromInt(getIntFromString("9:30")).equalsIgnoreCase("9:30"));

        List<List<String>> input1 = Arrays.asList(Arrays.asList("9:00", "10:30"),
                Arrays.asList("12:00", "13:00"), Arrays.asList("16:00", "17:00"));
        List<String> input1_r = Arrays.asList("9:00", "20:00");
        List<List<String>> input2 = Arrays.asList(Arrays.asList("10:00", "11:30"),
                Arrays.asList("12:30", "14:30"), Arrays.asList("14:30", "15:00"), Arrays.asList("16:00", "17:00"));
        List<String> input2_r = Arrays.asList("10:00", "18:30");
        List<Interval> calendar1 = generateIntervalList(input1);
        List<Interval> calendar2 = generateIntervalList(input2);
        List<Interval> res = find(calendar1, generateInterval(input1_r), calendar2, generateInterval(input2_r), 30);
        System.out.println(generateStringList(res));
    }

    public static List<Interval> generateIntervalList(List<List<String>> input) {
        List<Interval> res = new ArrayList<>();
        for (List<String> val : input) {
            res.add(generateInterval(val));
        }
        return res;
    }

    public static List<List<String>> generateStringList(List<Interval> intervals) {
        List<List<String>> res = new ArrayList<>();
        for (Interval interval : intervals) {
            res.add(Arrays.asList(getStringFromInt(interval.start), getStringFromInt(interval.end)));
        }
        return res;
    }

    public static Interval generateInterval(List<String> input) {
        return new Interval(getIntFromString(input.get(0)), getIntFromString(input.get(1)));
    }

    public static int getIntFromString(String str) {
        String[] strs = str.split(":");
        return 60 * Integer.valueOf(strs[0]) + Integer.valueOf(strs[1]);
    }

    public static String getStringFromInt(Integer time) {
        return (time / 60) + ":" + (time % 60);
    }

    public static List<Interval> find(List<Interval> calendar1, Interval range1,
                               List<Interval> calendar2, Interval range2, int period) {
        return mergeInterval(findFreeSlot(calendar1, range1), findFreeSlot(calendar2, range2), period);
    }

    private static List<Interval> mergeInterval(List<Interval> calendar1, List<Interval> calendar2, int period) {
        if (calendar1 == null || calendar2 == null) {
            return null;
        }
        List<Interval> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < calendar1.size() && j < calendar1.size()) {
            Interval c1 = calendar1.get(i);
            Interval c2 = calendar2.get(j);
            if (c1.end < c2.start) { // no overlap
                i++;
                continue;
            }
            if (c2.end < c1.start) { // no overlap
                j++;
                continue;
            }
            int new_start = Math.max(c1.start, c2.start);
            int new_end = Math.min(c1.end, c2.end);
            if (new_end - new_start >= period) {
                res.add(new Interval(new_start, new_end));
            }
            if (c1.end < c2.end) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    private static List<Interval> findFreeSlot(List<Interval> calendar, Interval range) {
        if (calendar == null || calendar.size() == 0) {
            return null;
        }
        List<Interval> res = new ArrayList<>();
        Interval prev = calendar.get(0);
        if (range.start < prev.start) {
            res.add(new Interval(range.start, prev.start));
        }
        for (int i = 1; i < calendar.size(); i++) {
            Interval curr = calendar.get(i);
            if (prev.end < curr.start) {
                res.add(new Interval(prev.end, curr.start));
            }
            prev.start = curr.start;
            prev.end = curr.end;
        }
        if (calendar.get(calendar.size() - 1).end < range.end) {
            res.add(new Interval(calendar.get(calendar.size() - 1).end, range.end));
        }
        return res;
    }

    public static class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
