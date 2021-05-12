package leetcode.segment_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits {
    public static String minInteger(String num, int k) {
        List<Queue<Integer>> pqs = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            pqs.add(new LinkedList<>());
        }
        for (int i = 0; i < num.length(); i++) {
            pqs.get(num.charAt(i) - '0').add(i);
        }
        String res = "";
        SegmentTree seg = new SegmentTree(num.length());
        for (int i = 0; i < num.length(); i++) {
            for (int digit = 0; digit <= 9; digit++) {
                if (pqs.get(digit).size() != 0) {
                    Integer pos = pqs.get(digit).peek();
                    int shift = seg.getCountLessThan(pos);
                    if (pos - shift <= k) {
                        k -= pos - shift;
                        seg.add(pos);
                        pqs.get(digit).remove();
                        res += digit;
                        break;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(minInteger("9438957234785635408", 23));
    }

    static class SegmentTree {
        int[] nodes;
        int n;

        public SegmentTree(int max) {
            nodes = new int[4 * max];
            n = max;
        }

        public void add(int num) {
            addUtil(num, 0, n, 0);
        }

        private void addUtil(int num, int l, int r, int node) {
            if (num < l || num > r) {
                return;
            }
            if (l == r) {
                nodes[node]++;
                return;
            }
            int mid = l + (r - l) / 2;
            addUtil(num, l, mid, 2 * node + 1);
            addUtil(num, mid + 1, r, 2 * node + 2);
            nodes[node] = nodes[2 * node + 1] + nodes[2 * node + 2];
        }

        public int getCountLessThan(int num) {
            return getUtil(0, num, 0, n, 0);
        }

        private int getUtil(int ql, int qr, int l, int r, int node) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && qr >= r) {
                return nodes[node];
            }
            int mid = l + (r - l) / 2;
            return getUtil(ql, qr, l, mid, 2 * node + 1) + getUtil(ql, qr, mid + 1, r, 2 * node + 2);
        }
    }
}
