package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. Subdomain Visit Count
 */
public class SubdomainVisitCount {

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cp : cpdomains) {
            int i = cp.indexOf(' ');
            int n = Integer.valueOf(cp.substring(0, i));
            String s = cp.substring(i + 1);
            map.put(s, map.getOrDefault(s, 0) + n);
            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    String d = s.substring(i + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            res.add(map.get(s) + " " + s);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{
                "9001 discuss.leetcode.com"
        }));
        System.out.println(subdomainVisits(new String[]{
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
        }));
    }
}
