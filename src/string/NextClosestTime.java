package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 681. Next Closest Time
 */
public class NextClosestTime {

    public String nextClosestTime(String time) {
        String[] val = time.split(":");
        Set<Integer> set = new HashSet<>();
        int hour = add(set, val[0]);
        int min = add(set, val[1]);
        int[] times = new int[] {hour, min};
        next(times);
        while (!contains(times[0], times[1], set)) {
            next(times);
        }
        return validStr(times[0]) + ":" + validStr(times[1]);
    }

    public void next(int[] times) {
        int hour = times[0];
        int min = times[1];
        min++;
        if (min == 60) {
            hour++;
            min = 0;
            if (hour == 24) {
                hour = 0;
            }
        }
        times[0] = hour;
        times[1] = min;
    }

    public int add(Set<Integer> set, String timeStr) {
        int time = Integer.parseInt(timeStr);
        set.add(time / 10);
        set.add(time % 10);
        return time;
    }

    public String validStr(int time) {
        if (time >= 0 && time <= 9) return "0" + time;
        else return time + "";
    }

    public boolean contains(int hour, int min, Set<Integer> set) {
        return set.contains(hour / 10) && set.contains(hour % 10) && set.contains(min / 10) && set.contains(min % 10);
    }

    public static void main(String[] args) {
        NextClosestTime obj = new NextClosestTime();
        System.out.println(obj.nextClosestTime("19:34"));
        System.out.println(obj.nextClosestTime("23:59"));
    }
}
