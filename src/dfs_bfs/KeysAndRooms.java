package dfs_bfs;

import java.util.*;

/**
 * 841. Keys and Rooms
 */
public class KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> dfs = new LinkedList<>();
        dfs.add(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.poll();
            for (int j : rooms.get(i)) {
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size())
                        return true;
                }
            }
        }
        return rooms.size() == seen.size();
    }

    public static boolean canVisitAllRoome(List<List<Integer>> rooms) {
        Deque<Integer> dfs = new LinkedList<>();
        dfs.add(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i)) {
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size())
                        return true;
                }
            }
        }
        return rooms.size() == seen.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>(Arrays.asList(1)));
        t.add(new ArrayList<>(Arrays.asList(2)));
        t.add(new ArrayList<>(Arrays.asList(3)));
        t.add(new ArrayList<>(Arrays.asList()));
        System.out.println(canVisitAllRoome(t));

        t.clear();
        t.add(new ArrayList<>(Arrays.asList(1, 3)));
        t.add(new ArrayList<>(Arrays.asList(3, 0, 1)));
        t.add(new ArrayList<>(Arrays.asList(2)));
        t.add(new ArrayList<>(Arrays.asList(0)));
        System.out.println(canVisitAllRoome(t));
    }
}
