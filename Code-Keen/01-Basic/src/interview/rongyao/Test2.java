package interview.rongyao;

import java.util.*;


/**
 * @Author: Keen
 * @Description:  传入一个字符串，进行规整，一系列规整规则。
 * @param
 * @return
*/
public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            String str = input.next();
            int len = input.nextInt();
            String[] split = str.split(",");
            Deque<String> deque = new LinkedList(Arrays.asList(split));
            //deque.forEach(System.out::printf);
            ArrayList<String> resultList = new ArrayList<>();

            while (deque.size() != 0) {
                //每次循环处理一行
                String first = deque.pop();
                int count = 1; //计数，一行有几个
                while(deque.size() != 0 && (first.length()+deque.peek().length()) < len) {
                    first = first+"*"+deque.poll();
                    count++;
                }
                //System.out.println(first);

                //填充未填充的*号
                int extraCount = len-first.length()+count-1;
                String[] strings = first.split("\\*");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < extraCount; i++) {
                    //插入这么多个*
                    if(strings.length-1 == 0) {
                        strings[0] = strings[0]+"*";
                        continue;
                    }
                    if(deque.size() == 0) {
                        if(i != 0) {
                            //最后一行
                            first = first+"*";
                        }
                        continue;
                    }

                    int j = i%(strings.length-1);
                    strings[j] = strings[j]+"*";
                }

                if(deque.size() != 0) {
                    for (String string : strings) {
                        sb.append(string);
                    }
                } else {
                    sb.append(first);
                }
                System.out.println(sb.toString());
            }

            //This,is,an,eggplant,of,our,beautifull,sweety,baby
            //System.out.println(sum);

            //This****is****an
            //eggplant**of*our
            //beautifull******
            //sweety*baby*****
        }
    }
}