package mj.twilio;

import java.util.*;

/**
 * https://www.1point3acres.com/bbs/thread-560264-1-1.html
 * https://github.com/jayshah19949596/CodingInterviews/tree/master/Twilio%20Software%20Engineer%20-%20New%20Grad-Part-2
 */
public class MissingWords {
    public static List<String> missingWords(String s, String t) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return res;
        }
        String[] s1 = s.split(" ");
        Set<String> set = new HashSet<>(Arrays.asList(t.split(" ")));
        for (String str : s1) {
            if (str.equals("")) {
                continue;
            }
            if (!set.contains(str)) {
                res.add(str);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(missingWords("I am using    HackerRank to improve programming", "am HackerRank to improve"));
    }
}
