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
        int[] t = new int[]{hour, min};
        next(t);
        while (!validTime(t, set)) {
            next(t);
        }
        return validStr(t[0]) + ":" + validStr(t[1]);
    }

    public void next(int[] time) {
        int hour = time[0];
        int min = time[1];
        min++;
        if (min == 60) {
            hour++;
            min = 0;
            if (hour == 24) {
                hour = 0;
            }
        }
        time[0] = hour;
        time[1] = min;
    }

    public int add(Set<Integer> set, String s) {
        int time = Integer.valueOf(s);
        set.add(time / 10);
        set.add(time % 10);
        return time;
    }

    public String validStr(int time) {
        if (time >= 0 && time <= 9)
            return "0" + time;
        return time + "";
    }

    public boolean validTime(int[] time, Set<Integer> set) {
        return set.contains(time[0] / 10) && set.contains(time[0] % 10) && set.contains(time[1] / 10) && set.contains(time[1] % 10);
    }

    public static void main(String[] args) {
        NextClosestTime obj = new NextClosestTime();
        System.out.println(obj.nextClosestTime("19:34"));
        System.out.println(obj.nextClosestTime("23:59"));
    }
}
