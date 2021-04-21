package interview;

/**
 * @ClassName ab2bba_360
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/17 16:34
 * @Version 1.0
 **/
public class ab2bba_360 {


    public int count(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder(str);
        char[] chars = str.toCharArray();
        for (int i = 1; i < str.length(); i++) {
            if(chars[i-1] == 'a' && chars[i] == 'b') {
                str.replace("ab", "bba");
            }

        }
        return 1;
    }

    public static void main(String[] args) {
        String str = "aab";

    }
}
