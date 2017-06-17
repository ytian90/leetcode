package array;
/**
 * Sort Array Given Order
 * https://shawnlincoding.wordpress.com/
 * @author yutian
 * @since Feb 6, 2016
 */
public class SortArrayGivenOrder {
	
	/*
	Given two arrays，one is actual numbers, the other is position array, 
	Based on position array, sort actual number array.
	Example：
	actual number array : [4 2 1 5 3]
	position array : [3 1 0 4 2]
	=>
	actual number array [1 2 3 4 5]
	*/
	
	public void sortOrder(int[] array, int[] order) {
		if (array == null || order == null) {
			throw new IllegalArgumentException();
		}
		if (array.length == 0 || order.length == 0 || array.length != order.length) {
			return;
		}
		int N = array.length;
		for (int i = 0; i < N; i++) {
			while (i != order[i]) {
				swap(array, i, order[i]);
				swap(order, i, order[i]);
			}
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = {4, 2, 1, 5, 3}, order = {3, 1, 0, 4, 2};
		new SortArrayGivenOrder().sortOrder(array, order);
		for (int i : array) System.out.println(i);
	}

}
