package mj.airbnb;

import java.util.*;

/**
 * 4. Display pages
 */
public class DisplayPages {

    public static List<String> displayPages(List<String> input, int pageSize) {
        List<String> res = new ArrayList<>();
        if (input == null || input.size() == 0) {
            return res;
        }
        List<String> visited = new ArrayList<>();
        Iterator<String> iter = input.iterator();
        boolean reachEnd = false;
        while (iter.hasNext()) {
            String curr = iter.next();
            String hostId = curr.split(",")[0];
            if (!visited.contains(hostId) || reachEnd) {
                res.add(curr);
                visited.add(hostId);
                iter.remove();
            }
            if (visited.size() == pageSize) {
                visited.clear();
                reachEnd = false;
                if (!input.isEmpty()) {
                    res.add(" ");
                }
                iter = input.iterator();
            }
            if (!iter.hasNext()) {
                iter = input.iterator();
                reachEnd = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(displayPages(new LinkedList<String>(Arrays.asList(
                "1,28,310.6,SF",
                "4,5,204.1,SF",
                "20,7,203.2,Oakland",
                "6,8,202.2,SF",
                "6,10,199.1,SF",
                "1,16,190.4,SF",
                "6,29,185.2,SF",
                "7,20,180.1,SF",
                "6,21,162.1,SF",
                "2,18,161.2,SF",
                "2,30,149.1,SF",
                "3,76,146.2,SF",
                "2,14,141.1,San Jose"
        )), 5));
    }
}
