package array;

/**
 * 849. Maximize Distance to Closest Person
 */
public class MaximizeDistanceToClosestPerson {
    public static int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }
        int prev = 0;
        while (seats[prev] == 1) {
            prev++;
        }
        int currLen = 1;
        for (int i = prev; i < seats.length; i++) {
            if (seats[i] == 0) {
                if (i == seats.length - 1 && (i - prev + 1 > currLen)) {
                    currLen = i - prev + 1;
                }
                continue;
            } else {
                if (prev == 0) {
                    currLen = i;
                } else if ((i - 1 - prev) / 2 + 1 > currLen) {
                    currLen = (i - 1 - prev) / 2 + 1;
                }
                prev = i;
                while (prev < seats.length && seats[prev] == 1) {
                    prev++;
                }
                i = prev;
            }
        }
        return currLen;
    }

    public int maxDistToClosest_BestSolution(int[] seats) {
        int res = 0, n = seats.length, last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, n - last - 1);
        return res;
    }

    public static int maxDistToClosest1(int[] seats) {
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
