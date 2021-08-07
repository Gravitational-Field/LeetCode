package saima;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String input = cin.nextLine();
            int[] rains = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();

            int len = rains.length;
            int[] result = new int[len];
            Queue<Integer> queue = new LinkedList<>();

            int chance = 0;
            ArrayList<Integer> lake_idx = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                if(rains[i] > 0) {
                    result[i] = -1;
                    if(lake_idx.indexOf(rains[i]) == -1) {
                        lake_idx.add(rains[i]);
                    } else {
                        if(chance == 0) {
                            result = new int[len];
                            break;
                        }else {
                            chance--;
                            result[queue.poll()] = rains[i];
                            lake_idx.remove(lake_idx.indexOf(rains[i]));
                        }


                    }
                } else{
                    chance++;
                    queue.offer(i);
                }
            }
            while (chance>0) {
                result[queue.poll()] = lake_idx.remove(0);
                chance --;
            }

            for (int i = 0; i < len-1; i++) {
                System.out.println(result[i]+",");
            }
            System.out.println(result[len-1]);

        }
    }
}

