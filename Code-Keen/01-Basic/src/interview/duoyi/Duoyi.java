package interview.duoyi;

/**
 * @ClassName Duoyi
 * @Description
 */
public class Duoyi {

    public static void main(String[] args) {

        int n = 8;
        System.out.println(new Duoyi().getAge(8));

    }

    public int getAge(int count) {
        if (count == 1) return 10;
        return getAge(count-1)+2;

    }

}
