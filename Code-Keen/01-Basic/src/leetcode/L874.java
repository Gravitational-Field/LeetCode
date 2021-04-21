package leetcode;

import com.sun.deploy.nativesandbox.IntegrityProcess;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName L874
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/4/16 8:47
 * @Version 1.0
 **/
public class L874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        if(commands == null || commands.length == 0) {
            return  0;
        }
        int result = 0;
        int x = 0,y = 0,direction = 0;  //x，y代表当前坐标
        int[][] xy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  //北移、东移、西移、南移

        //存储到set中进行判断
        Set<String> set = new HashSet<>();
        for (int[] array:obstacles) {
            set.add(array[0]+","+array[1]);
        }

        for (int com:commands) {
            if(com == -2) {
                // 左转
                direction = (direction+3)%4; //相当于右转了三次
            } else if(com == -1) {
                // 右转
                direction = (direction+1)%4;
            } else {
                //在指定方向前进com步
                for (int i = 1; i <= com; i++) {
                    int newX = x+xy[direction][0];
                    int newY = y+xy[direction][1];
                    //判断是否是障碍物
                    if(set.contains(newX+","+newY)) {
                        break;
                    }
                    //没有障碍物
                    x = newX;
                    y = newY;
                    result = Math.max(result,x*x+y*y);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] commands = {4,-1,3};
        int[][] obstacles = {};
        System.out.println(new L874().robotSim(commands, obstacles));
    }

}
