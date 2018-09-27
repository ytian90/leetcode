package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 894. All Possible Full Binary Trees
 */
public class AllPossibleFullBinaryTrees {

    public static List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        N = N - 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode curr = new TreeNode(0);
                    curr.left = l;
                    curr.right = r;
                    res.add(curr);
                }
            }
        }
        return res;
    }

    static Map<Integer, List<TreeNode>> cache = new HashMap<>();

    public static List<TreeNode> allPossibleFBTs(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0)
            return res;
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        N = N - 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBTs(i);
            List<TreeNode> right = allPossibleFBTs(N - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode curr = new TreeNode(0);
                    curr.left = l;
                    curr.right = r;
                    res.add(curr);
                }
            }
        }
        cache.put(N, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(allPossibleFBT(7));
    }
}
