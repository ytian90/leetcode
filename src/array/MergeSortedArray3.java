package array;

import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	public int row, col, val;
	Node(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
	
	public int compareTo(Node n) {
		if (val > n.val) return 1;
		else if (val < n.val) return -1;
		else return 0;
	}
}

public class MergeSortedArray3 {

//	private Comparator<Node> comp = new Comparator<Node>(){
//		public int compare(Node a, Node b) {
//			return a.val - b.val;
//		}
//	};
	
	public int[] merge(int[][] arrays) {
		if (arrays == null) return new int[0];
		int total_size = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(arrays.length);
	            
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Node elem = new Node(i, 0, arrays[i][0]);
                pq.add(elem);
                total_size += arrays[i].length;
            }
        }
        
        int[] result = new int[total_size];
        int index = 0;
        while (!pq.isEmpty()) {
            Node elem = pq.poll();
            result[index++] = elem.val;
            if (elem.col + 1 < arrays[elem.row].length) {
                elem.col += 1;
                elem.val = arrays[elem.row][elem.col];
                pq.add(elem);
            }
        }
        
        return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] t = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
		MergeSortedArray3 sol = new MergeSortedArray3();
		for (int i : sol.merge(t))
			System.out.print(i + " ");
		
	}

}
