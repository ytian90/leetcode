package array;

/**
 * 849. Maximize Distance to Closest Person
 */
public class MaximizeDistanceToClosestPerson {
    public static int maxDistToClosest(int[] seats) {
        int curr = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                curr = 2;
            } else if (seats[i] == 0 && curr != -1) {
                seats[i] = curr;
                curr++;
            }
        }
        curr = -1;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                curr = 2;
            } else if (seats[i] == 0 && curr != -1) {
                seats[i] = curr;
                curr++;
            } else if (seats[i] != 1 && curr != -1) {
                seats[i] = Math.min(seats[i], curr);
                curr++;
            }
        }
        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] > seats[max]) {
                max = i;
            }
        }
        return seats[max] - 1;
    }

    public static int maxDistToClosestt(int[] seats) {
        int i, j, res = 0, n = seats.length;
        for (i = j = 0; j < n; j++) {
            if (seats[j] == 1) {
                if (i == 0) res = Math.max(res, j - i);
                else res = Math.max(res, (j - i + 1) / 2);
                i = j + 1;
            }
        }
        res = Math.max(res, n - i);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
        System.out.println(maxDistToClosest(new int[]{1, 1, 0, 1, 1}));
        System.out.println(maxDistToClosest(new int[]{0, 1}));
    }
}
