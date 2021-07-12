package leetcode;

/**
 * @ClassName L72
 * @Description
 */
public class L72 {

    //1.使用递归的方式
    public int minDistance1(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        return recursion1(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int recursion1(String s1, String s2, int i, int j) {
        //结束状态
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        //子结构
        if (s1.charAt(i) == s2.charAt(j)) {
            return recursion1(s1, s2, i - 1, j - 1);
        } else {
            return Math.min(Math.min(
                    recursion1(s1, s2, i - 1, j) + 1, //删除
                    recursion1(s1, s2, i, j - 1) + 1 //添加
            ), recursion1(s1, s2, i - 1, j - 1) + 1);//替换
        }
    }


    //2.使用递归的方式+dptable
    public int minDistance2(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        int[][] dptable = new int[word1.length()][word2.length()];
        return recursion2(dptable, word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int recursion2(int[][] dptable, String s1, String s2, int i, int j) {
        //结束状态
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        //子结构
        if (s1.charAt(i) == s2.charAt(j)) {
            return recursion2(dptable, s1, s2, i - 1, j - 1);
        } else {
            return Math.min(Math.min(
                    recursion2(dptable, s1, s2, i - 1, j) + 1, //删除
                    recursion2(dptable, s1, s2, i, j - 1) + 1 //添加
            ), recursion2(dptable, s1, s2, i - 1, j - 1) + 1);//替换
        }
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";

        System.out.println(new L72().minDistance2(word1, word2));
        System.out.println(new L72().minDistance2("intention", "execution"));

    }

}
