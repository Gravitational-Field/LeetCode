package interview.shopee;

/**
 * @ClassName Shopee1
 * @Description: 按照指示进行行走，求最后的坐标位置
 * @Author Keen
 * @DATE 2021/7/19 15:33
 * @Version 1.0
 **/
public class Shopee1 {

    public int[] GetEndPoint(String order) {
        int[] result = new int[2];
        int[] steps = new int[4];
        int temp_step = 0;

        for (int i = 0; i < order.length(); i++) {
            if (order.charAt(i) >= '0' && order.charAt(i) <= '9') {
                temp_step = temp_step * 10 + (order.charAt(i) - '0');
            } else {
                if (temp_step == 0) temp_step++;
                switch (order.charAt(i)) {
                    case 'W':
                    case 'w':
                        steps[0] += temp_step;
                        break;
                    case 'D':
                    case 'd':
                        steps[1] += temp_step;
                        break;
                    case 'S':
                    case 's':
                        steps[2] += temp_step;
                        break;
                    case 'A':
                    case 'a':
                        steps[3] += temp_step;
                        break;
                }
                temp_step = 0;
            }
        }
        result[0] = steps[1] - steps[3];
        result[1] = steps[0] - steps[2];

        return result;
    }

    public int[] GetEndPoint1(String order) {
        int[] result = new int[2];

        String str = order.toLowerCase();
        int len = str.length();
        char[] chars = str.toCharArray();
        int step = 0;
        
        for (int i = 0; i < len; i++) {
            if(chars[i] >= '0' && chars[i]<= '9') {
                step = 10*step + chars[i] - '0';
            } else {
                if(step == 0) {
                    step = 1;
                }
                
                if(chars[i] == 'w') {
                    result[1] += step;
                } else if(chars[i] == 's') {
                    result[1] -= step;
                }  else if(chars[i] == 'd') {
                    result[0] += step;
                } else if(chars[i] == 'a') {
                    result[0] -= step;
                }
                step = 0;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String order = "W12D";
        System.out.println(new Shopee1().GetEndPoint1(order)[0] + " " + new Shopee1().GetEndPoint(order)[1]);
    }
}
