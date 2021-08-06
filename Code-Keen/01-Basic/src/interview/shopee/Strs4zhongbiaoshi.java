package interview.shopee;

import java.util.ArrayList;

/**
 * @ClassName Strs4zhongbiaoshi
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/7/16 19:41
 * @Version 1.0
 **/
public class Strs4zhongbiaoshi {

    public String fourTransform(String str) {
        int index = 0;
        ArrayList<String> as = new ArrayList<String>();
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_' || c == '-') {
                as.add(str.substring(index, i));
                i++;
                index = i; //跳过每个单词的首位
            } else if (Character.isUpperCase(c)) {
                as.add(str.substring(index, i));
                index = i;
            }
        }
        as.add(str.substring(index, str.length()));
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        for (int j = 0; j < as.size(); j++) {
            String asStr = as.get(j);
            str1 += Character.toUpperCase(asStr.charAt(0)) + asStr.substring(1, asStr.length());
            if (j == 0) {
                str2 += Character.toLowerCase(asStr.charAt(0)) + asStr.substring(1, asStr.length());
            } else {
                str2 += Character.toUpperCase(asStr.charAt(0)) + asStr.substring(1, asStr.length());
            }
            str3 += Character.toLowerCase(asStr.charAt(0)) + asStr.substring(1, asStr.length());
            str4 += Character.toLowerCase(asStr.charAt(0)) + asStr.substring(1, asStr.length());
            if (j != as.size() - 1) {
                str3 += "_";
                str4 += "-";
            }
        }
        return str1 + " " + str2 + " " + str3 + " " + str4;
    }


    public static void main(String[] args) {
        String str = "PascalCaseTest";
        System.out.println(new Strs4zhongbiaoshi().fourTransform(str));
    }
}
