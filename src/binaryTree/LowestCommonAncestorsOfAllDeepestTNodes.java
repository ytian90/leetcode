package binaryTree;

import java.util.ArrayList;

/**
 * Give the common ancestor of all the deepest TNodes of a tree.
 * http://www.1point3acres.com/bbs/thread-148413-1-1.html
 * @author yutian
 * @since Feb 4, 2016
 */
class TNode {
	int val;
	ArrayList<TNode> children;
	public TNode(int val) {
		this.val = val;
		children = new ArrayList<>();
	}
}

class Result {
	TNode TNode;
	int maxDepth;
	public Result(TNode TNode, int maxDepth) {
		this.TNode = TNode;
		this.maxDepth = maxDepth;
	}
}

public class LowestCommonAncestorsOfAllDeepestTNodes {

	public static TNode find(TNode root) {
		if (root == null || root.children.isEmpty()) return root;
		return helper(root).TNode;
	}

	private static Result helper(TNode root) {
		if (root.children.isEmpty()) return new Result(root, 1);
		int size = root.children.size();
		int maxDepth = Integer.MIN_VALUE;
		Result r = new Result(root, maxDepth);
		for (int i = 0; i < size; i++) {
			Result temp = helper(root.children.get(i));
			if (temp.maxDepth > maxDepth) {
				maxDepth = temp.maxDepth;
				r.TNode = temp.TNode;
				r.maxDepth = temp.maxDepth + 1;
			} else if (temp.maxDepth == maxDepth) {
				r.TNode = root;
			}
		}
		return r;
	}

	public static void main(String[] args) {
		TNode n1 = new TNode(1);
        TNode n2 = new TNode(2);
        TNode n3 = new TNode(3);
        TNode n4 = new TNode(4);
        TNode n5 = new TNode(5);
        TNode n6 = new TNode(6);
        TNode n7 = new TNode(7);
        TNode n8 = new TNode(8);
        TNode n9 = new TNode(9);
        TNode n10 = new TNode(10);
        TNode n11 = new TNode(11);
        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);
        n2.children.add(n5);
        n2.children.add(n6);
        n4.children.add(n7);
        n5.children.add(n8);
        n5.children.add(n9);
        n6.children.add(n10);
        n8.children.add(n11);
        TNode res = find(n1);
        System.out.println(res.val);
        
//        TNode n11 = new TNode(11);
//        n8.children.add(n11);
//        TNode res2 = find(n1);
//        System.out.println(res2.val);
        
	}

}

