package binaryTree;
/**
 * Populating Next Right Pointers in Each Node
 * Both I and II works!
 * @author yutian
 * @since Aug 22, 2015
 */
public class PopulatingNextRightPointersInEachNode {
	
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		// dummy is the node above prev
		// dummy.next stores the leftmost node in the next level
		TreeLinkNode dummy = new TreeLinkNode(0);
		TreeLinkNode curr = dummy, prev = root;
		while (prev != null) {
			// when prev has any child;
			// if it's the leftmost node, connect dummy.next to it
			// otherwise, connect current left node to it.
			if (prev.left != null) {
				curr.next = prev.left;
				curr = curr.next;
			}
			if (prev.right != null) {
				curr.next = prev.right;
				curr = curr.next;
			}
			prev = prev.next;
		}
		connect(dummy.next); // go down to the next level
	}
	

	// (1) Loop through level 0 to level n - 2; (2) Traverse this level and connect children.
	public void connect1(TreeLinkNode root) {
		while (root != null && root.left != null) {
			TreeLinkNode curr = root;
			while (curr != null) {
				curr.left.next = curr.right;
				curr.right.next = curr.next == null ? null : curr.next.left;
				curr = curr.next;
			}
			root = root.left;
		}
	}
	
	public void connect2(TreeLinkNode root) {
		if (root == null) return;
		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null) {
				root.right.next = root.next.left;
			}
		}
		connect2(root.left);
		connect2(root.right);
	}
	
	
	public static void main() {
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n7 = new TreeLinkNode(7);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.right = n7;
		
		PopulatingNextRightPointersInEachNode t = new PopulatingNextRightPointersInEachNode();
		t.connect(n1);
		System.out.println(n1.next.val);
		System.out.println(n2.next.val);
		System.out.println(n3.next.val);
		System.out.println(n4.next.val);
		System.out.println(n5.next.val);
		System.out.println(n7.next.val);
		
		
		
	}
}
