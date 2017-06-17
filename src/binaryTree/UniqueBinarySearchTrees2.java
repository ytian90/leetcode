package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 * @author yutian
 * @since Aug 21, 2015
 */
public class UniqueBinarySearchTrees2 {
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) return new ArrayList<TreeNode>();
        return add(1, n);
	}

	private List<TreeNode> add(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = add(start, i - 1);
            List<TreeNode> right = add(i + 1, end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees2 z = new UniqueBinarySearchTrees2();
		List<TreeNode> r = z.generateTrees(3);
		for (TreeNode t: r) {
			printTree(t);
			System.out.println();
		}
	}

	
	private static void printTree(TreeNode n) {
		if (n == null) return;
		System.out.print(n.val + " ");
		printTree(n.left);
		printTree(n.right);
	}

}
