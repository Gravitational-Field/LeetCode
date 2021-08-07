package interview.shopee;

import java.util.Locale;

/**
 * @ClassName YangShopee2
 * @Description: 命名驼峰式
 * @Author Keen
 * @DATE 2021/8/2 20:10
 * @Version 1.0
 **/
public class YangShopee2 {

    public String getTuoFeng(String str) {
        if(str == null || str.length() == 0) {
            return "";
        }
        //进行判断
        //String lowStr = str.toLowerCase();
        System.out.print(str +" : ");
        //有 _
        String result = "";
        if(str.contains("_")) {
            String lowStr = str.toLowerCase();  //
            StringBuilder sb = new StringBuilder();
            String[] splits = lowStr.split("_");
            for (int i = 0; i < splits.length; i++) {
                if(i==0) {
                    sb.append(splits[0]);
                } else {
                    sb.append(min2max(splits[i].charAt(0))).append(splits[i].substring(1));
                }
                //System.out.println(sb.toString());
            }
            result = sb.toString();
        }else {
            //没有_,  TestVariable
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if(i==0 && str.charAt(0)>='a' && str.charAt(0)<='z') {
                    sb.append(str.charAt(0));
                } else if(i==0 && str.charAt(0)>='A' && str.charAt(0)<='Z') {
                    sb.append(max2min(str.charAt(0)));
                } else {
                    sb.append(str.charAt(i));
                }
            }
            result = sb.toString();
        }
        return result;

    }


    public char max2min(char c) {
        return (char)(c+32);
    }

    public char min2max(char c) {
        return (char)(c-32);
    }


    public static void main(String[] args) {
        String str = "TestVariable";
        String str1 = "test_Variable";
        String str2 = "TEST_VARIABLE";
        String str3 = "test_variable";
        String str4 = "test_varia3le";
        //System.out.println(str2.toLowerCase(Locale.ROOT));
        //System.out.println((char)('a'-32));
        System.out.println(new YangShopee2().getTuoFeng(str));
        System.out.println(new YangShopee2().getTuoFeng(str1));
        System.out.println(new YangShopee2().getTuoFeng(str2));
        System.out.println(new YangShopee2().getTuoFeng(str3));
        System.out.println(new YangShopee2().getTuoFeng(str4));

    }
}
