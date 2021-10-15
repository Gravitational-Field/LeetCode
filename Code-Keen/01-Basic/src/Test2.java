/**
 * @ClassName Test2
 * @Description
 */
public class Test2 {
    /*编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。

    示例 1：
    输入：strs = ["flower","flow","flight"]
    输出："fl"
    示例 2：

    输入：strs = ["dog","racecar","car"]
    输出：""
    解释：输入不存在公共前缀。*/

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog","racecar","car"};
        System.out.println(new Test2().test(strs));

    }

    public String test(String[] strs) {
        String res = "";
        //错误判断
        int len = strs.length;
        if (len == 0) return res;
        if (len == 1) return strs[0];

        //进行处理:前两个进行比较
        for (int i = 0; i < Math.min(strs[0].length(), strs[1].length()); i++) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                res += strs[0].charAt(i);
            } else {
                break;
            }
        }

        //后边的依次进行比较
        for (int i = 2; i < len; i++) {
            //依次取出进行比较
            if (res.length() > strs[i].length()) {
                res = res.substring(0, strs[i].length());
            }
            //在res基础上截取公共部分
            for (int j = 0; j < res.length(); j++) {
                if (strs[i].charAt(j) != res.charAt(j)) {
                    res = res.substring(0, j);
                    break;
                }
            }


        }

        return res;
    }


}
