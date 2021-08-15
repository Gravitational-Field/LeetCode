package interview.rongyao;

import java.sql.Array;
import java.util.*;

/**
 * @ClassName Test13
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/8/14 19:06
 * @Version 1.0
 **/
public class Test13 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];

        ArrayList<Integer> index = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
            index.add(i);
        }

        int result = 0;

        while (!index.isEmpty()) {
            ArrayList<Integer> to_cut;
            HashMap<Integer, ArrayList<Integer>> xline = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> yline = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> xyline = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> yxline = new HashMap<>();

            for (int i = 0; i < n; i++) {
                //去掉已切的点
                if (!index.contains(i)) continue;

                //竖切
                if (xline.get(x[i]) == null) {
                    ArrayList<Integer> pointlst = new ArrayList<>();
                    pointlst.add(i);
                    xline.put(x[i], pointlst);
                } else {
                    ArrayList<Integer> pointlst = xline.get(x[i]);
                    pointlst.add(i);
                    xline.put(x[i], pointlst);
                }

                //横切
                if (yline.get(y[i]) == null) {
                    ArrayList<Integer> pointlst = new ArrayList<>();
                    pointlst.add(i);
                    yline.put(y[i], pointlst);
                } else {
                    ArrayList<Integer> pointlst = yline.get(y[i]);
                    pointlst.add(i);
                    yline.put(y[i], pointlst);
                }
                //左斜切
                if (xyline.get(x[i] - y[i]) == null) {
                    ArrayList<Integer> pointlst = new ArrayList<>();
                    pointlst.add(i);
                    xyline.put(x[i] - y[i], pointlst);
                } else {
                    ArrayList<Integer> pointlst = xyline.get(x[i] - y[i]);
                    pointlst.add(i);
                    xyline.put(x[i] - y[i], pointlst);
                }

                //右斜切
                if (yxline.get(x[i] + y[i]) == null) {
                    ArrayList<Integer> pointlst = new ArrayList<>();
                    pointlst.add(i);
                    yxline.put(x[i] + y[i], pointlst);
                } else {
                    ArrayList<Integer> pointlst = yxline.get(x[i] + y[i]);
                    pointlst.add(i);
                    yxline.put(x[i] + y[i], pointlst);
                }
            }

            Set<Integer> xset = xline.keySet();
            ArrayList<Map.Entry<Integer, ArrayList<Integer>>> xlist = new ArrayList<>(xline.entrySet());
            Collections.sort(xlist, (o1, o2) -> (o2.getValue().size() - o1.getValue().size()));
            to_cut = xlist.get(0).getValue();

            Set<Integer> yset = xline.keySet();
            ArrayList<Map.Entry<Integer, ArrayList<Integer>>> ylist = new ArrayList<>(yline.entrySet());
            Collections.sort(ylist, (o1, o2) -> (o2.getValue().size() - o1.getValue().size()));
            int ypoints = ylist.get(0).getValue().size();
            to_cut = to_cut.size() > ypoints ? to_cut : ylist.get(0).getValue();

            Set<Integer> xyset = xyline.keySet();
            ArrayList<Map.Entry<Integer, ArrayList<Integer>>> xylist = new ArrayList<>(xyline.entrySet());
            Collections.sort(xylist, (o1, o2) -> (o2.getValue().size() - o1.getValue().size()));
            int xypoints = xylist.get(0).getValue().size();
            to_cut = to_cut.size() > xypoints ? to_cut : xylist.get(0).getValue();

            Set<Integer> yxset = yxline.keySet();
            ArrayList<Map.Entry<Integer, ArrayList<Integer>>> yxlist = new ArrayList<>(yxline.entrySet());
            Collections.sort(yxlist, (o1, o2) -> (o2.getValue().size() - o1.getValue().size()));
            int yxpoints = yxlist.get(0).getValue().size();
            to_cut = to_cut.size() > yxpoints ? to_cut : yxlist.get(0).getValue();

            result++;
            index.removeAll(to_cut);
        }
        System.out.println(result);
            /*7
            1 5
            1 9
            2 1
            2 2
            3 3
            3 6
            4 5*/
    }

}

