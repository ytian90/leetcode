package leetcode.array;
/**
 * 605. Can Place Flowers
 * @author ytian
 *
 */
public class CanPlaceFlowers {
	
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
        	if (flowerbed[i] == 0) {
        		int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
        		int prev = (i == 0) ? 0 : flowerbed[i - 1];
        		if (next == 0 && prev == 0) {
        			flowerbed[i] = 1;
        			count++;
        		}
        	}
        }
        return count == n;
    }

	public static void main(String[] args) {
		System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
		System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
	}

	public boolean canPlaceFlowers1(int[] flowerbed, int n) {
		int size = flowerbed.length;
		if (flowerbed == null || size == 0) {
			return false;
		}
		if (size == 1 && flowerbed[0] == 0) {
			return true;
		}
		int res = 0;
		int x = 0;
		if (flowerbed[x] == 0) {
			while (x < size && flowerbed[x] == 0) {
				x++;
			}
			if (x == size) {
				res += (x % 2 == 0) ? x / 2 : (x + 1) / 2;
				return res >= n;
			} else {
				res += (x % 2 == 0) ? x / 2 : (x - 1) / 2;
			}
		}
		for (int i = x; i < size - 1;) {
			if (flowerbed[i] == 1 && flowerbed[i + 1] == 0) {
				int j = i + 1;
				while (j < size && flowerbed[j] == 0) {
					j++;
				}
				if (j == size) {
					int len = j - i - 1;
					res += (len % 2 == 0) ? len / 2 : (len - 1) / 2;
					break;
				} else {
					int len = j - i - 1;
					res += len % 2 == 0 ? len / 2 - 1 : (len + 1) / 2 - 1;
					i = j;
				}
			} else {
				i++;
			}
		}

		return res >= n;
	}
}
