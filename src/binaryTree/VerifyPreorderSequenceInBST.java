package binaryTree;

import java.util.Stack;

/**
 * 255. Verify Preorder Sequence in Binary Search Tree
 * @author yutian
 * @since Jan 1, 2016
 */
public class VerifyPreorderSequenceInBST {
	
	// Solution 1: Stack Time O(n) Space O(n)
	public static boolean verifyPreorder(int[] preorder) {
		int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<>();
        for (int p : preorder) {
            if (p < low) return false;
            while (!path.isEmpty() && p > path.peek()) {
                low = path.pop();
            }
            path.push(p);
        }
        return true;
    }
	
	// Solution 2: Time O(n) Space O(1)
	public static boolean verifyPreorder2(int[] preorder) {
		int low = Integer.MIN_VALUE, i = -1;
		for (int p: preorder) {
			if (p < low) return false;
			while (i >= 0 && p > preorder[i]) {
				low = preorder[i--];
			}
			preorder[++i] = p;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] test = new int[]{5, 2, 1, 3, 12, 2, 8};
		System.out.println(verifyPreorder2(test));
	}

}
