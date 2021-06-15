package company.lnkin.mj;

/**
 * 国人senior+泰国人junior， 简化版的combination sum，只需要返回满足target的个数
 *
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=764505&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D6%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class CombinationSum {
    public static int combinationSum(int[] candidates, int target) {
        int[] res = new int[1];
        helper(candidates, target, 0, res);
        return res[0];
    }

    private static void helper(int[] candidates, int target, int start, int[] res) {
        if (target < 0) return;
        if (target == 0) res[0]++;
        for (int i = start; i < candidates.length; i++) {
            helper(candidates, target - candidates[i], i, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }
}
