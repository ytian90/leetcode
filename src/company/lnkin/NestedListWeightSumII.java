package company.lnkin;

import java.util.List;

/**
 * LC 364. Nested List Weight Sum II
 *
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.
 *
 * The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth. Let maxDepth be the maximum depth of any integer.
 *
 * The weight of an integer is maxDepth - (the depth of the integer) + 1.
 *
 * Return the sum of each integer in nestedList multiplied by its weight.
 *
 * Example 1:
 *
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: 8
 * Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
 * 1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8
 * Example 2:
 *
 *
 * Input: nestedList = [1,[4,[6]]]
 * Output: 17
 * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1.
 * 1*3 + 4*2 + 6*1 = 17
 */
public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = getMaxDepth(nestedList);
        return helper(nestedList, depth);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                res += depth * n.getInteger();
            } else {
                res += helper(n.getList(), depth - 1);
            }
        }
        return res;
    }

    private int getMaxDepth(List<NestedInteger> list) {
        int res = 1;
        for (NestedInteger n : list) {
            if (!n.isInteger()) {
                int depth = 1 + getMaxDepth(n.getList());
                res = Math.max(res, depth);
            }
        }
        return res;
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}