package leetcode;

import java.util.Arrays;

/**
 * @ClassName L62
 * @Description: 不同路径
 * @Author Keen
 * @DATE 2021/5/27 10:30
 * @Version 1.0
 **/
public class L62 {


    //递归方式：自顶向下方式
    public int uniquePaths1(int m, int n) {
        return recursion1(0, 0, m, n);
    }

    //进行递归，计算[i,j]到[m-1,n-1]的路径条数
    private int recursion1(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }
        return recursion1(i + 1, j, m, n) + recursion1(i, j + 1, m, n);
    }


    //递归方式：自顶向下方式 + 记忆化搜索
    public int uniquePaths2(int m, int n) {
        int[][] dp= new int[m][n];  //递归不需要dp数组
        //基础状态处理
        //处理最后一列,列不变，行变
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }
        //处理最后一行，行不变，列变
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }
        //进行递归,来填充dp数组
        recursion2(0, 0, dp);

        return dp[0][0];
    }

    //进行递归，计算[i,j]到[m-1,n-1]的路径条数
    private int recursion2(int i, int j, int[][] dp) {
        //不需要进行这个结束判断
        /*if (i == dp.length - 1 || j == dp[0].length - 1) {
            return 1;
        }*/

        if(dp[i][j] == 0) {
            dp[i][j] = recursion2(i + 1, j, dp) + recursion2(i, j + 1, dp);
        }
        return dp[i][j];
    }


    //自底向上：动态规划递推方式  空间复杂度为：O(mn)
    public int uniquePaths3(int m, int n) {
        //从左上到右下 == 从右下走到左上
        int[][] dp = new int[m][n];
        //初始化状态
        for (int i = 0; i < m; i++) dp[i][0] = 1;  //行变，列不变
        for (int i = 0; i < n; i++) dp[0][i] = 1;  //列变，行不变

        //递推：dp[i][j] = dp[i+1][j] + dp[i][j+1]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }


    //自底向上：动态规划递推方式 尝试减小空间复杂度
    public int uniquePaths4(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }


    //组合数学方式 C m+n-2   m-1    这种方式容易导致越界
    public int uniquePaths5(int m, int n) {
        return (int)(factorial(m+n-2)/factorial(m-1)/factorial(n-1));
    }

    private long factorial(int i) {
        long sum = 1;
        for (int j = 1; j <= i; j++) {
            sum *= j;
        }
        return sum;
    }

    //组合数学方式：不越界，已经化简了
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        double res = 1;
        for (int i = 1; i < m; i++)
            res = res * (N - (m - 1) + i) / i;
        return (int) res;
    }

    /*作者：sdwwld
    链接：https://leetcode-cn.com/problems/unique-paths/solution/dong-tai-gui-hua-di-gui-gong-shi-deng-3z-9mp1/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public static void main(String[] args) {
        int m = 23;
        int n = 12;
        L62 l62 = new L62();
        System.out.println(l62.uniquePaths(m, n));
        /*for (int[] array:dp) {
            System.out.println(Arrays.toString(array));
        }*/
        //System.out.println(Math.factorial());
    }
}
