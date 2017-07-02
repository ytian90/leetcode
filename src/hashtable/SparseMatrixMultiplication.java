package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 311. Sparse Matrix Multiplication
 * @author yutian
 * @since Dec 27, 2015
 */
public class SparseMatrixMultiplication {
	
	public static int[][] multiply(int[][] A, int[][] B) {
        int a = A.length, b = A[0].length, c = B[0].length;
        int[][] C = new int[a][c];
        for (int i = 0; i < a; i++) {
        	for (int k = 0; k < b; k++) {
        		if (A[i][k] != 0) {
        			for (int j = 0; j < c; j++) {
        				if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
        			}
        		}
        	}
        }
        return C;
    }
	
	public static int[][] multiply2(int[][] A, int[][] B) {
		int a = A.length, b = A[0].length, c = B[0].length;
		int[][] C = new int[a][c];
		List[] index = new List[a];
		for (int i = 0; i < a; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < b; j++) {
				if (A[i][j] != 0) {
					list.add(j);
					list.add(A[i][j]);
				}
			}
			index[i] = list;
		}
		for (int i = 0; i < a; i++) {
			List<Integer> list = index[i];
			for (int p = 0; p < list.size() - 1; p += 2) {
				int col = list.get(p);
				int val1 = list.get(p + 1);
				for (int j = 0; j < c; j++) {
					int val2 = B[col][j];
					C[i][j] += val1 * val2;
				}
			}
		}
		return C;
	}
	
	public static void main(String[] args) {
//		int[][] A = new int[][]{{1, 0, 0}, {-1, 0, 3}};
//		int[][] B = new int[][]{{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
//		int[][] result = multiply(A, B);
//		for (int i = 0; i < A.length; i++) {
//			for (int j = 0; j < B[0].length; j++) {
//				System.out.print(result[i][j] + " ");
//			}
//			System.out.println();
//		}
		
//		int[][] a = new int[][]{{1, 2}, {3, 2}, {6, 3}, {9, 4}};
//		int[][] b = new int[][]{{4, 5}, {6, 2}, {9, 8}};
//		System.out.println(multiply2(a, b));
		
		int[] a = new int[]{0,2,0,2,0,0,3,0,0,4};
		int[] b = new int[]{0,0,0,0,5,0,2,0,0,8};
		System.out.println(multiply(a, b));
		
	}
	
	public static int multiply(int[] A, int[] B) {
		int dot_sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0 && B[i] != 0) {
				dot_sum += A[i] * B[i];
			}
		}
		return dot_sum;
	}
	
	// assume A and B are sparse vector
	public static int multiply3(int[][] A, int[][] B) {
		int a = A.length, b = A[0].length, c = B[0].length;
		ArrayList<ArrayList<Integer>> va = new ArrayList<>();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				if (A[i][j] != 0) {
					int index = b * i + j;
					va.add(new ArrayList<>(Arrays.asList(index, A[i][j])));
				}
			}
		}
		ArrayList<ArrayList<Integer>> vb = new ArrayList<>();
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < c; j++) {
				if (B[i][j] != 0) {
					int index = c * i + j;
					vb.add(new ArrayList<>(Arrays.asList(index, B[i][j])));
				}
			}
		}
		for (ArrayList<Integer> i: va) {
			System.out.println(i);
		}
		
		
		int dot_sum = 0;
		
		return dot_sum;
	}

	

}
