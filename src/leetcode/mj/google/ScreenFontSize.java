package leetcode.mj.google;

import java.util.List;

/**
 * 已知screen的高和宽，给你最小和最大的fontSize，要求给定一个string，将string用尽可能大的fontSize显示在screen里。
 * 已知两个API getHeight(int fontSize), getWidth(char c, int fontSize)，可以得到每个character在不同fontSize下的高和宽。
 * 和面试官交流后，确认string可以拆分成几行显示在screen中
 */
public class ScreenFontSize {
    private static int screenW , screenH, maxFontSize;
    private static API api;

    public ScreenFontSize(int screenW, int screenH, int maxFontSize) {
        this.screenW = screenW;
        this.screenH = screenH;
        this.maxFontSize = maxFontSize;
        this.api = api;
    }

    public int getMaxFontSizeToFit(List<String> words) {
        int minFS = 1, maxFS = maxFontSize;
        while (minFS < maxFS) {
            int midFS = minFS + (maxFS - minFS) / 2;
            if (getTotalLineHeight(words, minFS) <= screenH) {
                minFS = midFS + 1;
            } else {
                maxFS = midFS;
            }
        }
        return minFS;
    }

    public int getTotalLineHeight(List<String> words, int fs) {
        int currH = 0, currW = 0, totalH = 0;
        int i = 0;
        int[] size = getWordSize(words.get(i), fs);
        int spaceW = api.getLetterSize(' ', fs)[0];
        while (i < words.size()) {
            // width to fit in current line
            int wToFit = size[0] + (currW > 0 ? spaceW : 0);
            // fit in current line
            if (currW + wToFit <= screenW) {
                currW += wToFit;
                currH = Math.max(currH, size[1]);
                if (i < words.size() - 1) {
                    size = getWordSize(words.get(++i), fs);
                }
            // even a single word cannot fit it
            } else if (currW > screenW) {
                return -1;
            } else {
                totalH += currH;
                currW = 0;
                currH = 0;
            }
        }
        if (currW > 0) {
            totalH += currH;
        }
        return totalH;
    }

    private int[] getWordSize(String s, int fs) {
        int width = 0, height = 0;
        for (char c : s.toCharArray()) {
            int[] res = api.getLetterSize(c, fs);
            width += res[0];
            height = Math.max(height, res[1]);
        }
        return new int[]{width, height};
    }

    interface API {
        int[] getLetterSize(char c, int fs);
    }
}
