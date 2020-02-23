package binaryTree;

import java.util.*;

/**
 * 272. Closest Binary Search Tree Value II
 * @author yutian
 * @since Feb 15, 2016
 */
public class ClosestBinarySearchTreeValue2 {
    PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> b.delta.compareTo(a.delta));
    double target;
    int capacity;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.target = target;
        this.capacity = k;
        pushAllNodes(root);
        List<Integer> res = new ArrayList<>();
        for (Node node : pq) {
            res.add(node.nodeVal);
        }
        return res;
    }

    private void pushAllNodes(TreeNode node) {
        if (node == null) {
            return;

        }
        pushToPriorityQueue(node);
        pushAllNodes(node.left);
        pushAllNodes(node.right);
    }

    private void pushToPriorityQueue(TreeNode node) {
        pq.add(getNode(target, node));
        if (pq.size() == capacity + 1) {
            pq.poll();
        }
    }

    private Node getNode(double target, TreeNode node) {
        return new Node(Math.abs(target - node.val), node.val);
    }

    class Node {
        Double delta;
        Integer nodeVal;

        public Node(Double delta, Integer nodeVal) {
            this.delta = delta;
            this.nodeVal = nodeVal;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(8);
        TreeNode n6 = new TreeNode(12);
        TreeNode n7 = new TreeNode(20);
        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6; n3.right = n7;

        ClosestBinarySearchTreeValue2 t = new ClosestBinarySearchTreeValue2();
        System.out.println(t.closestKValues(n1, 7, 3));
    }

	// time O(N)
	public List<Integer> closestKValues1(TreeNode root, double target, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        helper(root, target, k , result);
        return result;
    }
	// inorder traversal
	private void helper(TreeNode root, double target, int k,
			LinkedList<Integer> result) {
		if (root == null) return;
		helper(root.left, target, k, result);
		if (result.size() == k) {
			if (Math.abs(target - root.val) < Math.abs(target - result.peekFirst()))
				result.removeFirst();
			else return;
		}
		result.add(root.val);
		helper(root.right, target, k, result);
	}
	
	// time O(logn + k) optimal but too long
	public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> succ = new Stack<>();
        Stack<TreeNode> pred = new Stack<>();
        initializePredecessorStack(root, target, pred);
        initializeSuccessorStack(root, target, succ);
        if(!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
            getNextPredecessor(pred);
        }
        while(k-- > 0) {
            if(succ.isEmpty()) {
                ret.add(getNextPredecessor(pred));
            } else if(pred.isEmpty()) {
                ret.add(getNextSuccessor(succ));
            } else {
                double succ_diff = Math.abs((double)succ.peek().val - target);
                double pred_diff = Math.abs((double)pred.peek().val - target);
                if(succ_diff < pred_diff) {
                    ret.add(getNextSuccessor(succ));
                } else {
                    ret.add(getNextPredecessor(pred));
                }
            }
        }
        return ret;
    }

    private void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
        while(root != null) {
            if(root.val == target) {
                succ.push(root);
                break;
            } else if(root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
        while(root != null){
            if(root.val == target){
                pred.push(root);
                break;
            } else if(root.val < target){
                pred.push(root);
                root = root.right;
            } else{
                root = root.left;
            }
        }
    }

    private int getNextSuccessor(Stack<TreeNode> succ) {
        TreeNode curr = succ.pop();
        int ret = curr.val;
        curr = curr.right;
        while(curr != null) {
            succ.push(curr);
            curr = curr.left;
        }
        return ret;
    }

    private int getNextPredecessor(Stack<TreeNode> pred) {
        TreeNode curr = pred.pop();
        int ret = curr.val;
        curr = curr.left;
        while(curr != null) {
            pred.push(curr);
            curr = curr.right;
        }
        return ret;
    }

}
