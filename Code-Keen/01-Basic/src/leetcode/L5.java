package leetcode;

/**
 * @ClassName L5
 * @Description: 最长回文子串
 * @Author Keen
 * @DATE 2021/8/19 14:04
 * @Version 1.0
 **/
public class L5 {

    public String longestPalindrome(String s) {
        if(s==null || s.length()==0||s.length()==1) {
            return s;
        }

        char[] chars = s.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            //以i为基的最长
            String oddRes = getMaxLengthSubStr(s,i,i);
            String evenRes = getMaxLengthSubStr(s,i,i+1);
            //int len = Math.max(oddRes.length(), evenRes.length());
            if(oddRes.length()>evenRes.length() && oddRes.length()>res.length()) {
                res = oddRes;
            } else if(oddRes.length()<=evenRes.length() && evenRes.length()>res.length()){
                res = evenRes;
            }
        }
        return res;
    }

    private String getMaxLengthSubStr(String s, int l, int r) {
        while(l>=0 && r<s.length()&& s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

    public static void main(String[] args) {
        //String s = "babad";
        String s = "bb";
        System.out.println(new L5().longestPalindrome(s));
    }
}
