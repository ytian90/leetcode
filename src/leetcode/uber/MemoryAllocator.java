package leetcode.uber;

import java.util.HashMap;
import java.util.Map;

/**
 * memory allocator
 *
 * 给一个表示memory状态的数组，里面只有0和1，0表示free，1表示used
 * 有两个操作，
 * {0, x} ，0表示分配内存，x是长度，要在当前memory中找到第一个满足长度x的free memory，将这块memory设置为1，并返回该内存块的起始位置（free时要用到这个位置）
 * {1, index}：1表示释放内存，index就是之前alloc时记录下来的“起始位置”，并把该内存块设置为0
 * 比如初始memory状态的数组：{0, 0, 0, 1, 1, 0, 0, 0, 0}
 * 操作序列：{0, 2}, {0, 3}, {1,0}
 * {0,2}表示分配长度为2的内存
 * {0,3}表示分配长度为3的内存
 * {1,0}表示释放之前分配的"起始位置"为0的内存
 */
public class MemoryAllocator {
    private static Map<Integer, Integer> allocated = new HashMap<>();
    private static Map<Integer, Integer> free = new HashMap<>();

    public static void allocator(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (nums[i] == 0) {
                free.put(i, j - 1);
            } else {
                allocated.put(i, j - 1);
            }
            i = j - 1;
        }
    }

    public static int operator(int[] x) {
        if (x == null || x.length == 0) {
            return -1;
        }
        if (x[0] == 0) {
            return allocate(x[1]);
        } else if (x[0] == 1) {
            return release(x[1]);
        }
        throw new IllegalArgumentException();
    }

    public static int allocate(int x) {
        for (int key : free.keySet()) {
            if (free.get(key) - key + 1 >= x) {
                int start = key, end = free.get(key);
                free.remove(key);
                allocated.put(start, start + x - 1);
                if (start + x - 1 < end) {
                    free.put(start + x, end);
                }
                return start;
            }
        }
        return -1;
    }

    public static int release(int x) {
        int start = x, end = allocated.get(x);
        allocated.remove(start);
        free.put(start, end);
        return start;
    }

    public static void main(String[] args) {
        allocator(new int[]{0, 0, 0, 1, 1, 0, 0, 0, 0});
        System.out.println(operator(new int[]{0, 2}));
        System.out.println(operator(new int[]{0, 3}));
        System.out.println(operator(new int[]{0, 1}));
        System.out.println(operator(new int[]{1, 0}));
    }

}
