package binaryTree;
/**
 * 315. Count of Smaller Numbers After Self
 * Implementation of Node
 * @author yutian
 * @since Jan 27, 2016
 */
public class Node {
	Node left, right;
	int val, sum, dup = 1;
	public Node (int v, int s) {
		val = v;
		sum = s;
	}
}