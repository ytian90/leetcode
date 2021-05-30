package company.uber.oa;

import java.util.Arrays;

/**
 * 改价格
 * update and add给int[] a, int[] b, in[][] operations
 * 两种operation:
 * 1) [0, i, x]: update b += x
 * 2) [1, x]: 找出a + b[j] = x的pair数量
 * 返回int[] res, pair的数量
 *
 * 举例: a = [2,3], b = [1,2], operations = [[1,3], [0,1,1],[1,5]], res = [1, 0]
 * operation [1,3]: a = [2,3], b = [1,2], a + b[j] = 3的pair只有a[0]=2,b[0]=1, return 1
 * operation [0,1,1]: a = [2,3], b = [1,3] (b[1] +=1)
 * operation [1,5]: a = [2,3], b = [1,3], a + b[j] = 5的pair不存在, return 0
 */
public class UpdateAndAdd {
    static int[] a;
    static int[] b;

    public static void updateAdd(int[] aa, int[] bb, int[][] operations) {
        a = aa;
        b = bb;
        for (int[] op : operations) {
            if (op[0] == 0) {
                System.out.println(Arrays.toString(update(op)));
            } else if (op[0] == 1) {
                System.out.println(findPairs(op));
            }
        }
    }

    private static int[] update(int[] op) {
        b[op[1]] += op[2];
        return b;
    }

    private static int findPairs(int[] op) {
        int target = op[1];
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] + b[i] == target) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        updateAdd(new int[]{2, 3}, new int[]{1, 2}, new int[][]{{1, 3}, {0, 1, 1}, {1, 5}});
    }

}
