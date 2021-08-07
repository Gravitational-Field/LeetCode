package saima;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.CharSequence;

public class Main1 {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        //int a, b;
        while (cin.hasNextLine()) { // 5,6,8,26,50,48,52,55,10,1,2,1,20,5:3
            String line = cin.nextLine();
            String[] split = line.split(":");
            String[] arrStr = split[0].split(",");
            //for (int i = 0; i < arrStr.length; i++) {
            //    System.out.print(arrStr[i]+"\t");
            //}
            System.out.println();
            int k = Integer.valueOf(split[1]);
            //System.out.println("k:" + k);
            //获取到了数据
            int[] arr = new int[arrStr.length];
            //int[] qianzhuiSum = new int[arr.length];
            for (int i = 0; i < arrStr.length; i++) {
                //System.out.print(arrStr[i] + " ");
                arr[i] = Integer.valueOf(arrStr[i]);
            }
            //构造前缀和数组
            int[] qianzhuiSum = new int[arr.length];
            for (int i = 0; i < arrStr.length; i++) {
                //System.out.print(arrStr[i] + " ");
                if(i == 0) {
                    qianzhuiSum[0] = arr[i];
                } else {
                    qianzhuiSum[i] = arr[i]+qianzhuiSum[i-1];
                }
            }

            //构造完成
            //for (int i : qianzhuiSum) {
            //    System.out.print(i+"\t");
            //}
            //构建3平均数数组，并计算最大的平均数
            double[] avgArr = new double[qianzhuiSum.length-k+1];
            for (int i = 0; i < avgArr.length; i++) {
                if(i == 0) {
                    avgArr[0] = qianzhuiSum[i+k-1]*1.0/k;
                } else {
                    avgArr[i] = (qianzhuiSum[i+k-1]-qianzhuiSum[i-1])*1.0/k;
                }
            }

            //System.out.println("平均值数组：");
            //for (int i = 0; i < avgArr.length; i++) {
            //    System.out.println();
            //}

            //计算平均增幅
            double max = Integer.MIN_VALUE;
            for (int i = 1; i < avgArr.length; i++) {
                double p = (avgArr[i]-avgArr[i-1])/avgArr[i-1];
                max = max>p?max:p;
            }

            System.out.println(String.format("%.2f", max*100)+"%");

            double d1 = 3.14158;
            System.out.println(String.format("%.2f", d1));
            System.out.printf("%.2f%n", d1);
        }
    }
}
