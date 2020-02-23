package hashtable;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. Daily Temperatures
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            int j = i + 1;
            while (j < T.length && T[i] >= T[j]) {
                j++;
            }
            res[i] = j == T.length ? 0 : j - i;
        }
        return res;
    }

    // time O(N), space O(N)
    public static int[] dailyTemperatures1(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int index = stack[top--];
                res[index] = i - index;
            }
            stack[++top] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
