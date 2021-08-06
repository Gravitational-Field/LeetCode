package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//f[i][j] 表示从 i - j 这一段变成回文串的最小代价
/*
    转移方程举例子：
f[i][j] = Math.min(f[i][j], f[i][j - 1] + Math.min(  inc[ c[j] - '0' ] , dec[ c[j] - '0' ] ));
为可以这样 我们是枚举len长度下的最下代价，也已知了 j = i + len - 1也就是i-j长度就是len的 这部分使我们要去求的

但是f[i][j - 1]的最小代价我们是上一步 len - 1长度枚举的时候就已经求了 f[i + 1][j - 1]是len - 2的长度，当然我们更早求了

因此有 c[i] == c[j] 时候 我们f[i + 1][j - 1]早就算出了， 那么必然有f[i][j] = f[i + 1][j - 1]这样才最小

但是当c[i] != c[j]  举例子 xxxxx1 反正其他的不管这个5个x = xxxxx我们早就知道了最小代价。那么多了一个1

直接删除变成xxxxxx  或者在添加一个1 -> 1xxxxxx1 也就是：
f[i][j] = Math.min(f[i][j], f[i][j - 1] + Math.min(  inc[ c[j] - '0' ] , dec[ c[j] - '0' ] ));


*/
public class Main123 {
    static String t = "";
    static int N = 110, INF = (int)10e9;
    static int[][] f = new int[N][N];
    static int[] inc = new int[]{-1, 100,200,360,220};
    static int[] dec = new int[]{-1, 120,350,200,320};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = bf.readLine();
        char[] c = t.toCharArray();
        for(int i = 0; i < c.length; i ++) {
            Arrays.fill(f[i], INF);
            f[i][i] = 0;
        }
        for(int len = 2; len <= c.length; len ++)  //枚举区间长度
            for(int i = 0; i + len - 1 < c.length; i ++){  //枚举左边端点
                int j = i + len - 1;  //右边端点
                if(c[i] == c[j] ){
                    f[i][j] = len == 2 ? 0 : f[i + 1][j - 1];
                }else if(c[i] != c[j]){

                    f[i][j] = Math.min(f[i][j], f[i][j - 1] + Math.min(  inc[ c[j] - '0' ] , dec[ c[j] - '0' ] ));
                    f[i][j] = Math.min(f[i][j], f[i + 1][j] + Math.min(  inc[ c[i] - '0' ] , dec[ c[i] - '0' ] ));
                }
            }
        System.out.println(f[0][c.length - 1]);
    }
}
