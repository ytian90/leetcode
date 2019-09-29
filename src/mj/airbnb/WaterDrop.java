package mj.airbnb;

/**
 * 14 Water Drop / Water Land
 */
public class WaterDrop {

    public static void pourWater(int[] heights, int water, int location) {
        int[] waters = new int[heights.length];
        int pourLocation;
        while (water > 0) {
            if (location != 0) {
                int left = location - 1;
                while (left > 0 && (heights[left - 1] + waters[left - 1] <= heights[left] + waters[left])) {
                    left--;
                }
                if (heights[left] + waters[left] < heights[location] + waters[location]) {
                    pourLocation = left;
                    waters[pourLocation]++;
                    water--;
                    continue;
                }
            }
            if (location != heights .length - 1) {
                int right = location + 1;
                while (right < heights.length - 1 && (heights[right + 1] + waters[right + 1] <= heights[right] + waters[right])) {
                    right++;
                }
                if (heights[right] + waters[right] < heights[location] + waters[location]) {
                    pourLocation = right;
                    waters[pourLocation]++;
                    water--;
                    continue;
                }
            }
            pourLocation = location;
            waters[pourLocation]++;
            water--;
        }
        print(heights, waters);
    }

    private static void print(int[] heights, int[] waters) {
        int n = heights.length;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, heights[i] + waters[i]);
        }
        for (int height = maxHeight; height >= 0; height--) {
            for (int i = 0; i < n; i++) {
                if (height <= heights[i]) {
                    System.out.print("+");
                } else if (height > heights[i] && height <= heights[i] + waters[i]) {
                    System.out.print("W");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        pourWater(new int[]{5,4,2,1,2,3,2,1,0,1,2,4}, 8, 5);

        int[] t2 = new int[]{1, 2, 3, 2, 1};
        for (int water = 0; water < 8; water++) {
            pourWater(t2, water, 0);
        }

    }
}
