package leetcode;

import java.util.Arrays;

/**
 * @ClassName L455
 * @Description: 分发饼干
 * @Author Keen
 * @DATE 2021/4/12 22:17
 * @Version 1.0
 **/
public class L455 {

    public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0 || s == null || s.length == 0) {
            return 0;
        }
        int gLen = g.length;
        int sLen = s.length;
        int i= 0;
        int j= 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;

        while (i < gLen && j < sLen) {
            if(g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1,2,3};

        System.out.println(new L455().findContentChildren(g, s));
    }
}
