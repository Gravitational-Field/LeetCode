package interview.xinlang;

import java.util.Stack;

/**
 * @Author: Keen
 * @Description:  用两个栈模拟队列
 * @param 
 * @return 
*/
public class Test2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        } else{
            int deleteItem = stack2.pop();
            return deleteItem;
        }

    }

    public void checkQueue(){
        int[] intArray1 = {1,2,3,4,5};
        int[] intArray2 = {6,7,8,9};
        int[] result = new int[9];

        for(int i=0;i<intArray1.length;i++) {
            push(intArray1[i]);
        }
        for(int i =0; i<3; i++) {
            result[i]=pop();
        }

        for(int i=0;i<intArray2.length;i++) {
            push(intArray2[i]);
        }
        for(int i =0; i<6; i++) {
            result[3+i]=pop();
        }

        for(int i=0; i<result.length;i++) {
            System.out.print(result[i]);
        }
    }

    public static void main(String[] args) {
        Test2 main = new Test2();
        main.checkQueue();
    }
}