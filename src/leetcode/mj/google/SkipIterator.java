package leetcode.mj.google;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * class SkipIterator {
 * 	public SkipIterator(Iterator itr);
 * 	boolean hasNext();
 * 	Integer next();
 * 	void skip(int num);
 * }
 * 传入的迭代器让我看作是在一个List<Integer>上面的迭代器，主要说下skip函数，输入参数是个int，表示下一个数字等于num的需要被跳过，
 * 就是当作这个list中下一个num不存在，skip可能被多次调用,skip(5),skip(5)表示后面的两个5都不要了。
 *
 * 思路：
 * 当面试官说skip可以多次调用时直接想到的用map存放skip调用的频率，所以思路也很直接Map<Integer, Integer>，key是需要被跳过的数字，
 * value是接下来多少个key需要被跳过，然后用一个Integer curr缓冲下一个integer，skip每调用一次频率加一，每跳过一次key，key的value减一。
 * 然后我设计的iterator中是next中call hasNext，hasNext负责找下一个合法元素，但是正确解法应该用另一个函数去专门找下一个合法元素。
 */
public class SkipIterator {
    private Iterator<Integer> iterator;
    private boolean hasNext;
    private Integer nextElement;
    private Map<Integer, Integer> map = new HashMap<>();

    public SkipIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        findNext();
    }

    public boolean hasNext() {
        return hasNext;
    }

    public Integer next() {
        if (!hasNext) return null;
        Integer res = nextElement;
        findNext();
        return res;
    }

    public void skip(int num) {
        if (hasNext) {
            if (nextElement == num) {
                findNext();
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
    }

    private void findNext() {
        hasNext = false;
        nextElement = null;
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (map.containsKey(next)) {
                map.put(next, map.get(next) - 1);
                if (map.get(next) == 0) {
                    map.remove(next);
                }
            } else {
                hasNext = true;
                nextElement = next;
                return;
            }
        }
    }
}
