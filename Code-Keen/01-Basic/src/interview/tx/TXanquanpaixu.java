package interview.tx;

import java.util.Arrays;

/**
 * @ClassName TXanquanpaixu
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/3/19 8:13
 * @Version 1.0
 **/
public class TXanquanpaixu {


    public static void main(String[] args) {
        System.out.println("abcd4312ABDC"+new TXanquanpaixu().sortString("abcd4312ABDC"));
        System.out.println(new TXanquanpaixu().sortString("123gfdSDFSDF1213asd"));
        System.out.println(new TXanquanpaixu().sortString("a"));
        System.out.println(new TXanquanpaixu().sortString("1"));
        System.out.println(new TXanquanpaixu().sortString("A"));
        System.out.println(new TXanquanpaixu().sortString("a1D"));
        System.out.println(new TXanquanpaixu().sortString("1aD"));
        System.out.println(new TXanquanpaixu().sortString("D1a"));
    }

    private String sortString(String str) {
        char[] chars = str.toCharArray();

        int index = 0; //记录存储的位置
        for (int i = 0; i < chars.length; i++) { //外层循环控制位置
            int j;
            for (j = i; j < chars.length; j++) {  //内层循环负责探索
                if(chars[j] >= '0' && chars[j] <= '9') {
                    //找到数字，进行调整
                    ajust(i, j, chars);
                    index = i;  //记录插入的位置
                    break;
                }
            }
            if(j == chars.length-1) {
                break;
            }
        }

        //定位下一次要插入的位置
        for (int i = index+1; i < chars.length; i++) { //外层循环控制位置
            int j;
            for (j = i; j < chars.length; j++) {  //内层循环负责探索
                if(chars[j] >= 'a' && chars[j] <= 'z') {
                    //找到小写字母，进行调整
                    ajust(i, j, chars);
                    index = i;  //记录插入的位置
                    break;
                }
            }
            if(j == chars.length-1) {
                break;
            }
        }

        return Arrays.toString(chars);
    }

    private void ajust(int i, int j, char[] chars) {
        char tmp = chars[j];
        for (int k = j; k > i ; k--) {
            chars[k] = chars[k-1];
        }
        chars[i] = tmp;
    }
}
