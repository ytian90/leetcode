package company.lnkin.mj;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.1point3acres.com/bbs/thread-774139-1-1.html
 * Given a list of strings denoting function name, START or END marker, and timestamp. Calls can be nested and one function can call child functions.
 * For example:
 *
 * "abc,START,100"
 * "def,START,150",
 * "def,END,180",
 * "abc,END,200"
 * Inclusive time is defined as all the time spent on a particular function, including time spent on its child calls.
 * Exclusive time is defined as the time spent on a particular function only, excluding time spent on its child calls.
 * In the above example, inclusive time for function "abc" is 200-100=100, while exclusive time for function "abc" is (200-100) - (180-150) = 70
 *
 * Given such list of strings, figure out the inclusive and exclusive time for any given function call.
 *
 * Note that the calls can span multiple levels and nested.
 * Sample Input:
 * "abc,START,100",
 *  "def,START,150",
 *  "bla",START,160,
 *  "hij,START,170",
 *  "hij,END,200",
 *  "bla",END, 200
 *  "def,END,220",
 * "job4,START,230",
 * "job4,END,250",
 * "abc,END,300"
 */
public class ExclusiveTimeOfFunctions {
    public static int[] parseJobTime(List<String> input, String jobName) {
        int start_time = -1;
        String child_name = "";
        int child_start = -1;
        int total_child_time = 0;
        int[] res = new int[2];
        for (String curr : input) {
            Log log = new Log(curr);
            if (jobName.equals(log.jobName)) {
                if (log.isStart) {
                    start_time = log.time;
                } else {
                    res[0] = log.time - start_time;
                    res[1] = res[0] - total_child_time;
                    return res;
                }
            } else {
                if (start_time != -1) { // this job is inside our interest job
                    if (child_name.equals("")) { // this job is a immediate children of our job
                        child_name = log.jobName;
                        child_start = log.time;
                    } else if (child_name.equals(log.jobName)) {
                        total_child_time += log.time - child_start;
                        child_name = "";
                        child_start = -1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(parseJobTime(Arrays.asList(
                "abc,START,100",
                "def,START,150",
                "bla,START,160",
                "hij,START,170",
                "hij,END,200",
                "bla,END,200",
                "def,END,220",
                "job4,START,230",
                "job4,END,250",
                "abc,END,300"
        ), "abc")));
    }

    static class Log {
        String jobName;
        boolean isStart;
        int time;
        public Log(String content) {
            String[] strs = content.split(",");
            this.jobName = strs[0];
            this.isStart = "START".equalsIgnoreCase(strs[1]);
            this.time = Integer.valueOf(strs[2]);
        }
    }
}
