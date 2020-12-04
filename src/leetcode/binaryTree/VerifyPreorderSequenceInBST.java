package leetcode.binaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 255. Verify Preorder Sequence in Binary Search Tree
 * @author yutian
 * @since Jan 1, 2016
 */
public class VerifyPreorderSequenceInBST {
	
	// Solution 1: Stack Time O(n) Space O(n)
	public static boolean verifyPreorder(int[] preorder) {
		int low = Integer.MIN_VALUE;
		Deque<Integer> stack = new LinkedList<>();
		for (int n : preorder) {
			if (n < low) return false;
			while (!stack.isEmpty() && n > stack.peek()) {
				low = stack.pop();
			}
			stack.push(n);
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
		System.out.println(verifyPreorder(new int[]{5, 2, 1, 3, 12, 2, 8}));
		System.out.println(verifyPreorder(new int[]{5, 2, 6, 1, 3}));
		System.out.println(verifyPreorder(new int[]{5, 2, 1, 3, 6}));
	}

}
