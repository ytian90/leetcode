package company.uber.oa;

import java.util.*;

/**
 * 移动矩阵，给定一个大的方形矩阵，先按照size分割，每一个小的方形矩阵找到里面第一个missing positive，
 * 然后再按照missing positive的顺序移动矩阵得到一个新的矩阵。这个题目完全就是在考你是不是能细心的处理好矩阵的位置和坐标，
 * 处理好之后排序什么的其实不难。找missing positive其实不需要用刷题网那个方法，就直接数一遍就好
 * https://leetcode.com/discuss/interview-question/949185/uber-sde-1-us-codesignal-oa
 *
 * Beauty of a square matrix is minimum positive integer which doesnt exist in the matrix.
 * ex. for 2x2 matrix 1,2,4,6 beauty is 3.
 * Given a square matrix of +ve integers 'numbers' and an integer 'size' which evenly divides 'numbers.length' Do the following :-
 * a) Split numbers into non-overlapping size x size submatrices.
 * b) Arrange all submatrices in ascending order of beauty and put them back into the matrix. Order should be from left to right, top to bottom. If same beauty, then place them in the original order they were present in the original matrix.
 * ex.
 * 1,2,2,3
 * 3,4,10,4
 * 2,10,1,2
 * 5,4,4,5
 * size = 2
 * Output will be
 * 2,3,2,10
 * 10,4,5,4
 * 1,2,1,2
 * 4,5,3,4
 *
 * Reasoning :
 * 1,2,3,4 beauty = 5
 * 2,3,10,4 beauty = 1
 * 2,10,5,4 beauty = 1
 * 1,2,4,5 beauty = 3
 * 						1<3<5
 */
public class BeautyOfMatrix {
    public static void main(String[] args) {
        System.out.println(getPositive(Arrays.asList(1, 2, 3, 4)));
        System.out.println(getPositive(Arrays.asList(2, 3, 10, 4)));
        System.out.println(getPositive(Arrays.asList(2, 10, 5, 4)));
        System.out.println(getPositive(Arrays.asList(1, 2, 4, 5)));

        for (int[] a : beautyOfMatrix(new int[][]{
                {1, 2, 2, 3},
                {3, 4, 10, 4},
                {2, 10, 1, 2},
                {5, 4, 4, 5}
        }, 2)) {
            System.out.println(Arrays.toString(a));
        }

    }


    public static int[][] beautyOfMatrix(int[][] matrix, int k) {
        Map<Integer, int[]> cells = new HashMap<>();

        //store grids into arrays keyed by their grid id
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int n = matrix.length;
        for(int i =0; i<n; i++){
            for(int j =0; j<n ; j++){
                int r = k * (i/k);
                int c = k * (j/k);
                int key = r*n + c;
                cells.put(key, new int[]{r,c});
                if(!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(matrix[i][j]);
            }
        }


        //calculate beauty of each grid
        TreeMap<Integer, List<Integer>> beauty = new TreeMap<>();
        for(Integer kS : map.keySet()){
            int b = getPositive(map.get(kS));
            if(!beauty.containsKey(b)) beauty.put(b, new ArrayList<>());
            beauty.get(b).add(kS);
        }

        //sorting beauty to access them in order
        for(List kS : map.values()){
            Collections.sort(kS);
        }

        int[][] res = new int[n][n]; //resultant array to return

        int r1 = 0; int c1 = 0;
        for(List<Integer> l : beauty.values()){
            for(int idx : l){
                int row = cells.get(idx)[0];
                int col = cells.get(idx)[1];
                for(int i = row,  rk= 0; i<row+k; i++, rk++){
                    for(int j = col,  ck = 0; j<col+k; j++, ck++){
                        res[k*(r1/k) + rk][k*(c1/k) + ck] = matrix[i][j];
                    }
                }
                if(c1 + k < n) {
                    c1+=k;
                }
                else {
                    r1+=k;
                    c1=0;
                }
            }
        }

        return res;
    }

    /* function to get first positive */
    public static int getPositive(List<Integer> list){
        int num = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: list){
            pq.offer(i);
        }
        while(!pq.isEmpty()){
            int val = pq.poll();
            if (val<=0) continue;
            if(val > num) break;
            else num++;
        }
        return num;
    }


}
