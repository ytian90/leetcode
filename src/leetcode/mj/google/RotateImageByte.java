package leetcode.mj.google;

import java.util.Arrays;

/**
 * mage以byte[][]储存 如果想中心镜像翻转怎么弄
 * https://www.1point3acres.com/bbs/thread-409626-1-1.html
 * 思路：跟reverse words一个思路，先翻转每行的byte，再翻转自身（字节翻转可用位运算能快
 */
public class RotateImageByte {
    private static final int INT_SIZE = 8;

    public static void rotate(byte[][] image) {
        for (byte[] row : image) {
            for (int i = 0; i < row.length / 2; i++) {
                swap(row, i, row.length - 1 - i);
            }
        }
        for (byte[] row : image) {
            for (int i = 0; i < row.length; i++) {
                row[i] = reverse(row[i]);
            }
        }
    }

    private static void swap(byte[] b, int i, int j) {
        byte t = b[i];
        b[i] = b[j];
        b[j] = t;
    }

    private static byte reverse(byte x) {
        byte y = 0;
        for (int pos = INT_SIZE - 1; pos >= 0; pos--) {
            y += ((x & 1) << pos);
            x >>= 1;
        }
        return y;
    }

    public static void main(String[] args) {
        byte[][] t = {{80, 6}};
        rotate(t);
        for (byte[] a : t) {
            System.out.println(Arrays.toString(a));
        }
    }
}
