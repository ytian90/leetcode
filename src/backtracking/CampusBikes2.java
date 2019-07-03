package backtracking;

/**
 * 1066. Campus Bikes 2
 */
public class CampusBikes2 {
    static int min = Integer.MAX_VALUE;

    public static int assignBikes(int[][] workers, int[][] bikes) {
        helper(0, 0, workers, bikes, new boolean[bikes.length]);
        return min;
    }

    public static void helper(int pos, int distance, int[][] workers, int[][] bikes, boolean[] visited) {
        if (pos == workers.length) {
            min = Math.min(min, distance);
            return;
        }
        if (distance > min) {
            return;
        }
        for (int i = 0; i < bikes.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            helper(pos + 1, distance + distance(workers[pos], bikes[i]), workers, bikes, visited);
            visited[i] = false;
        }
    }

    public static int distance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    public static void main(String[] args) {
//        System.out.println(assignBikes(new int[][]{
//                {0, 0},
//                {1, 1},
//                {2, 0}
//        }, new int[][]{
//                {1, 0},
//                {2, 2},
//                {2, 1}
//        }));

        System.out.println(assignBikes(new int[][]{
                {0, 0},
                {2, 1}
        }, new int[][]{
                {1, 2},
                {3, 3}
        }));
    }
}
