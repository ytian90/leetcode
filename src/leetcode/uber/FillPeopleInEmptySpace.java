package leetcode.uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 3. 装货
 * source = [ . * .
 *            * . . ]
 * source 中 *代表obstacle， .代表空地
 * figure =  [* *
 *            * .]
 * figure 中 * 代表 people， .代表空地
 *
 * 现在允许移动source中k个obstacle， 问能不能在source中装下people， obstacle的地方不能放people。
 * 如果有多个地方能装下，请问最小的index[i, j]组合
 * 例如题中例子
 * k = 2, source 可以把两个* 往右边推
 * 这样figure就能在[0,0] 为top left的起始位置装下
 */
public class FillPeopleInEmptySpace {
    public static int cost(char[][] source, char[][] figure) {
        List<int[]> cargo = new ArrayList<>();
        List<int[]> space = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[0].length; j++) {
                if (source[i][j] == '*' && figure[i][j] == '*') {
                    cargo.add(new int[]{i, j});
                } else if (source[i][j] == '.' && figure[i][j] == '.') {
                    space.add(new int[]{i, j});
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : a[0] - b[0]));
        for (int i = 0; i < cargo.size(); i++) {
            for (int j = 0; j < space.size(); j++) {
                int distance = Math.abs(cargo.get(i)[0] - space.get(j)[0]) + Math.abs(cargo.get(i)[1] - space.get(j)[1]);
                pq.add(new int[]{distance, j, i});
            }
        }
        int[] res = new int[cargo.size()];
        boolean[] taken = new boolean[space.size()];
        Arrays.fill(res, -1);
        while (pq.size() > 0) {
            int[] curr = pq.poll();
            int distance = curr[0], spot = curr[1], item = curr[2];
            if (res[item] == -1 && !taken[spot]) {
                res[item] = distance;
                taken[spot] = true;
            }
        }
        int total = 0;
        for (int i : res) {
            total += i;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(cost(new char[][]{{'.', '*', '.'},
                                             {'*', '.', '.'}},
                                new char[][]{{'*', '*', '.'},
                                             {'*', '.', '.'}}));
    }

}
