package company.uber;

/**
 * LC 1052. Grumpy Bookstore Owner
 *
 * Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.
 *
 * On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
 *
 * The bookstore owner knows a secret technique to keep themselves not grumpy for minutes minutes straight, but can only use it once.
 *
 * Return the maximum number of customers that can be satisfied throughout the day.
 *
 * Example 1:
 *
 * Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * Output: 16
 * Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
 * The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
public class GrumpyBookstoreOwner {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0, makeSatisfied = 0;
        for (int i = 0, localMakeSatisfied = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            } else {
                localMakeSatisfied += customers[i];
            }
            if (i >= minutes) {
                localMakeSatisfied -= customers[i - minutes] * grumpy[i - minutes];
            }
            makeSatisfied = Math.max(localMakeSatisfied, makeSatisfied);
        }
        return satisfied + makeSatisfied;
    }

    public static int maxSatisfied_myself(int[] customers, int[] grumpy, int minutes) {
        int res = 0, maxCalmDown = 0, maxCalmDownPos = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                int currMax = 0;
                for (int j = i; j < i + minutes && j < n; j++) {
                    if (grumpy[j] == 1) {
                        currMax += customers[j];
                    }
                }
                if (currMax > maxCalmDown) {
                    maxCalmDown = currMax;
                    maxCalmDownPos = i;
                }
            }
        }
        for (int i = 0; i < maxCalmDownPos; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }
        int endPos = Math.min(maxCalmDownPos + minutes, n);
        for (int i = maxCalmDownPos; i < endPos; i++) {
            res += customers[i];
        }
        for (int i = endPos; i < n; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5},
                new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println(maxSatisfied(new int[]{1}, new int[]{0}, 1));
    }
}
