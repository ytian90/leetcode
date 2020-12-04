package leetcode.mj.linkedin;

import java.util.*;

/**
 * leetcode 380, 381
 注意上述的三种trade off
 第二题是design a data structure, support add(val), remove(val), removeRandom.
 step1: leetcode.design  add = O(1), remove O(1), removeRandom, O(N). => hashset only, removeRandom的时候把东西全放进一个array, 然后再删。这样有O(N)的memory.不过也符合要求啦。.
 step2: leetcode.design  add = O(1), remove O(N), removeRandom, O(1). => hashset + leetcode.array... 这个简单。. Waral 鍗氬鏈夋洿澶氭枃绔�,
 step3: leetcode.design  add = O(1), remove O(1), removeRandom, O(1). => hashset + leetcode.array .. 用下面说的那个trick做remove.

 关键是要想到如何在O(1)时间里，从一个array里面删除一个元素。
 就是把这个元素和array的最后一个元素交换，然后删除最后一个元素，同时减小array的size。这样就O(1)完成了删除。思想感觉和quick sort的in-place partition非常像。
 小哥这个三步走循循善诱，不然估计还想不出来嗯。
 最后直接实现最后一个，前两个都是在讨论。
 design题目是那个write/maxPerformance/getRandom/deleteRandom都是O(1)的题目，我开始写的code和他想要的略有不同，
 最正确解法是vector里面同时存key/val，hashtable里面存key，value是vector的index。我的vector里面只存了key，所以多用了一个hashtable，不过最后也经过提示找到了这种方法。

 */
public class Insert_Get_GetRandom_RemoveRandom {

    ArrayList<Integer> nums;
    Map<Integer, Set<Integer>> locs;
    Random random;

    public Insert_Get_GetRandom_RemoveRandom() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) {
            locs.put(val, new LinkedHashSet<>());
        }
        locs.get(val).add(nums.size());
        nums.add(val);
        return !contain;
    }

    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) return false;
        int loc = locs.get(val).iterator().next();
        locs.get(val).remove(loc);
        if (loc < nums.size() - 1) {
            int lastone = nums.get(nums.size() - 1);
            nums.set(loc, lastone);
            locs.get(lastone).remove(nums.size() - 1);
            locs.get(lastone).add(loc);
        }
        nums.remove(nums.size() - 1);
        if (locs.get(val).isEmpty()) locs.remove(val);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    public boolean removeRandom() {
        int val = getRandom();
        return remove(val);
    }

    public static void main(String[] args) {
        Insert_Get_GetRandom_RemoveRandom obj = new Insert_Get_GetRandom_RemoveRandom();
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(3));
        System.out.println(obj.remove(2));
        System.out.println(obj.removeRandom());
    }
}
