package jianzhioffer;

/**
 * @ClassName Array_5_tihuankongge
 * @Description
 */
public class Array_5_tihuankongge {

    public static String replaceSpace(StringBuffer str) {
        //替换所有的空格
        int p1 = str.length()-1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') { //注意使用' '  代表单个字符
                str.append("  ");
            }
        }
        int p2 = str.length()-1;
        while (p1>=0 && p2>p1) {  //没考虑p2 == p1的情况，
            char c = str.charAt(p1);
            if (c == ' ') {
                //为空
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');

            }else {
                //不为空
                str.setCharAt(p2--,c);
            }
            p1--;
        }

        System.out.println(str);
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("helloworld ");
        System.out.println(replaceSpace(sb));
    }
}
