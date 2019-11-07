package mj.google;

import java.util.Arrays;

/**
 * https://www.1point3acres.com/bbs/thread-556631-1-1.html
 * 给定一堆不同高度的objects和一堆仓库storage的空间。东西只能从左向右推进仓库，如果有个位置太低了，
 * 那么后面的位置都会被前面的位置局限住。例如仓库是[1,5], 那么第二个位置最多也只能放1。
 * 问最多能把多少objects放进仓库。
 *
 * 例如,
 * objects = [3,3,1,4,5]
 * storage = [4,5,1,5]
 * 例如这里最多能放3个,[3,3,0,1]
 *
 * 我一开始把objects排序了，把object从低到高放，storage从后往前试能不能放。如果object <= storage[j]那就能放,试前一个位置
 * 经小哥提醒发发现storage的能放的高度是由前面最小的高度决定的，就先遍历了一下storage数组来更新storage能放的高度。
 * 然后他就说应该做对了。
 *
 * follow up1 是如果storage的空间远远小于object的数量。
 * 用heap来弹出最小的object
 *
 * follow up2 是如果storage左右都能推进去。
 * 我说是维护一个从左到右的min height和从右往左的min height,然后能放的高度是两个min height中大的那个，他说应该可以
 */
public class ObjectsStorage {

    public static int storage(int[] objects, int[] storage) {
        int res = 0;
        Arrays.sort(objects);
        int currMinStorage = storage[0];
        for (int i = 0; i < storage.length; i++) {
            currMinStorage = Math.min(currMinStorage, storage[i]);
            storage[i] = currMinStorage;
        }
        for (int i = storage.length - 1; i >= 0; i--) {
            if (objects[res] <= storage[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(storage(new int[]{3, 3, 1, 4, 5}, new int[]{4, 5, 1, 5}));
    }
}
