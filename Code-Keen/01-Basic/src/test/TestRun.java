package test;

/**
 * @ClassName TestRun
 * @Description: TODO
 * @Author Keen
 * @DATE 2021/6/17 10:44
 * @Version 1.0
 **/
public class TestRun {


        public static int aMethod(int i) throws Exception
        {
            try {
                return i / 0;
            } catch (Exception ex) {
                throw new Exception("exception in a Method");
            } finally {
                System.out.printf("finally");
            }
        }

        public static void main(String[]args)
        {
            try {
                aMethod(10);
            } catch (Exception ex) {
                System.out.printf("exception in main");
            }
            System.out.printf("finished");
        }


}
